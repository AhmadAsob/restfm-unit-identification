package id.co.astra.fifgroup.project.restfm_unit_identification.config;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EntityScan(basePackages = "id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifMotifEntity")
@EnableJpaRepositories(basePackages = "id.co.astra.fifgroup.project.restfm_unit_identification.repository.FifMotifRepo",
        entityManagerFactoryRef = "fifmotifEntityManagerFactory",
        transactionManagerRef = "fifmotifTransactionManager",
        repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
public class FifmotifDbConfig {

    @Bean
    @ConfigurationProperties("fifmotif.datasource")
    public DataSourceProperties fifmotifDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "fifmotif.datasource")
    public DataSource fifmotifDataSource(){
        return fifmotifDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "fifmotifEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean fifmotifEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(fifmotifDataSource());
        em.setPackagesToScan("id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifMotifEntity");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        em.setJpaVendorAdapter(vendorAdapter);
        HashMap<String,Object> properties = new HashMap<>();
        properties.put("hibernate.dialect","org.hibernate.dialect.Oracle10gDialect");
        properties.put("hibernate.show-sql",true);
        properties.put("hibernate.format-sql",true);
        properties.put("hibernate.hbm2ddl.auto","none");
        em.setJpaPropertyMap(properties);

        return em;
    }

    @Bean(name = "fifmotifTransactionManager")
    public PlatformTransactionManager fifmotifTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(fifmotifEntityManagerFactory().getObject());
        return transactionManager;
    }

//    @Bean(name = "fifmotifEntityManagerFactory")
//    public LocalContainerEntityManagerFactoryBean fifmotifEntityManagerFactory(EntityManagerFactoryBuilder builder,
//                                                                               @Qualifier("fifmotifDataSource") DataSource fifmotifDataSource){
//        return builder
//                .dataSource(fifmotifDataSource)
//                .packages("id.co.astra.fifgroup.project.restfm_unit_identification.entity.FifMotifEntity")
//                .persistenceUnit("fifmotif")
//                .build();
//    }

//    @Bean(name = "fifmotifTransactionManager")
//    public PlatformTransactionManager fifmotifTransactionManager(@Qualifier ("fifmotifEntityManagerFactory") EntityManagerFactory entityManagerFactory){
//        return new JpaTransactionManager(entityManagerFactory);
//    }
}
