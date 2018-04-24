package com.algaworks.brewer.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.algaworks.brewer.controller.CervejasController;

//ensina o spring a achar os controllers
//Ctrl+shift+o pra atualizar

//usa esse scan em vez de criar "com.algaworks.brewer.controller" 
@Configuration
@ComponentScan(basePackageClasses = CervejasController.class)
@EnableWebMvc
public class WebConfig implements WebMvcConfigurer{
	//usei o implements WebMvcConfigurer em vez
	//do extends WebMvcConfigurerAdapter porque este tá deprecado
	
}
