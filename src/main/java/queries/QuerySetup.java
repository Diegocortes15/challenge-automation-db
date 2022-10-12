package queries;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import utils.JpaManager;

public abstract class QuerySetup {
    protected EntityManager manager;
    protected JpaManager jpaManager = new JpaManager();
    protected EntityTransaction transaction;

    public QuerySetup() {
        //Create new entity manager and transaction
        manager = jpaManager.getManager();
        transaction = manager.getTransaction();
    }
}
