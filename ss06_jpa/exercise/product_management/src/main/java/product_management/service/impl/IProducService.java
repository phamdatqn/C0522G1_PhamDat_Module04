package product_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_management.model.Product;
import product_management.repository.IProducRepository;

import java.util.List;
import java.util.Optional;

@Service
public class IProducService implements product_management.service.IProducService {

    @Autowired
    private IProducRepository iProducRepository;

    @Override
    public List<Product> findAll() {
        return iProducRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return iProducRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProducRepository.save(product);
    }

    @Override
    public void create(Product product) {
        iProducRepository.save(product);
    }

    @Override
    public void delete(Product product) {
        iProducRepository.delete(product);
    }

    @Override
    public List<Product> findByName(String keySearch) {
        return iProducRepository.findByName(keySearch);
    }

}
