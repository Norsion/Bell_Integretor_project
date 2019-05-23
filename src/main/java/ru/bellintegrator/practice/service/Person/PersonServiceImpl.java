package ru.bellintegrator.practice.service.Person;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.Documents.DocumentDao;
import ru.bellintegrator.practice.dao.Office.OfficeDao;
import ru.bellintegrator.practice.dao.Person.PersonDao;
import ru.bellintegrator.practice.dao.TypeDocument.TypeDocumentDao;
import ru.bellintegrator.practice.dao.Сountries.CountryDao;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.PersonView;

import javax.xml.ws.Action;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final OfficeDao officeDao;
    private final DocumentDao documentDao;
    private final CountryDao countryDao;
    private final MapperFacade mapperFacade;

    @Autowired
    public PersonServiceImpl(PersonDao personDao, OfficeDao officeDao, DocumentDao documentDao, CountryDao countryDao, MapperFacade mapperFacade) {
        this.personDao = personDao;
        this.officeDao = officeDao;
        this.documentDao = documentDao;

        this.countryDao = countryDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public PersonView getPersonById(Long id) {
        Person person = personDao.loadById(id);
        return mapperFacade.map(person, PersonView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<PersonView> getPersons(PersonView personView) {
        List<Person> persons = personDao.getPersonByFilter(personView.officeId, personView.firstName, personView.secondName, personView.middleName, personView.position, personView.docNumber, personView.countriesCode);
        return mapperFacade.mapAsList(persons, PersonView.class);
    }

    @Override
    @Transactional
    public void savePerson(PersonView view) {

    }

    @Override
    @Transactional
    public void updatePerson(PersonView view) {
        Person person = personDao.loadById(view.id);
        if(person != null){
            person.setOffice(officeDao.loadById(view.officeId));
            person.setFirstName(view.firstName);
            person.setSecondName(view.secondName);
            person.setMiddletName(view.middleName);
            person.setPosition(view.position);
            person.setPhone(view.phone);
            person.setDocument(documentDao.loadById(view.docNumber));
            person.setCountries(countryDao.loadById(view.countriesCode));
            person.setIdentified(view.isIdentified);
            personDao.updatePerson(person);
        }
        else{
            throw new DataIntegrityViolationException("Человек с id: " + view.id + " не найден.");
        }

    }
}
