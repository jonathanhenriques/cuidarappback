package com.cuidar.infra.repository;

import com.cuidar.domain.model.PacienteED;
import com.cuidar.domain.repository.CustomJpaRepository;
import com.cuidar.domain.repository.PacienteRepository;
import com.cuidar.domain.repository.PacienteRepositoryQueries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.Predicate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomJpaRepositoryImpl<T, ID> extends SimpleJpaRepository<T, ID>
        implements CustomJpaRepository<T, ID> {

    private EntityManager manager;

    public CustomJpaRepositoryImpl(JpaEntityInformation<T, ?> entityInformation,
                                   EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.manager = entityManager;
    }

    @Override
    public Optional<T> buscarPrimeiro() {
        var jpql = "from " + getDomainClass().getName();

        T entity = manager.createQuery(jpql, getDomainClass())
                .setMaxResults(1)
                .getSingleResult();

        return Optional.ofNullable(entity);
    }

    @Override
    public void detach(T entity) {
        manager.detach(entity);
    }

    /**
     * Classe que diz como a busca sera feita no banco
     */
    public static class PacienteRepositoryImpl implements PacienteRepositoryQueries {

        @PersistenceContext
        private EntityManager manager;

        @Autowired
    //    @Lazy
        private PacienteRepository pacienteRepository;

        @Override
        public List<PacienteED> find(String nome) {
            var builder = manager.getCriteriaBuilder();

            var criteria = builder.createQuery(PacienteED.class);
            var root = criteria.from(PacienteED.class);

            var predicates = new ArrayList<Predicate>();

            if (StringUtils.hasText(nome)) {
                predicates.add(builder.like(root.get("nome"), "%" + nome + "%"));
            }
    //
    //        if (taxaFreteInicial != null) {
    //            predicates.add(builder.greaterThanOrEqualTo(root.get("taxaFrete"), taxaFreteInicial));
    //        }
    //
    //        if (taxaFreteFinal != null) {
    //            predicates.add(builder.lessThanOrEqualTo(root.get("taxaFrete"), taxaFreteFinal));
    //        }

            criteria.where(predicates.toArray(new Predicate[0]));

            var query = manager.createQuery(criteria);
            return query.getResultList();
        }
    }
}