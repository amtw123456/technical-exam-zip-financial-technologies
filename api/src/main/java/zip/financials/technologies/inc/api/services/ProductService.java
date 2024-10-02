package zip.financials.technologies.inc.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import zip.financials.technologies.inc.api.models.Product;
import zip.financials.technologies.inc.api.repositories.ProductRepo;

@Service
public class ProductService {

    @Autowired
    private ProductRepo repo;

    public Product createProduct(Product product) {
        return repo.save(product);
    }

    public List<Product> readAllProduct() {
        return repo.findAll();
    }

    public Product readProduct(int id) {

        Optional<Product> existingProduct = repo.findById(id);
        return existingProduct.get();

    }

    public Product updateProduct(int id, Product updatedProductDetails) {
        Optional<Product> existingProduct = repo.findById(id);
        if (existingProduct.isPresent()) {
            Product product = existingProduct.get();
            product.setName(updatedProductDetails.getName());
            product.setDescription(updatedProductDetails.getDescription());
            product.setProductType(updatedProductDetails.getProductType());
            product.setQuantity(updatedProductDetails.getQuantity());
            product.setUnitPrice(updatedProductDetails.getUnitPrice());
            product.setRequirements(updatedProductDetails.getRequirements());
            return repo.save(product);
        } else {
            return updatedProductDetails;
        }
    }

    public Product deleteProduct(int id) {
        Optional<Product> existingProduct = repo.findById(id);
        if (existingProduct.isPresent()) {
            repo.delete(existingProduct.get());
        }
        return existingProduct.get();
    }
}
