package proj;

import proj.domain.Book;
import proj.repos.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.*;

@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    private BookRepo bookRepo;


    @GetMapping
    public String main(Map<String, Object> model) {
        Iterable<Book> books = bookRepo.findAll();

        model.put("books", books);

        return "main";
    }

    @PostMapping
    public String add(@RequestParam String title, @RequestParam String author, Map<String, Object> model) {
            Book message = new Book(title, author);


            bookRepo.save(message);

            Iterable<Book> books = bookRepo.findAll();

            model.put("books", books);


        return "main";
    }

    @PostMapping("filterId")
    public String filterId(@RequestParam int firstId, @RequestParam int secondId, Map<String, Object> model) {
        Iterable<Book> books;

        books = bookRepo.findByIdBetween(firstId, secondId);


        model.put("books", books);

        return "main";
    }
    @PostMapping("filter")
    public String filter(@RequestParam String filter, Map<String, Object> model) {
        Iterable<Book> books;

        if (filter != null && !filter.isEmpty()) {
            books = bookRepo.findByAuthorContaining(filter);
        } else {
            books = bookRepo.findAll();
        }

        model.put("books", books);

        return "main";
    }
    @PostMapping("filterAuthor")
    public String filterAuthor(@RequestParam String filterAuthor, Map<String, Object> model) {
        Iterable<Book> books;

        if (filterAuthor != null && !filterAuthor.isEmpty()) {
            books = bookRepo.findByTitleContaining(filterAuthor);
        } else {
            books = bookRepo.findAll();
        }

        model.put("books", books);

        return "main";
    }
    @PostMapping ("distinctAuthor")
    public String distinctAuthor(Map<String, Object> model) {
        Iterable<Book> booksTwo;
        HashSet<String> authors = new HashSet<String>();
        HashSet<Book> books = new HashSet<Book>();
        booksTwo = bookRepo.findAll();
        for (Book m : booksTwo) {
            String tagNow = m.getAuthor();
            if (m.getAuthor().contains(",")) {
                String[] tempArr = tagNow.split(",");
                Collections.addAll(authors, tempArr);
            }
            else {
                authors.add(m.getAuthor());
            }
        }
        for (String s : authors) {
            Book temp = new Book();
            temp.setAuthor(s);
            books.add(temp);
        }
        booksTwo = books;
        model.put("booksTwo", booksTwo);
        return "main";
    }


}
