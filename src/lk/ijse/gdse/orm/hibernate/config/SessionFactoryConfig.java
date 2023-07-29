package lk.ijse.gdse.orm.hibernate.config;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private SessionFactoryConfig() {
    }

    public static SessionFactoryConfig getInstance() {
//        if(null==factoryConfig){
//            return factoryConfig = new SessionFactoryConfig();
//        }
//        return factoryConfig;
        return (null==factoryConfig) ? factoryConfig = new SessionFactoryConfig() : factoryConfig ;
    }


}
