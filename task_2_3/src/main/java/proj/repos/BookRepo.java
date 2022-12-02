package proj.repos;

import proj.domain.Book;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepo extends CrudRepository<Book, Long> {

    List<Book> findByAuthorContaining(String title);
    List<Book> findByTitleContaining(String author);
    List<Book> findByIdBetween(int idFirst, int idSecond);



}
