package com.cuidar.domain.model.TipoResidencia;

public enum TipoResidencia {

    CASA("Casa"),
    APARTAMENTO("Apartamento"),
    OUTRO("Outro");

    private String descricao;

    TipoResidencia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
