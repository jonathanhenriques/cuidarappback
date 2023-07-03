package com.cuidar.api.assembler;

import com.cuidar.api.model.input.AtendenteIdInput;
import com.cuidar.domain.model.AtendenteED;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AtendenteModelAsembler {

    @Autowired
    private ModelMapper modelMapper;

    public AtendenteED toDomainObject(AtendenteIdInput atendenteIdInput){
        return modelMapper.map(atendenteIdInput, AtendenteED.class);
    }

    //Faz a mesma coisa mas não cria uma nova instancia, usa a que foi passada
    public void copyToDomainObject(AtendenteIdInput atendenteIdInput, AtendenteED atendenteED){
        modelMapper.map(atendenteIdInput, atendenteED);
    }
}
