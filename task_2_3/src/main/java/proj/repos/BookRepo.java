package proj.repos;

import proj.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Long> {

    List<Book> findByAuthorContainingIgnoreCase(String title);
    List<Book> findByTitleContainingIgnoreCase(String author);
    List<Book> findByIdBetween(int idFirst, int idSecond);



}
