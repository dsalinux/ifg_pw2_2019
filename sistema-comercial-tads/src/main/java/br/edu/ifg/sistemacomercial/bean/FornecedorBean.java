/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.entity.Fornecedor;
import br.edu.ifg.sistemacomercial.logic.FornecedorLogic;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@SessionScoped
public class FornecedorBean extends GenericCrud<Fornecedor, FornecedorLogic>{

    @Inject
    private FornecedorLogic logic;
    
    @Override
    public FornecedorLogic getLogic() {
        return logic;
    }
    
    public List<Fornecedor> getFornecedores(){
        try {
            return getLogic().buscar(null);
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
            return null;
        }
    }
}
