package com.hermestechnologies.config;

import com.hermestechnologies.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {

    @Autowired
    private ApplicationContext context;

    @Bean
    public LocalSessionFactoryBean getSessionFactory() {
        LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
        if(System.getenv("STATE") == "testing"){
            factoryBean.setConfigLocation(context.getResource("classpath:hibernate-dev.cfg.xml"));
        }else{
            factoryBean.setConfigLocation(context.getResource("classpath:hibernate.cfg.xml"));
        }
        factoryBean.setAnnotatedClasses(User.class, Role.class, Stock.class, Product.class, Po.class, Supplier.class, PoItem.class, SupplierProduct.class);
        return factoryBean;
    }

    @Bean
    public HibernateTransactionManager getTransactionManager() {
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(getSessionFactory().getObject());
        return transactionManager;
    }
}
