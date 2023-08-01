package id.co.astra.fifgroup.project.restfm_unit_identification.config;

import com.cosium.spring.data.jpa.entity.graph.repository.support.EntityGraphJpaRepositoryFactoryBean;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.HashMap;


@Configuration
@EnableTransactionManagement
@EntityScan(basePackages = "id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity")
@EnableJpaRepositories(basePackages = "id.co.astra.fifgroup.project.restfm_unit_identification.repository.FmUiRepo",
        entityManagerFactoryRef = "fmUiEntityManagerFactory",
        transactionManagerRef = "fmUiTransactionManager",
        repositoryFactoryBeanClass = EntityGraphJpaRepositoryFactoryBean.class)
public class FmUiDbConfig {

    @Bean
    @ConfigurationProperties("fmui.datasource")
    public DataSourceProperties fmUiDataSourceProperties(){
        return new DataSourceProperties();
    }

    @Bean
    @ConfigurationProperties(prefix = "fmui.datasource")
    public DataSource fmUiDataSource(){
        return fmUiDataSourceProperties().initializeDataSourceBuilder().build();
    }

    @Bean(name = "fmUiEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean fmUiEntityManagerFactory(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(fmUiDataSource());
        em.setPackagesToScan("id.co.astra.fifgroup.project.restfm_unit_identification.entity.FmUiEntity");

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

    @Bean(name = "fmUiTransactionManager")
    public PlatformTransactionManager fmUiTransactionManager(){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(fmUiEntityManagerFactory().getObject());
        return transactionManager;
    }

}
