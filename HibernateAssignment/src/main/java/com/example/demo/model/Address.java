
package com.example.demo.model;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name="ADDRESS")
public class Address implements Serializable{
	
	private static final long serialVersionUID = 1L;

	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID",nullable=false)
	   private int id;
	   
	   @NotBlank
	   @Column(name="STREET",nullable = false)
	   private String street;
	   
	   @NotBlank
	   @Column(name="CITY",nullable = false)
	   private String city; 
	   
	   @NotBlank
	   @Column(name="STATE",nullable = false)
	   private String state; 
	   
	   @NotBlank
	   @Column(name="ZIP_CODE",nullable = false)
	   private String zipcode; 
	   
	   @OneToOne(fetch=FetchType.LAZY,optional=false)
	   @JoinColumn(name="address_id",referencedColumnName="id")
	   private Employee employee;

	   public Address() {}
	   
	   public Address(String street, String city, String state, String zipcode) {
	      this.street = street; 
	      this.city = city; 
	      this.state = state; 
	      this.zipcode = zipcode; 
	   }
	   
	   public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	   public String getStreet() {
	      return street;
	   }
	   
	   public void setStreet( String street ) {
	      this.street = street;
	   }
	   
	   public String getCity() {
	      return city;
	   }
	   
	   public void setCity( String city ) {
	      this.city = city;
	   }
	   
	   public String getState() {
	      return state;
	   }
	   
	   public void setState( String state ) {
	      this.state = state;
	   }
	   
	   public String getZipcode() {
	      return zipcode;
	   }
	   
	   public void setZipcode( String zipcode ) {
	      this.zipcode = zipcode;
	   }   
}
