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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author colpv
 */
@Entity
@Table(name = "SaleItem")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SaleItem.findAll", query = "SELECT i FROM SaleItem i"),
    @NamedQuery(name = "SaleItem.findByItemVenda", query = "SELECT i FROM SaleItem i WHERE i.itemVenda = :itemVenda"),
    @NamedQuery(name = "SaleItem.findByItemVendaQtd", query = "SELECT i FROM SaleItem i WHERE i.itemVendaQtd = :itemVendaQtd")})
public class SaleItem implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "item_venda")
    private Integer itemVenda;
    @Column(name = "item_venda_qtd")
    private Integer itemVendaQtd;
    @JoinColumn(name = "id_produto_venda", referencedColumnName = "produto_id")
    @ManyToOne(optional = false)
    private Product idProdutoVenda;
    @JoinColumn(name = "id_venda", referencedColumnName = "venda_id")
    @ManyToOne(optional = false)
    private Sale idVenda;

    public SaleItem() {
    }

    public SaleItem(Integer itemVenda) {
        this.itemVenda = itemVenda;
    }

    @Override
    public Integer getId() {
        return itemVenda;
    }

    public void setItemVenda(Integer itemVenda) {
        this.itemVenda = itemVenda;
    }

    public Integer getItemVendaQtd() {
        return itemVendaQtd;
    }

    public void setItemVendaQtd(Integer itemVendaQtd) {
        this.itemVendaQtd = itemVendaQtd;
    }

    public Product getIdProdutoVenda() {
        return idProdutoVenda;
    }

    public void setIdProdutoVenda(Product idProdutoVenda) {
        this.idProdutoVenda = idProdutoVenda;
    }

    public Sale getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(Sale idVenda) {
        this.idVenda = idVenda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (itemVenda != null ? itemVenda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SaleItem)) {
            return false;
        }
        SaleItem other = (SaleItem) object;
        if ((this.itemVenda == null && other.itemVenda != null) || (this.itemVenda != null && !this.itemVenda.equals(other.itemVenda))) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "entidades.entity.ItemVenda[ itemVenda=" + itemVenda + " ]";
    }
    
}
