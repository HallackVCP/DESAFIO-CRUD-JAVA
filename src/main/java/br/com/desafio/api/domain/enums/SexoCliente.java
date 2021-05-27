package br.com.desafio.api.domain.enums;

public enum SexoCliente {
	FEMININO("Feminino"),
    INDEFINIDO("Indefinido"),
    MASCULINO("Masculino");

    private final String sexo;

    SexoCliente(String sexo) {
        this.sexo = sexo;
    }

    public String getSexo() {
        return sexo;
    }
	

}
