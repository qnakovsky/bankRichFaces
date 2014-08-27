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
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * @author admin
 */
@Entity
@Table(name = "users")
public class User 
{
    @Id
    @SequenceGenerator(name = "myseq",sequenceName = "auto_id_user")
    @GeneratedValue(generator = "myseq")
    @Column(name = "user_id")
    private int user_id;
    
    @Column(name = "user_name")
    private String user_name;
    
    @OneToMany(mappedBy = "user")
    private Set<Account> accounts=new HashSet<Account>();
    
    public User() {
    }

    public Set<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(Set<Account> accounts) {
        this.accounts = accounts;
    }

    public User(String user_name) {
        this.user_name = user_name;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
    
}
