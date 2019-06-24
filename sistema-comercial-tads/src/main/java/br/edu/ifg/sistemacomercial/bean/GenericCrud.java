package br.edu.ifg.sistemacomercial.bean;

import br.edu.ifg.sistemacomercial.logic.GenericLogic;
import br.edu.ifg.sistemacomercial.util.JsfUtil;
import br.edu.ifg.sistemacomercial.util.exception.NegocioException;
import br.edu.ifg.sistemacomercial.util.exception.SistemaException;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;

public abstract class GenericCrud<E, L extends GenericLogic<E, ?>> extends JsfUtil {
    
    private E entity;
    private List<E> entitys;
    private Status statusTela;   
    
    public enum Status {
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
        } catch (IllegalAccessException | InstantiationException ex) {
            addMensagemFatal(new SistemaException("Erro ao instanciar uma nova Classe "+getEntityClass().getName(), ex));
        }
        
    }

    public void salvar(){
        try {
            getLogic().salvar(entity);
            addMensagem("Salvo com sucesso!");
            pesquisar();
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        } catch(SistemaException ex){
            addMensagemFatal(ex);
        }
    }
    
    public void remover(E entity){
        try {
            getLogic().deletar(entity);
            entitys.remove(entity);
            addMensagem("Deletado com sucesso!");
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        } catch(SistemaException ex){
            addMensagemFatal(ex);
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
                addMensagemAviso("Nenhum registro cadastrado.");
            }
        } catch (NegocioException ex) {
            addMensagemErro(ex);
        } catch(SistemaException ex){
            addMensagemFatal(ex);
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

    public void setEntitys(List<E> entitys) {
        this.entitys = entitys;
    }
    
    public String getStatusTela() {
        return statusTela.name();
    }

    public void setStatus(Status statusTela) {
        this.statusTela = statusTela;
    }
    public Status getStatus(){
        return this.statusTela;
    }

    public Class<E> getEntityClass() {
        Type type = getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) type;
        
        return (Class<E>) paramType.getActualTypeArguments()[0];        
    }
    
    public abstract L getLogic();
    
}
