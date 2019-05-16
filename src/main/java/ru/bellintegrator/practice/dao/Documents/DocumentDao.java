package ru.bellintegrator.practice.dao.Documents;

import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.TypeOfDocument;

import java.util.List;

public interface DocumentDao {
    /**
     * Получить все объекты document
     *
     * @return
     */
    List<Document> getAll();
    /**
     * Получить document по идентификатору
     *
     * @param id
     * @return
     */
    Document loadById(Long id);

    /**
     * Получить document по коду
     *
     * @param code
     * @return
     */
    Document loadByCode(Long code);
}
