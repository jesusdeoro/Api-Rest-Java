package com.example.demo;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "country")
public class Country {
@Id
@Column(name = "country_id")
Integer id;
@Column(name = "country")
String  country;
@Column(name = "last_update")
Date lastUpdate ;
public Country() {
}
public Integer getId() {
    return id;
}
public void setId(Integer id) {
    this.id = id;
}
public String getCountry() {
    return country;
}
public void setCountry(String country) {
    this.country = country;
}
public Date getLastUpdate() {
    return lastUpdate;
}
public void setLastUpdate(Date lastUpdate) {
    this.lastUpdate = lastUpdate;
}

}
