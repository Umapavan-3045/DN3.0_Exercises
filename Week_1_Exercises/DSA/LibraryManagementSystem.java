public class Book {
    private int id;
    private String title;
    private String author;

    public Book(int id, String title, String author) {
        this.id = id;
        this.title = title;
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    @Override
    public String toString() {
        return "Book ID: " + id + ", Title: " + title + ", Author: " + author;
    }
}

class LibraryManager {
    private Book[] books;
    private int size;

    public LibraryManager(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Array is full. Cannot add more books.");
        }
    }

    public Book linearSearchByTitle(String title) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }
}

class LibraryManagementSystem {
    private Book[] books;
    private int size;

    public LibraryManagementSystem(int capacity) {
        books = new Book[capacity];
        size = 0;
    }

    public void addBook(Book book) {
        if (size < books.length) {
            books[size++] = book;
        } else {
            System.out.println("Array is full. Cannot add more books.");
        }
    }

    public void sortBooksByTitle() {
        Arrays.sort(books, 0, size, Comparator.comparing(Book::getTitle, String.CASE_INSENSITIVE_ORDER));
    }

    public Book binarySearchByTitle(String title) {
        int low = 0;
        int high = size - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            int comparison = books[mid].getTitle().compareToIgnoreCase(title);
            if (comparison == 0) {
                return books[mid];
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        LibraryManager libraryManager = new LibraryManager(10);
        libraryManager.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        libraryManager.addBook(new Book(2, "1984", "George Orwell"));
        libraryManager.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));

        System.out.println("Linear Search:");
        Book foundBookLinear = libraryManager.linearSearchByTitle("1984");
        System.out.println(foundBookLinear != null ? foundBookLinear : "Book not found.");

        LibraryManagementSystem librarySystem = new LibraryManagementSystem(10);
        librarySystem.addBook(new Book(1, "The Great Gatsby", "F. Scott Fitzgerald"));
        librarySystem.addBook(new Book(2, "1984", "George Orwell"));
        librarySystem.addBook(new Book(3, "To Kill a Mockingbird", "Harper Lee"));

        librarySystem.sortBooksByTitle();
        System.out.println("Binary Search:");
        Book foundBookBinary = librarySystem.binarySearchByTitle("1984");
        System.out.println(foundBookBinary != null ? foundBookBinary : "Book not found.");
    }
}
