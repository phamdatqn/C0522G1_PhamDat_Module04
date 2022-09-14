package product_management.repository.ipml;

import org.springframework.stereotype.Repository;
import product_management.model.Product;
import product_management.repository.IProducRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class ProducRepository implements IProducRepository {
    private static Map<Integer, Product> productList = new HashMap<>();

    static {
        productList.put(1, new Product(1, "Bánh Yêu", 50000, "Hạn sử dụng 6 tháng", "Đồi thông 2 mộ"));
        productList.put(2, new Product(2, "Kẹo Yêu", 30000, "Hạn sử dụng 12 tháng", "Đồi thông 4 mộ"));
        productList.put(3, new Product(3, "Chup pa chip", 70000, "Hạn sử dụng 12 tháng", "Đồi thông 5 mộ"));
        productList.put(4, new Product(4, "Hương Chocalate", 20000, "Hạn sử dụng 6 tháng", "Đồi thông 6 mộ"));
    }

    @Override
    public List<Product> displayAll() {
        return new ArrayList<>(productList.values());
    }

    @Override
    public Product findById(int id) {
        return productList.get(id);
    }

    @Override
    public List<Product> searchByName(String name) {
        List<Product> searchList = new ArrayList<>();
        for (Map.Entry<Integer, Product> item : productList.entrySet()) {
            if (item.getValue().getName().toLowerCase().contains(name.toLowerCase())) {
                searchList.add(item.getValue());
            }
        }
        return searchList;
    }

    @Override
    public void update(int id, Product product) {
        productList.put(id, product);
    }

    @Override
    public void delete(int id) {
        productList.remove(id);
    }
}
