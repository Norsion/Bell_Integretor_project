package ru.bellintegrator.practice.dao.TypeDocument;

import ru.bellintegrator.practice.model.Document;
import ru.bellintegrator.practice.model.TypeOfDocument;

import java.util.List;

public interface TypeDocumentDao {
    /**
     * Получить все объекты document
     *
     * @return
     */
    List<TypeOfDocument> getAll();
    /**
     * Получить TypeOfDocument по идентификатору
     *
     * @param id
     * @return
     */
    TypeOfDocument loadById(Long id);

    /**
     * Получить document по коду
     *
     * @param code
     * @return
     */
    TypeOfDocument loadByCode(Long code);
}
