package br.edu.ifg.sistemacomercial.dao;

import br.edu.ifg.sistemacomercial.entity.Categoria;
import br.edu.ifg.sistemacomercial.util.FabricadeConexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoriaDAO {

    public void salvar(Categoria entity) throws SQLException{
        //Ordem das colunas: senha, nome, login, id, email
        String sqlInsert = "insert into categoria (nome, id) values (?, default)";
        String sqlUpdate = "update categoria set nome = ? where id = ?";
        
        PreparedStatement  ps;
        if(entity.getId() == null){
            ps = FabricadeConexao.getConexao().prepareStatement(sqlInsert);
        } else {
            ps = FabricadeConexao.getConexao().prepareStatement(sqlUpdate);
            ps.setInt(2, entity.getId());
        }
        ps.setString(1, entity.getNome());
        ps.execute();
        FabricadeConexao.fecharConexao();
    }
    
    public void deletar(Categoria entity) throws SQLException{
        String sqlDelete = "delete from categoria where id = ?";
        PreparedStatement ps = FabricadeConexao.getConexao().prepareStatement(sqlDelete);
        ps.setLong(1, entity.getId());
        ps.execute();
        FabricadeConexao.fecharConexao();
    }
    
    public List<Categoria> listar() throws SQLException{
        String sqlQuery = "select * from categoria";
        PreparedStatement ps = FabricadeConexao.getConexao().prepareStatement(sqlQuery);
        //java.sql.ResultSet
        ResultSet rs = ps.executeQuery();
        List<Categoria> categorias = new ArrayList<>();
        while(rs.next()){
            Categoria categoria = new Categoria();
            categoria.setId(rs.getInt("id"));
            categoria.setNome(rs.getString("nome"));
            categorias.add(categoria);
        }
        FabricadeConexao.fecharConexao();
        return categorias;
    }
    
}
