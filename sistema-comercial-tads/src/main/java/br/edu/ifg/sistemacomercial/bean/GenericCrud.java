package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.logic.GenericLogic;
import br.edu.ifg.sistemacomercial.util.JsfUtil;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;

public abstract class GenericCrud<E, L extends GenericLogic<E, ?>> extends JsfUtil {
    
    private E entity;
    private List<E> entitys;
    private Status statusTela;   
    
    private enum Status {
        INSERINDO,
        EDITANDO,
        PESQUISANDO
    }
    
    
    @PostConstruct
    public void init(){
        entitys = new ArrayList<>();   
        statusTela = Status.PESQUISANDO;
    }
    
    public void novo(){
        try {
            entity = getEntityClass().newInstance();
            statusTela = Status.INSERINDO;
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
        
    }

    public void metodoLento(){
        long milisAtuais = System.currentTimeMillis();
        long milisDepois = milisAtuais+2000;
        while(milisAtuais < milisDepois){
            //Fica atualizando o milis
            milisAtuais = System.currentTimeMillis();
        }
    }
    
    public void salvar(){
        try {
            metodoLento();
            getLogic().salvar(entity);
            addMensagem("Salvo com sucesso!");
            pesquisar();
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    public void remover(E entity){
        try {
            getLogic().deletar(entity);
            entitys.remove(entity);
            addMensagem("Deletado com sucesso!");
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    public void editar(E entity){
        this.entity = entity;
        statusTela = Status.EDITANDO;
    }
    
    public void pesquisar(){
        try {
            if(!statusTela.equals(Status.PESQUISANDO)){
                statusTela = Status.PESQUISANDO;
                return;
            }
            entitys = getLogic().buscar(null);// <-----trocar de entityDAO.listar()
            if(entitys == null || entitys.isEmpty()){
                addMensagemAviso("Nenhum usuário cadastrado.");
            }
        } catch (Exception ex) {
            addMensagemErro(ex.getMessage());
        }
    }
    
    public E getEntity() {
        return entity;
    }

    public void setEntity(E entity) {
        this.entity = entity;
    }

    public List<E> getEntitys() {
        return entitys;
    }

    public String getStatusTela() {
        return statusTela.name();
    }

    public Class<E> getEntityClass() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        
        return (Class<E>) paramType.getActualTypeArguments()[0];        
    }
    
    public abstract L getLogic();
    
}
