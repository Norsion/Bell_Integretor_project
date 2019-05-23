package ru.bellintegrator.practice.service.Office;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.bellintegrator.practice.dao.Office.OfficeDao;
import ru.bellintegrator.practice.dao.Organization.OrganizationDao;
import ru.bellintegrator.practice.model.Office;
import ru.bellintegrator.practice.model.Organization;
import ru.bellintegrator.practice.model.mapper.MapperFacade;
import ru.bellintegrator.practice.view.OfficeView;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {

    private final OfficeDao officeDao;
    private final MapperFacade mapperFacade;


    @Autowired
    public OfficeServiceImpl(OfficeDao officeDao, MapperFacade mapperFacade) {
        this.officeDao = officeDao;
        this.mapperFacade = mapperFacade;
    }

    @Override
    @Transactional(readOnly = true)
    public OfficeView getOfficeById(Long id) {
        Office office = officeDao.loadById(id);
        return mapperFacade.map(office, OfficeView.class);
    }

    @Override
    @Transactional(readOnly = true)
    public List<OfficeView> getOffices(OfficeView officeView) {
        List<Office> offices = officeDao.getOfficeByFilter(officeView.organizationId, officeView.name, officeView.phone, officeView.isActive);
        return mapperFacade.mapAsList(offices, OfficeView.class);
    }

    @Override
    @Transactional
    public void updateOffice(OfficeView view) {
        Office office = officeDao.loadById(view.id);
        if(office != null){
            office.setName(view.name);
            office.setAddress(view.address);
            office.setPhone(view.phone);
            office.setActive(view.isActive);
            officeDao.updateOffice(office);
        }
        else {
            throw new DataIntegrityViolationException("Офис с id: " + view.id + " не найден.");
        }

    }

    @Override
    @Transactional
    public void saveOffice(OfficeView view) {
        Office office = new Office(view.organizationId, view.name, view.address, view.phone, view.isActive);
        officeDao.saveOffice(office);
    }
}
