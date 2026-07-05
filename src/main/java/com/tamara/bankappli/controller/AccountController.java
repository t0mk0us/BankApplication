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
import org.springframework.web.bind.annotation.RequestBody;
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
import com.tamara.bankappli.service.AddressService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3015")
@RequestMapping(value = AccountController.CONTEXT_V1_ACCOUNT) // Now resolves clean relative context paths
@Slf4j
public class AccountController {
	
    // 1. STRIP OUT the absolute "http:/localhost:8090" protocol domain data!
    public static final String CONTEXT_1 = "/bankapplication/"; 
    public static final String CONTEXT_V1_ACCOUNT = CONTEXT_1 + "account"; // Becomes "/bankapplication/account"
	
    private final AccountService accountService;
	
    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/list")
	//@CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Lister les comptes")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Account>> AccountLookUp() throws JsonProcessingException {
    	log.info("Lister tous les comptes existantes dans ACCOUNT");
    	return new ResponseEntity<List<Account>>(accountService.getAll(), HttpStatusCode.valueOf(200));
    }
	
    @GetMapping("/count")
    //@CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Compter le nombre des comptes")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Long> CountAccounts() throws JsonProcessingException {
    	log.info("Compter le nombre total des comptes");
    	return new ResponseEntity<Long>(((AccountService) accountService).countAccounts(), HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    //@CrossOrigin(origins = "http://localhost:3015")
    //@CrossOrigin(origins = "http://localhost:3015", allowCredentials = "true")
    @ApiOperation(value = "Trouver un compte par id")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Account> AccountByID(@ApiParam(value = "id") @PathVariable("id") Long id) throws JsonProcessingException, AccountNotFoundException {
    	log.info("Trouver un compte par ID " + id);
    	return new ResponseEntity<Account>(((AccountService) accountService).getByID(id), HttpStatus.OK);
    }
       
    @GetMapping("/by_owner/{ownerId}")
    @ApiOperation(value = "Trouver un compte par id de client")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    // CHANGE THIS: Swap @RequestParam for @PathVariable
    public ResponseEntity<List<Account>> AccountByCustomerID(
            @ApiParam(value = "id") @PathVariable("ownerId") Long ownerId
    ) throws JsonProcessingException, AccountNotFoundException {
        
        log.info("Trouver un compte par ID du client " + ownerId);
        return new ResponseEntity<List<Account>>(((AccountService) accountService).getByCustomerID(ownerId), HttpStatus.OK);
    }
    
    // 1. Updated path order to match your React pattern: /by_owner/firstName/lastName
    // 2. Double-check your method uses @PathVariable matching your parameter sequence
    @GetMapping("/by_owner/{firstName}/{lastName}")  
    public ResponseEntity<List<Account>> findAccountsByOwnerFirstAndLastNames(
            @PathVariable("firstName") String firstName,
            @PathVariable("lastName") String lastName
    ) throws JsonProcessingException {
        
        log.info("Endpoint hit successfully! Searching database for: " + firstName + " " + lastName);
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
    @ApiOperation(value = "Enregistrer le compte")
    public ResponseEntity<String> SaveAccount(@RequestBody Account account) throws JsonProcessingException {
        log.info("Saving new account for owner ID: " + 
            (account.getOwner() != null ? account.getOwner().getID() : "Unknown"));
        
        return new ResponseEntity<String>(accountService.saveAccount(account), HttpStatus.OK);
    }
    
    @GetMapping("/delete")
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
