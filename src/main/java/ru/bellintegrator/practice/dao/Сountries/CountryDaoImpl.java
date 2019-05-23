package ru.bellintegrator.practice.dao.Сountries;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Countries;
import ru.bellintegrator.practice.model.TypeOfDocument;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class CountryDaoImpl implements CountryDao {

    private final EntityManager em;

    @Autowired
    public CountryDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Countries> getAll() {
        TypedQuery<Countries> query = em.createQuery("SELECT c FROM Countries c", Countries.class);
        return query.getResultList();
    }

    @Override
    public Countries loadById(Long id) {
        return em.find(Countries.class, id);
    }

    @Override
    public Countries loadByCode(Long code) {
        CriteriaQuery<Countries> criteriaQuery = buildCriteria(code);
        TypedQuery<Countries> query =em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    private CriteriaQuery<Countries> buildCriteria(Long code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Countries> criteriaQuery = builder.createQuery(Countries.class);

        Root<Countries> root = criteriaQuery.from(Countries.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("code"), code));

        return criteriaQuery;

    }
}
