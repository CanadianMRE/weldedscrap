package dataaccess;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Handles access to the main entity manager for the project
 * @author WeldedScrap
 */
public class DBUtil {
    /**
     * The main data access entity
     */
    private static final EntityManagerFactory emf
            = Persistence.createEntityManagerFactory("WeldedScrapPU");

    /**
     * Returns the main data access entity
     * @return  The entity manager for the project
     */
    public static EntityManagerFactory getEmFactory() {
        return emf;
    }
}
