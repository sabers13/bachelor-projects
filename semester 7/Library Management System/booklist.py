from tkinter import *
from tkinter import ttk
from tkinter import messagebox
import admin_panel, addbook
from utils import get_cursor


def allbooks(tree):
    cursor = get_cursor()
    # Clear existing data
    for row in tree.get_children():
        tree.delete(row)

    # Execute the query to retrieve data from the database
    query = """
        SELECT 
                b.book_id,
                b.name AS book_name,
                b.price,
                p.name AS publisher_name,
                b.author,
                b.status,
                c.name AS category_name
        FROM 
                book b
        JOIN 
                publisher p ON b.publisher_id = p.publisher_id
        LEFT JOIN
                category c ON b.book_id = c.book_id;
    """
    cursor.execute(query)
    books = cursor.fetchall()
    flag = 0
    for book1 in books:
        i = 0
        for book2 in books:
            i += 1
            if book1[6] != book2[6] and book1[0] == book2[0]:
                if type(book2[6]) is tuple:
                    books[i - 1][6] = (book1[6],) + book2[6]
                    books.pop(i)
                    flag = 1
                else:
                    i += flag
                    books[i - 2][6] = book1[6], book2[6]
                    books.pop(i - 1)
                    flag = 0
    # Insert retrieved data into the treeview
    for book in books:
        tree.insert('', 'end', values=(book[0], book[1], book[2], book[3], book[4], book[5], book[6] if book[6] else 'N/A'))

def clear_the_list(tree):
    for row in tree.get_children():
        tree.delete(row)


def search_books(tree, search_var, radio_var):
    cursor = get_cursor()

    # Clear existing data
    for row in tree.get_children():
        tree.delete(row)

    # Define the search query based on the selected radio button
    if radio_var.get() == 1:
        # Search by book name
        query = """
            SELECT
                    b.book_id,
                    b.name AS book_name,
                    b.price,
                    p.name AS publisher,
                    b.author,
                    b.status,
                    c.name AS category_name
            FROM
                    book b
            JOIN
                    publisher p ON b.publisher_id = p.publisher_id
            LEFT JOIN
                    category c ON b.book_id = c.book_id
            WHERE
                    LOWER(b.name) LIKE ?;
        """
    elif radio_var.get() == 2:
        # Search by author
        query = """
            SELECT
                    b.book_id,
                    b.name AS book_name,
                    b.price,
                    p.name AS publisher,
                    b.author,
                    b.status,
                    c.name AS category_name
            FROM
                    book b
            JOIN
                    publisher p ON b.publisher_id = p.publisher_id
            LEFT JOIN
                    category c ON b.book_id = c.book_id
            WHERE
                    LOWER(b.author) LIKE ?;
        """
    elif radio_var.get() == 3:
        # Search by publisher
        query = """
            SELECT
                    b.book_id,
                    b.name AS book_name,
                    b.price,
                    p.name AS publisher,
                    b.author,
                    b.status,
                    c.name AS category_name
            FROM
                    book b
            JOIN
                    publisher p ON b.publisher_id = p.publisher_id
            LEFT JOIN
                    category c ON b.book_id = c.book_id
            WHERE
                    LOWER(p.name) LIKE ?;
        """
    elif radio_var.get() == 4:
        # Search by status
        query = """
            SELECT
                    b.book_id,
                    b.name AS book_name,
                    b.price,
                    p.name AS publisher,
                    b.author,
                    b.status,
                    c.name AS category_name
            FROM
                    book b
            JOIN
                    publisher p ON b.publisher_id = p.publisher_id
            LEFT JOIN
                    category c ON b.book_id = c.book_id
            WHERE
                    LOWER(b.status) LIKE ?;
        """
    elif radio_var.get() == 5:
        # Search by category
        query = """
            SELECT
                    b.book_id,
                    b.name AS book_name,
                    b.price,
                    p.name AS publisher,
                    b.author,
                    b.status,
                    c.name AS category_name
            FROM
                    book b
            JOIN
                    publisher p ON b.publisher_id = p.publisher_id
            LEFT JOIN
                    category c ON b.book_id = c.book_id
            WHERE
                    LOWER(c.name) LIKE ?;
        """

    # Execute the query with the search term
    cursor.execute(query, ('%' + search_var.get().lower() + '%',))
    books = cursor.fetchall()

    # Insert retrieved data into the treeview
    for book in books:
        tree.insert('', 'end', values=(book[0], book[1], book[2], book[3], book[4], book[5], book[6] if book[6] else 'N/A'))

