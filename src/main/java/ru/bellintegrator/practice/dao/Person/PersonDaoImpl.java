package ru.bellintegrator.practice.dao.Person;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.bellintegrator.practice.model.Person;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class PersonDaoImpl implements PersonDao {

    private final EntityManager em;


    @Autowired
    public PersonDaoImpl(EntityManager em) {
        this.em = em;
    }


    @Override
    public Person loadById(Long id) {
        return em.find(Person.class, id);
    }

    @Override
    public List<Person> getPersonByFilter(Long officeId, String firstName, String secondName, String middleName, String position, Long docNumber, Long countriesId) {
        CriteriaQuery<Person> criteria = builderCriteria(officeId, firstName, secondName, middleName, position, docNumber, countriesId);
        TypedQuery<Person> query = em.createQuery(criteria);
        return query.getResultList();
    }

    @Override
    public void savePerson(Person person) {

        em.persist(person);
    }

    @Override
    public void updatePerson(Person person) {

        em.merge(person);
    }
    private CriteriaQuery<Person> builderCriteria(Long officeId, String firstName, String secondName, String middleName, String position, Long docNumber, Long countriesId){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteriaQuery = builder.createQuery(Person.class);
        Root<Person> personRoot = criteriaQuery.from(Person.class);
        criteriaQuery.select(personRoot);
        List<Predicate> predicateList = new ArrayList<>();
        predicateList.add(builder.equal(personRoot.get("office_id"), officeId));

        if (firstName != null) {
            predicateList.add(builder.equal(personRoot.get("firstName"), firstName));
        }
        if (secondName != null) {
            predicateList.add(builder.equal(personRoot.get("secondName"), secondName));
        }
        if (middleName != null) {
            predicateList.add(builder.equal(personRoot.get("middleName"), middleName));
        }
        if (position != null) {
            predicateList.add(builder.equal(personRoot.get("position"), position));
        }
        if (docNumber != null) {
            predicateList.add(builder.equal(personRoot.get("docNumber"), docNumber));
        }
        if (countriesId != null) {
            predicateList.add(builder.equal(personRoot.get("countries_id"), countriesId));
        }

        criteriaQuery.where(predicateList.toArray(new Predicate[]{}));
        return criteriaQuery;
    }
}
