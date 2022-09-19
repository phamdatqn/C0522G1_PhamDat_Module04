package blog_management.service;

import blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    Blog findById(int id);

    void save(Blog blog);

    Page<Blog> findByName(String keySearch, Pageable pageable);

    void delete(Blog blog);
}
