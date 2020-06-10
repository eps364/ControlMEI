package entity.person;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "PersonCostumer")
@NamedQueries({
    @NamedQuery(name = "Costumer.findAll", query = "SELECT c FROM Costumer c")
    , @NamedQuery(name = "Costumer.findByPessoaId", query = "SELECT c FROM Costumer c WHERE c.personId = :personId")
    , @NamedQuery(name = "Costumer.findByCpfNumber", query = "SELECT c FROM Costumer c WHERE c.socialNumber = :socialNumber")
    , @NamedQuery(name = "Costumer.findByEstadoCivil", query = "SELECT c FROM Costumer c WHERE c.maritalStatus = :maritalStatus")
    , @NamedQuery(name = "Costumer.findByLocalTrabalho", query = "SELECT c FROM Costumer c WHERE c.workplace = :workplace")
    , @NamedQuery(name = "Costumer.findByProfissao", query = "SELECT c FROM Costumer c WHERE c.professionName = :professionName")
    , @NamedQuery(name = "Costumer.findByRg", query = "SELECT c FROM Costumer c WHERE c.rg = :rg")
    , @NamedQuery(name = "Costumer.findBySalario", query = "SELECT c FROM Costumer c WHERE c.salary = :salary")
    , @NamedQuery(name = "Costumer.findBySexo", query = "SELECT c FROM Costumer c WHERE c.sexOfPerson = :sexOfPerson")})
@DiscriminatorColumn(name = "Costumer")
@PrimaryKeyJoinColumn(referencedColumnName = "personId")

public class Costumer extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "socialNumber")
    private String socialNumber;
    
    @Column(name = "maritalStatus")
    private String maritalStatus;
    
    @Column(name = "workplace")
    private String workplace;
    
    @Column(name = "professionName")
    private String professionName;
    
    // Documment brazilian
    @Column(name = "rg")
    private String rg;
    
    @Column(name = "salary")
    private Double salary;
    
    @Column(name = "sexOfPerson")
    private String sexOfPerson;

    public Costumer() {
    }

    public Costumer(Integer personId) {
        super(personId);
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getWorkplace() {
        return workplace;
    }

    public void setWorkplace(String workplace) {
        this.workplace = workplace;
    }

    public String getProfessionName() {
        return professionName;
    }

    public void setProfessionName(String professionName) {
        this.professionName = professionName;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double Salalry) {
        this.salary = Salalry;
    }

    public String getSexOfPerson() {
        return sexOfPerson;
    }

    public void setSexOfPerson(String sexOfPerson) {
        this.sexOfPerson = sexOfPerson;
    }

}
