package ru.bellintegrator.practice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.bellintegrator.practice.service.Office.OfficeService;
import ru.bellintegrator.practice.view.OfficeView;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Api(value = "OfficeController")
@RestController
@RequestMapping(value = "/api/Office", produces = APPLICATION_JSON_VALUE)
public class OfficeController {
    @Autowired
    private OfficeService officeService;

    @Autowired
    public OfficeController(OfficeService officeService) {
        this.officeService = officeService;
    }
    @ApiOperation(value = "Получить список", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping("/list")
    public List<OfficeView> offices(@RequestBody OfficeView officeView) {
        return officeService.getOffices(officeView);
    }

    @ApiOperation(value = "Найти офис по id", httpMethod = "GET")
    @GetMapping("/{id}")
    public OfficeView getOfficeById(@PathVariable Long id){
        return officeService.getOfficeById(id);
    }

    @ApiOperation(value = "Обновить список", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping("/update")

    public void updateOffice(@RequestBody OfficeView officeView){
       officeService.updateOffice(officeView);
    }

    @ApiOperation(value = "Сохранить список", httpMethod = "POST")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Success", response = String.class),
            @ApiResponse(code = 400, message = "Not found"),
            @ApiResponse(code = 500, message = "Failure")
    })
    @PostMapping("/save")
    public void saveOffice(@RequestBody OfficeView officeView){
        officeService.saveOffice(officeView);
    }

}
