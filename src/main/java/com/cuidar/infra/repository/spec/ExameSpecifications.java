package com.cuidar.infra.repository.spec;


import com.cuidar.domain.model.ExameED;
import com.cuidar.domain.repository.filter.ExameFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;
import java.util.List;


public class ExameSpecifications {

    public static Specification<ExameED> usandoFiltro(ExameFilter filtro){
        return (root, query, builder) -> {

            if (ExameED.class.equals(query.getResultType())) {
                root.fetch("paciente");
                root.fetch("medico");
                root.fetch("atendente");
                root.fetch("local");
            }

            var predicates = new ArrayList<Predicate>();

            if(filtro.getId() != null)
                predicates.add(builder.equal(root.get("id"), filtro.getId()));

            if(filtro.getNomeExame() != null)
                predicates.add(builder.equal(root.get("nomeExame"), filtro.getNomeExame()));

            if(filtro.getPacienteId() != null)
                predicates.add(builder.equal(root.get("paciente"), filtro.getPacienteId()));

            if(filtro.getMedicoId() != null)
                predicates.add(builder.equal(root.get("medico"), filtro.getMedicoId()));

            if(filtro.getLocalId() != null)
                predicates.add(builder.equal(root.get("local"), filtro.getLocalId()));

            if(filtro.getAtendenteId() != null)
                predicates.add(builder.equal(root.get("atendente"), filtro.getAtendenteId()));

            if(filtro.getDataExame() != null)
                predicates.add(builder.lessThanOrEqualTo(root.get("dataExame"), filtro.getDataExame()));

            if(filtro.getValor() != null)
                predicates.add(builder.equal(root.get("valor"), filtro.getValor()));

            if(filtro.getSituacao() != null)
                predicates.add(builder.equal(root.get("situacao"), filtro.getSituacao()));

            //para transformar uma Collection em um array
            return builder.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
        };
    }
}
