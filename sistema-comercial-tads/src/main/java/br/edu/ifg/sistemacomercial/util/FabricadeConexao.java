package br.edu.ifg.sistemacomercial.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.flywaydb.core.Flyway;

public class FabricadeConexao {

    private static Connection conexao;
    private static final String URL = "jdbc:postgresql://localhost/sistema-comercial";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "root";
    
    
    public static Connection getConexao() throws SQLException{
        if(conexao == null){
            try {
                Class.forName("org.postgresql.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FabricadeConexao.class.getName()).log(Level.SEVERE, null, ex);
            }
            Flyway flyway = Flyway.configure().dataSource(URL, USUARIO, SENHA).load();
            flyway.migrate();
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
