package entity.person;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT c FROM Employee c"),
    @NamedQuery(name = "Employee.findByPessoaId", query = "SELECT c FROM Employee c WHERE c.personId = :personId"),
    @NamedQuery(name = "Employee.findByCpfNumber", query = "SELECT c FROM Employee c WHERE c.socialNumber = :socialNumber"),
    @NamedQuery(name = "Employee.findByEstadoCivil", query = "SELECT c FROM Employee c WHERE c.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "Employee.findByNickname", query = "SELECT c FROM Employee c WHERE c.nickname = :nickname"),
    @NamedQuery(name = "Employee.findByLocalTrabalho", query = "SELECT c FROM Employee c WHERE c.workplace = :workplace"),
    @NamedQuery(name = "Employee.findByProfissao", query = "SELECT c FROM Employee c WHERE c.professionName = :professionName"),
    @NamedQuery(name = "Employee.findByRg", query = "SELECT c FROM Employee c WHERE c.rg = :rg"),
    @NamedQuery(name = "Employee.findBySalario", query = "SELECT c FROM Employee c WHERE c.salary = :salary"),
    @NamedQuery(name = "Employee.findBySexo", query = "SELECT c FROM Employee c WHERE c.sexOfPerson = :sexOfPerson"),
    @NamedQuery(name = "Employee.findByWorkcard", query = "SELECT c FROM Employee c WHERE c.workcard = :workcard"),
    @NamedQuery(name = "Employee.findByNumberPis", query = "SELECT c FROM Employee c WHERE c.numberPis = :numberPis"),
    @NamedQuery(name = "Employee.findByCnh", query = "SELECT c FROM Employee c WHERE c.cnh = :cnh"),
    @NamedQuery(name = "Employee.findByComission", query = "SELECT c FROM Employee c WHERE c.comission = :comission"),
    @NamedQuery(name = "Employee.findByEmployeeRole", query = "SELECT c FROM Employee c WHERE c.employeeRole = :employeeRole"),
    @NamedQuery(name = "Employee.findByVoterRegistration", query = "SELECT c FROM Employee c WHERE c.voterRegistration = :voterRegistration"),
    @NamedQuery(name = "Employee.findByAdmission", query = "SELECT c FROM Employee c WHERE c.admission = :admission")})
@DiscriminatorColumn(name = "Employee")
@PrimaryKeyJoinColumn(referencedColumnName = "personId")
public class Employee extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "socialNumber")
    private String socialNumber;

    @Column(name = "maritalStatus")
    private String maritalStatus;

    @Column(name = "nickname")
    private String nickname;

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

    @Column(name = "workcard")
    private String workcard;

    @Column(name = "numberPis")
    private String numberPis;

    @Column(name = "cnh")
    private String cnh;

    @Column(name = "comission")
    private Double comission;

    @Column(name = "employeeRole")
    private String employeeRole;

    // Documment brazilian
    @Column(name = "voterRegistration")
    private String voterRegistration;

//    @Temporal(TemporalType.DATE)
    @Column(name = "admission")
    private LocalDate admission;

    public Employee() {
    }

    public Employee(Integer personId) {
        super(personId);
    }

    public String getSocialNumber() {
        return socialNumber;
    }

    public void setSocialNumber(String socialNumber) {
        this.socialNumber = socialNumber;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
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
