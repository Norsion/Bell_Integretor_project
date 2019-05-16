package ru.bellintegrator.practice.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.Organization.OrganizationService;
import ru.bellintegrator.practice.view.OrganizationView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OrganizationController")
@RestController
@RequestMapping(value = "/api/Organization", produces = APPLICATION_JSON_VALUE)
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @Autowired
    public OrganizationController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }
    @ApiOperation(value = "Получить список организаций", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping("/list")
    public List<OrganizationView> organizations(@RequestBody OrganizationView organizationView) {
        return organizationService.getOrganizations(organizationView);
    }

    @ApiOperation(value = "Найти организацию по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public OrganizationView getOrganizationById(@PathVariable Long id){
        return organizationService.getOrganizationById(id);
    }

    @ApiOperation(value = "Обновление списка организаций", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping("/update")
    public void updateOrganization(@RequestBody OrganizationView organizationView){
        organizationService.updateOrganization(organizationView);
    }

    @ApiOperation(value = "Добавить новую организацию", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 404, message = "Not Found"),
            @ApiResponse(code = 500, message = "Failure")})
    @PostMapping("/save")
    public void saveOrganization(@RequestBody OrganizationView organizationView) {
        organizationService.saveOrganization(organizationView);
    }
}
