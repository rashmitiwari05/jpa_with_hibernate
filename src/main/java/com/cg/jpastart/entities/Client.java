package com.cg.jpastart.entities;

import javax.persistence.*;
import java.util.List;

public class Client {
    EntityManagerFactory auth;

    public static void main(String[] args) {
        Client client = new Client();
                 client.execute();
    }

    void execute() {
        //entity manager factory created
        auth = Persistence.createEntityManagerFactory("JPA-PU");
        Author author = createAuthor();
       
            int id = author.getAuthorId();
        Author found = findAuthorById(id);
        print(found);

        found.setFirstName("Rashmi");
        updateAuthor(found);

                print(found);

        List<Author> employees=findAllEmployees();

      

        System.out.println("printing all Authors");
        print(employees);
              auth.close();
    }

    void print(Author author){
        System.out.println("employee id="+author.getAuthorId()+" firstname="+author.getFirstName()+" middlename="+author.getMiddleName()+" lastname="+author.getLastName()+" phonenumber="+author.getPhoneNo());

    }
    void print(List<Author>authors){
        for (Author author:authors){
            print(author);
        }
    }

    Author findAuthorById(int authorid) {
        EntityManager em = auth.createEntityManager();
             EntityTransaction transaction = em.getTransaction();
        
            transaction.begin();
        Author a = em.find(Author.class, authorid);
        transaction.commit();
        em.close();
        return a;
    }

    List<Author> findAllEmployees(){
        EntityManager em = auth.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
       
        transaction.begin();
             Query query =em.createQuery("from Author");
        List<Author>authors=query.getResultList();
        return authors;
    }

    Author updateAuthor(Author author){
        EntityManager em = auth.createEntityManager();
         
          EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        author=em.merge(author);
        transaction.commit();
        em.close();
        return author;
    }

    void removeAuthorById(int authorid){
        EntityManager em = auth.createEntityManager();
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Author author=em.find(Author.class,authorid);
        em.remove(author);
        transaction.commit();
        em.close();
        System.out.println("Authors removed with id="+authorid);
    }


    Author createAuthor() {
        //
        //creating entity manager
        //
        EntityManager em = auth.createEntityManager();
        //
        //starting transaction
        //
        EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        Author author = new Author();
        author.setFirstName("Rashi");
        author.setMiddleName("Singh");
        author.setLastName("Tomar");
        author.setPhoneNo(9645677813);

        em.persist(author);
        //
        //comitting transaction
        //
        transaction.commit();

        System.out.println("Added one author, with  Authorid=" + author.getAuthorId());
        //
        // closing entity manager 
        //
        em.close();
        return author;
    }
}
