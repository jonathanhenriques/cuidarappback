package com.cuidar.infra.repository.spec;


import com.cuidar.domain.model.PacienteED;
import com.cuidar.domain.repository.filter.PacienteFilter;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.Predicate;
import java.util.ArrayList;


public class PacienteSpecifications {

    public static Specification<PacienteED> usandoFiltro(PacienteFilter filtro){
        return (root, query, builder) -> {

            if (PacienteED.class.equals(query.getResultType())) {
                root.fetch("Endereco");
                root.fetch("Contato");
                root.fetch("Local");
            }

            var predicates = new ArrayList<Predicate>();

            if(filtro.getId() != null)
                predicates.add(builder.equal(root.get("id"), filtro.getId()));

//            if(filtro.getCodigo() != null)
//                predicates.add(builder.equal(root.join("paciente").get("id"), filtro.getPacienteId()));

            if(filtro.getCodigo() != null)
                predicates.add(builder.equal(root.get("codigo"), filtro.getCodigo()));

            if(filtro.getNome() != null)
                predicates.add(builder.equal(root.get("nome"), filtro.getNome()));

            if(filtro.getDataNasc() != null)
                predicates.add(builder.equal(root.get("dataNasc"), filtro.getDataNasc()));

            if(filtro.getIdade() != null) {
                predicates.add(builder.equal(root.get("idade"), filtro.getIdade()));
            }

            if(filtro.getRG() != null) {
                predicates.add(builder.equal(root.get("RG"), filtro.getRG()));
            }

            if(filtro.getEstadoCivil() != null)
                predicates.add(builder.equal(root.get("estadoCivil"), filtro.getEstadoCivil()));

            if(filtro.getFilhos() != null)
                predicates.add(builder.equal(root.get("filhos"), filtro.getFilhos()));

            if(filtro.getNomeResponsavelPaciente() != null)
                predicates.add(builder.equal(root.get("nomeResponsavelPaciente"), filtro.getNomeResponsavelPaciente()));

            if(filtro.getContatoEmail() != null) {
                predicates.add(builder.equal(root.join("contato").get("email"), filtro.getContatoEmail()));
            }

            if(filtro.getContatoInstagram() != null) {
                predicates.add(builder.equal(root.join("contato").get("contInstagram"), filtro.getContatoInstagram()));
            }

            if(filtro.getProfissao() != null)
                predicates.add(builder.equal(root.get("profissao"), filtro.getProfissao()));

            if(filtro.getEnderecoRua() != null) {
                predicates.add(builder.equal(root.join("endereco").get("endRua"), filtro.getEnderecoRua()));
            }

            if(filtro.getEnderecoBairro() != null) {
                predicates.add(builder.equal(root.join("endereco").get("endBairro"), filtro.getEnderecoBairro()));
            }

            if(filtro.getEnderecoCidade() != null) {
                predicates.add(builder.equal(root.join("endereco").get("endCidade"), filtro.getEnderecoCidade()));
            }

            if(filtro.getEnderecoCep() != null) {
                predicates.add(builder.equal(root.join("endereco").get("cep"), filtro.getEnderecoCep()));
            }

            if(filtro.getDeficiente() != null)
                predicates.add(builder.lessThanOrEqualTo(root.get("deficiente"), filtro.getDeficiente()));

            if(filtro.getDeficiencia() != null)
                predicates.add(builder.lessThanOrEqualTo(root.get("deficiencia"), filtro.getDeficiencia()));

            if(filtro.getConvenio() != null)
                predicates.add(builder.lessThanOrEqualTo(root.get("convenio"), filtro.getConvenio()));

            if(filtro.getIndicacao() != null)
                predicates.add(builder.equal(root.get("indicacao"), filtro.getIndicacao()));

            if(filtro.getIsAtivo() != null)
                predicates.add(builder.equal(root.get("isAtivo"), filtro.getIsAtivo()));

            if(filtro.getDataCadastro() != null)
                predicates.add(builder.equal(root.get("dataCadastro"), filtro.getDataCadastro()));

            if(filtro.getDataAtualizacao() != null)
                predicates.add(builder.equal(root.get("dataAtualizacao"), filtro.getDataAtualizacao()));

            //para transformar uma Collection em um array
            return builder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
