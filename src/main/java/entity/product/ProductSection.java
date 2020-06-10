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
@Table(name = "ProductSection")
@NamedQueries({
    @NamedQuery(name = "ProductSection.findAll", query = "SELECT s FROM ProductSection s"),
    @NamedQuery(name = "ProductSection.findBySectionId", query = "SELECT s FROM ProductSection s WHERE s.sectionId = :sectionId"),
    @NamedQuery(name = "ProductSection.findBySectionName", query = "SELECT s FROM ProductSection s WHERE s.sectionName = :sectionName")})
public class ProductSection implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sectionId")
    private Integer sectionId;
    @Column(name = "sectionName")
    private String sectionName;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "section")
    private Collection<Product> productCollection;

    public ProductSection() {
    }

    public ProductSection(Integer sectionId) {
        this.sectionId = sectionId;
    }


    @Override
    public Integer getId() {
        return sectionId;
    }

    public void setSectionId(Integer sectionId) {
        this.sectionId = sectionId;
    }

    public String getSectionName() {
        return sectionName;
    }

    public void setSectionName(String sectionName) {
        this.sectionName = sectionName;
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
        hash += (sectionId != null ? sectionId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSection)) {
            return false;
        }
        ProductSection other = (ProductSection) object;
        return !((this.sectionId == null && other.sectionId != null) || (this.sectionId != null && !this.sectionId.equals(other.sectionId)));
    }

    @Override
    public String toString() {
        return this.sectionName;
    }
    
}
