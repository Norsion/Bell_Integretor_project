package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class OfficeView {
    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "11")
    public Long id;

    @NotEmpty
    @ApiModelProperty(value = "Идентификатор организации", example = "1")
    public Long organizationId;

    @Size(max = 50)
    @NotEmpty(message = "name cannot be null")
    @ApiModelProperty(value = "наименование офиса", example = "Главный офис")
    public String name;

    @Size(max = 50)
    @NotEmpty(message = "address cannot be null")
    @ApiModelProperty(value = "Адрес офиса", example = "ул.Московская 24")
    public String address;

    @Size(max = 50)
    @NotNull(message = "phone cannot be null")
    @ApiModelProperty(value = "Телефон офиса", example = "123321")
    public String phone;

    @NotNull(message = "isActive cannot be null")
    @ApiModelProperty(value = "Активность", example = "true")
    public boolean isActive;

    @Override
    public String toString() {
        return "OfficeView{" +
                "id=" + id +
                ", organizationId=" + organizationId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", phone='" + phone + '\'' +
                ", isActive=" + isActive +
                '}';
    }
}
