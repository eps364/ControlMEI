package entity.person;

import entity.Sale;
import entity.product.Product;
import entity.stage.State;
import interf.InterValueId;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")})
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable, InterValueId {

    @Column(name = "personStatus")
    private boolean personStatus;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)

    @Column(name = "personId")
    private Integer personId;

    @Column(name = "valueCredit")
    private Double valueCredit;

    @Column(name = "dateBirth")
    @Temporal(TemporalType.DATE)
    private Date dateBirth;

    @Column(name = "fantasyName")
    private String fantasyName;

    @Column(name = "companyName")
    private String companyName;

    @Column(name = "phone")
    private String phone;

    @Column(name = "cellPhone")
    private String cellPhone;

    @Column(name = "whatsapp")
    private String whatsapp;

    @Column(name = "email")
    private String email;

    @Column(name = "street")
    private String street;

    @Column(name = "reference")
    private String reference;

    @Column(name = "zipCode")
    private String zipCode;

    @Column(name = "districtName")
    private String districtName;

    @Column(name = "cityName")
    private String cityName;

    @JoinColumn(name = "personStateId", referencedColumnName = "stateCode")
    @ManyToOne(optional = false)
    private State state;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "customer")
    private Collection<Sale> saleCollection;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "supplier")
    private Collection<Product> productList;

    public Person() {
    }

    public Person(Integer pessoaId) {
        this.personId = pessoaId;
    }

    @Override
    public Integer getId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }

    public Double getValueCredit() {
        return valueCredit;
    }

    public void setValueCredit(Double valueCredit) {
        this.valueCredit = valueCredit;
    }

    public Date getNascimento() {
        return dateBirth;
    }

    public void setDateBirth(Date dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public boolean getPersonStatus() {
        return personStatus;
    }

    public void setPersonStatus(boolean personStatus) {
        this.personStatus = personStatus;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String fone) {
        this.phone = fone;
    }

    public String getCellPhone() {
        return cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getWhatsapp() {
        return whatsapp;
    }

    public void setWhatsapp(String whatsapp) {
        this.whatsapp = whatsapp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String cep) {
        this.zipCode = cep;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (personId != null ? personId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        return !((this.personId == null && other.personId != null) || (this.personId != null && !this.personId.equals(other.personId)));
    }

    @Override
    public String toString() {
        return this.companyName;
    }


    public Collection<Sale> getSaleCollection() {
        return saleCollection;
    }

    public void setVendaCollection(Collection<Sale> saleCollection) {
        this.saleCollection = saleCollection;
    }

    public Collection<Product> getProductCollection() {
        return productList;
    }

    public void setProdutoCollection(Collection<Product> productCollection) {
        this.productList = productCollection;
    }

}
