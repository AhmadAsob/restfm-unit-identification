package id.co.astra.fifgroup.project.restfm_unit_identification.config;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.HashMap;

@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity")
@EnableJpaRepositories(basePackages = "id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifappsRepo",
        entityManagerFactoryRef = "fifappsEntityManagerFactory",
        transactionManagerRef = "fifappsTransactionManager",
        repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
public class FifappsDbConfig {

    @Bean
    @ConfigurationProperties("fifapps.datasource")
    public DataSourceProperties fifappsDataSourceProperties() {
        return new DataSourceProperties();
    }

    @Primary
    @Bean
    @ConfigurationProperties(prefix = "fifapps.datasource")
    public DataSource fifappsDataSource(){
        return fifappsDataSourceProperties().initializeDataSourceBuilder().build();
    }


//    @Bean(name = "fifappsEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean fifappsEntityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                              @Qualifier("fifappsDataSource") DataSource fifappsDataSource){
//        return builder
//                .dataSource(fifappsDataSource)
//                .packages("id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity")
//                .persistenceUnit("fifapps")
//                .build();
//    }

    @Bean(name = "fifappsEntityManagerFactory")
    @Primary
    public LocalContainerEntityManagerFactoryBean fifappsEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(fifappsDataSource());
        em.setPackagesToScan("id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifappsEntity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String,Object> properties = new HashMap<>();
        properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        properties.put("hibernate.show-sql",true);
        properties.put("hibernate.format-sql",true);
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "fifappsTransactionManager")
    @Primary
    public PlatformTransactionManager fifappsTransactionManager(){
        JpaTransactionManager transactionManager
                = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(
                fifappsEntityManagerFactory().getObject());
        return transactionManager;
    }

//    @Bean(name = "fifappsTransactionManager")
//    public PlatformTransactionManager fifappsTransactionManager(@Qualifier("fifappsEntityManagerFactory") EntityManagerFactory entityManagerFactory){
//        return new JpaTransactionManager(entityManagerFactory);
//    }
}
