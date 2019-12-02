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



/**
 *
 * @author gabic
 */
public class ViagemDAO {
    
    private Connection con = null;
    
    public boolean create(Viagem viagem){
        
        String sql = "INSERT INTO viagem (dataSolicitacao, qtdPassageiros, vlCustoEstMotorista, vlCustoEstVeiculo, idveiculo, idunidade, idsituacao) VALUES (?,?,?,?,?,?,?)";
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement(sql);
            stmt.setDate(1, (Date) viagem.getDataSolicitacao());
            stmt.setInt(2, viagem.getQtdPassageiros());
            stmt.setFloat(3, (float) viagem.getVlCustoEstMotorista());
            stmt.setFloat(4, (float) viagem.getVlCustoEstVeiculo());
            //stmt.setString(5, viagem.getPlacaVeiculo()); agora ta na classe veiculo
            stmt.setInt(6, viagem.getVeiculo().getId());
            stmt.setInt(6, viagem.getUnidade().getId());
            stmt.setInt(7, viagem.getSituacao().getId());
            
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
    
}
