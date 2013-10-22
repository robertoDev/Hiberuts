package it.blackcat.hiberuts;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.HashMap;
import java.util.Map;

public final class EMF {
    private static EntityManagerFactory emfInstance=null;

    static {

/*
            Map<String, String> properties = new HashMap();
            if (SystemProperty.environment.value() == SystemProperty.Environment.Value.Production) {
              properties.put("javax.persistence.jdbc.driver","com.mysql.jdbc.GoogleDriver");
              properties.put("javax.persistence.jdbc.url",System.getProperty("cloudsql.url"));
            } else {
              properties.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
              properties.put("javax.persistence.jdbc.url","jdbc:mysql://localhost/sakila");
            }





*/
            Map<String, String> properties = new HashMap();
            if("homeuser".equals(System.getenv().get("USERNAME"))){
                properties.put("javax.persistence.jdbc.driver","com.mysql.jdbc.Driver");
                properties.put("javax.persistence.jdbc.url","jdbc:mysql://localhost/sakila");
                properties.put("javax.persistence.jdbc.user","hibernate");
                properties.put("javax.persistence.jdbc.password","hibernate");
            } else {
                properties.put("javax.persistence.jdbc.driver","com.mysql.jdbc.GoogleDriver");
                properties.put("javax.persistence.jdbc.url","jdbc:google:mysql://the-black-cat:blackcat/sakila");
                properties.put("javax.persistence.jdbc.user","root");
            }
            emfInstance = Persistence.createEntityManagerFactory("NewPersistenceUnit",properties);
    }

    private EMF() {}

    public static EntityManagerFactory get() {
        return emfInstance;
    }
}