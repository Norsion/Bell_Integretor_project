package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Date;
import java.util.List;

@ApiModel(description = "Человек")
public class PersonView {

    @NotEmpty
    @ApiModelProperty(value = "Уникальный идентификатор", hidden = true, example = "1")
    public Long id;

    @Size(max = 50)
    @NotEmpty(message = "firstName cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String firstName;

    @Size(max = 50)
    @NotNull(message = "secondName cannot be null")
    @ApiModelProperty(value = "Фамилия", example = "Иванов")
    public String secondName;

    @Size(max = 50)
    @NotNull(message = "middleName cannot be null")
    @ApiModelProperty(value = "Отчество", example = "Иванович")
    public String middleName;

    @Size(max = 50)
    @NotEmpty(message = "position cannot be null")
    @ApiModelProperty(value = "Должность", example = "Менеджер")
    public String position;

    @NotEmpty
    @ApiModelProperty(value = "Идентификатор офиса", example = "11")
    public Long officeId;

    @NotEmpty
    @ApiModelProperty(value = "Номер документа", example = "1")
    public Long docNumber;

    @NotNull
    @ApiModelProperty(value = "Телефон", example = "89273453232")
    public String phone;

    @NotEmpty
    @ApiModelProperty(value = "Код страны", example = "1")
    public Long countriesCode;  //Код страны

    @NotNull
    @ApiModelProperty(value = "Проверка", example = "true")
    public boolean isIdentified;

    @Override
    public String toString() {
        return "PersonView{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", secondName='" + secondName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", position='" + position + '\'' +
                ", officeId=" + officeId +
                ", docCode='" + docNumber + '\'' +
                ", phone='" + phone + '\'' +
                ", countriesCode='" + countriesCode + '\'' +
                ", isIdentified=" + isIdentified +
                '}';
    }
}
