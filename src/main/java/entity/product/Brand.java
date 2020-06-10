package entity.product;

import interf.InterValueId;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "brand")
@NamedQueries({
    @NamedQuery(name = "Brand.findAll", query = "SELECT b FROM Brand b"),
    @NamedQuery(name = "Brand.findBrandId", query = "SELECT b FROM Brand b WHERE b.brandId = :brandId"),
    @NamedQuery(name = "Brand.findByBrand", query = "SELECT b FROM Brand b WHERE b.brand = :brand")})
public class Brand implements Serializable,  InterValueId{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "brandId")
    private Integer brandId;
    @Basic(optional = false)
    @Column(name = "brand")
    private String brand;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "brand")
    private Collection<Product> productCollection;

    public Brand() {
    }

    public Brand(Integer brandId) {
        this.brandId = brandId;
    }

    public Brand(Integer brandId, String brand) {
        this.brandId = brandId;
        this.brand = brand;
    }

    @Override
    public Integer getId() {
        return brandId;
    }

    public void setBrandId(Integer brendId) {
        this.brandId = brendId;
    }

    public String getBrand() {
        return brand;
    }

    public void setMarca(String brand) {
        this.brand = brand;
    }


    public Collection<Product> getProductCollection() {
        return productCollection;
    }

    public void setProductCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (brandId != null ? brandId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        return !((this.brandId == null && other.brandId != null) || (this.brandId != null && !this.brandId.equals(other.brandId)));
    }

    @Override
    public String toString() {
        return this.brand;
    }
    
}
