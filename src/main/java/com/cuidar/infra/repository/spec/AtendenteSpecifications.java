package com.cuidar.infra.repository.spec;


import com.cuidar.domain.model.AtendenteED;
import com.cuidar.domain.model.AtendenteED;
import com.cuidar.domain.repository.filter.AtendenteFilter;
import com.cuidar.domain.repository.filter.AtendenteFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;


public class AtendenteSpecifications {

    public static Specification<AtendenteED> usandoFiltro(AtendenteFilter filtro){
        return (root, query, builder) -> {

//            if (AtendenteED.class.equals(query.getResultType())) {
//                root.fetch("paciente");
//                root.fetch("medico");
//                root.fetch("atendente");
//                root.fetch("local");
//            }

            var predicates = new ArrayList<Predicate>();

            if(filtro.getId() != null)
                predicates.add(builder.equal(root.get("id"), filtro.getId()));

            if(filtro.getNome() != null)
                predicates.add(builder.equal(root.get("nome"), filtro.getNome()));

            if(filtro.getIsAtivo() != null)
                predicates.add(builder.equal(root.get("isAtivo"), filtro.getIsAtivo()));

            //para transformar uma Collection em um array
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
