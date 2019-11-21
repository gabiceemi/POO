/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.edu.br.model.dao;

import static java.lang.Integer.parseInt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.unipampa.edu.br.bean.Deslocamento;
import org.unipampa.edu.br.bean.Situacao;
import org.unipampa.edu.br.connection.ConnectionFactory;



/**
 *
 * @author gabic
 */
public class DeslocamentoDAO {
    
    private Connection con = null;
    
    public boolean create(Deslocamento deslocamento){
        
        String sql = "INSERT INTO deslocamento (dataSolicitacao, qtdPassageiros, custoMotorista, custoVeiculo, placaVeiculo, idunidade, idsituacao) VALUES (?,?,?,?,?,?,?)";
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setString(1, deslocamento.getData());
            stmt.setInt(2, deslocamento.getQtdPassageiros());
            stmt.setInt(3, (int) deslocamento.getCustoMotorista());
            stmt.setInt(4, (int) deslocamento.getCustoVeiculo());
            stmt.setString(5, deslocamento.getPlacaVeiculo());
            stmt.setInt(6, deslocamento.getUnidade().getId());
            stmt.setInt(7, deslocamento.getSituacao().getId());
            
            stmt.executeUpdate();
            return true;
        } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Não foi possível salvar: "+ex);
            return false;
        }finally{
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Deslocamento> findAll(){
        
        String sql = "SELECT * FROM deslocamento d INNER JOIN situacao s on d.idsituacao = s.id;";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        Set<Deslocamento> deslocamentos = new HashSet<>();
        
        try {
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()){
                Deslocamento d = new Deslocamento();
                d.setData(rs.getString("dataSolicitacao"));
                d.setQtdPassageiros(parseInt(rs.getString("qtdPassageiros")));
                d.setCustoMotorista(rs.getDouble("custoMotorista"));
                d.setCustoVeiculo(rs.getDouble("custoVeiculo"));
                d.setPlacaVeiculo("placaVeiculo");
                d.setId(rs.getInt("did"));
                Situacao s = new Situacao();
                s.setId(rs.getInt("sid"));
                s.setSituacao(rs.getString("situacao"));
                d.setSituacao(s);
                
                
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível retornar os dados: "+ex);
        }
        return null;
    }
    
}
