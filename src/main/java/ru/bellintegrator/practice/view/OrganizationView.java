package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OrganizationView {
    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public long id;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "Наименование организации", example = "FirstOrganization")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "fullName cannot be null")
    @ApiModelProperty(value = "Полное Наименование огранизации", example = "ooo_FirstOrganization")
    public String fullName;

    @Size(max = 50)
    @NotEmpty(message = "inn cannot be null")
    @ApiModelProperty(value = "ИНН", example = "24214124124")
    public String inn;

    @Size(max = 50)
    @NotEmpty(message = "kpp cannot be null")
    @ApiModelProperty(value = "КПП", example = "121412412421")
    public String kpp;

    @Size(max = 50)
    @NotEmpty(message = "address cannot be null")
    @ApiModelProperty(value = "Адрес организации", example = "ул.Московская 24")
    public String address;

    @Size(max = 50)
    @NotNull(message = "phone cannot be null")
    @ApiModelProperty(value = "Телефон организации", example = "123321")
    public String phone;

    @NotNull(message = "isActive cannot be null")
    @ApiModelProperty(value = "Активность", example = "true")
    public boolean isActive;

    @Override
    public String toString() {
        return "OrganizationView{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fullName='" + fullName + '\'' +
                ", inn='" + inn + '\'' +
                ", kpp='" + kpp + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
