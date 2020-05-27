package entities.entity.uf;

import entities.entity.Person;
import interf.InterValueId;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name = "states")
@NamedQueries({
    @NamedQuery(name = "States.findAll", query = "SELECT e FROM States e")
    , @NamedQuery(name = "States.findByCodigouf", query = "SELECT e FROM States e WHERE e.codigouf = :codigouf")
    , @NamedQuery(name = "States.findByNome", query = "SELECT e FROM States e WHERE e.nome = :nome")
    , @NamedQuery(name = "States.findByRegiao", query = "SELECT e FROM States e WHERE e.regiao = :regiao")
    , @NamedQuery(name = "States.findByUf", query = "SELECT e FROM States e WHERE e.uf = :uf")})
public class States implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigouf")
    private Integer codigouf;
    @Column(name = "nome")
    private String nome;
    @Column(name = "regiao")
    private Integer regiao;
    @Column(name = "uf")
    private String uf;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estado")
    private Collection<Person> pessoaCollection;

    public States() {
    }
    
    public States(Integer codigouf) {
        this.codigouf = codigouf;
    }

    @Override
    public Integer getId() {
        return codigouf;
    }

    public void setCodigouf(Integer codigouf) {
        this.codigouf = codigouf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getRegiao() {
        return regiao;
    }

    public void setRegiao(Integer regiao) {
        this.regiao = regiao;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

   
    public Collection<Person> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Person> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigouf != null ? codigouf.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof States)) {
            return false;
        }
        States other = (States) object;
        return !((this.codigouf == null && other.codigouf != null) || (this.codigouf != null && !this.codigouf.equals(other.codigouf)));
    }

    @Override
    public String toString() {
        return this.uf;
    }
    
}
