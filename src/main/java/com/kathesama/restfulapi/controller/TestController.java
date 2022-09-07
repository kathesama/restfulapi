package com.kathesama.restfulapi.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${jms.configuration.base-url}")
public class TestController {
    public static final Logger logger = LoggerFactory.getLogger(TodoController.class);

    @GetMapping("/public")
    public String holaPublic(){
//        var auth = SecurityContextHolder.getContext().getAuthentication();
//        logger.info("Datos del usuario: {}", auth.getPrincipal());
//        logger.info("Datos de los permisos: {}", auth.getAuthorities());
//        logger.info("Autenticado?: {}", auth.isAuthenticated());
//
//        logger.info("Datos del usuario: {}", auth.getPrincipal());

        return "Hola Publico";
    }

    @GetMapping("/admin")
    public String holaAdmin(){
//        var auth = SecurityContextHolder.getContext().getAuthentication();
//        logger.info("Datos del usuario: {}", auth.getPrincipal());
//        logger.info("Datos de los permisos: {}", auth.getAuthorities());
//        logger.info("Autenticado?: {}", auth.isAuthenticated());
//
//        logger.info("Datos del usuario: {}", auth.getPrincipal());
        return "Hola Admin";
    }
}
