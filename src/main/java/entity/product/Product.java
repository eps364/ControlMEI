package entity.product;

import entity.person.Person;
import entity.SaleItem;
import interf.InterValueId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "product")

@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;

    @Column(name = "DTYPE")
    private String dtype;

    @Column(name = "percentage")
    private BigDecimal percentage;

    @Column(name = "nationalProduct")
    private String nationalProduct;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "productId")
    private Integer productId;

    @Column(name = "productName")
    private String productName;

    @Column(name = "productObservation")
    private String productObservation;

    @Column(name = "productCodeBar")
    private String productCodeBar;

    @Column(name = "productStatus")
    private String productStatus;

    @Column(name = "warranty")
    private Integer warranty;

    @Column(name = "saleComission")
    private BigDecimal salesCommission;

    @Column(name = "saleProfit")
    private BigDecimal saleProfit;

    @Column(name = "productImage")
    private String productImage;

    @Column(name = "parchasePrice")
    private BigDecimal parchasePrice;

    @Column(name = "salePrice")
    private BigDecimal salePrice;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
    private Collection<SaleItem> saleItems;

    @JoinColumn(name = "productCatogoryId", referencedColumnName = "categoryId")
    @ManyToOne(optional = false)
    private Category category;

    @JoinColumn(name = "productBrandId", referencedColumnName = "brandId")
    @ManyToOne(optional = false)
    private Brand brand;

    @JoinColumn(name = "productMeasureId", referencedColumnName = "measureId")
    @ManyToOne(optional = false)
    private Measure measure;

    @JoinColumn(name = "productSectionId", referencedColumnName = "sectionId")
    @ManyToOne(optional = false)
    private ProductSection section;

    @JoinColumn(name = "SupplierId", referencedColumnName = "personId")
    @ManyToOne(optional = false)
    private Person supplier;

    public Product() {
    }

    public Product(Integer produtoId) {
        this.productId = produtoId;
    }

    @Override
    public Integer getId() {
        return productId;
    }

    public void setProdutoId(Integer produtoId) {
        this.productId = produtoId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getCodeBar() {
        return productCodeBar;
    }

    public void setCodeBar(String productCodebar) {
        this.productCodeBar = productCodebar;
    }

    public String getObservation() {
        return productObservation;
    }

    public void setObservation(String productObervation) {
        this.productObservation = productObervation;
    }

    public String getProductStatus() {
        return productStatus;
    }

    public void setProductStatus(String productStatus) {
        this.productStatus = productStatus;
    }

    public BigDecimal getParchasePrice() {
        if (this.parchasePrice == null) {
            parchasePrice = BigDecimal.ZERO;
        }

        return parchasePrice;
    }

    public void setParchasePrice(BigDecimal parchasePrice) {

        this.parchasePrice = parchasePrice;
    }

    public BigDecimal getSalePrice() {
        if (this.salePrice == null) {
            salePrice = BigDecimal.ZERO;
        }
        return salePrice;
    }

    public void setSalePrice(BigDecimal salePrice) {
        this.salePrice = salePrice;
    }

    public Integer getWarranty() {
        if (this.warranty == null) {
            warranty = 0;
        }
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public BigDecimal getSalesCommission() {
        if (this.salesCommission == null) {
            salesCommission = BigDecimal.ZERO;
        }
        return salesCommission;
    }

    public void setSalesCommission(BigDecimal salesCommission) {
        this.salesCommission = salesCommission;
    }

    public BigDecimal getProfit() {
        if (this.saleProfit == null) {
            saleProfit = BigDecimal.ZERO;
        }
        return saleProfit;
    }

    public void setProfit(BigDecimal profit) {
        this.saleProfit = profit;
    }

    public String getProductImage() {
        if (this.productImage == null) {
            productImage = "";
        }
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public Measure getMeasure() {
        return measure;
    }

    public void setMeasure(Measure measure) {
        this.measure = measure;
    }

    public ProductSection getIdSecao() {
        return section;
    }

    public void setIdSecao(ProductSection idSecao) {
        this.section = idSecao;
    }

    public Person getSupplier() {
        return supplier;
    }

    public void setSupplier(Person person) {
        this.supplier = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (productId != null ? productId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        return !((this.productId == null && other.productId != null) || (this.productId != null && !this.productId.equals(other.productId)));
    }

    @Override
    public String toString() {
        return "entidades.entity.Product[ productId=" + productId + " ]";
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    public String getNational() {
        return nationalProduct;
    }

    public void setNational(String national) {
        this.nationalProduct = national;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }


    public Collection<SaleItem> getItemSaleCollection() {
        return saleItems;
    }

    public void setItemVendaCollection(Collection<SaleItem> saleItemCollection) {
        this.saleItems = saleItemCollection;
    }

}
