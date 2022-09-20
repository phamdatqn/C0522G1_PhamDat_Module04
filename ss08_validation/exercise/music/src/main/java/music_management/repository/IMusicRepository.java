package music_management.repository;

import music_management.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IMusicRepository extends JpaRepository<Music,Integer> {

}
