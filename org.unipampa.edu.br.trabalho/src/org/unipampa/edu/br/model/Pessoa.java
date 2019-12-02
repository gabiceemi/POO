package org.unipampa.edu.br.model;

public abstract class Pessoa {

	private int id;

	private int nome;

	private char tipo;

	private TipoPessoa tipoPessoa;

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
     * @return the nome
     */
    public int getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(int nome) {
        this.nome = nome;
    }

    /**
     * @return the tipo
     */
    public char getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tipoPessoa
     */
    public TipoPessoa getTipoPessoa() {
        return tipoPessoa;
    }

    /**
     * @param tipoPessoa the tipoPessoa to set
     */
    public void setTipoPessoa(TipoPessoa tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

}
