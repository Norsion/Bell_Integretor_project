package ru.bellintegrator.practice.dao.Сountries;

import ru.bellintegrator.practice.model.Countries;

import java.util.List;

public interface CountryDao {
    /**
     * Получить все объекты document
     *
     * @return
     */
    List<Countries> getAll();
    /**
     * Получить TypeOfDocument по идентификатору
     *
     * @param id
     * @return
     */
    Countries loadById(Long id);

    /**
     * Получить document по коду
     *
     * @param code
     * @return
     */
    Countries loadByCode(Long code);
}

