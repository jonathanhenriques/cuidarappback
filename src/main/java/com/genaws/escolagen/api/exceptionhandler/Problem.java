package com.genaws.escolagen.api.exceptionhandler;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.OffsetDateTime;
import java.util.List;

@JsonInclude(Include.NON_NULL)
@Builder
@Getter
@Schema(name = "Problema")
public class Problem {

    @Schema(example = "400")
    private Integer status;

    @Schema(example = "https://genaws.up.railway.app/dados-invalidos")
    private String type;

    @Schema(example = "Dados inválidos")
    private String title;

    @Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
    private String detail;

    @Schema(example = "Um ou mais campos estão inválidos. Faça o preenchimento correto e tente novamente.")
    private String userMessage;

    @Schema(example = "2023-011-23T23:23:50.902245498Z")
    private OffsetDateTime timestamp;

    @Schema(description = "Lista de objetos ou campos que geraram o erro")
    private List<Object> objects;

    //Qualuer propriedade ou classe que estiver com excessoes
    @Builder
    @Getter
    @Schema(name = "ObjetoProblema")
    public static class Object {

        @Schema(example = "[prorpiedade]")
        private String name;

        @Schema(example = "O(A) [prorpiedade] é inválido(a)")
        private String userMessage;

    }

}
