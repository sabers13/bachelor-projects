from tkinter import *
from tkinter import ttk, messagebox
import admin_panel
from utils import get_cursor


def allusers(tree):
    cursor = get_cursor()
    # Clear existing data
    for row in tree.get_children():
        tree.delete(row)

    # Execute the query to retrieve data from the database
    query = """
        SELECT
            m.member_id AS user_id,
            m.username AS username,
            m.first_name AS first_name,
            m.last_name AS last_name,
            m.email AS email,
            m.address AS address,
            m.phone AS phone,
            m.role AS role,
            u.status
        FROM
            member m
        LEFT JOIN
            user_tbl u ON m.member_id = u.member_id
        WHERE
            u.status IN ('Suspend', 'Valid');
    """
    cursor.execute(query)
    users = cursor.fetchall()
    # Insert retrieved data into the treeview
    for user in users:
        tree.insert('', 'end', values=(user[0], user[1], user[2], user[3], user[4], user[5], user[6], user[7], user[8]))


def clear_the_list(tree):
    for row in tree.get_children():
        tree.delete(row)


def search_users(tree, search_var, radio_var):
    cursor = get_cursor()

    # Clear existing data
    for row in tree.get_children():
        tree.delete(row)

    # Define the search query based on the selected radio button
    if radio_var.get() == 1:
        # Search by first name
        query = """
            SELECT
                m.member_id AS user_id,
                m.username AS username,
                m.first_name AS first_name,
                m.last_name AS last_name,
                m.email AS email,
                m.address AS address,
                m.phone AS phone,
                m.role AS role,
            FROM
                member m
            WHERE
                LOWER(m.first_name) LIKE ?;
        """
    elif radio_var.get() == 2:
        # Search by last name
        query = """
            SELECT
                m.member_id AS user_id,
                m.username AS username,
                m.first_name AS first_name,
                m.last_name AS last_name,
                m.email AS email,
                m.address AS address,
                m.phone AS phone,
                m.role AS role,
            FROM
                member m
            WHERE
                LOWER(m.last_name) LIKE ?;
        """
    elif radio_var.get() == 3:
        # Search by role
        query = """
            SELECT
                m.member_id AS user_id,
                m.username AS username,
                m.first_name AS first_name,
                m.last_name AS last_name,
                m.email AS email,
                m.address AS address,
                m.phone AS phone,
                m.role AS role,
            FROM
                member m
            WHERE
                LOWER(m.role) LIKE ?;
        """
    # Execute the query with the search term
    cursor.execute(query, ('%' + search_var.get().lower() + '%',))
    users = cursor.fetchall()

    # Insert retrieved data into the treeview
    for user in users:
        tree.insert('', 'end', values=(user[0], user[1], user[2], user[3], user[4], user[5], user[6],\
                                       user[7], user[8]))

def remove_user(tree):
    # Check if a row is selected
    selected_item = tree.selection()
    if not selected_item:
        messagebox.showinfo("Information", "Please select a user to remove.")
        return

    # Prompt user for confirmation
    confirmation = messagebox.askyesno("Confirmation", "Are you sure you want to remove the selected user?")
    if not confirmation:
        return

    cursor = get_cursor()

    try:
        # Get the selected user ID
        selected_user_id = tree.item(selected_item, 'values')[0]

        # Check and delete associated transactions
        delete_transactions_query = "DELETE FROM transactions WHERE member_id = ?"
        cursor.execute(delete_transactions_query, selected_user_id)

        # Delete associated records in user_tbl
        delete_user_tbl_query = "DELETE FROM user_tbl WHERE member_id = ?"
        cursor.execute(delete_user_tbl_query, selected_user_id)

        # Delete the user
        delete_user_query = "DELETE FROM member WHERE member_id = ?"
        cursor.execute(delete_user_query, selected_user_id)

        # Commit the changes to the database
        cursor.commit()

        # Update the Treeview to reflect the changes
        allusers(tree)

        messagebox.showinfo("Success", "User removed successfully.")
    except Exception as e:
        print(f"Error: {e}")
        messagebox.showerror("Error", "An error occurred while removing the user.")

# def change_user_role(tree):
#     # Check if a row is selected
#     selected_item = tree.selection()
#     if not selected_item:
#         messagebox.showinfo("Information", "Please select a user.")
#         return
#
#     # Prompt user for confirmation
#     confirmation = messagebox.askyesno("Confirmation", "Are you sure you want to change the role?")
#     if not confirmation:
#         return
#
#     cursor = get_cursor()
#
#     try:
#         # Get the selected user ID and current role
#         selected_user_id = tree.item(selected_item, 'values')[0]
#         current_role = tree.item(selected_item, 'values')[7]
#
#         # Determine the new role
#         new_role = 'User' if current_role == 'Admin' else 'Admin'
#
#         # Update the role in the database
#         change_role_query = "UPDATE member SET role = ? WHERE member_id = ?"
#         cursor.execute(change_role_query, (new_role, selected_user_id))
#
#         # Commit the changes to the database
#         cursor.commit()
#
#         # Update the Treeview to reflect the changes
#         allusers(tree)
#
#         messagebox.showinfo("Success", "Role changed successfully.")
#     except Exception as e:
#         print(f"Error: {e}")
#         messagebox.showerror("Error", "An error occurred while changing the role.")

