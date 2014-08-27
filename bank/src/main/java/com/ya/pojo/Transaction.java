/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.ya.pojo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 *
 * @author admin
 */
@Entity
@Table(name = "transactions")
public class Transaction implements Serializable 
{
    @Id
    @Column(name="transact_id")
     @SequenceGenerator(name = "myseq",sequenceName = "auto_id_tran")
    @GeneratedValue(generator = "myseq")
    private int transaction_id;
    @Column(name="acc_id")
    private int acc_id;
    @Column(name = "amount")
    private int amount;
    @Column(name = "info")
    private String info;
    @ManyToOne
    @JoinColumn(name = "acc_id",insertable = false,updatable = false)
    Account account;

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
    public Transaction() {
    }

    public Transaction(int acc_id, int amount, String info) {
        this.acc_id = acc_id;
        this.amount = amount;
        this.info = info;
    }

    public int getTransaction_id() {
        return transaction_id;
    }

    public void setTransaction_id(int transaction_id) {
        this.transaction_id = transaction_id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    
}
