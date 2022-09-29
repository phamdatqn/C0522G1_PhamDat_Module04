package smartphone_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import smartphone_management.model.Smartphone;

public interface ISmartphoneRepository extends JpaRepository<Smartphone,Integer> {
}
