package entities.entity.product;

import interf.InterValueId;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table(name = "stock")
@NamedQueries({
    @NamedQuery(name = "Stock.findAll", query = "SELECT e FROM Stock e"),
    @NamedQuery(name = "Stock.findLike", query = "SELECT e FROM Stock e WHERE e.produtoCodeBar LIKE :codebar"),
    @NamedQuery(name = "Stock.findByEstoqueQtd", query = "SELECT e FROM Stock e WHERE e.estoqueQtd = :estoqueQtd")})
public class Stock extends Product implements Serializable, InterValueId {

    @Column(name = "estoque_qtd")
    private int estoqueQtd;

    public Stock() {
    }

    public Stock(Integer produtoId) {
        super(produtoId);
    }

  
    public int getEstoqueQtd() {
        return estoqueQtd;
    }

    public void setEstoqueQtd(int estoqueQtd) {
        this.estoqueQtd = estoqueQtd;
    }
}
