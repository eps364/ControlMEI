/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import entity.product.Product;
import interf.InterValueId;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


/**
 *
 * @author colpv
 */
@Entity
@Table(name = "SaleItem")
@NamedQueries({
    @NamedQuery(name = "SaleItem.findAll", query = "SELECT i FROM SaleItem i"),
    @NamedQuery(name = "SaleItem.findByISaleId", query = "SELECT i FROM SaleItem i WHERE i.saleItemId = :saleItem"),
    @NamedQuery(name = "SaleItem.findByISaleItemQtt", query = "SELECT i FROM SaleItem i WHERE i.saleItemQtt = :saleItemQtt")})
public class SaleItem implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "saleItemId")
    private Integer saleItemId;
    @Column(name = "saleItemQtt")
    private Integer saleItemQtt;
    
    @JoinColumn(name = "saleProductId", referencedColumnName = "productId")
    @ManyToOne(optional = false)
    private Product product;
    
    @JoinColumn(name = "idOfSaleItem", referencedColumnName = "saleId")
    @ManyToOne(optional = false)
    private Sale sale;

    public SaleItem() {
    }

    public SaleItem(Integer itemVenda) {
        this.saleItemId = itemVenda;
    }

    @Override
    public Integer getId() {
        return saleItemId;
    }

    public void setSaleItem(Integer saleItemId) {
        this.saleItemId = saleItemId;
    }

    public Integer getItemQuantity() {
        return saleItemQtt;
    }

    public void setItemQuantity(Integer saleItemQtt) {
        this.saleItemQtt = saleItemQtt;
    }

    public Product getSaleProduct() {
        return product;
    }

    public void setSaleProduct(Product saleProduct) {
        this.product = saleProduct;
    }

    public Sale getSale() {
        return sale;
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleItemId != null ? saleItemId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleItem)) {
            return false;
        }
        SaleItem other = (SaleItem) object;
        return !((this.saleItemId == null && other.saleItemId != null) || (this.saleItemId != null && !this.saleItemId.equals(other.saleItemId)));
    }
    
    

    @Override
    public String toString() {
        return "entity.saleItem[ saleItemId=" + saleItemId + " ]";
    }
    
}
