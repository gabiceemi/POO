/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.edu.br.dao;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.unipampa.edu.br.model.Viagem;
import org.unipampa.edu.br.connection.ConnectionFactory;
import org.unipampa.edu.br.model.Situacao;

/**
 *
 * @author gabic
 */
public class SituacaoDAO {

    public Situacao create(Situacao s) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO situacao (situacao)VALUES(?)";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, s.getValor());

            stmt.executeUpdate();

            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                int novoId = resultSet.getInt("LAST_INSERT_ID()");
                s.setId(novoId);
            }
            
        
        return s;
    }
    catch (SQLException ex

    
        ) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar: " + ex);
        return s;
    }

    
        finally {
            ConnectionFactory.closeConnection(con, stmt);
    }
}

public Situacao select(String situacao) {
        Situacao s = new Situacao();
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * situacao WHERE situacao = ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql + situacao);
            rs = stmt.executeQuery();
            while (rs.next()) {
                s.setId(rs.getInt("id"));
                s.setValor(rs.getString("valor"));
                return s;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a Situacao do Deslocamento: " + ex);
        }
        return null;

    }
}
