package org.unipampa.edu.br.controller;

import java.io.File;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.unipampa.edu.br.model.Viagem;
import org.unipampa.edu.br.model.Situacao;
import org.unipampa.edu.br.model.TipoDeslocamento;
import org.unipampa.edu.br.model.Unidade;
import org.unipampa.edu.br.model.Veiculo;


public class ControllerExcell {

	private String unidadeUnipampa, tipoDeslocamento, dataSolicitacao, placaVeiculo, situacaoSolitacao;
	private int qtdPassageiros;
	private float vlMotorista, vlVeiculo;
	private Set<Viagem> viagem = new HashSet<Viagem>();
	private Viagem v = new Viagem();
	private Unidade u = new Unidade();
        private Situacao s = new Situacao();
        private TipoDeslocamento t = new TipoDeslocamento();
        private Veiculo veiculo = new Veiculo();

	public void lerExcel(String EXCEL_FILE_LOCATION) {
		Workbook workbook = null;
                Calendar c = Calendar.getInstance();

		try {

			workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
			Sheet sheet = workbook.getSheet(0);
			for (int i = 1; i < 321; i++) {
				v = new Viagem();
                                u = new Unidade();
                                s = new Situacao();
				System.out.println("Viagem n�: " + i);
				Cell unidade = sheet.getCell(0, 0);
				System.out.print(unidade.getContents() + ": ");
				Cell cell1 = sheet.getCell(0, i);
				unidadeUnipampa = cell1.getContents().toString();
				System.out.println(unidadeUnipampa);
				u.setValor(unidadeUnipampa);//setar valor unidade
				v.setUnidade(u);// set unidade da classe viagem

				Cell tipo_deslocamento = sheet.getCell(1, 0);
				System.out.print(tipo_deslocamento.getContents() + ": ");
				Cell cell2 = sheet.getCell(1, i);
				tipoDeslocamento = cell2.getContents().toString();
				System.out.println(tipoDeslocamento);
                                t.setValor(tipoDeslocamento);
				v.setTipoDeslocamento(t);

				Cell dt_solicitacao = sheet.getCell(2, 0);
				System.out.print(dt_solicitacao.getContents() + ": ");
				Cell cell3 = sheet.getCell(2, i);
				dataSolicitacao = cell3.getContents().toString();
                                String[] dataSeparada = dataSolicitacao.split("/");
				System.out.println(dataSolicitacao);
                                c.set(Calendar.DAY_OF_MONTH, parseInt(dataSeparada[0]));
                                c.set(Calendar.MONTH, parseInt(dataSeparada[1]));
                                c.set(Calendar.YEAR, parseInt(dataSeparada[2]));
                                Date data = c.getTime();
				v.setDataSolicitacao(data);

				Cell placa_veiculo = sheet.getCell(3, 0);
				System.out.print(placa_veiculo.getContents() + ": ");
				Cell cell4 = sheet.getCell(3, i);
				placaVeiculo = cell4.getContents().toString();
				System.out.println(placaVeiculo);
				veiculo.setPlaca(placaVeiculo);
                                v.setVeiculo(veiculo);

				Cell qtd_passageiros = sheet.getCell(4, 0);
				System.out.print(qtd_passageiros.getContents() + ": ");
				Cell cell5 = sheet.getCell(4, i);
				qtdPassageiros = Integer.parseInt(cell5.getContents());
				System.out.println(qtdPassageiros);
				v.setQtdPassageiros(qtdPassageiros);

				Cell custo_motorista = sheet.getCell(5, 0);
				System.out.print(custo_motorista.getContents() + ": ");
				Cell cell6 = sheet.getCell(5, i);
				String motorista = cell6.getContents().toString();
				System.out.println(motorista);
				if (motorista != "") {
					vlMotorista = Float.parseFloat(motorista);
				} else {
					vlMotorista = 0;
				}
				v.setVlCustoEstMotorista(vlMotorista);
				System.out.println(vlMotorista);

				Cell custo_estadia_veiculo = sheet.getCell(6, 0);
				System.out.print(custo_estadia_veiculo.getContents() + ": ");
				Cell cell7 = sheet.getCell(6, i);
				String veiculo = cell7.getContents().toString();
				if (veiculo != "") {
					vlVeiculo = Float.parseFloat(veiculo);
				} else {
					vlVeiculo = 0;
				}
				v.setVlCustoEstVeiculo(vlVeiculo);
				System.out.println(vlVeiculo);

				Cell situacao = sheet.getCell(7, 0);
				System.out.print(situacao.getContents() + ": ");
				Cell cell8 = sheet.getCell(7, i);
				situacaoSolitacao = cell8.getContents().toString();
				System.out.println(situacaoSolitacao);
                                s.setValor(situacaoSolitacao);
                                v.setSituacao(s);
                                
				viagem.add(v);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (BiffException e) {
			e.printStackTrace();
		} finally {

			if (workbook != null) {
				workbook.close();
			}

		}
	}
	
	public Set<Viagem> getViagem() {
		return viagem;
	}

	public void setViagem(Set<Viagem> viagem) {
		this.viagem = viagem;
	}
	
}