package org.unipampa.edu.br.model;

public class Passageiro extends Pessoa {

	private char sexo;

	private Seguradora seguradora;

    /**
     * @return the sexo
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * @param sexo the sexo to set
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * @return the seguradora
     */
    public Seguradora getSeguradora() {
        return seguradora;
    }

    /**
     * @param seguradora the seguradora to set
     */
    public void setSeguradora(Seguradora seguradora) {
        this.seguradora = seguradora;
    }

}
