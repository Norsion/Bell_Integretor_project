package ru.bellintegrator.practice.dao.TypeDocument;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Countries;
import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.TypeOfDocument;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

@Repository
public class TypeDocumentDaoImpl implements TypeDocumentDao {

    private final EntityManager em;

    @Autowired
    public TypeDocumentDaoImpl(EntityManager em) {

        this.em = em;
    }


    @Override
    public List<TypeOfDocument> getAll() {
        TypedQuery<TypeOfDocument> query = em.createQuery("SELECT dt FROM TypeOfDocument dt", TypeOfDocument.class);
        return query.getResultList();
    }

    @Override
    public TypeOfDocument loadById(Long id) {

        return em.find(TypeOfDocument.class, id);
    }

    @Override
    public TypeOfDocument loadByCode(Long code) {
        CriteriaQuery<TypeOfDocument> criteriaQuery = buildCriteria(code);
        TypedQuery<TypeOfDocument> query = em.createQuery(criteriaQuery);
        return query.getSingleResult();
    }

    private CriteriaQuery<TypeOfDocument> buildCriteria(Long code) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<TypeOfDocument> criteriaQuery = builder.createQuery(TypeOfDocument.class);

        Root<TypeOfDocument> root = criteriaQuery.from(TypeOfDocument.class);
        criteriaQuery.select(root);
        criteriaQuery.where(builder.equal(root.get("code"), code));

        return criteriaQuery;

    }
}
