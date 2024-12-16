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
                member.member_id AS user_id,
                member.username AS username,
                member.first_name AS first_name,
                member.last_name AS last_name,
                member.email AS email,
                member.address AS address,
                member.phone AS phone,
                member.role AS role,
                u.status  -- Include the status column in the SELECT clause
            FROM
                member
            LEFT JOIN
                user_tbl u ON member.member_id = u.member_id
            WHERE
                u.status IN ('Suspend');
    """
    cursor.execute(query)
    users = cursor.fetchall()
    # Insert retrieved data into the treeview
    for user in users:
        tree.insert('', 'end', values=(user[0], user[1], user[2], user[3], user[4], user[5], user[6], user[7],
                                       user[8]))



def clear_the_list(tree):
    for row in tree.get_children():
        tree.delete(row)


def release_from_blackList(tree):
    # Check if a row is selected
    selected_item = tree.selection()
    if not selected_item:
        messagebox.showinfo("Information", "Please select a user.")
        return

    # Prompt user for confirmation
    confirmation = messagebox.askyesno("Confirmation", "Are you sure you want to Release the user from blacklist?")
    if not confirmation:
        return

    cursor = get_cursor()

    try:
        # Get the selected user ID and current role
        selected_user_id = tree.item(selected_item, 'values')[0]

        # Update the role in the database
        remove_from_blacklist_query = "UPDATE user_tbl SET status = 'Valid' WHERE member_id = ?"
        cursor.execute(remove_from_blacklist_query, selected_user_id)

        # Commit the changes to the database
        cursor.commit()

        # Update the Treeview to reflect the changes
        allusers(tree)

        messagebox.showinfo("Success", "User Removed From BlackList successfully.")
    except Exception as e:
        print(f"Error: {e}")
        messagebox.showerror("Error", "An error occurred while changing the role.")

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

    heading1 = Label(frame1, text='Library Suspended List', fg='black', bg='white', font=('Calibre', 20, 'bold'))
    heading1.place(x=275, y=20)

    library_Image = PhotoImage(file='./assets/library.png')
    library_Image_label = Label(frame1, image=library_Image)
    library_Image_label.place(x=240, y=20)

    bck_btn = Button(frame1, text='<<', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2',
                     border=2, command=lambda: back_to_main(username))
    bck_btn.place(x=25, y=20)

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

    release_blacklist_btn = Button(frame1, text='Release User', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                        cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'), command=lambda : release_from_blackList(tree))
    release_blacklist_btn.place(x=130, y=90)

    windows.mainloop()


if __name__ == '__main__':
    main()