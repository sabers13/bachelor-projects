from tkinter import *
from tkinter import messagebox
import booklist
from utils import get_cursor

def main(username):

    windows = Tk()

    windows.title("Library Management System")
    windows.geometry('540x550')
    windows.resizable(0, 0)

    def back_to_booklist(username):
        windows.destroy()
        booklist.main(username)

    # frame=Frame(windows)
    frame = Frame(windows, width=610, height=600, bg='white', bd=8)
    frame.place(x=0, y=0)

    def submit():
        if (
                bookname_Entry.get() == ""
                or bookprice_Entry.get() == ""
                or bookauthor_Entry.get() == ""
                or bookcategory_Entry.get() == ""
                or bookdate_Entry.get() == ""
        ):
            messagebox.showerror("Alert!", "All Fields must be entered")
        else:
            cursor = get_cursor()

            select_publisher_id_query = "SELECT publisher_id FROM publisher WHERE name=?"
            publisher_name = bookPublisher_Entry.get()

            try:
                # Execute the query to retrieve the publisher_id
                cursor.execute(select_publisher_id_query, publisher_name)
                result = cursor.fetchone()

                if result:
                    publisher_id = result[0]
                else:
                    # If the publisher doesn't exist, you might want to handle this case
                    messagebox.showerror("Alert!", "Publisher not found.")
                    return

                # Placeholder for inserting data into the book table
                insert_query = """
                    INSERT INTO book (name, price, publisher_id, author, status, date_of_publish)
                    VALUES (?, ?, ?, ?, ?, ?)
                """
                cursor.execute(insert_query, (
                    bookname_Entry.get(),
                    float(bookprice_Entry.get()),
                    publisher_id,
                    bookauthor_Entry.get(),
                    "In Stock",
                    bookdate_Entry.get()
                ))

                # Commit the changes to the database
                cursor.commit()

                retrive_added_book_id_query = """
                    SELECT book_id FROM book WHERE name=?
                """
                cursor.execute(retrive_added_book_id_query, bookname_Entry.get())
                added_book_id = cursor.fetchone()[0]


                add_book_to_category_query = """
                    INSERT INTO category (book_id,name) values(?,?)
                """

                cursor.execute(add_book_to_category_query, added_book_id, bookcategory_Entry.get())
                cursor.commit()

                messagebox.showinfo("Success", "Book Added Successfully.")
            except Exception as e:
                print(f"Error: {e}")

    bookname = StringVar()
    bookprice = StringVar()
    bookauthor = StringVar()
    bookpublisher = StringVar()
    bookdate = StringVar()

    #labels on window
    heading = Label(frame, text='Admin Add Book', fg='black', bg='white', font=('Calibre', 20, 'bold'))
    heading.place(x=160, y=20)


    library_Image = PhotoImage(file='./assets/library.png')
    library_Label = Label(frame, image=library_Image)
    library_Label.place(x=120, y=20)

    bookname_Label = Label(frame, text="Name:", fg='black', bg='white', font=('Calibre', 15, 'bold'))
    bookname_Label.place(x=10, y=100)

    bookname_Entry = Entry(frame, width=30, borderwidth=2)
    bookname_Entry.place(x=240, y=100)

    bookprice_Label = Label(frame, text="Price:", fg='black', bg='white', font=('Calibre', 15, 'bold'))
    bookprice_Label.place(x=10, y=150)

    bookprice_Entry = Entry(frame, width=30, borderwidth=2)
    bookprice_Entry.place(x=240, y=150)

    bookauthor_Label = Label(frame, text="Author:", fg='black', bg='white', font=('Calibre', 15, 'bold'))
    bookauthor_Label.place(x=10, y=200)

    bookauthor_Entry = Entry(frame, width=30, borderwidth=2)
    bookauthor_Entry.place(x=240, y=200)

    bookpublisher_Label = Label(frame, text="Publisher:", fg='black', bg='white', font=('Calibre', 15, 'bold'))
    bookpublisher_Label.place(x=10, y=250)

    bookPublisher_Entry = Entry(frame, width=30, borderwidth=2)
    bookPublisher_Entry.place(x=240, y=250)

    bookcategory_Label = Label(frame, text="Category:", fg='black', bg='white', font=('Calibre', 15, 'bold'))
    bookcategory_Label.place(x=10, y=300)

    bookcategory_Entry = Entry(frame, width=30, borderwidth=2)
    bookcategory_Entry.place(x=240, y=300)

    bookdate_Label = Label(frame, text="Date Of Publish:", fg='black', bg='white', font=('Calibre', 15, 'bold'))
    bookdate_Label.place(x=10, y=350)

    bookdate_Entry = Entry(frame, width=30, borderwidth=2)
    bookdate_Entry.place(x=240, y=350)

    submit1btn = Button(frame, text='Submit', width=15, borderwidth=5, height=2, bg='#7f7fff', fg='white', cursor='hand2',
                        border=2,font=('#57a1f8', 16, 'bold'), command= lambda: submit())
    submit1btn.place(x=150, y=400)

    bck_btn = Button(frame, text='<<', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2', border=2,
                    command= lambda : back_to_booklist(username))
    bck_btn.place(x=10, y=480)



    windows.mainloop()


if __name__ == "__main__":
    main()