package blog_management.blog.service;

import blog_management.blog.model.Blog;
import org.springframework.data.domain.Page;

import java.awt.print.Pageable;
import java.util.List;
import java.util.Optional;

public interface IBlogService {

    Page<Blog> findAll(Pageable pageable);

    Optional<Blog> findById(int id);

    void save(Blog blog);

    void delete(Blog blog);
}
