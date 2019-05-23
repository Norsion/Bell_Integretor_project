package ru.bellintegrator.practice.dao.Organization;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Organization;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    @Autowired
    public OrganizationDaoImpl(EntityManager em) {
        this.em = em;
    }

    @Override
    public Organization loadById(Long id) {
        return em.find(Organization.class, id);
    }

    @Override
    public List<Organization> getOrganizationByFilter(String name, String inn, Boolean isActive) {
        CriteriaQuery<Organization> criteriaQuery = buildCriteria(name, inn, isActive);
        TypedQuery<Organization> query = em.createQuery(criteriaQuery);
        return query.getResultList();
    }

    @Override
    public void saveOrganization(Organization organization) {
        em.persist(organization);

    }

    @Override
    public void updateOrganization(Organization organization) {
        em.merge(organization);
    }

    private CriteriaQuery<Organization> buildCriteria(String name, String inn, Boolean isActive) {
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Organization> criteriaQuery = builder.createQuery(Organization.class);
        Root<Organization> organizationRoot = criteriaQuery.from(Organization.class);
        criteriaQuery.select(organizationRoot);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(builder.equal(organizationRoot.get("name"), name));

        if (inn != null) {
            predicateList.add(builder.equal(organizationRoot.get("inn"), inn));
        }

        if (isActive) {
            predicateList.add(builder.equal(organizationRoot.get("isActive"), isActive));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
        return criteriaQuery;
    }
}
