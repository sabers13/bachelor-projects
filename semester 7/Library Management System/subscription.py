from tkinter import *
from PIL import Image, ImageTk
import tkinter as tk
from tkinter import ttk
from tkinter import messagebox
import login
from datetime import date, datetime
from dateutil.relativedelta import relativedelta

import user_panel
from utils import get_cursor, generate_md5, email_validation, phone_number_validation


def main(user_id):
    # print(user_id)
    def test():
        print("test")

    def back():
        windows.destroy()
        user_panel.main(user_id)

    def add_months(month):
        new_date = expire_date + relativedelta(months=month)
        print(type(new_date))
        update_date_query = """
                            UPDATE user_tbl SET expire_date = ? WHERE member_id = ?;
                        """
        cursor.execute(update_date_query, new_date, user_id)
        cursor.commit()
        windows.destroy()
        messagebox.showinfo('Success', 'Your membership has been successfully Renewed.')
        main(user_id)
    cursor = get_cursor()
    windows = Tk()
    windows.geometry('440x640')
    windows.resizable(0, 0)

    windows.title("User Panel")

    fetch_user_query = """
                    SELECT expire_date FROM user_tbl WHERE member_id = ?
                """
    cursor.execute(fetch_user_query, user_id)
    user = cursor.fetchall()
    expire_date = user[0][0]
    today = date.today()

    # frame=Frame(windows)
    frame = Frame(windows, width=610, height=640, bg='white', bd=8)
    frame.place(x=0, y=0)

    # labels on window
    heading = Label(frame, text=str((user[0][0] - today).days) + " days of your \nsubscription remains", fg='black',
                    bg='white', font=('Calibre', 20, 'bold'))
    heading.place(x=90, y=10)
    subscription_3m_Image = PhotoImage(file='./assets/3-month.png')
    subscription_6m_Image = PhotoImage(file='./assets/6-month.png')
    subscription_1y_Image = PhotoImage(file='./assets/1-year.png')
    username_Image = PhotoImage(file='./assets/usernamelogo.png')
    username_Label = Label(frame, image=username_Image)
    username_Label.place(x=45, y=20)

    bck_btn = Button(frame, text='<<', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2',
                     border=2,
                     command=back)
    bck_btn.place(x=10, y=580)

    subscription_3m = Button(frame, image=subscription_3m_Image, command=lambda: add_months(3))
    subscription_3m.place(x=150, y=80)

    subscription_6m = Button(frame, image=subscription_6m_Image, command=lambda: add_months(6))
    subscription_6m.place(x=150, y=265)

    subscription_1y = Button(frame, image=subscription_1y_Image, command=lambda: add_months(12))
    subscription_1y.place(x=150, y=450)
    windows.mainloop()


if __name__ == '__main__':
    main()
