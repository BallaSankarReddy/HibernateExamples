package com.spring.hibernate.util;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfiguration {

	@Value("${spring.datasource.dbcp2.driver-class-name}")
	private String DB_DRIVER;

	@Value("${spring.datasource.data-password}")
	private String DB_PASSWORD;

	@Value("${spring.datasource.url}")
	private String DB_URL;

	@Value("${spring.datasource.data-username}")
	private String DB_USERNAME;

	@Value("${spring.jpa.properties.hibernate.dialect}")
	private String HIBERNATE_DIALECT;

	@Value("${spring.jpa.show-sql}")
	private String HIBERNATE_SHOW_SQL;

	@Value("${spring.jpa.hibernate.ddl-auto}")
	private String HIBERNATE_HBM2DDL_AUTO;

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		Properties hbmPOP = new Properties();
		hbmPOP.put("hibernate.dialect", HIBERNATE_DIALECT);
		hbmPOP.put("hibernate.show_sql", HIBERNATE_SHOW_SQL);
		hbmPOP.put("hibernate.hbm2ddl.auto", HIBERNATE_HBM2DDL_AUTO);
		sessionFactory.setPackagesToScan("com.spring.hibernate");
		sessionFactory.setHibernateProperties(hbmPOP);
		return sessionFactory;
	}

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();

		dataSource.setDriverClassName(DB_DRIVER);
		dataSource.setPassword(DB_PASSWORD);
		dataSource.setUsername(DB_USERNAME);
		dataSource.setUrl(DB_URL);

		return dataSource;
	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}
}
