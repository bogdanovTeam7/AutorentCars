package pti.sb_rest_autorentcars.db;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import pti.sb_rest_autorentcars.model.Car;

public class Database {
	private SessionFactory factory;

	public Database() {
		StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
		factory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
	}

	public void close() {
		factory.close();
	}

	public List<Car> getAllCars() {
		Session session = factory.openSession();
		Transaction transaction = session.beginTransaction();
		Query query = session.createQuery("SELECT c FROM Car c WHERE c.available=?1", Car.class);
		query.setParameter(1, Boolean.TRUE);
		List<Car> cars = query.getResultList();
		transaction.commit();
		session.close();
		return cars;
	}
}
