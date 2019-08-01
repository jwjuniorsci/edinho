/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercial.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import org.hibernate.envers.Audited;

/**
 *
 * @author ricardo
 */
@Entity
@Audited
@Table(name = "venda")
public class Venda implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ven_id")
    private Long id;
    @Column(name = "ven_total", nullable = false)
    private BigDecimal total;
    @Column(name = "ven_desconto")
    private BigDecimal desconto;
    @Column(name = "ven_dtvenda")
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date dtvenda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venda", orphanRemoval = true)
    private List<VendaItem> vendaItens = new ArrayList<>();
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getDesconto() {
        return desconto;
    }

    public void setDesconto(BigDecimal desconto) {
        this.desconto = desconto;
    }

    public Date getDtvenda() {
        return dtvenda;
    }

    public void setDtvenda(Date dtvenda) {
        this.dtvenda = dtvenda;
    }

    public List<VendaItem> getVendaItens() {
        return vendaItens;
    }

    public void setVendaItens(List<VendaItem> vendaItens) {
        this.vendaItens = vendaItens;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venda)) {
            return false;
        }
        Venda other = (Venda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return id.toString();
    }
    
}
