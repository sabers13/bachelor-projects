import re
from pathlib import Path
import pyodbc

# ---- Adjust these two to your setup ----
DSN_NAME = "SQL-ODBC"     # your working DSN (Driver 17)
DB_NAME  = "LibraryDB"    # target database
# ----------------------------------------

# Resolve directories
BASE_DIR = Path(__file__).resolve().parent
SQL_DIR = BASE_DIR / "sql"
if not SQL_DIR.exists():
    # fall back to current folder if there's no 'sql' subfolder
    SQL_DIR = BASE_DIR

# Collect .sql files and sort by numeric prefix (e.g., '1-', '2-', ...)
def sort_key(p: Path):
    m = re.match(r"(\d+)", p.stem)
    return (int(m.group(1)) if m else 9999, p.name.lower())

SQL_FILES = sorted(SQL_DIR.glob("*.sql"), key=sort_key)

GO_RE = re.compile(r'^\s*GO\s*$', re.IGNORECASE | re.MULTILINE)

def run_batches(sql_text: str, cur):
    batches = [b.strip() for b in GO_RE.split(sql_text) if b.strip()]
    for i, batch in enumerate(batches, 1):
        cur.execute(batch)
        cur.connection.commit()

def main():
    if not SQL_FILES:
        raise SystemExit(f"No .sql files found in: {SQL_DIR}")

    # Driver 17 dev setup: either Encrypt=no or Encrypt=yes;TrustServerCertificate=yes
    conn = pyodbc.connect(f"DSN={DSN_NAME};Database={DB_NAME};Encrypt=no;")
    cur = conn.cursor()

    # Ensure we're in the right DB
    cur.execute(f"USE [{DB_NAME}];")
    cur.connection.commit()

    for f in SQL_FILES:
        print(f"Running {f.name} ...")
        text = f.read_text(encoding="utf-8")
        run_batches(text, cur)
        print(f"OK: {f.name}")

    cur.close()
    conn.close()
    print("All done.")

if __name__ == "__main__":
    main()
