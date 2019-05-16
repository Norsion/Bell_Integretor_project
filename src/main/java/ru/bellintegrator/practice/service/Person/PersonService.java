package ru.bellintegrator.practice.service.Person;

import ru.bellintegrator.practice.model.Person;
import ru.bellintegrator.practice.view.PersonView;


import java.util.List;

/**
 * Сервис пользователей
 */

public interface PersonService {

    /**
     * Получить данные пользователя по id
     * @param id
     * @return person
     */
    PersonView getPersonById(Long id);

    /**
     * Получить список пользователей по фильтру
     * @param personView
     * @return
     */
    List<PersonView> getPersons(PersonView personView);

    /**
     *
     * @param personView
     * @return
     */
    void savePerson(PersonView personView);

    /**
     *
     * @param personView
     * return
     */
    void updatePerson(PersonView personView);
}
