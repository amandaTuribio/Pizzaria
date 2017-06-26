/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

/**
 *
 * @author amanda
 */
public class DAO {
        public static Session getSession() {
        
        Configuration configuration = new Configuration();
        configuration.configure();
        ServiceRegistry serviceRegistry = 
                new StandardServiceRegistryBuilder().applySettings(
                        configuration.getProperties()
                ).build();

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory(serviceRegistry);
        return sessionFactory.openSession();        
    }
}
