package br.edu.ifg.sistemacomercial.dao;

import br.edu.ifg.sistemacomercial.entity.Usuario;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.NoResultException;

public class UsuarioDAO extends GenericDAO<Usuario, Integer>{

    public Usuario buscar(String email, String senha) {
        try{
            Usuario usuario = (Usuario) getEntityManager().createQuery(
                        "from " + getEntityClass().getName()
                        +" where email = '"+email
                        +"' and senha = '"+senha
                        +"' and data_desativacao is null").getSingleResult();
            return usuario;
        } catch (NoResultException ex){
            return null;
        }
    }

//    @Override
//    public List<Usuario> listar() throws SQLException {
//        List<Usuario> usuarios = getEntityManager().createQuery("from Usuario").getResultList();
//        System.out.println("imprimindo#########################################"+usuarios.size());
//        for (Usuario usuario : usuarios) {
//            System.out.println(usuario.getPermissoes().size());
//            
//        }
//        getEntityManager().close();
//        return usuarios;
//    }
 
    
}
