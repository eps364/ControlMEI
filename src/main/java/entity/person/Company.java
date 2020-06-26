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
@Table(name = "company")

@NamedQueries({
    @NamedQuery(name = "Company.findAll", query = "SELECT c FROM Company c"),
    @NamedQuery(name = "Company.findByPessoaId", query = "SELECT c FROM Company c WHERE c.personId = :personId"),
    @NamedQuery(name = "Company.findByCnpjNumber", query = "SELECT c FROM Company c WHERE c.companyNumber = :companyNumber"),
    @NamedQuery(name = "Company.findByFantasyName", query = "SELECT c FROM Company c WHERE c.fantasyName = :fantasyName"),
    @NamedQuery(name = "Company.findByInscEstadual", query = "SELECT c FROM Company c WHERE c.stateRegister = :stateRegister")})
@DiscriminatorColumn(name = "Company")
@PrimaryKeyJoinColumn(referencedColumnName = "personId")
public class Company extends Person implements Serializable, interf.InterValueId {

    private static final long serialVersionUID = 1L;
    @Column(name = "companyNumber")
    private String companyNumber;

    @Column(name = "stateRegister")
    private String stateRegister;

    @Column(name = "fantasyName")
    private String fantasyName;

    public Company() {
    }

    public Company(Integer pessoaId) {
        super(pessoaId);
    }

    public String getCnpjNumber() {
        return companyNumber;
    }

    public void setCnpjNumber(String cnpjNumber) {
        this.companyNumber = cnpjNumber;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public String getStateRegister() {
        return stateRegister;
    }

    public void setStateRegister(String inscEstadual) {
        this.stateRegister = inscEstadual;
    }

}
