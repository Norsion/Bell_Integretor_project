package ru.bellintegrator.practice.service.Organization;

import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

public interface OrganizationService {
    /**
     * Получить данные организации по id
     * @param id
     * @return organization
     */
    OrganizationView getOrganizationById(Long id);
    /**
     * получить список организаций по фильтру
     * @param organizationView
     * @return
     */
    List<OrganizationView> getOrganizations(OrganizationView organizationView);

    /**
     * Обновить список организаций
     * @param organizationView
     * @return
     */
    void updateOrganization(OrganizationView organizationView);

    /**
     * сохранить данные об организации
     * @param organizationView
     * @return
     */
    void saveOrganization(OrganizationView organizationView);
}
