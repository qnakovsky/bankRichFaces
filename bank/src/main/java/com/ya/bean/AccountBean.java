/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ya.bean;

import com.ya.pojo.Account;
import com.ya.pojo.Transaction;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author admin
 */
public class AccountBean 
{    
    private int user_id;
    private int amount;   
    private Set<Transaction> transacts = new HashSet<Transaction>();
    void add()
    {
        Account ac = new Account(user_id, amount);
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("manager");
        EntityManager entityManager = emf.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.persist(ac);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Set<Transaction> getTransacts() {
        return transacts;
    }

    public void setTransacts(Set<Transaction> transacts) {
        this.transacts = transacts;
    }
}
