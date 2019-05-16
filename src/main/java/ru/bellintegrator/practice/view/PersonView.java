package ru.bellintegrator.practice.view;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotEmpty;
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
    @NotEmpty(message = "secondName cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String secondName;

    @Size(max = 50)
    @NotEmpty(message = "middleName cannot be null")
    @ApiModelProperty(value = "Имя", example = "Иван")
    public String middleName;

    public String position;
    public Long officeId;
    public String docCode;
    public Date docDate;
    public String phone;
    public String countriesCode;  //Код страны
    public boolean isIdentified;



}
