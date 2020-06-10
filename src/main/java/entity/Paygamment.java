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

@Entity
@Table(name = "Paygamment")
@NamedQueries({
    @NamedQuery(name = "Paygamment.findAll", query = "SELECT p FROM Paygamment p"),
    @NamedQuery(name = "Paygamment.findByPagamentoId", query = "SELECT p FROM Paygamment p WHERE p.paymentId = :paymentId"),
    @NamedQuery(name = "Paygamment.findByPagamentoTipo", query = "SELECT p FROM Paygamment p WHERE p.payment = :payment")})
public class Paygamment implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "paymentId")
    private Integer paymentId;
    @Column(name = "payment")
    private String payment;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paymentSale")
    private Collection<Sale> saleCollection;

    public Paygamment() {
    }

    public Paygamment(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public Collection<Sale> getVendaCollection() {
        return saleCollection;
    }

    public void setVendaCollection(Collection<Sale> saleCollection) {
        this.saleCollection = saleCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paymentId != null ? paymentId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Paygamment)) {
            return false;
        }
        Paygamment other = (Paygamment) object;
        return !((this.paymentId == null && other.paymentId != null) || (this.paymentId != null && !this.paymentId.equals(other.paymentId)));
    }

    @Override
    public String toString() {
        return "entity.Paymment[ paymentId=" + paymentId + " ]";
    }

}
