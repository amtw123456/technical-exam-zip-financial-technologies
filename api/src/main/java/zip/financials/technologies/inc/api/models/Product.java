package zip.financials.technologies.inc.api.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import zip.financials.technologies.inc.api.enums.ProductType;

@Entity
@Data
@Table(name = "PRODUCT")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private int id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESCRIPTION", length = 500)
    private String description;

    @Column(name = "PRODUCT_TYPE", nullable = false)
    private ProductType productType;

    @Column(name = "QUANTITY", nullable = false)
    private int quantity;

    @Column(name = "UNIT_PRICE", nullable = false)
    private double unitPrice;

    @Column(name = "REQUIREMENTS", length = 1000)
    private String requirements;
}
