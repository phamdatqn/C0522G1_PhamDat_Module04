package blog_management.repository;

import blog_management.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    Blog findById(int id);

    @Query(value = "select * from Blog where title like %:keySearch%", nativeQuery = true)
    Page<Blog> findByName(@Param("keySearch") String keySearch, Pageable pageable);
}
