package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamara.bankappli.enums.Constants;
import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.model.Account;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = AccountController.CONTEXT_V1_ACCOUNT)
//@Api(tags = { SwaggerConstant.TAG_ADDRESS_NAME })
@Slf4j
public class AccountController<AccountService> {
	
	private static Constants constants;
	
	//public static final String  CONTEXT_V1_ACCOUNT = constants.CONTEXT_1 + "account";
	public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	
	public static final String CONTEXT_V1_ACCOUNT = CONTEXT_1 + "address";

	@Autowired
	AccountService accountService;

    @SuppressWarnings("unchecked")
	//@Public
    @GetMapping("/list")
    @ApiOperation(value = "Lister les comptes")
    // @formatter:off
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Account>> AccountLookUp(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup) throws JsonProcessingException {
    	log.info("Lister les comptes de " + nomTableLookup);
    	return new ResponseEntity<>(((com.tamara.bankappli.service.AccountService) accountService).getAll(), HttpStatus.OK);
    }
    
    // @Public
    @GetMapping("/find")
    @ApiOperation(value = "Trouver un compte par id")
    // @formatter:off
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Account> AccountByID(@ApiParam(value = "ID") @RequestParam(required = true) String id) throws JsonProcessingException {
    	log.info("Trouver un compte par ID " + "ID");
    	return new ResponseEntity<Account>(HttpStatus.OK);
    }
}
