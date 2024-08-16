package Session;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class SingletonSession implements AutoCloseable{

    static SingletonSession instance;
    private final Session session;
    private final SessionFactory sessionFactory;
    private final StandardServiceRegistry registry;

    private SingletonSession() {

        registry = new StandardServiceRegistryBuilder().configure().build();
        sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
        session = sessionFactory.openSession();
    }

    public Session getSession() {
        return session;
    }

    public static SingletonSession getInstance() {

        if(instance == null) return new SingletonSession();
        return instance;
    }

    @Override
    public void close() throws Exception {
        session.close();
        sessionFactory.close();
        registry.close();
    }
}
