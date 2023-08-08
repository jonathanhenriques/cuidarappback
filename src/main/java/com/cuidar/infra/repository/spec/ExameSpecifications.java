package com.cuidar.infra.repository.spec;


import com.cuidar.domain.model.ExameED;
import com.cuidar.domain.repository.filter.ExameFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;

import java.util.ArrayList;


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

            if(filtro.getPacienteId() != null)
                predicates.add(builder.equal(root.join("paciente").get("id"), filtro.getPacienteId()));

            if(filtro.getCodigo() != null)
                predicates.add(builder.equal(root.get("codigo"), filtro.getCodigo()));

            if(filtro.getNomeExame() != null)
                predicates.add(builder.equal(root.get("nomeExame"), filtro.getNomeExame()));

            if(filtro.getPacienteCodigo() != null)
                predicates.add(builder.equal(root.get("codigo"), filtro.getPacienteCodigo()));

            if(filtro.getPacienteRG() != null) {
                predicates.add(builder.equal(root.join("paciente").get("RG"), filtro.getPacienteRG()));
            }

            if(filtro.getPacienteNomeResponsavel() != null) {
                predicates.add(builder.equal(root.join("paciente").get("nomeResponsavelPaciente"), filtro.getPacienteNomeResponsavel()));
            }

            if(filtro.getPacienteIndicacao() != null) {
                predicates.add(builder.equal(root.join("paciente").get("indicacao"), filtro.getPacienteIndicacao()));
            }

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

            if(filtro.getIsAtivo() != null)
                predicates.add(builder.equal(root.get("isAtivo"), filtro.getIsAtivo()));

            //para transformar uma Collection em um array
            return builder.and(predicates.toArray(new javax.persistence.criteria.Predicate[0]));
        };
    }
}