def add_to_black_list(tree):
    # Check if a row is selected
    selected_item = tree.selection()
    if not selected_item:
        messagebox.showinfo("Information", "Please select a user.")
        return

    # Prompt user for confirmation
    confirmation = messagebox.askyesno("Confirmation", "Are you sure you want to add the user to the blacklist?")
    if not confirmation:
        return

    cursor = get_cursor()

    try:
        # Get the selected user ID
        selected_user_id = tree.item(selected_item, 'values')[0]

        # Update the status in the user_tbl table to 'Blacklisted'
        add_blacklist_query = "UPDATE user_tbl SET status = 'Suspend' WHERE member_id = ?"
        cursor.execute(add_blacklist_query, selected_user_id)

        # Commit the changes to the database
        cursor.commit()

        # Update the Treeview to reflect the changes
        allusers(tree)

        messagebox.showinfo("Success", "User added to the blacklist successfully.")
    except Exception as e:
        print(f"Error: {e}")
        messagebox.showerror("Error", "An error occurred while adding the user to the blacklist.")


def main(username):
    windows = Tk()

    windows.title("Library Management System")
    windows.geometry('800x600')
    windows.resizable(0, 0)

    def back_to_main(username):
        windows.destroy()
        admin_panel.main(username)

    # First Frame
    frame1 = Frame(windows, width=800, height=150, bg='white')
    frame1.pack(fill=BOTH, expand=True)

    heading1 = Label(frame1, text='Library Book List', fg='black', bg='white', font=('Calibre', 20, 'bold'))
    heading1.place(x=275, y=20)

    library_Image = PhotoImage(file='./assets/library.png')
    library_Image_label = Label(frame1, image=library_Image)
    library_Image_label.place(x=240, y=20)

    bck_btn = Button(frame1, text='<<', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2',
                     border=2, command=lambda: back_to_main(username))
    bck_btn.place(x=25, y=20)

    search_var = StringVar()
    search_entry = Entry(frame1, width=45, bd=3, textvariable=search_var)
    search_entry.place(x=250, y=90)

    # Create a Treeview with columns

    # Second Frame
    frame2 = Frame(windows, width=800, height=300, bg='white')
    frame2.pack(fill=BOTH, expand=True, padx=20, pady=20)  # Added padx and pady for padding
    tree = ttk.Treeview(frame2, columns=('ID', 'Username', 'First Name', 'Last Name', 'Email', 'Address', 'Phone', 'Role', 'Status'), show='headings')

    # Set column headers
    tree.heading('ID', text='ID')
    tree.heading('Username', text='Username')
    tree.heading('First Name', text='First Name')
    tree.heading('Last Name', text='Last Name')
    tree.heading('Email', text='Email')
    tree.heading('Address', text='Address')
    tree.heading('Phone', text='Phone')
    tree.heading('Role', text='Role')
    tree.heading('Status', text='Status')

    # Specify column widths
    tree.column('ID', width=50)
    tree.column('Username', width=100)
    tree.column('First Name', width=100)
    tree.column('Last Name', width=100)
    tree.column('Email', width=100)
    tree.column('Address', width=100)
    tree.column('Phone', width=100)
    tree.column('Role', width=100)
    tree.column('Status', width=100)

    # Pack the Treeview
    tree.pack(fill=BOTH, expand=True)

    # Update the Treeview with data
    user_list_btn = Button(frame1, text='User List', width=10, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                           cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'), command=lambda: allusers(tree))
    user_list_btn.place(x=25, y=90)


    clear_user_list_btn = Button(frame1, text='Clear User List', width=12, borderwidth=5, height=2, bg='#7f7fff',
                                 fg='white',
                                 cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'),
                                 command=lambda: clear_the_list(tree))
    clear_user_list_btn.place(x=25, y=150)

    remove_user_btn = Button(frame1, text='Remove User', width=10, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                           cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'), command=lambda : remove_user(tree))
    remove_user_btn.place(x=150, y=150)

    search_btn = Button(frame1, text='Search', width=12, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                        cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'),
                        command=lambda: search_users(tree, search_var, radio_var))
    search_btn.place(x=550, y=90)

    add_to_blacklist_btn = Button(frame1, text='Add to Black List', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                        cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'), command=lambda : add_to_black_list(tree))
    add_to_blacklist_btn.place(x=115, y=90)

    radio_var = IntVar()
    radio_first_name = Radiobutton(frame1, text='First Name', variable=radio_var, value=1)
    radio_first_name.place(x=300, y=120)

    radio_last_name = Radiobutton(frame1, text='Last Name', variable=radio_var, value=2)
    radio_last_name.place(x=400, y=120)


    windows.mainloop()


if __name__ == '__main__':
    main()