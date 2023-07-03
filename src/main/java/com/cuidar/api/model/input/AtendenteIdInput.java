package com.cuidar.api.model.input;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class AtendenteIdInput {

    @NotNull
    private Long id;

}
