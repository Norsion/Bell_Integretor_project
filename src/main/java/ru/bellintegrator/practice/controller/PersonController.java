package ru.bellintegrator.practice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.Person.PersonService;
import ru.bellintegrator.practice.view.PersonView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "PersonController", description = "Управление информацией о людях")
@RestController
@RequestMapping(value = "/api/Person", produces = APPLICATION_JSON_VALUE)
public class PersonController {

    @Autowired
    private PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }


    @ApiOperation(value = "Получить список людей", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping("/list")
    public List<PersonView> persons(@RequestBody PersonView personView) {
        return personService.getPersons(personView);
    }

    @ApiOperation(value = "Найти человека по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public PersonView getPersonById(@PathVariable Long id){
        return personService.getPersonById(id);}

    @ApiOperation(value = "Обновление списка людей", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping("/update")
    public void updatePerson(@RequestBody PersonView personView){

        personService.updatePerson(personView);
    }

    @ApiOperation(value = "Добавить нового человека", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void savePerson(@RequestBody PersonView person) {

        personService.savePerson(person);
    }

}