from tkinter import *
import bookReturn
import borrowBook
import login
import subscription
from utils import get_cursor
import user_profile


def main(user_id):
    # print(user_id)

    def back():
        windows.destroy()
        login.main()

    def bokReturn():
        windows.destroy()
        bookReturn.main(user_id)

    def submit():
        fetch_user_query = """
                        SELECT * FROM user_tbl 
                    """
        cursor.execute(fetch_user_query)
        user = cursor.fetchall()
        print(user)

    def subscription_btn(user_id):
        windows.destroy()
        subscription.main(user_id)

    def borrow_btn(user_id):
        windows.destroy()
        borrowBook.main(user_id)

    def userprofile(user_id):
        windows.destroy()
        user_profile.main(user_id)

    cursor = get_cursor()
    windows = Tk()
    windows.geometry('540x640')
    windows.resizable(0, 0)

    windows.title("User Panel")

    # frame=Frame(windows)
    frame = Frame(windows, width=610, height=640, bg='white', bd=8)
    frame.place(x=0, y=0)

    # labels on window
    heading = Label(frame, text='User Panel', fg='black', bg='white', font=('Calibre', 20, 'bold'))
    heading.place(x=90, y=20)

    username_Image = PhotoImage(file='./assets/usernamelogo.png')
    username_Label = Label(frame, image=username_Image)
    username_Label.place(x=45, y=20)
    bck_btn = Button(frame, text='<<', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2',
                     border=2,
                     command=back)
    bck_btn.place(x=10, y=580)

    subscription_plans = Button(frame, text='Subscription Plans', width=15, borderwidth=5, height=2, bg='#7f7fff',
                                fg='white',
                                cursor='hand2',
                                border=2, font=('#57a1f8', 16, 'bold'), command=lambda: subscription_btn(user_id))
    subscription_plans.place(x=150, y=120)

    borrow_book = Button(frame, text='Borrow a Book', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                         cursor='hand2',
                         border=2, font=('#57a1f8', 16, 'bold'), command=lambda: borrow_btn(user_id))
    borrow_book.place(x=150, y=230)

    return_book = Button(frame, text='Return a Book', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                         cursor='hand2',
                         border=2, font=('#57a1f8', 16, 'bold'), command=bokReturn)
    return_book.place(x=150, y=340)

    profile = Button(frame, text='Profile', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                     cursor='hand2',
                     border=2, font=('#57a1f8', 16, 'bold'), command=lambda : userprofile(user_id))
    profile.place(x=150, y=450)

    windows.mainloop()


if __name__ == '__main__':
    main()
