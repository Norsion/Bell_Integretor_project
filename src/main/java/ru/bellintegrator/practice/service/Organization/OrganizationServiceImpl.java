package ru.bellintegrator.practice.service.Organization;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.Organization.OrganizationDao;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private OrganizationDao organizationDao;
    private final MapperFacade mapperFacade;


    public OrganizationServiceImpl(OrganizationDao organizationDao, MapperFacade mapperFacade) {
        this.organizationDao = organizationDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public OrganizationView getOrganizationById(Long id) {
        Organization organization = organizationDao.loadById(id);
        return mapperFacade.map(organization, OrganizationView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OrganizationView> getOrganizations(OrganizationView organizationView) {
        List<Organization> organizations = organizationDao.getOrganizationByFilter(organizationView.name, organizationView.inn, organizationView.isActive);
        return mapperFacade.mapAsList(organizations, OrganizationView.class);
    }

    @Override
    @Transactional
    public void updateOrganization(OrganizationView view) {
        Organization org = organizationDao.loadById(view.id);
        if(org != null){
            org.setName(view.name);
            org.setFullName(view.fullName);
            org.setInn(view.inn);
            org.setKpp(view.kpp);
            org.setAddress(view.address);
            org.setPhone(view.phone);
            org.setActive(view.isActive );
        }
        organizationDao.updateOrganization(org);
    }

    @Override
    @Transactional
    public void saveOrganization(OrganizationView view) {
        Organization organization = new Organization(view.name, view.fullName, view.inn, view.kpp,view.address, view.phone, view.isActive);
        organizationDao.saveOrganization(organization);
    }
}
