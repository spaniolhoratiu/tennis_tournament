package layer_data_access.repo;

import config.HibernateConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class GenericRepo {

    private final static Session session = HibernateConfig.Instance();

    public static <T> T findById(Class<T> clasz, int id) {

        Transaction transaction = session.beginTransaction();
        T toReturn = null;
        toReturn = session.find(clasz, Integer.valueOf(id));
        transaction.commit();

        return toReturn;
    }

    /**
     * Save returns the object identifier not the saved object.
     */
    public static <T> int save(T toSave) {
        Transaction transaction = session.beginTransaction();
        int savedId = (int) session.save(toSave);
        transaction.commit();
        return savedId;
    }




}
