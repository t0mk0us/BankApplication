package com.tamara.bankappli.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.service.AccountService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = AccountController.CONTEXT_V1_ACCOUNT)
//@Api(tags = { SwaggerConstant.TAG_ACCOUNT_NAME })
@Slf4j
public class AccountController{
	
	public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	
	public static final String CONTEXT_V1_ACCOUNT = CONTEXT_1 + "account";

	@Autowired
	AccountService accountService;
	@Qualifier("accountService")

    @GetMapping("/list")
    @ApiOperation(value = "Lister les comptes")

    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Account>> AccountLookUp(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup) throws JsonProcessingException {
    	log.info("Lister tous les comptes existantes dans " + nomTableLookup);
    	return new ResponseEntity<>(((com.tamara.bankappli.service.AccountService) accountService).getAll(), HttpStatus.OK);
    }
	
    @GetMapping("/count")
    @ApiOperation(value = "Compter le nombre des comptes")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Long> CountAccounts() throws JsonProcessingException {
    	log.info("Compter le nombre total des comptes");
    	return new ResponseEntity<Long>(((com.tamara.bankappli.service.AccountService) accountService).countAccounts(), HttpStatus.OK);
    }
    
    @GetMapping("/find")
    @ApiOperation(value = "Trouver un compte par id")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Account> AccountByID(@ApiParam(value = "ID") @RequestParam(required = true) UUID id) throws JsonProcessingException {
    	log.info("Trouver un compte par ID " + "ID");
    	return new ResponseEntity<Account>(((AccountService) accountService).getByID(id), HttpStatus.OK);
    }
    
    @GetMapping("/findByCustomer")
    @ApiOperation(value = "Trouver des comptes par id du client")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Account>> AccountByCustomerId(@ApiParam(value = "ID") @RequestParam(required = true) UUID id) throws JsonProcessingException {
    	log.info("Trouver un compte par ID du client  " + "ID");
    	return new ResponseEntity<List<Account>>(((com.tamara.bankappli.service.AccountService) accountService).findByCustomerId(id), HttpStatus.OK);
    }
    
    @GetMapping("/save")
    @ApiOperation(value = "Enregistrer le compte")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> SaveAccount(@ApiParam(value = "account") @RequestParam(required = true) Account a) throws JsonProcessingException {
    	log.info("Enregistrer le compte  " + a.getID());
    	return new ResponseEntity<String>(((com.tamara.bankappli.service.AccountService) accountService).saveAccount(a), HttpStatus.OK);
    }
    
    @GetMapping("/delete")
    @ApiOperation(value = "Effacer le compte")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> DeleteAccount(@ApiParam(value = "Account") @RequestParam(required = true) Account a) throws JsonProcessingException {
    	log.info("Enregistrer le compte  " + a.getID());
    	return new ResponseEntity<String>(((com.tamara.bankappli.service.AccountService) accountService).deleteAccount(a), HttpStatus.OK);
    }
}