def remove_book(tree):
    # Check if a row is selected
    selected_item = tree.selection()
    if not selected_item:
        messagebox.showinfo("Information", "Please select a book to remove.")
        return

    # Prompt user for confirmation
    confirmation = messagebox.askyesno("Confirmation", "Are you sure you want to remove the selected book?")
    if not confirmation:
        return

    cursor = get_cursor()

    try:
        # Get the selected book ID
        selected_book_id = tree.item(selected_item, 'values')[0]

        # Manually delete corresponding entries in the category table
        delete_category_query = "DELETE FROM category WHERE book_id = ?"
        cursor.execute(delete_category_query, (selected_book_id,))

        # Execute the DELETE query
        delete_query = "DELETE FROM book WHERE book_id = ?"
        cursor.execute(delete_query, (selected_book_id,))

        # Commit the changes to the database
        cursor.commit()

        # Update the Treeview to reflect the changes
        allbooks(tree)

        messagebox.showinfo("Success", "Book removed successfully.")
    except Exception as e:
        print(f"Error: {e}")
        messagebox.showerror("Error", "An error occurred while removing the book.")


def main(username):
    windows = Tk()

    windows.title("Library Management System")
    windows.geometry('800x600')
    windows.resizable(0, 0)

    def back_to_main(username):
        windows.destroy()
        admin_panel.main(username)

    def add_book(username):
        windows.destroy()
        addbook.main(username)

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
    search_entry.place(x=240, y=90)

    # Create a Treeview with columns

    # Second Frame
    frame2 = Frame(windows, width=800, height=300, bg='white')
    frame2.pack(fill=BOTH, expand=True, padx=20, pady=20)  # Added padx and pady for padding
    tree = ttk.Treeview(frame2, columns=('ID', 'Title', 'Price', 'Publisher', 'Author', 'Inventory', 'Category'), show='headings')

    # Set column headers
    tree.heading('ID', text='Book ID')
    tree.heading('Title', text='Book Title')
    tree.heading('Price', text='Price')
    tree.heading('Publisher', text='Publisher')
    tree.heading('Author', text='Author')
    tree.heading('Inventory', text='Inventory')
    tree.heading('Category', text='Category')

    # Specify column widths
    tree.column('ID', width=50)
    tree.column('Title', width=100)
    tree.column('Price', width=100)
    tree.column('Publisher', width=100)
    tree.column('Author', width=100)
    tree.column('Inventory', width=100)
    tree.column('Category', width=100)

    # Pack the Treeview
    tree.pack(fill=BOTH, expand=True)

    # Update the Treeview with data
    book_list_btn = Button(frame1, text='Book List', width=10, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                           cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'), command=lambda: allbooks(tree))
    book_list_btn.place(x=25, y=90)

    clear_book_list_btn = Button(frame1, text='Clear Book List', width=12, borderwidth=5, height=2, bg='#7f7fff',
                                 fg='white',
                                 cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'),
                                 command=lambda: clear_the_list(tree))
    clear_book_list_btn.place(x=25, y=150)

    remove_book_btn = Button(frame1, text='Remove Book', width=10, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                           cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'), command=lambda : remove_book(tree))
    remove_book_btn.place(x=150, y=150)

    add_book_btn = Button(frame1, text='Add Book', width=10, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                           cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'), command=lambda : add_book(username))
    add_book_btn.place(x=250, y=150)

    search_btn = Button(frame1, text='Search', width=12, borderwidth=5, height=2, bg='#7f7fff', fg='white',
                        cursor='hand2', border=2, font=('#57a1f8', 8, 'bold'),
                        command=lambda: search_books(tree, search_var, radio_var))
    search_btn.place(x=550, y=90)

    radio_var = IntVar()
    radio_all = Radiobutton(frame1, text='Name', variable=radio_var, value=1)
    radio_all.place(x=160, y=120)

    radio_author = Radiobutton(frame1, text='Author', variable=radio_var, value=2)
    radio_author.place(x=230, y=120)

    radio_publisher = Radiobutton(frame1, text='Publisher', variable=radio_var, value=3)
    radio_publisher.place(x=300, y=120)

    radio_status = Radiobutton(frame1, text='Status', variable=radio_var, value=4)
    radio_status.place(x=390, y=120)

    radio_category = Radiobutton(frame1, text='Category', variable=radio_var, value=5)
    radio_category.place(x=460, y=120)

    windows.mainloop()


if __name__ == '__main__':
    main()