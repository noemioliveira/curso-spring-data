package br.com.noemi.curso.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaDialect;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
//habilita  JPA repository do Spring
@EnableJpaRepositories(basePackages ="br.com.noemi.curso.repository")
//habilita as trasacoes
@EnableTransactionManagement
//habilita o arquivo de propeties p/ Spring  ler
@PropertySource( value ="classpath:application.properties")
public class SpringDataConfig {
	
	@Value( value ="${jdbc.user}")
	private String username;
	@Value( value ="${jdbc.pass}")
	private String password;
	@Value( value ="${jdbc.driver}")
	private String driver;
	@Value( value ="${jdbc.url}")
	private String url;
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory factory){
		
		JpaTransactionManager manager = new JpaTransactionManager();
		manager.setEntityManagerFactory(factory);
		manager.setJpaDialect(new HibernateJpaDialect());
		return manager;
	}
	
	@Bean
	public HibernateJpaVendorAdapter jpaVendorAdapter(){
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		vendorAdapter.setShowSql(true);
		vendorAdapter.setGenerateDdl(true);
		
		return vendorAdapter;
	}
	
	@Bean
	public EntityManagerFactory  entityManagerFactory(){
		
		LocalContainerEntityManagerFactoryBean factory= new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(jpaVendorAdapter());
		factory.setPackagesToScan("br.com.noemi.curso.entity");
		factory.setDataSource(dataSource());
		factory.afterPropertiesSet();
		
		return factory.getObject();
	}
	
	@Bean(name = "dataSources")
	public DataSource dataSource(){
		DriverManagerDataSource dataSources = new DriverManagerDataSource();
		dataSources.setUsername(username);
		dataSources.setPassword(password);
		dataSources.setDriverClassName(driver);
		dataSources.setUrl(url);
		
		return dataSources;
	}
	

}
