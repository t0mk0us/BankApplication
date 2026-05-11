package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.model.User;
import com.tamara.bankappli.service.UserService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(value = UserController.CONTEXT_V1_USER)
//@Api(tags = { SwaggerConstant.TAG_USER_NAME })
@Slf4j
public class UserController {
	
	//public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	public static final String CONTEXT_1 = "http:/localhost:8080/bankapplication/"; 
	
	public static final String CONTEXT_V1_USER = CONTEXT_1 + "user";

	@Autowired
	UserService userService;

    @GetMapping("/list")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })  
    public ResponseEntity<List<User>> PersonLookUp(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup) throws JsonProcessingException {
    	log.info("Lister les utilisateurs de " + nomTableLookup);
    	return new ResponseEntity<List<User>>(userService.getAll(), HttpStatusCode.valueOf(200));
    }
    
    @GetMapping("/userName/{userName}")   
    @ApiResponses({
        @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
        @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    }) 
	public ResponseEntity<User> UserByUserName(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup, 
			@ApiParam(name = "column", value = "userName") @RequestParam(required = true) String userName) {
    	
		log.info("Trouver une personne par prenom et nom dans " + nomTableLookup);
		return new ResponseEntity<User>(userService.getByUserName(userName), HttpStatusCode.valueOf(200));
	}
}


