package blog_management.repository;

import blog_management.dto.IBlogDto;
import blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    @Query(value = "select * from Blog where title like %:keySearch%", nativeQuery = true)
    Page<Blog> findByName(@Param("keySearch") String keySearch, Pageable pageable);

    @Query(value = "select b.title as titleDto, c.category_name as categoryDto from blog b join category c on b.category_id = c.id", nativeQuery = true)
    List<IBlogDto> findByNameDto();

    @Query(value = "select * from Blog where category_id = :chooseSelect", nativeQuery = true)
    Page<Blog> findByCategory(@Param("chooseSelect") int chooseSelect, Pageable pageable);

    List<Blog> findAll();

    @Query(value = "select * from Blog where title like %:keySearch%", nativeQuery = true)
    List<Blog> findByNameAjax(@Param("keySearch") String keySearch);
}
