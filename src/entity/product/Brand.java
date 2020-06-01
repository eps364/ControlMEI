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
    @NamedQuery(name = "Brand.findAll", query = "SELECT m FROM Brand m"),
    @NamedQuery(name = "Brand.findByMarcaId", query = "SELECT m FROM Brand m WHERE m.marcaId = :marcaId"),
    @NamedQuery(name = "Brand.findByMarca", query = "SELECT m FROM Brand m WHERE m.marca = :marca")})
public class Brand implements Serializable,  InterValueId{

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "marca_id")
    private Integer marcaId;
    @Basic(optional = false)
    @Column(name = "marca")
    private String marca;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idMarca")
    private Collection<Product> produtoCollection;

    public Brand() {
    }

    public Brand(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public Brand(Integer marcaId, String marca) {
        this.marcaId = marcaId;
        this.marca = marca;
    }

    @Override
    public Integer getId() {
        return marcaId;
    }

    public void setMarcaId(Integer marcaId) {
        this.marcaId = marcaId;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
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
        hash += (marcaId != null ? marcaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Brand)) {
            return false;
        }
        Brand other = (Brand) object;
        if ((this.marcaId == null && other.marcaId != null) || (this.marcaId != null && !this.marcaId.equals(other.marcaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.marca;
    }
    
}
