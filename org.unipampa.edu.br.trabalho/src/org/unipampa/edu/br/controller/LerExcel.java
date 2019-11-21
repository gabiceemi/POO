package org.unipampa.edu.br.controller;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import org.unipampa.edu.br.bean.Deslocamento;
import org.unipampa.edu.br.bean.Situacao;
import org.unipampa.edu.br.bean.Unidade;


public class LerExcel {

	private String unidadeUnipampa, tipoDeslocamento, dataSolicitacao, placaVeiculo, situacaoSolitacao;
	private int qtdPassageiros;
	private double vlMotorista, vlVeiculo;
	private Set<Deslocamento> deslocamentos = new HashSet<Deslocamento>();
	private Deslocamento d = new Deslocamento();
	private Unidade u = new Unidade();
        private Situacao s = new Situacao();

	public void lerExcel(String EXCEL_FILE_LOCATION) {
		Workbook workbook = null;

		try {

			workbook = Workbook.getWorkbook(new File(EXCEL_FILE_LOCATION));
			Sheet sheet = workbook.getSheet(0);
			for (int i = 1; i < 321; i++) {
				d = new Deslocamento();
                                u = new Unidade();
                                s = new Situacao();
				System.out.println("Viagem n�: " + i);
				Cell unidade = sheet.getCell(0, 0);
				System.out.print(unidade.getContents() + ": ");
				Cell cell1 = sheet.getCell(0, i);
				unidadeUnipampa = cell1.getContents().toString();
				System.out.println(unidadeUnipampa);
				u.setUnidade(unidadeUnipampa);
				d.setUnidade(u);

				Cell tipo_deslocamento = sheet.getCell(1, 0);
				System.out.print(tipo_deslocamento.getContents() + ": ");
				Cell cell2 = sheet.getCell(1, i);
				tipoDeslocamento = cell2.getContents().toString();
				System.out.println(tipoDeslocamento);
				d.setTipo(tipoDeslocamento);

				Cell dt_solicitacao = sheet.getCell(2, 0);
				System.out.print(dt_solicitacao.getContents() + ": ");
				Cell cell3 = sheet.getCell(2, i);
				dataSolicitacao = cell3.getContents().toString();
				System.out.println(dataSolicitacao);
				d.setData(dataSolicitacao);

				Cell placa_veiculo = sheet.getCell(3, 0);
				System.out.print(placa_veiculo.getContents() + ": ");
				Cell cell4 = sheet.getCell(3, i);
				placaVeiculo = cell4.getContents().toString();
				System.out.println(placaVeiculo);
				d.setPlacaVeiculo(placaVeiculo);

				Cell qtd_passageiros = sheet.getCell(4, 0);
				System.out.print(qtd_passageiros.getContents() + ": ");
				Cell cell5 = sheet.getCell(4, i);
				qtdPassageiros = Integer.parseInt(cell5.getContents());
				System.out.println(qtdPassageiros);
				d.setQtdPassageiros(qtdPassageiros);

				Cell custo_motorista = sheet.getCell(5, 0);
				System.out.print(custo_motorista.getContents() + ": ");
				Cell cell6 = sheet.getCell(5, i);
				String motorista = cell6.getContents().toString();
				System.out.println(motorista);
				if (motorista != "") {
					vlMotorista = Double.parseDouble(motorista);
				} else {
					vlMotorista = 0.0;
				}
				d.setCustoMotorista(vlMotorista);
				System.out.println(vlMotorista);

				Cell custo_estadia_veiculo = sheet.getCell(6, 0);
				System.out.print(custo_estadia_veiculo.getContents() + ": ");
				Cell cell7 = sheet.getCell(6, i);
				String veiculo = cell7.getContents().toString();
				if (veiculo != "") {
					vlVeiculo = Double.parseDouble(veiculo);
				} else {
					vlVeiculo = 0.0;
				}
				d.setCustoVeiculo(vlVeiculo);
				System.out.println(vlVeiculo);

				Cell situacao = sheet.getCell(7, 0);
				System.out.print(situacao.getContents() + ": ");
				Cell cell8 = sheet.getCell(7, i);
				situacaoSolitacao = cell8.getContents().toString();
				System.out.println(situacaoSolitacao);
                                s.setSituacao(situacaoSolitacao);
                                d.setSituacao(s);
                                
				deslocamentos.add(d);
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
	
	public Set<Deslocamento> getDeslocamentos() {
		return deslocamentos;
	}

	public void setDeslocamentos(Set<Deslocamento> deslocamentos) {
		this.deslocamentos = deslocamentos;
	}
	
}