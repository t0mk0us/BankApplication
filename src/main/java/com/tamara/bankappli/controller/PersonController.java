package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.model.Person;
import com.tamara.bankappli.service.PersonService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = PersonController.CONTEXT_V1_PERSON)
//@Api(tags = { SwaggerConstant.TAG_ADDRESS_NAME })
@Slf4j
public class PersonController {
	
	//public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	public static final String CONTEXT_1 = "/bankapplication/"; 
	
	public static final String CONTEXT_V1_PERSON = CONTEXT_1 + "person";
	
    private final PersonService personService;
	
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })  
    public ResponseEntity<List<Person>> personLookUp() throws JsonProcessingException {
    	log.info("Lister les personnes de PERSON");
    	return new ResponseEntity<List<Person>>(personService.getAll(), HttpStatusCode.valueOf(200));
    }
	
    @GetMapping("/count")
    @ApiOperation(value = "Compter le nombre des comptes")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Long> countPersons() throws JsonProcessingException {
    	log.info("Compter le nombre total des comptes");
    	return new ResponseEntity<Long>(personService.countPersons(), HttpStatus.OK);
    }
    
    @GetMapping("/firstName/{firstName}/lastName/{lastName}")   
    @ApiResponses({
        @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
        @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    }) 
	public ResponseEntity<Person> personByFirstAndLast(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup, 
			@ApiParam(name = "column", value = "firstName") @RequestParam(required = true) String firstName,
			@ApiParam(name = "column", value = "lastName") @RequestParam(required = true) String lastName) throws JsonProcessingException {
    	
		log.info("Trouver une personne par prenom et nom dans " + nomTableLookup);
		return new ResponseEntity<Person>(personService.getByFirstAndLast(firstName, lastName), HttpStatusCode.valueOf(200));
	}
    
    @GetMapping("/save")
    @ApiOperation(value = "Enregistrer une personne")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> savePerson(@RequestBody Person c) throws JsonProcessingException {
    	//log.info("Enregistrer une devise  " + c.getID());
    	return new ResponseEntity<String>(personService.savePerson(c), HttpStatus.OK);
    }
    
    @GetMapping("/delete")
    @ApiOperation(value = "Effacer une personne")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> deletePerson(@ApiParam(value = "person") @RequestParam(required = true) Person c) throws JsonProcessingException {
    	//log.info("Enregistrer la devise  " + c.getID());
    	return new ResponseEntity<String>(personService.deletePerson(c), HttpStatus.OK);
    }
}

