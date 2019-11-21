/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.unipampa.edu.br.bean;

/**
 *
 * @author gabic
 */
public class Deslocamento {
    
    private int id;
    private String tipo;
    private String data;
    private int qtdPassageiros;
    private double custoMotorista;
    private double custoVeiculo;
    private Situacao situacao;
    private String placaVeiculo;
    private Unidade unidade;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }

    /**
     * @return the qtdPassageiros
     */
    public int getQtdPassageiros() {
        return qtdPassageiros;
    }

    /**
     * @param qtdPassageiros the qtdPassageiros to set
     */
    public void setQtdPassageiros(int qtdPassageiros) {
        this.qtdPassageiros = qtdPassageiros;
    }

    /**
     * @return the custoMotorista
     */
    public double getCustoMotorista() {
        return custoMotorista;
    }

    /**
     * @param custoMotorista the custoMotorista to set
     */
    public void setCustoMotorista(double custoMotorista) {
        this.custoMotorista = custoMotorista;
    }

    /**
     * @return the custoVeiculo
     */
    public double getCustoVeiculo() {
        return custoVeiculo;
    }

    /**
     * @param custoVeiculo the custoVeiculo to set
     */
    public void setCustoVeiculo(double custoVeiculo) {
        this.custoVeiculo = custoVeiculo;
    }

    /**
     * @return the situacao
     */
    public Situacao getSituacao() {
        return situacao;
    }

    /**
     * @param situacao the situacao to set
     */
    public void setSituacao(Situacao situacao) {
        this.situacao = situacao;
    }

    /**
     * @return the placaVeiculo
     */
    public String getPlacaVeiculo() {
        return placaVeiculo;
    }

    /**
     * @param placaVeiculo the placaVeiculo to set
     */
    public void setPlacaVeiculo(String placaVeiculo) {
        this.placaVeiculo = placaVeiculo;
    }

    /**
     * @return the unidade
     */
    public Unidade getUnidade() {
        return unidade;
    }

    /**
     * @param unidade the unidade to set
     */
    public void setUnidade(Unidade unidade) {
        this.unidade = unidade;
    }

   
}
