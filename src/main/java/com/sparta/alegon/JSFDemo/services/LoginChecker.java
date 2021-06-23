package com.sparta.alegon.JSFDemo.services;

import javax.persistence.*;

import com.sparta.alegon.JSFDemo.entities.UsersEntity;


public class LoginChecker {

    EntityManagerFactory factory;
    EntityManager manager;
    EntityTransaction transaction;


    public int check(String username, String password){
        setupConnection();
        return checkData( username,  password);
    }

        public void setupConnection(){
            factory = Persistence.createEntityManagerFactory("default");

            manager = factory.createEntityManager();
            //transaction = manager.getTransaction();
        }

        public int checkData(String username, String password){
            try{
                transaction.begin();
                Query q1 = manager.createQuery("SELECT u FROM UsersEntity u WHERE u.name = :name");
                q1.setParameter("name",username);
                UsersEntity usersEntity = (UsersEntity) q1.getSingleResult();
                transaction.commit();
                if(usersEntity != null) {
                    if(password == usersEntity.getPassword()){
                        return 1;
                    }
                    else{
                        return 2;
                    }
                }else{
                    return 3;
                }

//                UsersEntity user = manager.find(UsersEntity.class, 1);
//                usersEntity.getName();
//                usersEntity.getPassword();

//                manager.persist(usersEntity);
//                transaction.commit();

            } finally {
                if(transaction.isActive()){
                    transaction.rollback();
                }
                manager.close();
                factory.close();
            }
        }
    }

