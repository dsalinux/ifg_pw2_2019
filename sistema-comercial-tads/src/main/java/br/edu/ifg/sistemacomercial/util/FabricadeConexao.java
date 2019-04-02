package br.edu.ifg.sistemacomercial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class FabricadeConexao {

    private static Connection conexao;
    private static final String URL = "jdbc:postgresql://localhost/sistema-comercial";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "root";
    
    
    public static Connection getConexao() throws SQLException{
        if(conexao == null){
            conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
        }
        return conexao;
    }
    
    public static void fecharConexao() throws SQLException{
        if(conexao != null){
            conexao.close();
        } 
        conexao = null;
    }
    
    
}
