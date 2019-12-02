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
import org.unipampa.edu.br.model.Veiculo;

/**
 *
 * @author gabic
 */
public class VeiculoDAO {

    public Veiculo create(Veiculo v) {

        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        String sql = "INSERT INTO veiculo (veiculo)VALUES(?)";

        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, v.getPlaca());

            stmt.executeUpdate();

            ResultSet resultSet = stmt.executeQuery("SELECT LAST_INSERT_ID()");
            if (resultSet.next()) {
                int novoId = resultSet.getInt("LAST_INSERT_ID()");
                v.setId(novoId);
            }
            
        
        return v;
    }
    catch (SQLException ex

    
        ) {
            JOptionPane.showMessageDialog(null, "Não foi possível salvar: " + ex);
        return v;
    }

    
        finally {
            ConnectionFactory.closeConnection(con, stmt);
    }
}

public Veiculo select(String veiculo) {
        Veiculo v = new Veiculo();
        Connection con = ConnectionFactory.getConnection();
        String sql = "SELECT * veiculo WHERE veiculo = ";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = con.prepareStatement(sql + veiculo);
            rs = stmt.executeQuery();
            while (rs.next()) {
                v.setId(rs.getInt("id"));
                v.setPlaca(rs.getString("placa"));
                return v;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível encontrar a Placa do Veiculo: " + ex);
        }
        return null;

    }
}
