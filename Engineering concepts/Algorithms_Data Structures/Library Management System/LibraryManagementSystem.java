import java.util.*;
class Book
{
	int bookId;
	String title;
	String author;
	Book(int bookId, String title, String author)
	{
		this.bookId = bookId;
		this.title = title;
		this.author = author;
	}
	void display()
	{
		System.out.println("Book ID : " + bookId);
		System.out.println("Title   : " + title);
		System.out.println("Author  : " + author);
	}
}
public class LibraryManagementSystem
{
	static void linearSearch(Book[] books, String key)
	{
		for (Book book : books)
		{
			if (book.title.equalsIgnoreCase(key))
			{
				System.out.println("\nBook Found using Linear Search");
				book.display();
				return;
			}
		}
		System.out.println("Book Not Found");
	}
	static void binarySearch(Book[] books, String key)
	{
		int left = 0;
		int right = books.length - 1;
		while (left <= right)
		{
			int mid = left + ((right - left)/ 2);
			int result = key.compareToIgnoreCase(books[mid].title);
			if (result == 0)
			{
				System.out.println("\nBook Found using Binary Search");
				books[mid].display();
				return;
			}
			else if (result > 0)
			{
				left = mid + 1;
			}
			else
				right = mid - 1;
		}
		System.out.println("Book Not Found");
	}
	public static void main(String[] args)
	{
	    Book b1 = new Book(101, "C++", "Bjarne Stroustrup");
	    Book b2 = new Book(102, "DBMS", "Korth");
	    Book b3 = new Book(103, "Java", "Herbert Schildt");
	    Book b4 = new Book(104, "Python", "Guido");
		Book[] books = {b1,b2,b3,b4};
		Scanner sc = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("\n===== Library Management System =====");
			System.out.println("1. Linear Search");
			System.out.println("2. Binary Search");
			System.out.println("3. Display All Books");
			System.out.println("4. Exit");
			System.out.print("Enter Choice: ");
			choice = sc.nextInt();
			sc.nextLine();
			switch (choice)
			{

			case 1:
				System.out.print("Enter Book Title: ");
				String title1 = sc.nextLine();
				linearSearch(books, title1);
				break;
			case 2:
				System.out.print("Enter Book Title: ");
				String title2 = sc.nextLine();
				binarySearch(books, title2);
				break;
			case 3:
				System.out.println("\nBook Details:");
				for (Book book : books)
				{
					book.display();
					System.out.println();
				}
				break;
			case 4:
				System.out.println("Exiting...");
				break;
			default:
				System.out.println("Invalid Choice");
			}
		} while (choice != 4);
	}
}
