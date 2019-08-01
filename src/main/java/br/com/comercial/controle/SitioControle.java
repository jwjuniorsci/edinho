/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercial.controle;


import br.com.comercial.converter.ConverterGenerico;
import br.com.comercial.entidade.Sitio;
import br.com.comercial.facade.SitioFacade;
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
public class SitioControle  implements Serializable {
    
    @Inject
    private SitioFacade sitioFacade;
    private Sitio sitio; 
    private ConverterGenerico converterGenerico;
    private String nome;

   
    public ConverterGenerico converter(){
        if(converterGenerico==null){
            converterGenerico = new ConverterGenerico(sitioFacade);
        }
        return converterGenerico;
    }

    
    
    public void novo() {
        sitio = new Sitio();
    }
    
    public void salvar() throws Exception {
        sitioFacade.salvar(sitio);
    }
    
    public void editar(Sitio e){
        sitio = e;
    }
    
    public void excluir(Sitio e) throws Exception{
        sitioFacade.excluir(e);
    }
    
    public List<Sitio> getLista(){
        return sitioFacade.listar();
    }

    public Sitio getSitio() {
        return sitio;
    }

    public void setSitio(Sitio sitio) {
        this.sitio = sitio;
    }
    
    public List<Sitio> autoCompleteList(String valor) {
        return sitioFacade.listaAutocomplete(valor);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    
}
