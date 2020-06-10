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
@Table(name = "measure")
@NamedQueries({
    @NamedQuery(name = "Measure.findAll", query = "SELECT m FROM Measure m"),
    @NamedQuery(name = "Measure.findByMeasureId", query = "SELECT m FROM Measure m WHERE m.measureId = :measureId"),
    @NamedQuery(name = "Measure.findByMeasureName", query = "SELECT m FROM Measure m WHERE m.measureName = :measureName")})
public class Measure implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "measureId")
    private Integer measureId;
    @Column(name = "measureName")
    private String measureName;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "measure")
    private Collection<Product> productCollection;

    public Measure() {
    }

    public Measure(Integer medidaId) {
        this.measureId = medidaId;
    }

    @Override
    public Integer getId() {
        return measureId;
    }

    public void setMedidaId(Integer medidaId) {
        this.measureId = medidaId;
    }

    public String getMedida() {
        return measureName;
    }

    public void setMedida(String medida) {
        this.measureName = medida;
    }

    public Collection<Product> getProdutoCollection() {
        return productCollection;
    }

    public void setProdutoCollection(Collection<Product> productCollection) {
        this.productCollection = productCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (measureId != null ? measureId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Measure)) {
            return false;
        }
        Measure other = (Measure) object;
        return !((this.measureId == null && other.measureId != null) || (this.measureId != null && !this.measureId.equals(other.measureId)));
    }

    @Override
    public String toString() {
        return this.measureName;
    }
    
}
