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
    @NamedQuery(name = "Measure.findByMedidaId", query = "SELECT m FROM Measure m WHERE m.medidaId = :medidaId"),
    @NamedQuery(name = "Measure.findByMedida", query = "SELECT m FROM Measure m WHERE m.medida = :medida")})
public class Measure implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "medida_id")
    private Integer medidaId;
    @Column(name = "medida")
    private String medida;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMedida")
    private Collection<Product> produtoCollection;

    public Measure() {
    }

    public Measure(Integer medidaId) {
        this.medidaId = medidaId;
    }

    @Override
    public Integer getId() {
        return medidaId;
    }

    public void setMedidaId(Integer medidaId) {
        this.medidaId = medidaId;
    }

    public String getMedida() {
        return medida;
    }

    public void setMedida(String medida) {
        this.medida = medida;
    }

    public Collection<Product> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Product> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (medidaId != null ? medidaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Measure)) {
            return false;
        }
        Measure other = (Measure) object;
        if ((this.medidaId == null && other.medidaId != null) || (this.medidaId != null && !this.medidaId.equals(other.medidaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.medida;
    }
    
}
