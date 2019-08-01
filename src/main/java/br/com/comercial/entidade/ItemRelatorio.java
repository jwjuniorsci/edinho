/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercial.entidade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

/**
 *
 * @author junior
 */
@Entity
public class ItemRelatorio implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String servico;
    private String centroCusto;
    private String canaTipo;
    private String rorigem;
    private String cultura;
    private String kmInicio;
    private String kmFim;
    private String uni;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dataserv;
    private BigDecimal qtdMh;
    private BigDecimal vlrMhora;
    private BigDecimal vlrDesc;
    private BigDecimal vlrTotal;
    private BigDecimal relSeg;
    @ManyToOne
    private Relatorio relatorio;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getCanaTipo() {
        return canaTipo;
    }

    public void setCanaTipo(String canaTipo) {
        this.canaTipo = canaTipo;
    }

    public String getRorigem() {
        return rorigem;
    }

    public void setRorigem(String rorigem) {
        this.rorigem = rorigem;
    }

    public String getCultura() {
        return cultura;
    }

    public void setCultura(String cultura) {
        this.cultura = cultura;
    }

    public String getUni() {
        return uni;
    }

    public void setUni(String uni) {
        this.uni = uni;
    }

    public Date getDataserv() {
        return dataserv;
    }

    public void setDataserv(Date dataserv) {
        this.dataserv = dataserv;
    }

    public BigDecimal getQtdMh() {
        return qtdMh;
    }

    public void setQtdMh(BigDecimal qtdMh) {
        this.qtdMh = qtdMh;
    }

    public BigDecimal getVlrMhora() {
        return vlrMhora;
    }

    public void setVlrMhora(BigDecimal vlrMhora) {
        this.vlrMhora = vlrMhora;
    }

    public BigDecimal getVlrDesc() {
        return vlrDesc;
    }

    public void setVlrDesc(BigDecimal vlrDesc) {
        this.vlrDesc = vlrDesc;
    }

    public BigDecimal getVlrTotal() {
        return vlrTotal;
    }

    public void setVlrTotal(BigDecimal vlrTotal) {
        this.vlrTotal = vlrTotal;
    }

    public BigDecimal getRelSeg() {
        return relSeg;
    }

    public void setRelSeg(BigDecimal relSeg) {
        this.relSeg = relSeg;
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public String getKmInicio() {
        return kmInicio;
    }

    public void setKmInicio(String kmInicio) {
        this.kmInicio = kmInicio;
    }

    public String getKmFim() {
        return kmFim;
    }

    public void setKmFim(String kmFim) {
        this.kmFim = kmFim;
    }

    public String getCentroCusto() {
        return centroCusto;
    }

    public void setCentroCusto(String centroCusto) {
        this.centroCusto = centroCusto;
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
        if (!(object instanceof ItemRelatorio)) {
            return false;
        }
        ItemRelatorio other = (ItemRelatorio) object;
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
