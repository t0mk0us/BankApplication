package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.model.Company;
import com.tamara.bankappli.service.CompanyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3015")
@RequestMapping(value = CompanyController.CONTEXT_V1_Company)
//@Api(tags = { SwaggerConstant.TAG_CURRENCY_NAME })
@Slf4j
public class CompanyController{
	
	//public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	
	public static final String CONTEXT_1 = "/bankapplication/"; 
	public static final String CONTEXT_V1_Company = CONTEXT_1 + "company";
	
    private final CompanyService companyService;
	
    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping("/list")
    @ApiOperation(value = "Lister les devises")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Company>> companyLookUp() throws JsonProcessingException {
    	log.info("Lister tous les comptes existantes dans CURRENCY");
    	return new ResponseEntity<List<Company>>(companyService.getAll(), HttpStatusCode.valueOf(200));
    }
	
    @GetMapping("/count")
    @ApiOperation(value = "Compter le nombre des companies")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Long> countCompanies() throws JsonProcessingException {
    	log.info("Compter le nombre total des comptes");
    	return new ResponseEntity<Long>(companyService.countCompanies(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    @ApiOperation(value = "Trouver une companie par id")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Company> companyByID(@ApiParam(value = "ID") @PathVariable("id") Long id) throws JsonProcessingException {
    	log.info("Trouver une devise par ID " + "ID");
    	return new ResponseEntity<Company>(companyService.getByID(id), HttpStatus.OK);
    }
    
    @GetMapping("/save")
    @ApiOperation(value = "Enregistrer une companie")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> saveCompany(@RequestBody Company c) throws JsonProcessingException {
    	log.info("Enregistrer une companie  " + c.getCompanyName());
    	return new ResponseEntity<String>(companyService.saveCompany(c), HttpStatus.OK);
    }
    
    @GetMapping("/delete")
    @ApiOperation(value = "Effacer une devise")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> deleteCompany(@ApiParam(value = "company") @RequestParam(required = true) Company c) throws JsonProcessingException {
    	log.info("Supprimer la devise  " + c.getCompanyName());
    	return new ResponseEntity<String>(companyService.deleteCompany(c), HttpStatus.OK);
    }
    
    public void print() {
    	
    }
}
