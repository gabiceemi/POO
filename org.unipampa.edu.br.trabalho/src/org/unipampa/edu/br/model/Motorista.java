package org.unipampa.edu.br.model;

public class Motorista extends Pessoa {

	private String numeroCnh;

    /**
     * @return the numeroCnh
     */
    public String getNumeroCnh() {
        return numeroCnh;
    }

    /**
     * @param numeroCnh the numeroCnh to set
     */
    public void setNumeroCnh(String numeroCnh) {
        this.numeroCnh = numeroCnh;
    }
    
    public String toString(){
        return getNumeroCnh();
    }

}
