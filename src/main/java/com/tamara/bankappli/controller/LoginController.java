package com.tamara.bankappli.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatusCode;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.tamara.bankappli.enums.SwaggerConstant;
import com.tamara.bankappli.model.Person;
import com.tamara.bankappli.service.LoginService;
import com.tamara.bankappli.service.PersonService;

import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.extern.slf4j.Slf4j;

@RestController
@CrossOrigin(origins = "http://localhost:3015")
@RequestMapping(value = LoginController.CONTEXT_V1_LOGIN)
//@Api(tags = { SwaggerConstant.TAG_ADDRESS_NAME })
@Slf4j
public class LoginController {
	
	//public static final String CONTEXT_1 = "http://design4logic/apps/bankapplication"; 
	public static final String CONTEXT_1 = "http:/localhost:8090/bankapplication/"; 
	
	public static final String CONTEXT_V1_LOGIN = CONTEXT_1 + "login";

	@Autowired
	LoginService loginService;

	@CrossOrigin(origins = "http://localhost:3015")
    @GetMapping("/{userName}/{userPass}")
    @ApiResponses({
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
            @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
    })  
    public ResponseEntity<Boolean> UserLookUp(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup,
    		@ApiParam(name = "column", value = "userName") @RequestParam(required = true) String userName,
			@ApiParam(name = "column", value = "userPass") @RequestParam(required = true) String userPass) throws JsonProcessingException {
    	log.info("Lister les personnes de " + nomTableLookup);
    	return new ResponseEntity<Boolean>(loginService.checkCredentials(userName, userPass), HttpStatusCode.valueOf(200));
    }

    @CrossOrigin(origins = "http://localhost:3015")
    @PostMapping("/{userName}/{userPass}")
    @ApiResponses({
        @ApiResponse(code = SwaggerConstant.HTTP_CODE_OK, message = SwaggerConstant.HTTP_CODE_OK_MESSAGE),
        @ApiResponse(code = SwaggerConstant.HTTP_CODE_UNAUTHORIZED, message = SwaggerConstant.HTTP_CODE_UNAUTHORIZED_MESSAGE)
	})  
	public ResponseEntity<Boolean> LoginRequest(@ApiParam(name = "table", value = "nomTableLookup") @RequestParam(required = true) String nomTableLookup,
			@ApiParam(name = "column", value = "userName") @RequestParam(required = true) String userName,
			@ApiParam(name = "column", value = "userPass") @RequestParam(required = true) String userPass) throws JsonProcessingException {
		log.info("Got the Login Request from " + userName + userPass);
		return new ResponseEntity<Boolean>(loginService.checkCredentials(userName, userPass), HttpStatusCode.valueOf(200));
	}
    
/*    public ResponseEntity<?> login(@RequestBody LoginRequest request) {
        // Replace this with actual database/security logic
    	
        if ("admin".equals(request.getUsername()) && "password123".equals(request.getUserPass())) {
            return ResponseEntity.ok(new LoginResponse("Login Successful!", "mock-jwt-token"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    } */
}


