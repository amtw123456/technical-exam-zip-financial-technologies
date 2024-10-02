package zip.financials.technologies.inc.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import zip.financials.technologies.inc.api.models.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}