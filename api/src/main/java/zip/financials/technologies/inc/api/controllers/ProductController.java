package zip.financials.technologies.inc.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import zip.financials.technologies.inc.api.models.Product;
import zip.financials.technologies.inc.api.services.ProductService;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("v1/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @RequestMapping("/create")
    public Product CreateProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @RequestMapping("/readAll")
    public List<Product> ReadAllProduct() {
        return service.readAllProduct();
    }

    @RequestMapping("/read/{productId}")
    public Product ReadProduct(@PathVariable Integer productId) {
        return service.readProduct(productId);
    }

    @RequestMapping("/update/{productId}")
    public Product UpdateProduct(@PathVariable Integer productId, @RequestBody Product product) {
        return service.updateProduct(productId, product);
    }

    @RequestMapping("/delete/{productId}")
    public Product DeleteProduct(@PathVariable Integer productId) {
        return service.deleteProduct(productId);
    }
}
