
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
@Table(name = "category")
@NamedQueries({
    @NamedQuery(name = "Category.findAll", query = "SELECT c FROM Category c"),
    @NamedQuery(name = "Category.findByCategoriaId", query = "SELECT c FROM Category c WHERE c.categoriaId = :categoriaId"),
    @NamedQuery(name = "Category.findByCategoria", query = "SELECT c FROM Category c WHERE c.categoria = :categoria")})
public class Category implements Serializable, InterValueId {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCategoria")
    private Collection<Product> produtoCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "categoria_id")
    private Integer categoriaId;
    @Basic(optional = false)
    @Column(name = "categoria")
    private String categoria;

    public Category() {
    }

    public Category(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public Category(Integer categoriaId, String categoria) {
        this.categoriaId = categoriaId;
        this.categoria = categoria;
    }

    

    public void setCategoriaId(Integer categoriaId) {
        this.categoriaId = categoriaId;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (categoriaId != null ? categoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Category)) {
            return false;
        }
        Category other = (Category) object;
        if ((this.categoriaId == null && other.categoriaId != null) || (this.categoriaId != null && !this.categoriaId.equals(other.categoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return this.categoria;
    }

    @Override
    public Integer getId() {
       return this.categoriaId;
    }

    public Collection<Product> getProdutoCollection() {
        return produtoCollection;
    }

    public void setProdutoCollection(Collection<Product> produtoCollection) {
        this.produtoCollection = produtoCollection;
    }
    
}
