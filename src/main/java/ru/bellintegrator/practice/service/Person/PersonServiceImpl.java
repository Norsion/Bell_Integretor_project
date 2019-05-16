package ru.bellintegrator.practice.service.Person;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.Documents.DocumentDao;
import ru.bellintegrator.practice.dao.Office.OfficeDao;
import ru.bellintegrator.practice.dao.Person.PersonDao;
import ru.bellintegrator.practice.dao.TypeDocument.TypeDocumentDao;
import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.PersonView;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;
    private final OfficeDao officeDao;
    private final DocumentDao documentDao;
    private final TypeDocumentDao typeDocumentDao;
    private final MapperFacade mapperFacade;

    public PersonServiceImpl(PersonDao personDao, OfficeDao officeDao, DocumentDao documentDao, TypeDocumentDao typeDocumentDao, MapperFacade mapperFacade) {
        this.personDao = personDao;
        this.officeDao = officeDao;
        this.documentDao = documentDao;
        this.typeDocumentDao = typeDocumentDao;
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
        List<Person> persons = personDao.getPersonByFilter(personView.officeId, personView.firstName, personView.secondName, personView.middleName, personView.position,personView.docCode, personView.countriesCode);
        return mapperFacade.mapAsList(persons, PersonView.class);
    }

    @Override
    @Transactional
    public void savePerson(PersonView personView) {

    }

    @Override
    @Transactional
    public void updatePerson(PersonView personView) {

    }
}
