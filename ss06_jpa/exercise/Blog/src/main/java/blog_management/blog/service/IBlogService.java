package blog_management.blog.service;

import blog_management.blog.model.Blog;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    List<Blog> findAll();

    Optional<Blog> findById(int id);

    void save(Blog blog);

    void delete(Blog blog);

}
