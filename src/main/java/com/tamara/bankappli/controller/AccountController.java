package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.exception.AccountNotFoundException;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Address;
import com.tamara.bankappli.service.AccountService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3015")
@RequestMapping(value = AccountController.CONTEXT_V1_ACCOUNT)
//@Api(tags = { SwaggerConstant.TAG_ACCOUNT_NAME })
@Slf4j
public class AccountController{
	
	//public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	
	public static final String CONTEXT_1 = "http:/localhost:8080/bankapplication/"; 
	public static final String CONTEXT_V1_ACCOUNT = CONTEXT_1 + "account";

	@Autowired
	AccountService accountService;
	@Qualifier("accountService")

    @GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Lister les comptes")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Account>> AccountLookUp(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup) throws JsonProcessingException {
    	log.info("Lister tous les comptes existantes dans " + nomTableLookup);
    	return new ResponseEntity<List<Account>>(accountService.getAll(), HttpStatusCode.valueOf(200));
    }
	
    @GetMapping("/count")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Compter le nombre des comptes")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Long> CountAccounts() throws JsonProcessingException {
    	log.info("Compter le nombre total des comptes");
    	return new ResponseEntity<Long>(((AccountService) accountService).countAccounts(), HttpStatus.OK);
    }
    
    @GetMapping("/{ownerId}")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Trouver un compte par id")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Account>> AccountByCustomerID(@ApiParam(value = "id") @RequestParam(required = true) Long ownerId) throws JsonProcessingException, AccountNotFoundException {
    	log.info("Trouver un compte par ID du client " + ownerId);
    	return new ResponseEntity<List<Account>>(((AccountService) accountService).getByCustomerID(ownerId), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Trouver un compte par id")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Account> AccountByID(@ApiParam(value = "id") @RequestParam(required = true) Long id) throws JsonProcessingException, AccountNotFoundException {
    	log.info("Trouver un compte par ID de client " + id);
    	return new ResponseEntity<Account>(((AccountService) accountService).getByID(id), HttpStatus.OK);
    }
    
    @GetMapping("/by_owner/{lastName}/{firstName}")  
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Trouver un compte par le nom et prenom de client")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Account>> findAccountsByOwnerFirstAndLastNames(@ApiParam(value = "firstName") @RequestParam(required = true) String firstName,
    		@ApiParam(value = "lastName") @RequestParam(required = true) String lastName) throws JsonProcessingException {
    	log.info("Trouver un compte par ID de client " + firstName + " " + lastName);
    	return new ResponseEntity<List<Account>>(((AccountService) accountService).getByOwnerFirstAndLast(firstName, lastName), HttpStatus.OK);
    }
	/*
	 * @GetMapping("/findByCustomer")
	 * 
	 * @ApiOperation(value = "Trouver des comptes par id du client")
	 * 
	 * @ApiResponses({
	 * 
	 * @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message =
	 * SwaggerConstant.HTTP_CODE_OK_MESSAGE),
	 * 
	 * @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message =
	 * SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE) }) public
	 * ResponseEntity<List<Account>> AccountByCustomerId(@ApiParam(value =
	 * "ID") @RequestParam(required = true) Long id) throws JsonProcessingException
	 * { //log.info("Trouver un compte par ID du client  " + "ID"); return new
	 * ResponseEntity<List<Account>>(((AccountService)
	 * accountService).findByOwner(id), HttpStatus.OK); }
	 */
    
    @PostMapping("/save")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Enregistrer le compte")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> SaveAccount(@ApiParam(value = "account") @RequestParam(required = true) Account a) throws JsonProcessingException {
    	//log.info("Enregistrer le compte  " + a.getID());
    	return new ResponseEntity<String>(((AccountService) accountService).saveAccount(a), HttpStatus.OK);
    }
    
    @GetMapping("/delete")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Effacer le compte")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> DeleteAccount(@ApiParam(value = "Account") @RequestParam(required = true) Account a) throws JsonProcessingException {
    	//log.info("Enregistrer le compte  " + a.getID());
    	return new ResponseEntity<String>(((AccountService) accountService).deleteAccount(a), HttpStatus.OK);
    }
    
    // Controller specific exception handler, not central like @ControllerAdvice
    @ExceptionHandler(AccountNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String accountNotFoundExceptionHandler(AccountNotFoundException ex) {
        return ex.getMessage(); // example	
    }
    
    public void print() {
    	
    }
}
