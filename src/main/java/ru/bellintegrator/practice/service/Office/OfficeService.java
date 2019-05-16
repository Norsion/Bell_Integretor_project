package ru.bellintegrator.practice.service.Office;

import ru.bellintegrator.practice.view.OfficeView;

import java.util.List;

public interface OfficeService {
    /**
     * @param id
     * @return office
     */
    OfficeView getOfficeById(Long id);

    /**
     * @param officeView
     * @return office
     */
    List<OfficeView> getOffices(OfficeView officeView);

    /**
     * @param officeView
     * @return office
     */
    void updateOffice(OfficeView officeView);



    /**
     * @param officeView
     * @return office
     */
    void saveOffice(OfficeView officeView);


}
