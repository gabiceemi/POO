/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.edu.br.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import org.unipampa.edu.br.connection.ConnectionFactory;
import org.unipampa.edu.br.model.Unidade;

/**
 *
 * @author gabic
 */
public class UnidadeDAO {
    
    public Unidade create(Unidade u){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO unidade (unidade)VALUES(?)";
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, u.getValor());
            
            stmt.executeUpdate();
            
            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                int novoId = resultSet.getInt("LAST_INSERT_ID()");
                u.setId(novoId);
            }
            return u;
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar: "+ex);
            return u;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public Unidade select(String unidade) {
        Unidade u = new Unidade();
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * unidade WHERE unidade = ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql + unidade);
            rs = stmt.executeQuery();
            while (rs.next()) {
                u.setId(rs.getInt("id"));
                u.setValor(rs.getString("unidade"));
                return u;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a Unidade do Deslocamento: " + ex);
        }
        return null;

    }
    
}
