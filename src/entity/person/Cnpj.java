package entity.person;

import entity.Person;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "cnpj")

@NamedQueries({
    @NamedQuery(name = "Cnpj.findAll", query = "SELECT c FROM Cnpj c")
    , @NamedQuery(name = "Cnpj.findByPessoaId", query = "SELECT c FROM Cnpj c WHERE c.pessoaId = :pessoaId")
    , @NamedQuery(name = "Cnpj.findByCnpjNumber", query = "SELECT c FROM Cnpj c WHERE c.cnpjNumber = :cnpjNumber")
    , @NamedQuery(name = "Cnpj.findByInscEstadual", query = "SELECT c FROM Cnpj c WHERE c.inscEstadual = :inscEstadual")
    , @NamedQuery(name = "Cnpj.findByInscMunicipal", query = "SELECT c FROM Cnpj c WHERE c.inscMunicipal = :inscMunicipal")})
@DiscriminatorColumn(name = "CNPJ")
@PrimaryKeyJoinColumn(referencedColumnName = "pessoa_id")
public class Cnpj extends Person implements Serializable, interf.InterValueId {

    private static final long serialVersionUID = 1L;
    @Column(name = "cnpj_number")
    private String cnpjNumber;
    @Column(name = "insc_estadual")
    private String inscEstadual;
    @Column(name = "insc_municipal")
    private String inscMunicipal;
   
    public Cnpj() {
    }

    public Cnpj(Integer pessoaId) {
        super(pessoaId);
    }

    public String getCnpjNumber() {
        return cnpjNumber;
    }

    public void setCnpjNumber(String cnpjNumber) {
        this.cnpjNumber = cnpjNumber;
    }

    public String getInscEstadual() {
        return inscEstadual;
    }

    public void setInscEstadual(String inscEstadual) {
        this.inscEstadual = inscEstadual;
    }

    public String getInscMunicipal() {
        return inscMunicipal;
    }

    public void setInscMunicipal(String inscMunicipal) {
        this.inscMunicipal = inscMunicipal;
    }



}
