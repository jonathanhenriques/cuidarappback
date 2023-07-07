package com.cuidar.api.core.data;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.Map;
import java.util.stream.Collectors;


public class PageableTranslator {

    public static Pageable translate(Pageable pageable, Map<String, String> fieldsMapping) {
        var orders = pageable.getSort().stream()

                //Filtra os campos para retirar propriedades que nao existem
                .filter(order -> fieldsMapping.containsKey(order.getProperty()))

                //filtro verificando se existe uma chave com o nome de um campo
                // (map criado no controller fazendo o DE PARA dos campos com nomes errados para os certos)
                .map(order -> new Sort.Order(order.getDirection(),
                        fieldsMapping.get(order.getProperty())))
                .collect(Collectors.toList());

        return PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
                Sort.by(orders));
    }

}