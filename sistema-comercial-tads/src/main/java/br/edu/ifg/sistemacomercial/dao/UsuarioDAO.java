package br.edu.ifg.sistemacomercial.dao;

import br.edu.ifg.sistemacomercial.entity.Usuario;
import br.edu.ifg.sistemacomercial.util.FabricadeConexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void salvar(Usuario entity) throws SQLException{
        //Ordem das colunas: senha, nome, login, id, email
        String sqlInsert = "insert into usuario (nome, login, senha, email, id"
                + ") values (?, ?, ?, ?, default)";
        String sqlUpdate = "update usuario set nome = ?, login = ?, senha = ?, "
                + "email = ? where id = ?";
        
        PreparedStatement  ps;
        if(entity.getId() == null){
            ps = FabricadeConexao.getConexao().prepareStatement(sqlInsert);
        } else {
            ps = FabricadeConexao.getConexao().prepareStatement(sqlUpdate);
            ps.setLong(5, entity.getId());
        }
        ps.setString(1, entity.getNome());
        ps.setString(2, entity.getLogin());
        ps.setString(3, entity.getSenha());
        ps.setString(4, entity.getEmail());
        FabricadeConexao.getConexao().setAutoCommit(false);
        ps.execute();
        FabricadeConexao.getConexao().commit();
        FabricadeConexao.fecharConexao();
    }
    
    public void deletar(Usuario entity) throws SQLException{
        String sqlDelete = "delete from usuario where id = ?";
        PreparedStatement ps = FabricadeConexao.getConexao().prepareStatement(sqlDelete);
        ps.setLong(1, entity.getId());
        ps.execute();
        FabricadeConexao.fecharConexao();
    }
    
    public List<Usuario> listar() throws SQLException{
        String sqlQuery = "select * from usuario";
        PreparedStatement ps = FabricadeConexao.getConexao().prepareStatement(sqlQuery);
        //java.sql.ResultSet
        ResultSet rs = ps.executeQuery();
        List<Usuario> usuarios = new ArrayList<>();
        while(rs.next()){
            Usuario usuario = new Usuario();
            usuario.setId(rs.getLong("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setLogin(rs.getString("login"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));
            usuarios.add(usuario);
        }
        FabricadeConexao.fecharConexao();
        return usuarios;
    }
    
}
