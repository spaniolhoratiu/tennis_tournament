package repo;

import config.HibernateConfig;
import model.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

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

    public static <T> void delete(T toDelete){
        Transaction transaction = session.beginTransaction();
        session.delete(toDelete);
        transaction.commit();
    }

    public static <T> List<T> getAll(Class<T> className)
    {
        Transaction transaction = session.beginTransaction();
        Criteria criteria = session.createCriteria(className);
        return criteria.list();
    }

    public static <T> void update(T toUpdate)
    {
        Transaction transaction = session.beginTransaction();
        session.update(toUpdate);
        transaction.commit();
    }
}
