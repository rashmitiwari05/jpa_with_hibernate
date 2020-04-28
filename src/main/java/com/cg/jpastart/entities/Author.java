package com.cg.jpastart.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;



    @Entity

    @Table(name="authors")
    public class Author implements Serializable {
                    private static final long serialVersionUID = 1L;

        @Id
        @GeneratedValue
        private int authorId;

          private String firstName;

        private String middleName;

             private String lastName;
        private int phoneNo;

        public int getAuthorId() {
              
               return authorId;
        }

        public void setAuthorId(int authorId) {
                      this.authorId = authorId;
        }

        public String getFirstName() {
            return firstName;
        }



        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getMiddleName() {
                     return middleName;
        }

        public void setMiddleName(String middleName) {
            this.middleName = middleName;
        }

        public String getLastName() {
                        return lastName;
        }

        public void setLastName(String lastName) {
                      this.lastName = lastName;
        }

        public int getPhoneNo() {
                      return phoneNo;
        }



        public void setPhoneNo(int phoneNo) {
                    this.phoneNo = phoneNo;
        }
    }
