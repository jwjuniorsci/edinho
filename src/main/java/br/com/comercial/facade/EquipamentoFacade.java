/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercial.facade;

import br.com.comercial.entidade.Cliente;
import br.com.comercial.entidade.Equipamento;
import br.com.comercial.entidade.Sitio;
import br.com.comercial.persistencia.Transacional;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author ricardo
 */
@Transacional
public class EquipamentoFacade extends AbstractFacade<Equipamento> implements Serializable{

    @Inject
    private EntityManager em;
    
    public EquipamentoFacade() {
        super(Equipamento.class);
    }

    @Override
    public EntityManager getEm() {
        return em;
    }
    
    public List<Equipamento> listaAutocomplete(String valor) {
        Query q = em.createQuery("from Equipamento where lower(nome) like :filtro");
        q.setParameter("filtro","%"+valor.toLowerCase()+"%");
        return q.getResultList();
    }
    
}
