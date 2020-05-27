package entities.entity.product;

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
    @NamedQuery(name = "ProductSection.findBySecaoId", query = "SELECT s FROM ProductSection s WHERE s.secaoId = :secaoId"),
    @NamedQuery(name = "ProductSection.findBySecao", query = "SELECT s FROM ProductSection s WHERE s.secao = :secao")})
public class ProductSection implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "secao_id")
    private Integer secaoId;
    @Column(name = "secao")
    private String secao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idSecao")
    private Collection<Product> produtoCollection;

    public ProductSection() {
    }

    public ProductSection(Integer secaoId) {
        this.secaoId = secaoId;
    }


    @Override
    public Integer getId() {
        return secaoId;
    }

    public void setSecaoId(Integer secaoId) {
        this.secaoId = secaoId;
    }

    public String getSecao() {
        return secao;
    }

    public void setSecao(String secao) {
        this.secao = secao;
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
        hash += (secaoId != null ? secaoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProductSection)) {
            return false;
        }
        ProductSection other = (ProductSection) object;
        if ((this.secaoId == null && other.secaoId != null) || (this.secaoId != null && !this.secaoId.equals(other.secaoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.secao;
    }
    
}
