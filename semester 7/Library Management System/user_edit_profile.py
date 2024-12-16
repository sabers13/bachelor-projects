from tkinter import *
from tkinter import messagebox
import user_profile
from utils import get_cursor, generate_md5, email_validation, phone_number_validation



def main(user_id, tree):
    windows = Tk()

    windows.title("Library Management System")
    windows.geometry('540x640')
    windows.resizable(0, 0)

    def back_to_profile(user_id):
        windows.destroy()
        user_profile.main(user_id)

    def submit(firstname_Entry, lastname_Entry, address_entry, email_entry, phone_num_entry, username_Entry,
               password_Entry, re_enter_password_Entry):
        non_empty_fields = []

        # Check which fields have values
        if firstname_Entry.get():
            non_empty_fields.append(("first_name", firstname_Entry.get()))
        if lastname_Entry.get():
            non_empty_fields.append(("last_name", lastname_Entry.get()))
        if address_entry.get():
            non_empty_fields.append(("address", address_entry.get()))
        if email_entry.get():
            non_empty_fields.append(("email", email_validation(email_entry.get())))
        if phone_num_entry.get():
            non_empty_fields.append(("phone", phone_number_validation(phone_num_entry.get())))
        if username_Entry.get():
            non_empty_fields.append(("username", username_Entry.get()))
        if password_Entry.get():
            non_empty_fields.append(("password", generate_md5(password_Entry.get())))

        # Perform the update for each non-empty field
        cursor = get_cursor()
        try:
            for field, value in non_empty_fields:
                update_query = f"""
                    UPDATE member
                    SET {field} = ?
                    WHERE member_id = ?
                """
                cursor.execute(update_query, (value, user_id))
                cursor.commit()

            messagebox.showinfo('Success', 'Profile Updated Successfully.')
        except Exception as e:
            print(f"Error: {e}")

        # Clear the fields after a successful update or if no modifications were detected
        firstname_Entry.delete(0, END)
        lastname_Entry.delete(0, END)
        address_entry.delete(0, END)
        phone_num_entry.delete(0, END)
        email_entry.delete(0, END)
        username_Entry.delete(0, END)
        password_Entry.delete(0, END)
        re_enter_password_Entry.delete(0, END)

    frame = Frame(windows, width=610, height=640, bg='white', bd=8)
    frame.place(x=0, y=0)

    heading = Label(frame, text='Edit Profile', fg='black', bg='white', font=('Calibre', 20, 'bold'))
    heading.place(x=200, y=20)

    username_Image = PhotoImage(file='./assets/usernamelogo.png')
    username_Label = Label(frame, image=username_Image)
    username_Label.place(x=150, y=20)

    bck_btn = Button(frame, text='<<', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2', border=2, command= lambda :back_to_profile(user_id))
    bck_btn.place(x=10, y=580)


    # getting data from the entry fields
    firstname = StringVar()
    lastname = StringVar()
    email = StringVar()
    username_new = StringVar()
    password = StringVar()
    phone = StringVar()
    Address = StringVar()




    first_name_Label = Label(frame, text="First Name:", fg='black', bg='white', font=('Calibre', 15, 'bold'))
    first_name_Label.place(x=10, y=100)

    first_name_Entry = Entry(frame, width=30, borderwidth=2)
    first_name_Entry.place(x=240, y=100)


    last_name_Label = Label(frame, text="Last Name:", fg='black',bg='white', font=('Calibre', 15, 'bold'))
    last_name_Label.place(x=10, y=150)

    lastname_Entry = Entry(frame, width=30, borderwidth=2)
    lastname_Entry.place(x=240, y=150)

    address_label = Label(frame, text='Address:', fg='black', bg='white', font=('Calibre', 15, 'bold'))
    address_label.place(x=10, y=200)

    address_entry = Entry(frame, width=30, borderwidth=2)
    address_entry.place(x=240, y=200)

    idlabel_Email = Label(frame, text='Email:', fg='black', bg='white', font=('Calibre', 15, 'bold'))
    idlabel_Email.place(x=10, y=250)

    email_entry = Entry(frame, width=30, borderwidth=2)
    email_entry.place(x=240, y=250)

    phone_num_label = Label(frame, text='Phone:', fg='black', bg='white', font=('Calibre', 15, 'bold'))
    phone_num_label.place(x=10, y=300)

    phone_num_entry = Entry(frame, width=30, borderwidth=2)
    phone_num_entry.place(x=240, y=300)

    username_lbl = Label(frame, text='Username:', fg='black', bg='white', font=('Calibre', 15, 'bold'))
    username_lbl.place(x=10, y=350)

    username_Entry = Entry(frame, width=30, borderwidth=2)
    username_Entry.place(x=240, y=350)

    password_lbl = Label(frame, text='Password:', fg='black', bg='white', font=('Calibre', 15, 'bold'))
    password_lbl.place(x=10, y=400)

    password_Entry=Entry(frame, width=30, borderwidth=2)
    password_Entry.place(x=240, y=400)

    re_enter_password_lbl = Label(frame, text='Confirm Password:', fg='black', bg='white', font=('Calibre', 15, 'bold'))
    re_enter_password_lbl.place(x=10, y=450)

    re_enter_password_Entry = Entry(frame, width=30, borderwidth=2)
    re_enter_password_Entry.place(x=240, y=450)

    submit1btn = Button(frame, text='Submit', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white', cursor='hand2',
                        border=2,font=('#57a1f8', 16, 'bold'), command= lambda : submit(first_name_Entry, lastname_Entry, address_entry, email_entry, phone_num_entry, username_Entry, password_Entry, re_enter_password_Entry))
    submit1btn.place(x=150, y=500)

    windows.mainloop()




if __name__ == '__main__':
    main()
