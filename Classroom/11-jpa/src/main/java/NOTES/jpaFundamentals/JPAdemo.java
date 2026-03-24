package NOTES.jpaFundamentals;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAdemo {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("jpa");

        EntityManager em = emf.createEntityManager();

        try {

            em.getTransaction().begin();

            Student student = new Student("Javed", 26);

            em.persist(student);

            em.getTransaction().commit();

            System.out.println("Saved with ID: " + student.getId());

        } finally {
            em.close();
            emf.close();
        }
    }
}