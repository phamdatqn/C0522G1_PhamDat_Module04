package music_management.repository;

import music_management.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music, Integer> {
    Music findById(int id);

    @Query(value = "select * from music where music_name like %:keySearch%", nativeQuery = true)
    Page<Music> findByName(@Param("keySearch") String keySearch, Pageable pageable);
}
