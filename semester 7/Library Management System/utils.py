import hashlib
import re
import pyodbc as odbc
import os
from tkinter import ttk

data_source = 'SQL-ODBC'  # matches the System DSN you created

def get_cursor():
    # For Driver 17: either set Encrypt=No in the DSN,
    # or keep Encrypt=Yes and TrustServerCertificate=Yes.
    conn = odbc.connect(
        f"DSN={data_source};"
        "Database=LibraryDB;"
        "Encrypt=no;"  # <-- or use: Encrypt=yes;TrustServerCertificate=yes;
    )
    return conn.cursor()

cursor = get_cursor()
def generate_md5(password_str):
    # Create an MD5 hash object
    md5 = hashlib.md5()

    # Update the hash object with the password bytes
    md5.update(password_str.encode('utf-8'))

    # Get the hexadecimal representation of the digest
    hashed_password = md5.hexdigest()

    return hashed_password

def email_validation(email_str):

    regex = r'\b[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\.[A-Z|a-z]{2,7}\b'

    if (re.fullmatch(regex, email_str)):
        return True
    else:
        return False

def phone_number_validation(phone_str):

    regex = r'(0|91)?[6-9][0-9]{9}'

    if (re.fullmatch(regex, phone_str)):
        return True
    else:
        return False


def insert_data_to_tables():
    try:
        files = []
        for file in os.listdir():
            if file.endswith('.sql'):
                files.append(file)
        for file in files:
            with open(file, 'r') as sql_file:
                sql_script = sql_file.read()
                lines = sql_script.split(";")
                table_name = file.removesuffix(".sql").split("-")[1]
                query = f"SELECT COUNT(*) FROM {table_name};"
                cursor.execute(query)
                table_count = cursor.fetchone()[0]
                if table_count == 0 or table_count == 1:
                    for line in lines:
                        cursor.execute(line)
                    cursor.commit()
                else:
                    pass
    except Exception as e:
        print(f"Error executing SQL script: {str(e)}")


