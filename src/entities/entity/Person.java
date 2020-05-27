package entities.entity;

import entities.entity.uf.States;
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
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "person")
@NamedQueries({
    @NamedQuery(name = "Person.findAll", query = "SELECT p FROM Person p")})
@Inheritance(strategy = InheritanceType.JOINED)
public class Person implements Serializable, InterValueId {

    @Column(name = "status")
    private boolean active;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCliente")
    private Collection<Sale> vendaCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pessoa_id")
    private Integer pessoaId;
    @Column(name = "credito")
    private Double credito;
    @Column(name = "nascimento")
    @Temporal(TemporalType.DATE)
    private Date nascimento;
    @Column(name = "nome_fantasia")
    private String nomeFantasia;
    @Column(name = "razao_social")
    private String razaoSocial;
    @Column(name = "fone")
    private String fone;
    @Column(name = "celular")
    private String celular;

    @Column(name = "whatsapp")
    private String whatsapp;
    @Column(name = "email")
    private String email;
    @Column(name = "rua")
    private String rua;
    @Column(name = "referencia")
    private String referencia;
    @Column(name = "cep")
    private String cep;
    @Column(name = "bairro")
    private String bairro;
    @Column(name = "cidade")
    private String cidade;

    @JoinColumn(name = "id_estado", referencedColumnName = "codigouf")
    @ManyToOne(optional = false)
    private States estado;

    public Person() {
    }

    public Person(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    @Override
    public Integer getId() {
        return pessoaId;
    }

    public void setPessoaId(Integer pessoaId) {
        this.pessoaId = pessoaId;
    }

    public Double getCredito() {
        return credito;
    }

    public void setCredito(Double credito) {
        this.credito = credito;
    }

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public boolean getActive() {
        return active;
    }

    public void setActive(boolean status) {
        this.active = status;
    }

    public String getFone() {
        return fone;
    }

    public void setFone(String fone) {
        this.fone = fone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
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

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getReferencia() {
        return referencia;
    }

    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public States getEstado() {
        return estado;
    }

    public void setEstado(States idEstado) {
        this.estado = idEstado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pessoaId != null ? pessoaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Person)) {
            return false;
        }
        Person other = (Person) object;
        return !((this.pessoaId == null && other.pessoaId != null) || (this.pessoaId != null && !this.pessoaId.equals(other.pessoaId)));
    }

    @Override
    public String toString() {
        return "entidades.abstracts.Pessoa[ pessoaId=" + pessoaId + " ]";
    }

    @XmlTransient
    public Collection<Sale> getVendaCollection() {
        return vendaCollection;
    }

    public void setVendaCollection(Collection<Sale> vendaCollection) {
        this.vendaCollection = vendaCollection;
    }

}
