/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.edu.br.dao;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.unipampa.edu.br.model.Viagem;
import org.unipampa.edu.br.model.Situacao;
import org.unipampa.edu.br.model.Veiculo;
import org.unipampa.edu.br.connection.ConnectionFactory;
import org.unipampa.edu.br.model.Motorista;
import org.unipampa.edu.br.model.Seguradora;
import org.unipampa.edu.br.model.TipoDeslocamento;
import org.unipampa.edu.br.model.Unidade;



/**
 *
 * @author gabic
 */
public class ViagemDAO {
    
    private Connection con = null;
    
    public boolean create(Viagem viagem){
        
        String sql = "INSERT INTO viagem (dataSolicitacao, qtdPassageiros, vlCustoEstadia, vlCustoEstVeiculo, veiculo, unidade, tipoDeslocamento, situacao, motorista) VALUES (?,?,?,?,?,?,?,?,?)";
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) viagem.getDataSolicitacao());
            stmt.setInt(2, viagem.getQtdPassageiros());
            stmt.setFloat(3, (float) viagem.getVlCustoEstMotorista());
            stmt.setFloat(4, (float) viagem.getVlCustoEstVeiculo());
            stmt.setInt(5, viagem.getVeiculo().getId());
            stmt.setInt(6, viagem.getUnidade().getId());
            stmt.setInt(7, viagem.getTipoDeslocamento().getId());
            stmt.setInt(8, viagem.getSituacao().getId());
            stmt.setInt(9, viagem.getMotorista().getId());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Não foi possível salvar: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Viagem> findAll(){
        
        String sql = "SELECT * FROM viagem v INNER JOIN situacao s on d.idsituacao = s.id;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Set<Viagem> viagem = new HashSet<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Viagem v = new Viagem();
                v.setDataSolicitacao(rs.getDate("dataSolicitacao"));
                v.setQtdPassageiros(parseInt(rs.getString("qtdPassageiros")));
                v.setVlCustoEstMotorista(rs.getFloat("vlCustoEstMotorista"));
                v.setVlCustoEstVeiculo(rs.getFloat("vlCustoEstVeiculo"));
                //v.setPlacaVeiculo("placaVeiculo");
                v.setId(rs.getInt("did"));
                Situacao s = new Situacao();
                s.setId(rs.getInt("sid"));
                s.setValor(rs.getString("situacao"));
                v.setSituacao(s);
                
                v.setId(rs.getInt("vid"));
                Veiculo ve = new Veiculo();
                ve.setId(rs.getInt("veid"));
                ve.setPlaca(rs.getString("veiculo"));
                v.setVeiculo(ve);
               
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar os dados: "+ex);
        }
        return null;
    }

    public List<Unidade> selectAllUnidade() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Unidade> unidades = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM unidade");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Unidade u = new Unidade();

                u.setId(rs.getInt("idUnidade"));
                u.setValor(rs.getString("valor"));
                unidades.add(u);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return unidades;
    }

    public List<TipoDeslocamento> selectAllDeslocamentos() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<TipoDeslocamento> deslocamentos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM tipodeslocamento");
            rs = stmt.executeQuery();

            while (rs.next()) {

                TipoDeslocamento tipoD = new TipoDeslocamento();

                tipoD.setId(rs.getInt("idTipoDeslocamento"));
                tipoD.setValor(rs.getString("valor"));
                deslocamentos.add(tipoD);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return deslocamentos;
    }

    public List<Situacao> selectAllSituacao() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Situacao> situacoes = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM situacao");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Situacao situacao = new Situacao();

                situacao.setId(rs.getInt("idSituacao"));
                situacao.setValor(rs.getString("valor"));
                situacoes.add(situacao);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return situacoes;
    }

    public List<Veiculo> selectAllVeiculos() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Veiculo> veiculos = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM veiculo");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Veiculo veiculo = new Veiculo();

                veiculo.setId(rs.getInt("idVeiculo"));
                veiculo.setPlaca(rs.getString("placa"));
                veiculos.add(veiculo);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return veiculos;
    }

    public List<Motorista> selectAllMotoristas() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Motorista> motoristas = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM motorista");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Motorista motorista = new Motorista();

                motorista.setId(rs.getInt("idMotorista"));
                motorista.setNumeroCnh(rs.getString("numCNH"));
                motoristas.add(motorista);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return motoristas;
    }

    public List<Seguradora> selectAllSeguradoras() {
        Connection con = ConnectionFactory.getConnection();

        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<Seguradora> seguradoras = new ArrayList<>();

        try {
            stmt = con.prepareStatement("SELECT * FROM seguradora");
            rs = stmt.executeQuery();

            while (rs.next()) {

                Seguradora seguradora = new Seguradora();

                seguradora.setId(rs.getInt("idSeguradora"));
                seguradora.setEndereco(rs.getString("endereco"));
                seguradoras.add(seguradora);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VeiculoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }

        return seguradoras;
    }
    
}
