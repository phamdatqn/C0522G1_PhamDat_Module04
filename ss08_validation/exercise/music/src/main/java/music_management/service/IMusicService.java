package music_management.service;

import music_management.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IMusicService {
    Page<Music> findAll(Pageable pageable);

    void save(Music music);
}
