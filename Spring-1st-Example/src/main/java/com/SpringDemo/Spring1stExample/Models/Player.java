package com.SpringDemo.Spring1stExample.Models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Timestamp;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer player_id;

    private String username;

    private String password;

    private String email;

    private String first_name;

    private String last_name;

    private Timestamp signup_date;

    private boolean active_ind;

    private Timestamp deactivation_date;

    public Integer getPlayer_id() {
        return player_id;
    }

    public void setPlayer_id(Integer player_id) {
        this.player_id = player_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Timestamp getSignup_date() {
        return signup_date;
    }

    public void setSignup_date(Timestamp signup_date) {
        this.signup_date = signup_date;
    }

    public boolean isActive_ind() {
        return active_ind;
    }

    public void setActive_ind(boolean active_ind) {
        this.active_ind = active_ind;
    }

    public Timestamp getDeactivation_date() {
        return deactivation_date;
    }

    public void setDeactivation_date(Timestamp deactivation_date) {
        this.deactivation_date = deactivation_date;
    }
}