package product_management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import product_management.model.Product;
import product_management.repository.IProducRepository;

import java.util.List;

@Service
public class IProducService implements product_management.service.IProducService {

    @Autowired
    private IProducRepository iProducRepository;

    @Override
    public List<Product> displayAll() {
        return iProducRepository.displayAll();
    }

    @Override
    public void save(Product product) {
        iProducRepository.save(product);
    }

    @Override
    public Product findById(int id) {
        return iProducRepository.findById(id);
    }

    @Override
    public void update(Product product) {
        iProducRepository.update(product);
    }

    @Override
    public void delete(int id) {
        iProducRepository.delete(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        return iProducRepository.searchByName(name);
    }

}
