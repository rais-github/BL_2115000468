public class LibraryManagementSystem {
    class Book {
        String title;
        String author;
        String genre;
        int bookId;
        boolean isAvailable;
        Book prev;
        Book next;

        public Book(String title, String author, String genre, int bookId, boolean isAvailable) {
            this.title = title;
            this.author = author;
            this.genre = genre;
            this.bookId = bookId;
            this.isAvailable = isAvailable;
            this.prev = null;
            this.next = null;
        }
    }

    private Book head;
    private Book tail;
    private int count;

    public LibraryManagementSystem() {
        head = null;
        tail = null;
        count = 0;
    }

    public void addBookAtBeginning(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (head == null) {
            head = tail = newBook;
        } else {
            newBook.next = head;
            head.prev = newBook;
            head = newBook;
        }
        count++;
    }

    public void addBookAtEnd(String title, String author, String genre, int bookId, boolean isAvailable) {
        Book newBook = new Book(title, author, genre, bookId, isAvailable);
        if (tail == null) {
            head = tail = newBook;
        } else {
            tail.next = newBook;
            newBook.prev = tail;
            tail = newBook;
        }
        count++;
    }

    public void addBookAtPosition(String title, String author, String genre, int bookId, boolean isAvailable, int position) {
        if (position <= 0) {
            addBookAtBeginning(title, author, genre, bookId, isAvailable);
        } else if (position >= count) {
            addBookAtEnd(title, author, genre, bookId, isAvailable);
        } else {
            Book newBook = new Book(title, author, genre, bookId, isAvailable);
            Book current = head;
            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }
            newBook.next = current.next;
            newBook.prev = current;
            current.next.prev = newBook;
            current.next = newBook;
            count++;
        }
    }

    public void removeBookById(int bookId) {
        Book current = head;
        while (current != null && current.bookId != bookId) {
            current = current.next;
        }
        if (current != null) {
            if (current == head) {
                head = head.next;
                if (head != null) {
                    head.prev = null;
                }
            } else if (current == tail) {
                tail = tail.prev;
                if (tail != null) {
                    tail.next = null;
                }
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
            count--;
        }
    }

    public Book searchBookByTitle(String title) {
        Book current = head;
        while (current != null) {
            if (current.title.equalsIgnoreCase(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public Book searchBookByAuthor(String author) {
        Book current = head;
        while (current != null) {
            if (current.author.equalsIgnoreCase(author)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void updateBookAvailability(int bookId, boolean isAvailable) {
        Book current = head;
        while (current != null) {
            if (current.bookId == bookId) {
                current.isAvailable = isAvailable;
                return;
            }
            current = current.next;
        }
    }

    public void displayBooksForward() {
        Book current = head;
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.next;
        }
    }

    public void displayBooksReverse() {
        Book current = tail;
        while (current != null) {
            System.out.println("Book ID: " + current.bookId + ", Title: " + current.title + ", Author: " + current.author + ", Genre: " + current.genre + ", Available: " + current.isAvailable);
            current = current.prev;
        }
    }

    public int countBooks() {
        return count;
    }

    public static void main(String[] args) {
        LibraryManagementSystem library = new LibraryManagementSystem();
        library.addBookAtBeginning("Book1", "Author1", "Genre1", 1, true);
        library.addBookAtEnd("Book2", "Author2", "Genre2", 2, false);
        library.addBookAtPosition("Book3", "Author3", "Genre3", 3, true, 1);
        library.displayBooksForward();
        library.displayBooksReverse();
        System.out.println("Total books: " + library.countBooks());
        library.removeBookById(2);
        library.displayBooksForward();
        System.out.println("Total books: " + library.countBooks());
        library.updateBookAvailability(1, false);
        library.displayBooksForward();
    }
}