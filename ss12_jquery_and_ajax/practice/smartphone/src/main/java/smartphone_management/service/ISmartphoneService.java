package smartphone_management.service;

import smartphone_management.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {

    List<Smartphone> findAll();

    Smartphone save(Smartphone smartphone);

    Optional<Smartphone> findById(int id);

    void delete(int id);
}
