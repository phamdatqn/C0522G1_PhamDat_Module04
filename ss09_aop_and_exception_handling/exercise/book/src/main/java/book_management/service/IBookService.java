package book_management.service;

import book_management.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> findAllPage(String search, Pageable pageable);

    void save(Book book);

    Book findById(int id);
}
