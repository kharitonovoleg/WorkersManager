package by.manager.dao;

import by.manager.model.Workers;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

import org.slf4j.Logger;


@Repository
public class DaoWorkersImpl implements DaoWorkers {

    private static final Logger logger = LoggerFactory.getLogger(DaoWorkersImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addWorkers(Workers workers) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(workers);
        logger.info("Worker successfully saved. Worker details: " + workers);
    }

    @Override
    public void updateWorkers(Workers workers) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(workers);
        logger.info("Worker successfully update. Worker details: " + workers);

    }

    @Override
    public void removeWorkers(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Workers workers = (Workers) session.load(Workers.class, new Integer(id));

        if (workers != null) {
            session.delete(workers);
        }
        logger.info("Worker successfully removed. Worker details: " + workers);
    }

    @Override
    public Workers getWorkersById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Workers workers = (Workers) session.load(Workers.class, new Integer(id));
        logger.info("Worker successfully loaded. Worker details: " + workers);

        return workers;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Workers> listWorkers() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Workers> workersList = session.createQuery("from Workers").list();

        for (Workers workers : workersList) {
            logger.info("Worker list: " + workers);
        }
        return workersList;
    }

    @Override
    public Collection<Workers> getWorkers(String search) {
        Session session = this.sessionFactory.getCurrentSession();
        if (search == null || search.trim().isEmpty()) {
            return session.createQuery("FROM Workers").list();
        }
        return session.createQuery("select c from Workers where c.firstName like :search").
                setParameter("search", search.trim() + "%").list();
    }

}
