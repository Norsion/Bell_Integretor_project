package ru.bellintegrator.practice.dao.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OfficeDaoImpl implements OfficeDao {

    private final EntityManager em;

    @Autowired
    public OfficeDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Office loadById(Long id) {
        return em.find(Office.class, id);
    }

    @Override
    public List<Office> getOfficeByFilter(Long organizationId, String name, String phone, Boolean isActive) {
        CriteriaQuery<Office> criteria = builderCriteria(organizationId, name, phone, isActive);
        TypedQuery<Office> query = em.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public void saveOffice(Office office) {
        em.persist(office);
    }

    @Override
    public void updateOffice(Office office) {
        em.merge(office);
    }

    private CriteriaQuery<Office> builderCriteria(Long organizationId, String name, String phone, Boolean isActive){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Office> criteriaQuery = builder.createQuery(Office.class);
        Root<Office> officeRoot = criteriaQuery.from(Office.class);
        criteriaQuery.select(officeRoot);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(builder.equal(officeRoot.get("organization_id"), organizationId));

        if (name != null) {
            predicateList.add(builder.equal(officeRoot.get("name"), name));
        }
        if (phone != null) {
            predicateList.add(builder.equal(officeRoot.get("phone"), phone));
        }
        if (isActive != null) {
            predicateList.add(builder.equal(officeRoot.get("isActive"), isActive));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
        return criteriaQuery;
    }
}
