package music_management.repository;

import music_management.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> displayAll();

    void save(Music music);

    Music findById(int id);

    void update(Music music);

    void delete(int id);

    List<Music> searchByName(String name);
}
