package lk.ijse.gdse.orm.hibernate.config;

import lk.ijse.gdse.orm.hibernate.entity.Customer;
import lk.ijse.gdse.orm.hibernate.entity.Order;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;
    private static SessionFactory sessionFactory;

    private SessionFactoryConfig() {
     /*   StandardServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().configure().build();

        Metadata metadata = new MetadataSources(serviceRegistry).addAnnotatedClass(Customer.class).getMetadataBuilder().applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE).build();

//        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();*/
        /* sessionFactory = new MetadataSources(new StandardServiceRegistryBuilder().configure().build())
                            .addAnnotatedClass(Customer.class)
                            .getMetadataBuilder()
                            .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                            .build()
                            .buildSessionFactory();*/
                sessionFactory = new Configuration().configure()
                        .addAnnotatedClass(Order.class)
                        .addAnnotatedClass(Customer.class)
                        .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance() {
/*        if(null==factoryConfig){
            return factoryConfig = new SessionFactoryConfig();
        }
     return factoryConfig;
   */
        return (null==factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig ;
    }

    public Session getSession(){

        return sessionFactory.openSession();

    }


}
