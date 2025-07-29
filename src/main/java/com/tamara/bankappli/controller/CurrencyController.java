package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.model.Account;
import com.tamara.bankappli.model.Currency;
import com.tamara.bankappli.service.AccountService;
import com.tamara.bankappli.service.CurrencyService;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = CurrencyController.CONTEXT_V1_Currency)
//@Api(tags = { SwaggerConstant.TAG_CURRENCY_NAME })
@Slf4j
public class CurrencyController{
	
	//public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	
	public static final String CONTEXT_1 = "http:/localhost:8080/bankapplication/"; 
	public static final String CONTEXT_V1_Currency = CONTEXT_1 + "currency";

	@Autowired
	CurrencyService currencyService;
	@Qualifier("currencyService")

    @GetMapping("/list")
	@CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Lister les devises")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<List<Currency>> CurrencyLookUp(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup) throws JsonProcessingException {
    	log.info("Lister tous les comptes existantes dans " + nomTableLookup);
    	return new ResponseEntity<List<Currency>>(currencyService.getAll(), HttpStatusCode.valueOf(200));
    }
	
    @GetMapping("/count")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Compter le nombre des devises")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Long> CountCurrencys() throws JsonProcessingException {
    	log.info("Compter le nombre total des comptes");
    	return new ResponseEntity<Long>(((CurrencyService) currencyService).countCurrencys(), HttpStatus.OK);
    }
    
    @GetMapping("/find")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Trouver une devise par id")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<Currency> CurrencyByID(@ApiParam(value = "ID") @RequestParam(required = true) Long id) throws JsonProcessingException {
    	log.info("Trouver une devise par ID " + "ID");
    	return new ResponseEntity<Currency>(((CurrencyService) currencyService).getByID(id), HttpStatus.OK);
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
	 * ResponseEntity<List<Currency>> CurrencyByCustomerId(@ApiParam(value =
	 * "ID") @RequestParam(required = true) Long id) throws JsonProcessingException
	 * { //log.info("Trouver un compte par ID du client  " + "ID"); return new
	 * ResponseEntity<List<Currency>>(((CurrencyService)
	 * CurrencyService).findByOwner(id), HttpStatus.OK); }
	 */
    
    @GetMapping("/save")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Enregistrer une devise")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> SaveCurrency(@ApiParam(value = "currency") @RequestParam(required = true) Currency c) throws JsonProcessingException {
    	//log.info("Enregistrer une devise  " + c.getID());
    	return new ResponseEntity<String>(((CurrencyService) currencyService).saveCurrency(c), HttpStatus.OK);
    }
    
    @GetMapping("/delete")
    @CrossOrigin(origins = "http://localhost:3015")
    @ApiOperation(value = "Effacer une devise")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })
    public ResponseEntity<String> DeleteCurrency(@ApiParam(value = "currency") @RequestParam(required = true) Currency c) throws JsonProcessingException {
    	//log.info("Enregistrer la devise  " + c.getID());
    	return new ResponseEntity<String>(((CurrencyService) currencyService).deleteCurrency(c), HttpStatus.OK);
    }
    
    public void print() {
    	
    }
}
