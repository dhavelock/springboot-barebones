package ca.mcgill.ecse321;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.Session;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {

        /* Connect to the DB and begin an atomic operation */
        Session session = HibernateUtil.getSession();
        session.beginTransaction();

        /* Create an example student */
        Hello hello = new Hello(1, "Hello!");

        /* Write the student to the DB by committing the transaction */
        session.saveOrUpdate(hello);

        session.getTransaction().commit();

        session.close();

        HibernateUtil.closeSession();

        System.out.println("close");

        /* Back to the spring application. The above is to test Hibernate */
        SpringApplication.run(Application.class, args);
    }
}
