/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author colpv
 */
@Entity
@Table(name = "Paygamment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Paygamment.findAll", query = "SELECT p FROM Paygamment p"),
    @NamedQuery(name = "Paygamment.findByPagamentoId", query = "SELECT p FROM Paygamment p WHERE p.pagamentoId = :pagamentoId"),
    @NamedQuery(name = "Paygamment.findByPagamentoTipo", query = "SELECT p FROM Paygamment p WHERE p.pagamentoTipo = :pagamentoTipo")})
public class Paygamment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "pagamento_id")
    private Integer pagamentoId;
    @Column(name = "pagamento_tipo")
    private String pagamentoTipo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPgtoVenda")
    private Collection<Sale> vendaCollection;

    public Paygamment() {
    }

    public Paygamment(Integer pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public Integer getPagamentoId() {
        return pagamentoId;
    }

    public void setPagamentoId(Integer pagamentoId) {
        this.pagamentoId = pagamentoId;
    }

    public String getPagamentoTipo() {
        return pagamentoTipo;
    }

    public void setPagamentoTipo(String pagamentoTipo) {
        this.pagamentoTipo = pagamentoTipo;
    }

    @XmlTransient
    public Collection<Sale> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Sale> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pagamentoId != null ? pagamentoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paygamment)) {
            return false;
        }
        Paygamment other = (Paygamment) object;
        if ((this.pagamentoId == null && other.pagamentoId != null) || (this.pagamentoId != null && !this.pagamentoId.equals(other.pagamentoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.entity.Pagamento[ pagamentoId=" + pagamentoId + " ]";
    }
    
}
