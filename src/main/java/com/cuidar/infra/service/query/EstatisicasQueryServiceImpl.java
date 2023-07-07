package com.cuidar.infra.service.query;


import com.cuidar.api.PacienteResponseMin;
import com.cuidar.domain.model.PacienteED;
import com.cuidar.domain.service.EstatisticasQueryService;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;

/**
 * Classe de implementacao do service para impressao de relatorios com estatisticas
 * Onde as querys sao implementadas manualmente.
 */
@Repository
public class EstatisicasQueryServiceImpl implements EstatisticasQueryService {

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<PacienteED> consultarQuantidadePacientesCadasrados() {
        var builder = manager.getCriteriaBuilder();
        var query = builder.createQuery(PacienteED.class);
        var root = query.from(PacienteED.class);
        var predicates = new ArrayList<Predicate>();

        var selection = query.select(root);

        return manager.createQuery(query).getResultList();
    }

}
