package music_management.service;

import music_management.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {

    void save(Music music);

    Music findById(int id);

    Page<Music> findByName(String keySearch, Pageable pageable);
}
