package com.itsqmet.app_gym_web2.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;


@Configuration
public class CorsConfiguracion {
    @Bean
    public CorsConfigurationSource corsConfigurationSource(){
        CorsConfiguration configuracion=new CorsConfiguration();
        //peticiones desde el origen angular
        configuracion.setAllowedOrigins(List.of("http://localhost:4200"));
        //permitir todos los metodos http
        configuracion.setAllowedMethods(List.of("GET","POST","PUT","DELETE"));
        //PERMITE cabecera en la solicitud
        configuracion.setAllowedHeaders(List.of("*"));
        //aplicar esta configuracio na todas las rutas del back
        UrlBasedCorsConfigurationSource source=new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**",configuracion);
        return source;

    }
}
