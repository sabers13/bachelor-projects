from tkinter import *
from tkinter import ttk
from tkinter import messagebox
import user_panel
from utils import get_cursor
from datetime import date, datetime


def main(user_id):
    windows = Tk()

    windows.title("Borrowed books")
    windows.geometry('800x600')
    windows.resizable(0, 0)
    today = date.today()

    def returnBook(user_id):
        selected_book = tree.focus()
        details = tree.item(selected_book)
        # user_id = 2
        book_id = details.get('values')[0]

        insert_transaction = """
                                            INSERT INTO transactions (member_id,book_id,status,transaction_date)
                                            VALUES (?, ?, ?, ?)
                                            UPDATE book SET status = ? WHERE book_id = ?;

                                        """
        cursor.execute(insert_transaction, user_id, book_id, "Return", today, "In Stock", book_id)
        cursor.commit()
        windows.destroy()
        messagebox.showinfo('Success', 'You Borrowed your book successfully.')
        main(user_id)

    def back_to_main(user_id):
        windows.destroy()
        user_panel.main(user_id)

    cursor = get_cursor()
    # member_id = 2
    query = """
        SELECT book.book_id, book.name, transactions.transaction_date, transactions.status, transactions.member_id
        FROM book JOIN transactions ON book.book_id = transactions.book_id where member_id = ? order by transaction_date
                """
    cursor.execute(query, user_id)
    books = cursor.fetchall()
    # Assuming each book entry in the 'books' list has borrowed_books user ID at index 4
    borrowed_books = []
    book_counts = {}

    for book in books:
        book_id = book[0]
        status = book[3]

        if book_id not in book_counts:
            book_counts[book_id] = {'Borrow': 0, 'Return': 0}

        if status == 'Borrow':
            book_counts[book_id]['Borrow'] += 1
        elif status == 'Return':
            book_counts[book_id]['Return'] += 1

    # Now book_counts dictionary contains counts for each book
    for book_id, counts in book_counts.items():
        borrow_count = counts['Borrow']
        return_count = counts['Return']
        if borrow_count - return_count == 1:
            borrowed_books.append(book_id)
    new_books = []
    for item in borrowed_books:
        for book in reversed(books):
            print(item)
            if item == book[0]:
                new_books.append(book)
                break

    # First Frame
    frame1 = Frame(windows, width=800, height=150, bg='white')
    frame1.pack(fill=BOTH, expand=True)

    heading1 = Label(frame1, text='Borrowed books List', fg='black', bg='white', font=('Calibre', 20, 'bold'))
    heading1.place(x=275, y=20)

    library_Image = PhotoImage(file='./assets/library.png')
    library_Image_label = Label(frame1, image=library_Image)
    library_Image_label.place(x=240, y=20)

    bck_btn = Button(frame1, text='<<', width=7, borderwidth=5, height=2, bg='#babcbb', fg='black', cursor='hand2',
                     border=2, command=lambda: back_to_main(user_id))
    bck_btn.place(x=25, y=20)

    return_btn = Button(frame1, text='Return', width=12, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                        cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'),
                        command=lambda: returnBook(user_id))
    return_btn.place(x=550, y=140)

    # Create borrowed_books Treeview with columns

    # Second Frame
    frame2 = Frame(windows, width=800, height=300, bg='white')
    frame2.pack(fill=BOTH, expand=True, padx=20, pady=20)  # Added padx and pady for padding
    tree = ttk.Treeview(frame2, columns=('ID', 'Title', 'Date', 'Cost'),
                        show='headings')

    # Set column headers
    tree.heading('ID', text='Book ID')
    tree.heading('Title', text='Book Title')
    tree.heading('Date', text='Date of borrow')
    tree.heading('Cost', text='Cost')

    # Specify column widths
    tree.column('ID', width=50)
    tree.column('Title', width=100)
    tree.column('Date', width=100)
    tree.column('Cost', width=100)

    # Pack the Treeview
    tree.pack(fill=BOTH, expand=True)

    for book in new_books:
        tree.insert('', 'end',
                    values=(book[0], book[1], book[2], str(int((today - book[2]).days * 0.4)) + "$"))

    windows.mainloop()


if __name__ == '__main__':
    main()
