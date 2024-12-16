import time
from tkinter import *
from tkinter import messagebox
import booklist, admin_profile, userList, login, suspendedUsers

def main(username):
    windows = Tk()

    windows.title("Library Management System")
    windows.geometry('600x400')
    windows.resizable(0, 0)

    frame = Frame(windows, width=700, height=500, bg='white')
    frame.place(x=0, y=0)

    heading = Label(frame, text='Library Admin Panel', fg='black', bg='white', font=('Calibre', 20, 'bold'))
    heading.place(x=175, y=20)

    lib_Image = PhotoImage(file='./assets/library.png')
    library_Image_label = Label(frame, image=lib_Image)
    library_Image_label.place(x=125, y=20)

    def show_book_list(username):
        windows.destroy()
        booklist.main(username)

    book_list_btn = Button(frame, text='Book List', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white', cursor='hand2',
                           border=2, font=('#57a1f8', 16, 'bold'), command=lambda: show_book_list(username))
    book_list_btn.place(x=50, y=90)

    def profile(username):
        windows.destroy()
        admin_profile.main(username)

    see_profile_btn = Button(frame, text='Profile', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white', cursor='hand2',
                             border=2, font=('#57a1f8', 16, 'bold'), command=lambda: profile(username))
    see_profile_btn.place(x=350, y=90)

    def user_List(username):
        windows.destroy()
        userList.main(username)

    def suspend(username):
        windows.destroy()
        suspendedUsers.main(username)

    def logout():
        confirmation = messagebox.askyesno("Confirmation", "Are you sure you want to Log Out?")
        if not confirmation:
            return
        else:
            messagebox.showinfo("Success", "Logged Out successfully.")
            windows.destroy()
            login.main()

    list_of_users_btn = Button(frame, text='User List', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white', cursor='hand2',
                               border=2, font=('#57a1f8', 16, 'bold'), command=lambda: user_List(username))
    list_of_users_btn.place(x=50, y=180)

    suspend_btn = Button(frame, text='Suspend User', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white', cursor='hand2',
                               border=2, font=('#57a1f8', 16, 'bold'), command=lambda : suspend(username))
    suspend_btn.place(x=350, y=180)

    log_out_btn = Button(frame, text='LOG OUT', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2', border=2,
                    command= lambda : logout())
    log_out_btn.place(x=50, y=280)

    windows.mainloop()

if __name__ == '__main__':
    main()
