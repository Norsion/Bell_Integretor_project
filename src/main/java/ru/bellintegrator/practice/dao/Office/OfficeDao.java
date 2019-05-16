package ru.bellintegrator.practice.dao.Office;

import ru.bellintegrator.practice.model.Office;

import java.util.List;

public interface OfficeDao {
    /**
     * Получить Office по идентификатору
     *
     * @param id
     * @return
     */
    Office loadById(Long id);
    /**
     * Получить Office(фильтр)
     *
     * @param organizationId
     * @param name
     * @param phone
     * @param isActive
     *
     * @return
     */
    List<Office> getOfficeByFilter(Long organizationId, String name, String phone, Boolean isActive);

    /**
     * Сохраняем данные об офисе
     * @param office
     */
    void saveOffice(Office office);

    /**
     * Обновляем данные об офисе
     * @param office
     */
    void updateOffice(Office office);
}
