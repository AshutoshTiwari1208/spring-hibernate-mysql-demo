package com.inclined.hibernate.practice;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.inclined.hibernate.demo.entity.Student;

public class PrimaryKeyDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();

		try {	
		// making object to save
		Student student1 = new Student("Ashu","Tiw","ashutosh3309@gmail.com");
		Student student2 = new Student("Sundar", "Pichai", "sundar@gmail.com");
		Student student3 = new Student("Steve", "Jobs", "steve@apple.com");
		
		// start transaction
		session.beginTransaction();
		
		// save student to session
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		System.out.println("Student3 brefore---> "+ student3.getId());
		
		//commit the transaction
		session.getTransaction().commit();
		
		System.out.println("Student3 after---> "+ student3.getId());

		
		session = factory.getCurrentSession();
		session.beginTransaction();
		
		Student stu = session.get(Student.class, 4);
		System.out.println(stu);
		session.getTransaction().commit();
		
		}finally {
			factory.close();
		}
	}

}
