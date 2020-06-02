package entity.product;

import entity.Person;
import entity.SaleItem;
import interf.InterValueId;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "product")

@Inheritance(strategy = InheritanceType.JOINED)
public class Product implements Serializable, InterValueId {

    @Column(name = "DTYPE")
    private String dtype;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idProdutoVenda")
    private Collection<SaleItem> itemVendaCollection;

    @Column(name = "percente")
    private BigDecimal percente;
    @Column(name = "nacional")
    private String nacional;
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "produto_id")
    private Integer produtoId;
    @Column(name = "produto_descricao")
    private String produtoDescricao;

    @Column(name = "productObservation")
    private String productObservation;

    @Column(name = "produto_codebar")
    private String produtoCodeBar;

    @Column(name = "condicao")
    private String condicao;

    @Column(name = "warranty")
    private Integer warranty;

    @Column(name = "saleComission")
    private BigDecimal comission;

    @Column(name = "sellingProfit")
    private BigDecimal profit;

    @Column(name = "productImage")
    private String productImage;

    @Column(name = "preco_compra")
    private BigDecimal precoCompra;
    @Column(name = "preco_venda")
    private BigDecimal precoVenda;
    @JoinColumn(name = "id_categoria", referencedColumnName = "categoria_id")
    @ManyToOne(optional = false)
    private Category idCategoria;
    @JoinColumn(name = "id_marca", referencedColumnName = "marca_id")
    @ManyToOne(optional = false)
    private Brand idMarca;
    @JoinColumn(name = "id_medida", referencedColumnName = "medida_id")
    @ManyToOne(optional = false)
    private Measure idMedida;

    @JoinColumn(name = "id_secao", referencedColumnName = "secao_id")
    @ManyToOne(optional = false)
    private ProductSection idSecao;

    @JoinColumn(name = "suppier", referencedColumnName = "pessoa_id")
    @ManyToOne(optional = false)
    private Person personId;

    public Product() {
    }

    public Product(Integer produtoId) {
        this.produtoId = produtoId;
    }

    @Override
    public Integer getId() {
        return produtoId;
    }

    public void setProdutoId(Integer produtoId) {
        this.produtoId = produtoId;
    }

    public String getProdutoDescricao() {
        return produtoDescricao;
    }

    public void setProdutoDescricao(String produtoDescricao) {
        this.produtoDescricao = produtoDescricao;
    }

    public String getCodeBar() {
        return produtoCodeBar;
    }

    public void setCodeBar(String produtoCodeBar) {
        this.produtoCodeBar = produtoCodeBar;
    }

    public String getObservation() {
        return productObservation;
    }

    public void setObservation(String productObervation) {
        this.productObservation = productObervation;
    }

    public String getCondicao() {
        return condicao;
    }

    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    public BigDecimal getPrecoCompra() {
        if (this.precoCompra == null) {
            precoCompra = BigDecimal.ZERO;
        }

        return precoCompra;
    }

    public void setPrecoCompra(BigDecimal precoCompra) {

        this.precoCompra = precoCompra;
    }

    public BigDecimal getPrecoVenda() {
        if (this.precoVenda == null) {
            precoVenda = BigDecimal.ZERO;
        }
        return precoVenda;
    }

    public void setPrecoVenda(BigDecimal precoVenda) {
        this.precoVenda = precoVenda;
    }

    public Integer getWarranty() {
        if (this.warranty == null) {
            warranty = 0;
        }
        return warranty;
    }

    public void setWarranty(Integer warranty) {
        this.warranty = warranty;
    }

    public BigDecimal getCommission() {
        if (this.comission == null) {
            comission = BigDecimal.ZERO;
        }
        return comission;
    }

    public void setComission(BigDecimal comission) {
        this.comission = comission;
    }

    public BigDecimal getProfit() {
        if (this.profit == null) {
            profit = BigDecimal.ZERO;
        }
        return profit;
    }

    public void setProfit(BigDecimal profit) {
        this.profit = profit;
    }

    public String getProductImage() {
        if (this.productImage == null) {
            productImage = "";
        }
        return productImage;
    }

    public void setProductImage(String productImage) {
        this.productImage = productImage;
    }

    public Category getIdCategoria() {
        return idCategoria;
    }

    public void setCategoria(Category idCategoria) {
        this.idCategoria = idCategoria;
    }

    public Brand getIdMarca() {
        return idMarca;
    }

    public void setIdMarca(Brand idMarca) {
        this.idMarca = idMarca;
    }

    public Measure getIdMedida() {
        return idMedida;
    }

    public void setIdMedida(Measure idMedida) {
        this.idMedida = idMedida;
    }

    public ProductSection getIdSecao() {
        return idSecao;
    }

    public void setIdSecao(ProductSection idSecao) {
        this.idSecao = idSecao;
    }

    public Person getPerson() {
        return personId;
    }

    public void setPerson(Person person) {
        this.personId = person;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (produtoId != null ? produtoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Product)) {
            return false;
        }
        Product other = (Product) object;
        return !((this.produtoId == null && other.produtoId != null) || (this.produtoId != null && !this.produtoId.equals(other.produtoId)));
    }

    @Override
    public String toString() {
        return "entidades.entity.Produto[ produtoId=" + produtoId + " ]";
    }

    public BigDecimal getPercente() {
        return percente;
    }

    public void setPercente(BigDecimal percente) {
        this.percente = percente;
    }

    public String getNacional() {
        return nacional;
    }

    public void setNacional(String nacional) {
        this.nacional = nacional;
    }

    public String getDtype() {
        return dtype;
    }

    public void setDtype(String dtype) {
        this.dtype = dtype;
    }

    @XmlTransient
    public Collection<SaleItem> getItemVendaCollection() {
        return itemVendaCollection;
    }

    public void setItemVendaCollection(Collection<SaleItem> itemVendaCollection) {
        this.itemVendaCollection = itemVendaCollection;
    }

}
