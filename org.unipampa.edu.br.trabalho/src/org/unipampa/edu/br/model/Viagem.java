package org.unipampa.edu.br.model;

import java.util.Date;

public class Viagem {

	private int id;

	private Date dataSolicitacao;

	private int qtdPassageiros;

	private float vlCustoEstMotorista;

	private float vlCustoEstVeiculo;

	private Unidade unidade;

	private TipoDeslocamento tipoDeslocamento;

	private Veiculo veiculo;

	private Passageiro[] passageiros;

	private Motorista motorista;

	private Situacao situacao;

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
     * @return the dataSolicitacao
     */
    public Date getDataSolicitacao() {
        return dataSolicitacao;
    }

    /**
     * @param dataSolicitacao the dataSolicitacao to set
     */
    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
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
     * @return the vlCustoEstMotorista
     */
    public float getVlCustoEstMotorista() {
        return vlCustoEstMotorista;
    }

    /**
     * @param vlCustoEstMotorista the vlCustoEstMotorista to set
     */
    public void setVlCustoEstMotorista(float vlCustoEstMotorista) {
        this.vlCustoEstMotorista = vlCustoEstMotorista;
    }

    /**
     * @return the vlCustoEstVeiculo
     */
    public float getVlCustoEstVeiculo() {
        return vlCustoEstVeiculo;
    }

    /**
     * @param vlCustoEstVeiculo the vlCustoEstVeiculo to set
     */
    public void setVlCustoEstVeiculo(float vlCustoEstVeiculo) {
        this.vlCustoEstVeiculo = vlCustoEstVeiculo;
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

    /**
     * @return the tipoDeslocamento
     */
    public TipoDeslocamento getTipoDeslocamento() {
        return tipoDeslocamento;
    }

    /**
     * @param tipoDeslocamento the tipoDeslocamento to set
     */
    public void setTipoDeslocamento(TipoDeslocamento tipoDeslocamento) {
        this.tipoDeslocamento = tipoDeslocamento;
    }

    /**
     * @return the veiculo
     */
    public Veiculo getVeiculo() {
        return veiculo;
    }

    /**
     * @param veiculo the veiculo to set
     */
    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    /**
     * @return the passageiros
     */
    public Passageiro[] getPassageiros() {
        return passageiros;
    }

    /**
     * @param passageiros the passageiros to set
     */
    public void setPassageiros(Passageiro[] passageiros) {
        this.passageiros = passageiros;
    }

    /**
     * @return the motorista
     */
    public Motorista getMotorista() {
        return motorista;
    }

    /**
     * @param motorista the motorista to set
     */
    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
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

}
