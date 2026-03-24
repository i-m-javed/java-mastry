package com.capgi.dao;

import com.capgi.entity.Laptop;
import com.capgi.entity.Student1;
import com.capgi.repository.StudentRepo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class StudentDaoImpl implements StudentDao{
    @Override
    public void saveData() {
        EntityManager em= StudentRepo.getEntityManager();
        EntityTransaction trx= em.getTransaction();
        trx.begin();
        Laptop laptop = new Laptop();
        laptop.setId(201);
        laptop.setBrand("Dell");
        laptop.setPrice(65000);

        Student1 student = new Student1();
        student.setId(11);
        student.setName("Krishna");
        student.setCourse("Computer Science");

        student.setLaptop(laptop);
        laptop.setStudent(student);

        em.persist(laptop);
        em.persist(student);
        trx.commit();
        em.close();
    }

    @Override
    public void fetchLaptopFromStudent(int studentId) {
        EntityManager em= StudentRepo.getEntityManager();
        Student1 s1= em.find(Student1.class,studentId);
        if(s1!=null){
            if(s1.getLaptop()!=null) System.out.println(s1.getLaptop());
            else System.out.println("No laptop found associated to this user");
        }else{
            System.out.println("Student not found");
        }
        em.close();
    }

    @Override
    public void fetchStudentFromLaptop(int laptopID) {
        EntityManager em= StudentRepo.getEntityManager();
        Laptop l1= em.find(Laptop.class,laptopID);
        if(l1!=null){
            if(l1.getStudent()!=null) System.out.println(l1.getStudent());
            else System.out.println("No Student found associated to this Laptop");
        }else{
            System.out.println("Laptop not found");
        }
        em.close();
    }

    @Override
    public void updateLaptopBrand(int laptopId, String newBrand) {
        EntityManager em= StudentRepo.getEntityManager();
        EntityTransaction trx= em.getTransaction();
        trx.begin();
        Laptop l1= em.find(Laptop.class,laptopId);
        if(l1!=null){
            l1.setBrand(newBrand);
            em.merge(l1);
            trx.commit();
            System.out.println("Update Successful");
        }else{
            System.out.printf("Laptop not found");
        }
        em.close();
    }

    @Override
    public void updateStudentCourse(int studentId, String newCourse) {
        EntityManager em= StudentRepo.getEntityManager();
        EntityTransaction trx= em.getTransaction();
        trx.begin();
        Student1 s1= em.find(Student1.class,studentId);
        if(s1!=null){
            s1.setCourse(newCourse);
            em.merge(s1);
            trx.commit();
            System.out.println("Update Successful");
        }else{
            System.out.println("Student not found");
        }
        em.close();
    }

    @Override
    public void changeLaptopForStudent(int studentId, int newLaptopId) {
        EntityManager em= StudentRepo.getEntityManager();
        EntityTransaction trx= em.getTransaction();
        trx.begin();
        Student1 s1= em.find(Student1.class,studentId);

        if(s1!=null){
            Laptop l1=s1.getLaptop();
            if(l1!=null){
                l1.setStudent(null);
            }
            Laptop l2= em.find(Laptop.class,newLaptopId);
            if(l2==null){
                l2 = new Laptop();
                l2.setId(newLaptopId);
                l2.setBrand("Random_"+newLaptopId);
                l2.setPrice(newLaptopId*100);
                em.persist(l2);
            }
            s1.setLaptop(l2);
            l2.setStudent(s1);
            em.merge(l2);
            System.out.println("Laptop changed");
            trx.commit();
        }else{
            System.out.println("Student not found");
        }
        em.close();
    }

    @Override
    public void removeLaptopFromStudent(int studentId) {
        EntityManager em= StudentRepo.getEntityManager();
        EntityTransaction trx= em.getTransaction();
        trx.begin();
        Student1 s1= em.find(Student1.class,studentId);
        if(s1!=null && s1.getLaptop()!=null){
            Laptop l1=s1.getLaptop();
            s1.setLaptop(null);
            l1.setStudent(null);
            em.merge(s1);
            em.merge(l1);
            trx.commit();
            System.out.println("Laptop removed from student");
        }
        em.close();
    }

    @Override
    public void deleteStudentAndLaptop(int studentId) {
        EntityManager em= StudentRepo.getEntityManager();
        EntityTransaction trx= em.getTransaction();
        trx.begin();
        Student1 s1= em.find(Student1.class,studentId);
        if(s1!=null){
            if(s1.getLaptop()!=null){
                Laptop l1=s1.getLaptop();
                em.remove(l1);
                System.out.println("Laptop removed");
            }
            em.remove(s1);
            trx.commit();
            System.out.println("Student removed");
        }
        em.close();
    }
}
