package org.unipampa.edu.br.model;

import org.unipampa.edu.br.model.ModeloVeiculo;

public class Veiculo {

	private int id;

	private String placa;

	private ModeloVeiculo modeloVeiculo;

	private MarcaVeiculo marcaVeiculo;

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
     * @return the placa
     */
    public String getPlaca() {
        return placa;
    }

    /**
     * @param placa the placa to set
     */
    public void setPlaca(String placa) {
        this.placa = placa;
    }

    /**
     * @return the modeloVeiculo
     */
    public ModeloVeiculo getModeloVeiculo() {
        return modeloVeiculo;
    }

    /**
     * @param modeloVeiculo the modeloVeiculo to set
     */
    public void setModeloVeiculo(ModeloVeiculo modeloVeiculo) {
        this.modeloVeiculo = modeloVeiculo;
    }

    /**
     * @return the marcaVeiculo
     */
    public MarcaVeiculo getMarcaVeiculo() {
        return marcaVeiculo;
    }

    /**
     * @param marcaVeiculo the marcaVeiculo to set
     */
    public void setMarcaVeiculo(MarcaVeiculo marcaVeiculo) {
        this.marcaVeiculo = marcaVeiculo;
    }

}
