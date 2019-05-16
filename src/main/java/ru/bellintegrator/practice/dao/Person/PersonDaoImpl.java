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
import javax.persistence.criteria.Root;
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
    public List<Person> getPersonByFilter(Long officeId, String firstName, String secondName, String middleName, String position, String docNumber, String countriesId) {
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
    private CriteriaQuery<Person> builderCriteria(Long officeId, String firstName, String secondName, String middleName, String position, String docNumber, String countriesId){
        CriteriaBuilder builder = em.getCriteriaBuilder();
        CriteriaQuery<Person> criteria = builder.createQuery(Person.class);
        Root<Person> person = criteria.from(Person.class);
        //criteria.where()

        return criteria;
    }
}
