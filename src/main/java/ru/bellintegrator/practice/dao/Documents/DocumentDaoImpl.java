package ru.bellintegrator.practice.dao.Documents;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Countries;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class DocumentDaoImpl implements DocumentDao {

    private final EntityManager em;

    @Autowired
    public DocumentDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public List<Document> getAll() {
        TypedQuery<Document> query = em.createQuery("SELECT d FROM Document d", Document.class);
        return query.getResultList();
    }

    @Override
    public Document loadById(Long id) {
        return em.find(Document.class, id);
    }

    @Override
    public Document loadByCode(Long code) {
        CriteriaQuery<Document> criteriaQuery = buildCriteria(code);
        TypedQuery<Document> query = em.createQuery(criteriaQuery);

        return query.getSingleResult();
    }

    private CriteriaQuery<Document> buildCriteria(Long code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Document> criteriaQuery = builder.createQuery(Document.class);

        Root<Document> root = criteriaQuery.from(Document.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("code"), code));

        return criteriaQuery;

    }
}
