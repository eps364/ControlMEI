package entities.entity.person;

import entities.entity.Person;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table(name = "cpf")
@NamedQueries({
    @NamedQuery(name = "Cpf.findAll", query = "SELECT c FROM Cpf c")
    , @NamedQuery(name = "Cpf.findByPessoaId", query = "SELECT c FROM Cpf c WHERE c.pessoaId = :pessoaId")
    , @NamedQuery(name = "Cpf.findByCpfNumber", query = "SELECT c FROM Cpf c WHERE c.cpfNumber = :cpfNumber")
    , @NamedQuery(name = "Cpf.findByEstadoCivil", query = "SELECT c FROM Cpf c WHERE c.estadoCivil = :estadoCivil")
    , @NamedQuery(name = "Cpf.findByLocalTrabalho", query = "SELECT c FROM Cpf c WHERE c.localTrabalho = :localTrabalho")
    , @NamedQuery(name = "Cpf.findByProfissao", query = "SELECT c FROM Cpf c WHERE c.profissao = :profissao")
    , @NamedQuery(name = "Cpf.findByRg", query = "SELECT c FROM Cpf c WHERE c.rg = :rg")
    , @NamedQuery(name = "Cpf.findBySalario", query = "SELECT c FROM Cpf c WHERE c.salario = :salario")
    , @NamedQuery(name = "Cpf.findBySexo", query = "SELECT c FROM Cpf c WHERE c.sexo = :sexo")})
@DiscriminatorColumn(name = "CPF")
@PrimaryKeyJoinColumn(referencedColumnName = "pessoa_id")

public class Cpf extends Person implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "cpf_number")
    private String cpfNumber;
    @Column(name = "estado_civil")
    private String estadoCivil;
    @Column(name = "local_trabalho")
    private String localTrabalho;
    @Column(name = "profissao")
    private String profissao;
    @Column(name = "rg")
    private String rg;
    @Column(name = "salario")
    private Double salario;
    @Column(name = "sexo")
    private String sexo;

    public Cpf() {
    }

    public Cpf(Integer pessoaId) {
        super(pessoaId);
    }

    public String getCpfNumber() {
        return cpfNumber;
    }

    public void setCpfNumber(String cpfNumber) {
        this.cpfNumber = cpfNumber;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getLocalTrabalho() {
        return localTrabalho;
    }

    public void setLocalTrabalho(String localTrabalho) {
        this.localTrabalho = localTrabalho;
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

}
