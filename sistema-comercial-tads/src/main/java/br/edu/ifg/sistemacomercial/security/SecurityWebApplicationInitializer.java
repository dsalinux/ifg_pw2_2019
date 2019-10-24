/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.sistemacomercial.security;

import br.edu.ifg.sistemacomercial.dao.UsuarioDAO;
import br.edu.ifg.sistemacomercial.util.PersistenceFactory;
import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;

/**
 *
 * @author danilo
 */
public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

    public SecurityWebApplicationInitializer() {
        super(SecurityConfiguration.class, UsuarioDAO.class, PersistenceFactory.class);
    }

}
