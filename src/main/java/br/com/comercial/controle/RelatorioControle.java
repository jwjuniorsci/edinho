/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercial.controle;

import br.com.comercial.converter.ConverterGenerico;
import br.com.comercial.entidade.ItemRelatorio;
import br.com.comercial.entidade.Relatorio;
import br.com.comercial.facade.RelatorioFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JW Junior
 */
@Named
@SessionScoped
public class RelatorioControle implements Serializable {

    @Inject
    private RelatorioFacade relatorioFacade;
    private Relatorio relatorio;
    private ItemRelatorio itemRelatorio;
    private ConverterGenerico converterGenerico;
    private String nome;

    public ConverterGenerico converter() {
        if (converterGenerico == null) {
            converterGenerico = new ConverterGenerico(relatorioFacade);
        }
        return converterGenerico;
    }

    public void novo() {
        relatorio = new Relatorio();
        itemRelatorio = new ItemRelatorio();
        itemRelatorio.setRelatorio(relatorio);
    }

    public void salvar() throws Exception {
        relatorioFacade.salvar(relatorio);
    }

    public void editar(Relatorio e) {
        relatorio = e;
    }

    public void excluir(Relatorio e) throws Exception {
        relatorioFacade.excluir(e);
    }

    public List<Relatorio> getLista() {
        return relatorioFacade.listar();
    }

    public Relatorio getRelatorio() {
        return relatorio;
    }

    public void setRelatorio(Relatorio relatorio) {
        this.relatorio = relatorio;
    }

    public List<Relatorio> autoCompleteList(String valor) {
        return relatorioFacade.listaAutocomplete(valor);
    }

    public void addItem() {
        if (itemRelatorio.getServico().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo Serviço é obrigatório!"));
            return;
        } else if (itemRelatorio.getCanaTipo().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo Tipo Cana é obrigatório!"));
            return;
        } else if (itemRelatorio.getDataserv() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo Data é obrigatório!"));
            return;
        } else if (itemRelatorio.getRorigem().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo R. Origem é obrigatório!"));
            return;
        } else if (itemRelatorio.getCultura().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo Cultura é obrigatório!"));
            return;
        } else if (itemRelatorio.getUni().equals("")) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo Uni. é obrigatório!"));
            return;
        } else if (itemRelatorio.getQtdMh() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo Qtd. M/H é obrigatório!"));
            return;
        } else if (itemRelatorio.getVlrMhora() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo Vlr M/Hora é obrigatório!"));
            return;
        } else if (itemRelatorio.getVlrDesc() == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(
                    FacesMessage.SEVERITY_ERROR, "Erro ao Adicionar", "O campo Vlr. Desc. é obrigatório!"));
            return;
        } else {
            itemRelatorio.setVlrTotal(itemRelatorio.getQtdMh().multiply(itemRelatorio.getVlrMhora()));
            relatorio.getItemRelatorio().add(itemRelatorio);
            itemRelatorio = new ItemRelatorio();
            itemRelatorio.setRelatorio(relatorio);
        }
    }
    
    public void removeItem(ItemRelatorio ir){
        relatorio.getItemRelatorio().remove(ir);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ItemRelatorio getItemRelatorio() {
        return itemRelatorio;
    }

    public void setItemRelatorio(ItemRelatorio itemRelatorio) {
        this.itemRelatorio = itemRelatorio;
    }
    
    

}
