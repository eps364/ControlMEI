package entity.product;

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
    @NamedQuery(name = "Stock.findLike", query = "SELECT e FROM Stock e WHERE e.productCodeBar LIKE :productCodeBar"),
    @NamedQuery(name = "Stock.findByStockQtt", query = "SELECT e FROM Stock e WHERE e.stockQtt = :stockQtt")})
public class Stock extends Product implements Serializable, InterValueId {

    @Column(name = "stockQtt")
    private int stockQtt;

    public Stock() {
    }

    public Stock(Integer productId) {
        super(productId);
    }

  
    public int getStockQtt() {
        return stockQtt;
    }

    public void setStockQtt(int stockQtt) {
        this.stockQtt = stockQtt;
    }
}
