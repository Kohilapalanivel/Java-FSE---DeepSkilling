/*package com.library.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.library.repository.BookRepository;
@Service
public class BookService 
{
    @Autowired
    private BookRepository bookRepository;
    public void addBook()
    {
        System.out.println("Service Layer: Adding Book...");
        bookRepository.saveBook();
    }
}
*/
package com.library.service;
import com.library.repository.BookRepository;
public class BookService 
{
    private BookRepository bookRepository;
    public BookService() 
    {
    	
    }
    public BookService(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }
    public void setBookRepository(BookRepository bookRepository)
    {
        this.bookRepository = bookRepository;
    }
    public void addBook() 
    {
        System.out.println("Service Layer: Adding Book...");
        bookRepository.saveBook();
    }
}
