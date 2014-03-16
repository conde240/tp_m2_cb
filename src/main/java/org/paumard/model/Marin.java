package org.paumard.model;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


@NamedQueries({
		@NamedQuery(name="getAllMarin",
		
				query="select marin from Marin marin"),
		
		@NamedQuery(name="updateMarin",
		
		query="update Marin marin set marin.nom= :nom, marin.prenom= :prenom, marin.age= :age where marin.id= :id")
		

})

@SuppressWarnings("serial")
@Entity(name="Marin")
@Table(name="Marin")
@Access(AccessType.FIELD)
@XmlRootElement(name="marin", namespace="www.simo.org")
@XmlType(propOrder={"nom","prenom","age","email","address"})
public class Marin implements Serializable {

	@XmlAttribute(name="id")
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id ;
	
	@Column(name="last_name", length=40)
	private String nom ;
	
	@Column(name="first_name", length=40)
	private String prenom ;
	
	@Column(name="age")
	private int age ;
	
	@Column(name="email", length=40)
	private String email ;
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
public Long getId()
{
  return this.id;	
}
	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	
	@Override
	public String toString() {
		return "Marin [id=" + id + ", nom=" + nom + ", prenom=" + prenom
				+ ", age=" + age + "]";
	}
}
