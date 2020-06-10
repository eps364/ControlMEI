package entity;

import entity.person.Person;
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

/**
 *
 * @author colpv
 */
@Entity
@Table(name = "Sale")
@NamedQueries({
    @NamedQuery(name = "Sale.findAll", query = "SELECT v FROM Sale v"),
    @NamedQuery(name = "Sale.findBySaleId", query = "SELECT v FROM Sale v WHERE v.saleId = :saleId"),
    @NamedQuery(name = "Sale.findBySaleValor", query = "SELECT v FROM Sale v WHERE v.totalSalePrice = :totalSalePrice"),
    @NamedQuery(name = "Sale.findBySaleDate", query = "SELECT v FROM Sale v WHERE v.dateOfSale = :dateOfSale"),
    @NamedQuery(name = "Sale.findBySaleStatus", query = "SELECT v FROM Sale v WHERE v.saleStatus = :saleStatus")})
public class Sale implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "saleId")
    private Integer saleId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "totalSalePrice")
    private BigDecimal totalSalePrice;

    @Column(name = "dateOfSale")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfSale;

    @Column(name = "saleStatus")
    private String saleStatus;

    @JoinColumn(name = "paymentSaleId", referencedColumnName = "paymentId")
    @ManyToOne(optional = false)
    private Paygamment paymentSale;

    @JoinColumn(name = "productPersonId", referencedColumnName = "personId")
    @ManyToOne(optional = false)
    private Person costumer;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sale")
    private Collection<SaleItem> items;

    public Sale() {
    }

    public Sale(Integer saleId) {
        this.saleId = saleId;
    }

    @Override
    public Integer getId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public BigDecimal getTotalSalePrice() {
        return totalSalePrice;
    }

    public void setTotalSalePrice(BigDecimal totalSalePrice) {
        this.totalSalePrice = totalSalePrice;
    }

    public Date getDateOfSale() {
        return dateOfSale;
    }

    public void setDateOfSale(Date dateOfSale) {
        this.dateOfSale = dateOfSale;
    }

    public String getSaleStatus() {
        return saleStatus;
    }

    public void setSaleStatus(String saleStatus) {
        this.saleStatus = saleStatus;
    }

    public Paygamment getPaymentSale() {
        return paymentSale;
    }

    public void setPaymentSale(Paygamment paymentSale) {
        this.paymentSale = paymentSale;
    }

    public Person getCustomer() {
        return costumer;
    }

    public void setCostumer(Person costumer) {
        this.costumer = costumer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (saleId != null ? saleId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Sale)) {
            return false;
        }
        Sale other = (Sale) object;
        return !((this.saleId == null && other.saleId != null) || (this.saleId != null && !this.saleId.equals(other.saleId)));
    }

    @Override
    public String toString() {
        return "entity.Sale[ saleId=" + saleId + " ]";
    }

    public Collection<SaleItem> getSaleItemCollection() {
        return items;
    }

    public void setSaleItemCollection(Collection<SaleItem> saleItemCollection) {
        this.items = saleItemCollection;
    }

}
