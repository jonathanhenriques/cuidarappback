package com.cuidar.api.assembler;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PacienteModelAssembler {

    @Autowired
    private ModelMapper modelMapper;


}
