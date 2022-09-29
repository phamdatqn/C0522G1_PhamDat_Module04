package blog_management.service;

import blog_management.dto.IBlogDto;
import blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogService {

    Blog findById(int id);

    void save(Blog blog);

    Page<Blog> findByName(String keySearch, Pageable pageable);

    Page<Blog> findByCategory(int chooseSelect, Pageable pageable);

    void delete(Blog blog);

    List<IBlogDto> findByNameDto();

    List<Blog> findAll();

    List<Blog> findByNameAjax(String keySearch);
}
