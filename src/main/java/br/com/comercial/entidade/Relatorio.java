/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercial.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author junior
 */
@Entity
public class Relatorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String cooperado;
    private String tipoCana;
    @OneToMany(mappedBy = "relatorio", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemRelatorio> itemRelatorio;
    private BigDecimal vlrEquipProp;
    private BigDecimal vlrTotal;
    @ManyToOne
    private Equipamento equipamento;
    @ManyToOne
    private Sitio sitio;

    public Relatorio() {
        itemRelatorio = new ArrayList<ItemRelatorio>();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCooperado() {
        return cooperado;
    }

    public void setCooperado(String cooperado) {
        this.cooperado = cooperado;
    }

    public String getTipoCana() {
        return tipoCana;
    }

    public void setTipoCana(String tipoCana) {
        this.tipoCana = tipoCana;
    }

    public List<ItemRelatorio> getItemRelatorio() {
        return itemRelatorio;
    }

    public void setItemRelatorio(List<ItemRelatorio> itemRelatorio) {
        this.itemRelatorio = itemRelatorio;
    }

    public BigDecimal getVlrEquipProp() {
        BigDecimal total = new BigDecimal(BigInteger.ZERO);
        for(ItemRelatorio ir : itemRelatorio){
            total = total.add(ir.getQtdMh());
        }
        vlrEquipProp = total;
        return vlrEquipProp;
    }

    public void setVlrEquipProp(BigDecimal vlrEquipProp) {
        this.vlrEquipProp = vlrEquipProp;
    }

    public BigDecimal getVlrTotal() {
        BigDecimal total = new BigDecimal(BigInteger.ZERO);
        for(ItemRelatorio ir : itemRelatorio){
            total = total.add(ir.getVlrTotal());
        }
        vlrTotal=total;
        return vlrTotal;
    }

    public void setVlrTotal(BigDecimal vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
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
        if (!(object instanceof Relatorio)) {
            return false;
        }
        Relatorio other = (Relatorio) object;
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
