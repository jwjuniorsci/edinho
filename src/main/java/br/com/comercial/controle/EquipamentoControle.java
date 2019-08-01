/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercial.controle;


import br.com.comercial.converter.ConverterGenerico;
import br.com.comercial.entidade.Equipamento;
import br.com.comercial.facade.EquipamentoFacade;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author JW Junior
 */
@Named
@SessionScoped
public class EquipamentoControle  implements Serializable {
    
    @Inject
    private EquipamentoFacade equipamentoFacade;
    private Equipamento equipamento; 
    private ConverterGenerico converterGenerico;
    private String nome;

   
    public ConverterGenerico converter(){
        if(converterGenerico==null){
            converterGenerico = new ConverterGenerico(equipamentoFacade);
        }
        return converterGenerico;
    }

    
    
    public void novo() {
        equipamento = new Equipamento();
    }
    
    public void salvar() throws Exception {
        equipamentoFacade.salvar(equipamento);
    }
    
    public void editar(Equipamento e){
        equipamento = e;
    }
    
    public void excluir(Equipamento e) throws Exception{
        equipamentoFacade.excluir(e);
    }
    
    public List<Equipamento> getLista(){
        return equipamentoFacade.listar();
    }

    public Equipamento getEquipamento() {
        return equipamento;
    }

    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }
    
    public List<Equipamento> autoCompleteList(String valor) {
        return equipamentoFacade.listaAutocomplete(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
