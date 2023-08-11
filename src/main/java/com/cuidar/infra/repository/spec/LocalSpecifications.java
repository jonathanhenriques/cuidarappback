package com.cuidar.infra.repository.spec;


import com.cuidar.domain.model.AtendenteED;
import com.cuidar.domain.model.LocalED;
import com.cuidar.domain.repository.filter.AtendenteFilter;
import com.cuidar.domain.repository.filter.LocalFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;


public class LocalSpecifications {

    public static Specification<LocalED> usandoFiltro(LocalFilter filtro){
        return (root, query, builder) -> {

            // Carregar a propriedade endereco junto com a consulta
            root.fetch("endereco", JoinType.LEFT); // Adicione o JoinType se necessário

            var predicates = new ArrayList<Predicate>();

            if(filtro.getId() != null)
                predicates.add(builder.equal(root.get("id"), filtro.getId()));

            if(filtro.getNomeLocal() != null)
                predicates.add(builder.equal(root.get("nomeLocal"), filtro.getNomeLocal()));

            if(filtro.getIsAtivo() != null)
                predicates.add(builder.equal(root.get("isAtivo"), filtro.getIsAtivo()));

            if(filtro.getEndRua() != null)
                predicates.add(builder.equal(root.get("endereco").get("endRua"), filtro.getEndRua()));

            if(filtro.getEndBairro() != null)
                predicates.add(builder.equal(root.get("endereco").get("endBairro"), filtro.getEndBairro()));

            if(filtro.getEndCep() != null)
                predicates.add(builder.equal(root.get("endereco").get("endCep"), filtro.getEndCep()));

            if(filtro.getEndCidade() != null)
                predicates.add(builder.equal(root.get("endereco").get("endCidade"), filtro.getEndCidade()));

            if(filtro.getEndTipoResidencia() != null)
                predicates.add(builder.equal(root.get("endereco").get("endTipoResidencia"), filtro.getEndTipoResidencia()));

            //para transformar uma Collection em um array
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
