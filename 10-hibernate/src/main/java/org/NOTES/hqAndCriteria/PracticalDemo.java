package org.NOTES.hqAndCriteria;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import lombok.var;
import org.NOTES.relationships.HibernateUtil;
import org.NOTES.relationships.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PracticalDemo {

    public static void main(String[] args) {
        Session session = HibernateUtil
                .getSessionFactory()
                .getCurrentSession();

        Transaction tx = session.beginTransaction();

        // ________________________
        //  HQL EXAMPLE
        // ------------------------

        // Fetch students above age 20
        var students = session.createQuery(
                        "from Student s where s.age > :age",
                        Student.class)
                .setParameter("age", 20)
                .list();

        students.forEach(s ->
                System.out.println(s.getName()));

        tx.commit();

        // ________________________
        //  PAGINATION EXAMPLE
        // ------------------------

        var paginated = session.createQuery(
                        "from Student",
                        Student.class)
                .setFirstResult(0)
                .setMaxResults(5)
                .list();


        // ________________________
        //  AGGREGATION EXAMPLE
        // ------------------------

        Long count = session.createQuery(
                        "select count(s) from Student s",
                        Long.class)
                .uniqueResult();

        System.out.println("Total Students: " + count);

        // ________________________
        //  JOIN FETCH EXAMPLE
        // ------------------------

        var students1 = session.createQuery(
                        "select s from Student s join fetch s.department",
                        Student.class)
                .list();

        // ________________________
        //  CRITERIA API EXAMPLE
        // ------------------------

        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> root = cq.from(Student.class);
        cq.select(root).where(cb.gt(root.get("age"), 20));

        var results = session.createQuery(cq).getResultList();
    }
}
