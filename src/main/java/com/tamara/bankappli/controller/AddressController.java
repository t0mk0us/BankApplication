package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.exception.AccountNotFoundException;
import com.tamara.bankappli.exception.AddressNotFoundException;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Address;
import com.tamara.bankappli.repository.AccountRepository;
import com.tamara.bankappli.service.AccountService;
import com.tamara.bankappli.service.AddressService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = AddressController.CONTEXT_V1_ADDRESS)
//@Api(tags = { SwaggerConstant.TAG_ADDRESS_NAME })
@Slf4j
public class AddressController {
	
	//public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	public static final String CONTEXT_1 = "/bankapplication/"; 
	
	public static final String CONTEXT_V1_ADDRESS = CONTEXT_1 + "address";

    private final AddressService addressService;
	
    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/list")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Lister les adresses")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Address>> AddressLookUp() throws JsonProcessingException {
    	log.info("Lister les adresses de ADDRESS");
    	return new ResponseEntity<List<Address>>(addressService.getAll(), HttpStatusCode.valueOf(200));
    }
    
    @GetMapping("/count")
    @ApiOperation(value = "Compter le nombre des adresses")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Long> countAddressES() throws JsonProcessingException {
    	log.info("Compter le nombre total des adresses");
    	return new ResponseEntity<Long>(((AddressService) addressService).countAddress(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    //@CrossOrigin(origins = "http://localhost:3015", allowCredentials = "true")
    @ApiOperation(value = "Trouver un compte par id")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Address> AddressByID(@ApiParam(value = "id") @PathVariable("id") Long id) throws JsonProcessingException, AddressNotFoundException {
    	log.info("Trouver un compte par ID " + id);
    	return new ResponseEntity<Address>(((AddressService) addressService).getByID(id), HttpStatus.OK);
    }
}
