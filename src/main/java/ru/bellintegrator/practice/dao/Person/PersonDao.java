package ru.bellintegrator.practice.dao.Person;

import ru.bellintegrator.practice.model.Person;

import java.util.List;

public interface PersonDao {
    /**
     * Получить Person по идентификатору
     *
     * @param id
     * @return
     */
    Person loadById(Long id);
    /**
     * Получить Person(фильтр)
     *
     * @param officeId
     * @param firstName
     * @param secondName
     * @param middleName
     * @param position
     * @param docCode
     * @param countriesCode
     * @return
     */
    List<Person> getPersonByFilter(Long officeId, String firstName, String secondName, String middleName, String position, String docCode, String countriesCode);

    /**
     * Сохраняем данные о человеке
     * @param person
     */
    void savePerson(Person person);

    /**
     * Обновляем данные о человеке
     * @param person
     */
    void updatePerson(Person person);
}
