package br.edu.ifg.sistemacomercial.dao;

import br.edu.ifg.sistemacomercial.entity.Usuario;
import javax.persistence.NoResultException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UsuarioDAO extends GenericDAO<Usuario, Integer> implements UserDetailsService {

    public Usuario buscar(String email, String senha) {
        try {
            Usuario usuario = (Usuario) getEntityManager().createQuery(
                    "from " + getEntityClass().getName()
                    + " where email = '" + email
                    + "' and senha = '" + senha
                    + "' and data_desativacao is null").getSingleResult();
            return usuario;
        } catch (NoResultException ex) {
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
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        String jpql = "from Usuario u where u.email = :email";
        Usuario usuario = getEntityManager().createQuery(jpql, Usuario.class).setParameter("email", email).getSingleResult();
        if (usuario == null) {
            throw new UsernameNotFoundException("O email " + email + " não existe");
        }
        usuario.getPermissoes().size();
        return usuario;
    }

}
