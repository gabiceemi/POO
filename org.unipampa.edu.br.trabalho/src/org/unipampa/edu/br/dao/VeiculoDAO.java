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
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.unipampa.edu.br.connection.ConnectionFactory;
import org.unipampa.edu.br.model.MarcaVeiculo;
import org.unipampa.edu.br.model.ModeloVeiculo;
import org.unipampa.edu.br.model.Veiculo;

/**
 *
 * @author gabic
 */
public class VeiculoDAO {

    public void create(Veiculo v) {

        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("INSERT INTO veiculo (placa,marca,modelo)VALUES(?,?,?)");
            stmt.setString(1, v.getPlaca());
            stmt.setInt(2, v.getMarcaVeiculo().getId());
            stmt.setInt(3, v.getModeloVeiculo().getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            System.out.println(ex);
        } finally {
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

    public List<MarcaVeiculo> selectAllMarca() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<MarcaVeiculo> marcas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM marcaveiculo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                MarcaVeiculo marca = new MarcaVeiculo();

                marca.setId(rs.getInt("idMarcaVeiculo"));
                marca.setNome(rs.getString("nome"));
                marcas.add(marca);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return marcas;
    }

    public List<ModeloVeiculo> selectAllModelo() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<ModeloVeiculo> modelos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM modeloveiculo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                ModeloVeiculo modelo = new ModeloVeiculo();

                modelo.setId(rs.getInt("idModeloVeiculo"));
                modelo.setNome(rs.getString("nome"));
                modelos.add(modelo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return modelos;
    }
}
