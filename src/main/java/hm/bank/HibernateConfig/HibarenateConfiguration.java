package hm.bank.HibernateConfig;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibarenateConfiguration {
    private SessionFactory sessionFactory;
    private Session session;

    public Session getSession() {
        Configuration configuration = new Configuration();
        configuration.configure("/Hibernate/hibernate.cfg.xml");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
        return session;
    }

    public void closeSession() {
        sessionFactory.close();
        session.close();
    }
}
