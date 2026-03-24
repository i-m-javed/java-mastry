package NOTES.entityManager_crud;

import NOTES.jpaFundamentals.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class PracticalDemo {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("jpa");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();

        try {

            // FIND -> immediately execute select
            tx.begin();
            Student student = em.find(Student.class, 1L);

            System.out.println(student.getName());

            tx.commit();

            //GETREFERENCE
            tx.begin();

            Student student1 = em.getReference(Student.class, 1L);

            System.out.println("Proxy created");

            // SQL executes only here
            System.out.println(student1.getName());

            tx.commit();

            //MERGE
            tx.begin();

            Student detached = new Student();
            detached.setId(1L);
            detached.setName("Updated Name");

            Student managed = em.merge(detached);

            tx.commit();
            // managed is tracked but detached is not

            // DETACH
            tx.begin();

            Student student2 = em.find(Student.class, 1L);

            em.detach(student2);

            student2.setName("Changed After Detach");

            tx.commit();
            //NO update executed

            //CLEAR
            em.clear();
            // All managed entities become detached

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}


