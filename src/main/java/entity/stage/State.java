package entity.stage;

import entity.person.Person;
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
@Table(name = "stateOfCountry")
@NamedQueries({
    @NamedQuery(name = "State.findAll", query = "SELECT e FROM State e")
    , @NamedQuery(name = "State.findByStateCode", query = "SELECT e FROM State e WHERE e.stateCode = :stateCode")
    , @NamedQuery(name = "State.findByStateName", query = "SELECT e FROM State e WHERE e.stateName = :stateName")
    , @NamedQuery(name = "State.findByRegionCode", query = "SELECT e FROM State e WHERE e.regionCode = :regionCode")
    , @NamedQuery(name = "State.findByStateInitials", query = "SELECT e FROM State e WHERE e.stateInitials = :stateInitials")})
public class State implements Serializable, InterValueId {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "stateCode")
    private Integer stateCode;
    @Column(name = "stateName")
    private String stateName;    
    @Column(name = "regionName")
    private Integer regionCode;    
    @Column(name = "stateInitials")
    private String stateInitials;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "state")
    private Collection<Person> personCollection;

    public State() {
    }
    
    public State(Integer codigouf) {
        this.stateCode = codigouf;
    }

    @Override
    public Integer getId() {
        return stateCode;
    }

    public void setStateCode(Integer stateCode) {
        this.stateCode = stateCode;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public Integer getRegionCode() {
        return regionCode;
    }

    public void setRegionCode(Integer regionCode) {
        this.regionCode = regionCode;
    }

    public String getStateInitials() {
        return stateInitials;
    }

    public void setStateInitials(String stateInitials) {
        this.stateInitials = stateInitials;
    }

   
    public Collection<Person> getPessoaCollection() {
        return personCollection;
    }

    public void setPessoaCollection(Collection<Person> personCollection) {
        this.personCollection = personCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stateCode != null ? stateCode.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof State)) {
            return false;
        }
        State other = (State) object;
        return !((this.stateCode == null && other.stateCode != null) || (this.stateCode != null && !this.stateCode.equals(other.stateCode)));
    }

    @Override
    public String toString() {
        return this.stateInitials;
    }
    
}
