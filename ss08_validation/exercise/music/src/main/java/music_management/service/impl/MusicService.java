package music_management.service.impl;

import music_management.model.Music;
import music_management.repository.IMusicRepository;
import music_management.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MusicService implements IMusicService {

    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public Page<Music> findAll(Pageable pageable) {
        return iMusicRepository.findAll(pageable);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public Music findById(int id) {
        return iMusicRepository.findById(id);
    }

    @Override
    public Page<Music> findByName(String keySearch, Pageable pageable) {
        return iMusicRepository.findByName(keySearch, pageable);
    }
}
