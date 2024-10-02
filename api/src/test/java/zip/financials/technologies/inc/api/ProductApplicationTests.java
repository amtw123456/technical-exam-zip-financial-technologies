package zip.financials.technologies.inc.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import zip.financials.technologies.inc.api.enums.ProductType;
import zip.financials.technologies.inc.api.models.Product;
import zip.financials.technologies.inc.api.services.ProductService;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductApplicationTests {

	@Autowired
	private ProductService productService;

	@Test
	void testCreateProduct() {
		Product product = new Product();
		product.setName("Smartphone");
		product.setDescription("A high-end smartphone");
		product.setProductType(ProductType.ELECTRONIC);
		product.setQuantity(100);
		product.setUnitPrice(999.99);
		product.setRequirements("Charger included");

		Product createdProduct = productService.createProduct(product);

		assertNotNull(createdProduct.getId(), "Product ID should not be null after save");
		assertNotNull(createdProduct, "Created product should not be null");

		// Deletes the testing product created for this test
		productService.deleteProduct(createdProduct.getId());
	}

	@Test
	void testReadProduct() {
		Product product = new Product();
		product.setName("Sample Product");
		product.setDescription("This is a sample product.");
		product.setProductType(ProductType.HOUSEHOLD);
		product.setQuantity(10);
		product.setUnitPrice(29.99);
		product.setRequirements("No special requirements.");

		Product createdProduct = productService.createProduct(product);
		assertNotNull(createdProduct.getId(), "Created product ID should not be null");

		Product fetchedProduct = productService.readProduct(createdProduct.getId());

		assertNotNull(fetchedProduct, "Fetched product should not be null");
		assertEquals(createdProduct.getId(), fetchedProduct.getId(),
				"Fetched product ID should match the created product ID");
		assertEquals(createdProduct.getName(), fetchedProduct.getName(),
				"Fetched product name should match the created product name");
		assertEquals(createdProduct.getDescription(), fetchedProduct.getDescription(),
				"Fetched product description should match the created product description");
		assertEquals(createdProduct.getProductType(), fetchedProduct.getProductType(),
				"Fetched product type should match the created product type");
		assertEquals(createdProduct.getQuantity(), fetchedProduct.getQuantity(),
				"Fetched product quantity should match the created product quantity");
		assertEquals(createdProduct.getUnitPrice(), fetchedProduct.getUnitPrice(),
				"Fetched product unit price should match the created product unit price");
		assertEquals(createdProduct.getRequirements(), fetchedProduct.getRequirements(),
				"Fetched product requirements should match the created product requirements");

		// Deletes the testing product created for this test
		productService.deleteProduct(createdProduct.getId());
	}

	@Test
	void testUpdateProduct() {

		Product product = new Product();
		product.setName("Old Smartphone");
		product.setDescription("An old smartphone");
		product.setProductType(ProductType.APPLIANCE);
		product.setQuantity(50);
		product.setUnitPrice(499.99);
		product.setRequirements("Basic charger included");
		Product createdProduct = productService.createProduct(product);

		Product updatedProduct = new Product();
		updatedProduct.setName("New Smartphone");
		updatedProduct.setDescription("An updated high-end smartphone");
		updatedProduct.setProductType(ProductType.ELECTRONIC);
		updatedProduct.setQuantity(75);
		updatedProduct.setUnitPrice(799.99);
		updatedProduct.setRequirements("Updated charger included");

		Product updatedProductResult = productService.updateProduct(createdProduct.getId(), updatedProduct);

		assertEquals(updatedProduct.getName(), updatedProductResult.getName(),
				"Product name should match the updated name");
		assertEquals(updatedProduct.getDescription(), updatedProductResult.getDescription(),
				"Product description should match the updated description");
		assertEquals(updatedProduct.getQuantity(), updatedProductResult.getQuantity(),
				"Product quantity should match the updated quantity");
		assertEquals(updatedProduct.getUnitPrice(), updatedProductResult.getUnitPrice(),
				"Product unit price should match the updated unit price");
		assertEquals(updatedProduct.getProductType(), updatedProductResult.getProductType(),
				"Product type should match the updated product type");
		assertEquals(updatedProduct.getRequirements(), updatedProductResult.getRequirements(),
				"Product requirements should match the updated requirements");

		// Deletes the testing product created for this test
		productService.deleteProduct(createdProduct.getId());
	}

	@Test
	void testDeleteProduct() {
		Product product = new Product();
		product.setName("Smart TV");
		product.setDescription("A large smart TV");
		product.setProductType(ProductType.ELECTRONIC);
		product.setQuantity(20);
		product.setUnitPrice(1299.99);
		product.setRequirements("HDMI and power cable included");
		Product createdProduct = productService.createProduct(product);
		Product deletedProduct = productService.deleteProduct(createdProduct.getId());

		assertNotNull(deletedProduct, "Deleted product should not be null");
		assertEquals(createdProduct.getId(), deletedProduct.getId(),
				"Deleted product ID should match the created product ID");
	}
}
