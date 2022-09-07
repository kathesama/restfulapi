//package com.kathesama.restfulapi.controller;
//
//import com.kathesama.restfulapi.dto.AuthenticationDTO;
//import com.kathesama.restfulapi.dto.TokenDTO;
//import com.kathesama.restfulapi.service.implementation.JWTServiceImpl;
//import com.kathesama.restfulapi.service.implementation.UserDetailServiceImpl;
//import io.swagger.v3.oas.annotations.Operation;
//import io.swagger.v3.oas.annotations.media.Content;
//import io.swagger.v3.oas.annotations.media.Schema;
//import io.swagger.v3.oas.annotations.responses.ApiResponse;
//import io.swagger.v3.oas.annotations.responses.ApiResponses;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.validation.ConstraintViolationException;
//
//@RestController
//@RequestMapping("${jms.configuration.base-url}")
//public class AuthController {
//
//    @Autowired
//    UserDetailServiceImpl userDetailsService;
//    @Autowired
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private JWTServiceImpl jwtService;
//
//    public static final Logger logger = LoggerFactory.getLogger(AuthController.class);
//
//    @PostMapping("/authenticate")
//    public ResponseEntity<?> authenticate(@RequestBody AuthenticationDTO user){
//        var auth = SecurityContextHolder.getContext().getAuthentication();
//        logger.info("Datos del usuario: {}", auth.getPrincipal());
//        logger.info("Datos de los permisos: {}", auth.getAuthorities());
//        logger.info("Autenticado?: {}", auth.isAuthenticated());
//        logger.info("Datos del usuario: {}", auth.getPrincipal());
//
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(user.getUsuario(), user.getClave())
//        );
//
//        final UserDetails userdetails = userDetailsService.loadUserByUsername(user.getUsuario());
//
//        final String jwt = jwtService.generateToken(userdetails);
//
//        TokenDTO tokenDTO = new TokenDTO(jwt);
//
//        return ResponseEntity.ok(tokenDTO);
//
//    }
//}
