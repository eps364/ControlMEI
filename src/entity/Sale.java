/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import interf.InterValueId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author colpv
 */
@Entity
@Table(name = "Sale")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT v FROM Sale v"),
    @NamedQuery(name = "Sale.findByVendaId", query = "SELECT v FROM Sale v WHERE v.vendaId = :vendaId"),
    @NamedQuery(name = "Sale.findByVendaValor", query = "SELECT v FROM Sale v WHERE v.vendaValor = :vendaValor"),
    @NamedQuery(name = "Sale.findByVendaData", query = "SELECT v FROM Sale v WHERE v.vendaData = :vendaData"),
    @NamedQuery(name = "Sale.findByVendaStatus", query = "SELECT v FROM Sale v WHERE v.vendaStatus = :vendaStatus")})
public class Sale implements Serializable, InterValueId {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idVenda")
    private Collection<SaleItem> itemVendaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "venda_id")
    private Integer vendaId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "venda_valor")
    private BigDecimal vendaValor;
    @Column(name = "venda_data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date vendaData;
    @Column(name = "venda_status")
    private String vendaStatus;
    @JoinColumn(name = "id_pgto_venda", referencedColumnName = "pagamento_id")
    @ManyToOne(optional = false)
    private Paygamment idPgtoVenda;
    @JoinColumn(name = "id_cliente", referencedColumnName = "pessoa_id")
    @ManyToOne(optional = false)
    private Person idCliente;

    public Sale() {
    }

    public Sale(Integer vendaId) {
        this.vendaId = vendaId;
    }

    @Override
    public Integer getId() {
        return vendaId;
    }

    public void setVendaId(Integer vendaId) {
        this.vendaId = vendaId;
    }

    public BigDecimal getVendaValor() {
        return vendaValor;
    }

    public void setVendaValor(BigDecimal vendaValor) {
        this.vendaValor = vendaValor;
    }

    public Date getVendaData() {
        return vendaData;
    }

    public void setVendaData(Date vendaData) {
        this.vendaData = vendaData;
    }

    public String getVendaStatus() {
        return vendaStatus;
    }

    public void setVendaStatus(String vendaStatus) {
        this.vendaStatus = vendaStatus;
    }

    public Paygamment getIdPgtoVenda() {
        return idPgtoVenda;
    }

    public void setIdPgtoVenda(Paygamment idPgtoVenda) {
        this.idPgtoVenda = idPgtoVenda;
    }

    public Person getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Person idCliente) {
        this.idCliente = idCliente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vendaId != null ? vendaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        return !((this.vendaId == null && other.vendaId != null) || (this.vendaId != null && !this.vendaId.equals(other.vendaId)));
    }

    @Override
    public String toString() {
        return "entidades.entity.Venda[ vendaId=" + vendaId + " ]";
    }

    @XmlTransient
    public Collection<SaleItem> getItemVendaCollection() {
        return itemVendaCollection;
    }

    public void setItemVendaCollection(Collection<SaleItem> itemVendaCollection) {
        this.itemVendaCollection = itemVendaCollection;
    }
    
}
