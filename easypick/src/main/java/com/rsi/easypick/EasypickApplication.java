package com.rsi.easypick;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class EasypickApplication {

	@Value("${spring.datasource.driver-class-name}")
	private String driverClassName;	
	//@Value("${spring.datasource.username}")
	//private String username;
	//@Value("${spring.datasource.password}")
	//private String pwd;
	//@Value("${spring.datasource.iv}")
	//private String iv;
	@Value("${spring.datasource.url}")
	private String url;
	@Value("${spring.datasource.tomcat.testOnBorrow}")
	private Boolean testOnBorrow;
	@Value("${spring.datasource.tomcat.validationQuery}")
	private String validationQuery;
	
	public static void main(String[] args) {
		SpringApplication.run(EasypickApplication.class, args);
	}
	
	@Bean
	public DataSource dataSource() {
	    DataSource dataSource = new DataSource(); // org.apache.tomcat.jdbc.pool.DataSource;
	    dataSource.setDriverClassName(driverClassName);
	    dataSource.setUrl(url);
	    //dataSource.setUsername(username);
	    //String pass = encryptDecryptUtil.Decrypt(this.pwd, iv);
	    //dataSource.setPassword(pass);
	    dataSource.setTestWhileIdle(testOnBorrow);     
	    dataSource.setValidationQuery(validationQuery);
	    return dataSource;
	}
	
}
