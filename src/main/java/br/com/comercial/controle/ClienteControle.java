/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.comercial.controle;

import br.com.comercial.entidade.Cliente;
import br.com.comercial.facade.AbstractFacade;
import br.com.comercial.facade.ClienteFacade;
import java.io.Serializable;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author ricardo
 */
@Named
public class ClienteControle extends AbstractControle<Cliente> implements Serializable {

    @Inject
    private ClienteFacade clienteFacade;

    public ClienteControle() {
        super(Cliente.class);
    }

    @Override
    public AbstractFacade<Cliente> getFacade() {
        return clienteFacade;
    }

}
