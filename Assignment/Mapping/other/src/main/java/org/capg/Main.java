package org.capg;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import org.capg.entity.Author;
import org.capg.entity.Book;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aman");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        // Create
//        tx.begin();
//
//        Author author = new Author();
//        author.setId(1);
//        author.setName("J.K. Rowling");
//        author.setAge(55);
//        author.setEmail("jk@example.com");
//
//        Book book1 = new Book();
//        book1.setId(1);
//        book1.setTitle("Harry Potter 1");
//        book1.setPrice(29.99);
//        book1.setPublicationYear(1997);
//        book1.setAuthor(author);
//
//        Book book2 = new Book();
//        book2.setId(2);
//        book2.setTitle("Harry Potter 2");
//        book2.setPrice(31.99);
//        book2.setPublicationYear(1998);
//        book2.setAuthor(author);
//        author.setBooks(Arrays.asList(book1, book2));
//        em.persist(author);
//        tx.commit();

        // Read Author
//        Author foundAuthor = em.find(Author.class, 1);
//        System.out.println("Author: " + foundAuthor.getName() + ", Age: " + foundAuthor.getAge() + ", Email: " + foundAuthor.getEmail());
//        foundAuthor.getBooks().forEach(book -> System.out.println("Book: " + book.getTitle() + ", Price: " + book.getPrice()));

        // Read Book
//        Book foundBook = em.find(Book.class, 1);
//        System.out.println("Book: " + foundBook.getTitle() + ", Author: " + foundBook.getAuthor().getName());

        // Update Author
//        tx.begin();
//        Author authorToUpdate = em.find(Author.class, 1);
//        authorToUpdate.setAge(57);
//        em.merge(authorToUpdate);
//        tx.commit();

        // Update Book
//        tx.begin();
//        Book bookToUpdate = em.find(Book.class, 1);
//        bookToUpdate.setPrice(25.99);
//        em.merge(bookToUpdate);
//        tx.commit();

        // Delete Book
//        tx.begin();
//        Book bookToDelete = em.find(Book.class, 2);
//        em.remove(bookToDelete);
//        tx.commit();

        // Delete Author
//        tx.begin();
//        Author authorToDelete = em.find(Author.class, 1);
//        em.remove(authorToDelete);
//        tx.commit();

        em.close();
        emf.close();
    }
}
