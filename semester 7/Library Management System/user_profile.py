from tkinter import *
from tkinter import ttk
import user_panel, user_edit_profile
from utils import get_cursor

def show_profile(tree, user_id):
    cursor = get_cursor()

    # Execute the query to retrieve data for the specific user
    query = """
        SELECT 
                m.username,
                m.first_name,
                m.last_name,
                m.email,
                m.address,
                m.phone,
                m.role
        FROM 
                member m
        WHERE 
                m.member_id = ?;
    """
    cursor.execute(query, user_id)
    user_data = cursor.fetchone()

    # Insert retrieved data into the treeview
    tree.insert('', 'end', values=(
        user_data[0], user_data[1], user_data[2], user_data[3], user_data[4], user_data[5], user_data[6]))

def main(user_id):
    windows = Tk()

    windows.title("Library Management System")
    windows.geometry('800x400')
    windows.resizable(0, 0)


    def back_to_main(user_id):
        windows.destroy()
        user_panel.main(user_id)

    # First Frame
    frame1 = Frame(windows, width=800, height=150, bg='white')
    frame1.pack(fill=BOTH, expand=True)

    heading1 = Label(frame1, text='Library User Profile', fg='black', bg='white', font=('Calibre', 20, 'bold'))
    heading1.place(x=310, y=20)

    library_Image = PhotoImage(file='./assets/library.png')
    library_Image_label = Label(frame1, image=library_Image)
    library_Image_label.place(x=260, y=20)

    bck_btn = Button(frame1, text='<<', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2',
                     border=2, command=lambda: back_to_main(user_id))
    bck_btn.place(x=25, y=20)

    # Create a Treeview with columns

    # Second Frame
    frame2 = Frame(windows, width=800, height=300, bg='white')
    frame2.pack(fill=BOTH, expand=True, padx=20, pady=20)  # Added padx and pady for padding
    tree = ttk.Treeview(frame2, columns=('Username', 'First Name', 'Last Name', 'Email', 'Address', 'Phone', 'Role'), show='headings')

    # Set column headers
    tree.heading('Username', text='Username')
    tree.heading('First Name', text='First Name')
    tree.heading('Last Name', text='Last Name')
    tree.heading('Email', text='Email')
    tree.heading('Address', text='Address')
    tree.heading('Phone', text='Phone')
    tree.heading('Role', text='Role')

    # Specify column widths
    tree.column('Username', width=100)
    tree.column('First Name', width=100)
    tree.column('Last Name', width=100)
    tree.column('Email', width=100)
    tree.column('Address', width=100)
    tree.column('Phone', width=100)
    tree.column('Role', width=100)

    # Pack the Treeview
    tree.pack(fill=BOTH, expand=True)

    show_profile(tree, user_id)

    def edit_profile(user_id):
        windows.destroy()
        user_edit_profile.main(user_id, tree)

    edit_profile_btn = Button(frame1, text='Edit Profile', width=10, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                           cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'), command= lambda: edit_profile(user_id))
    edit_profile_btn.place(x=25, y=90)

    windows.mainloop()




if __name__ == '__main__':
    main()