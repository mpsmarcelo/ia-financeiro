package br.com.iafinanceiroapi.enums;


public enum Categoria {

    ALUGUEL("Aluguel"),
    AGUA("Agua"),
    ENERGIA("Energia"),
    TRANSPORTE("Transporte"),
    ALIMENTACAO("Alimentação"),
    VESTUARIO("Vestuário"),
    LAZER("Lazer");

    private final String descricao;

    Categoria(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
