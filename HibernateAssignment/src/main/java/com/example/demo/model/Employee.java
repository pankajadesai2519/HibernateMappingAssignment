package com.example.demo.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;



@Entity
@Table(name="EMPLOYEE")
public class Employee implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="ID",nullable=false)
	   private int id;
	   
	   @NotBlank
	   @Column(name="FIRST_NAME",nullable = false)
	   private String firstName; 
	   
	   @NotBlank
	   @Column(name="LAST_NAME",nullable = false)
	   private String lastName;
	   
	   @NotNull
	   @Column(name="SALARY",nullable = false)
	   private int salary;
	   
	   @OneToOne(mappedBy = "employee",fetch=FetchType.LAZY,cascade=CascadeType.ALL,orphanRemoval=true)   
	   private Address address;
	   
	   @OneToMany(cascade =CascadeType.ALL,orphanRemoval = true)
	   @JoinColumn(name="EMPLOYEE_ID")
	   private Set<Account> account;

	   public Employee() {}
	   
	   public Employee(String fname, String lname, int salary, Address address ) {
	      this.firstName = fname;
	      this.lastName = lname;
	      this.salary = salary;
	      this.address = address;
	   }
	   
	   public int getId() {
	      return id;
	   }
	   
	   public void setId( int id ) {
	      this.id = id;
	   }
	   
	   public String getFirstName() {
	      return firstName;
	   }
	   
	   public void setFirstName( String first_name ) {
	      this.firstName = first_name;
	   }
	   
	   public String getLastName() {
	      return lastName;
	   }
	   
	   public void setLastName( String last_name ) {
	      this.lastName = last_name;
	   }
	   
	   public int getSalary() {
	      return salary;
	   }
	   
	   public void setSalary( int salary ) {
	      this.salary = salary;
	   }

	   public Address getAddress() {
	      return address;
	   }
	   
	   public void setAddress( Address address ) {
	      this.address = address;
	   }

	public Set<Account> getAccount() {
		return account;
	}

	public void setAccount(Set<Account> account) {
		this.account = account;
	}	   
	   
}
