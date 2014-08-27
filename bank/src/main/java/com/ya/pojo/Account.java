/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ya.pojo;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "account")
public class Account 
{
    @Id
    @Column(name="acc_id")
    @SequenceGenerator(name = "myseq",sequenceName = "auto_id_acc")
    @GeneratedValue(generator = "myseq")
    private int acc_id;
    @Column(name = "user_id")
    private int user_id;
    @Column(name = "amount")
    private int amount;
    
    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private User user;

    public Set<Transaction> getTransacts() {
        return transacts;
    }

    public void setTransacts(Set<Transaction> transacts) {
        this.transacts = transacts;
    }
    @OneToMany(mappedBy = "account")
    private Set<Transaction> transacts = new HashSet<Transaction>();
    
    public Account() {
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
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

    public User getUser() {
        return user;
    }

    public Account(int user_id, int amount) {
        this.user_id = user_id;
        this.amount = amount;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Account(int amount) {
        this.amount = amount;
    }
            
    
}
