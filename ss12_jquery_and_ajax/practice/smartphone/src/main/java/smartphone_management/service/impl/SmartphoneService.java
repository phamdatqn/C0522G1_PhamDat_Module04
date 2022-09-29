package smartphone_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import smartphone_management.model.Smartphone;
import smartphone_management.repository.ISmartphoneRepository;
import smartphone_management.service.ISmartphoneService;

import java.util.List;
import java.util.Optional;

@Service
public class SmartphoneService implements ISmartphoneService {

    @Autowired
    private ISmartphoneRepository iSmartphoneRepository;

    @Override
    public List<Smartphone> findAll() {
        return iSmartphoneRepository.findAll();
    }

    @Override
    public Smartphone save(Smartphone smartphone) {
        return iSmartphoneRepository.save(smartphone);
    }

    @Override
    public Optional<Smartphone> findById(int id) {
        return iSmartphoneRepository.findById(id);
    }

    @Override
    public void delete(int id) {
        iSmartphoneRepository.deleteById(id);
    }


}
