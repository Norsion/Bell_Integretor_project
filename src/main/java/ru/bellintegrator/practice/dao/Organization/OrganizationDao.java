package ru.bellintegrator.practice.dao.Organization;

import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.Organization;

import java.util.List;

public interface OrganizationDao {
    /**
     * Получить Organization по идентификатору
     *
     * @param id
     * @return
     */
    Organization loadById(Long id);
    /**
     * Получить Organization(фильтр)
     *
     * @param name
     * @param inn
     * @param isActive
     *
     * @return
     */
    List<Organization> getOrganizationByFilter(String name, String inn, Boolean isActive);

    /**
     * Сохраняем данные об организации
     * @param organization
     */
    void saveOrganization(Organization organization);

    /**
     * Обновляем данные об организации
     * @param organization
     */
    void updateOrganization(Organization organization);
}
