package dataaccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static final EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("WeldedScrapPU");
    
    public static EntityManagerFactory getEmFactory() {
        System.out.println(emf);
        return emf;
    }
}