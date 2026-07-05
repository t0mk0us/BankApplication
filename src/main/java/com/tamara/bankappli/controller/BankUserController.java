package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.model.BankUser;
import com.tamara.bankappli.service.BankUserService;

import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = BankUserController.CONTEXT_V1_USER)
//@Api(tags = { SwaggerConstant.TAG_USER_NAME })
@Slf4j
public class BankUserController {
	
	//public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	public static final String CONTEXT_1 = "/bankapplication/"; 
	
	public static final String CONTEXT_V1_USER = CONTEXT_1 + "user";

    private final BankUserService userService;
	
    @Autowired
    public BankUserController(BankUserService userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })  
    public ResponseEntity<List<BankUser>> usersLookUp() throws JsonProcessingException {
    	log.info("Lister les utilisateurs de l'appli BankApplication");
    	return new ResponseEntity<List<BankUser>>(userService.getAll(), HttpStatusCode.valueOf(200));
    }
    
}


