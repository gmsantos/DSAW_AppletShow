/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package compromissos;

import java.sql.*;

/**
 *
 * @author Daniel
 */
public class ConexaoDB {
    
    private Connection conexao;
    
    public ConexaoDB(){
        conexao = null;
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conexao = 
            DriverManager.getConnection("jdbc:mysql://localhost/DSAW","root","31Exorcist#!");
        }
        catch (SQLException excecao)
        {
            System.err.println("Erro ao conectar com o banco: " + excecao.getMessage());
        }
    }
    
    public Connection getConexao(){
        return conexao;
    }
    
    public void fecharConexao(){
        try {
            if(getConexao()!= null){
                if(!conexao.isClosed()){
                    getConexao().close();
                }
            }
        }
        catch (SQLException excecao) {
            System.err.println("Erro ao fechar a conexao com o banco: " + excecao.getMessage());
        }
    }
}
