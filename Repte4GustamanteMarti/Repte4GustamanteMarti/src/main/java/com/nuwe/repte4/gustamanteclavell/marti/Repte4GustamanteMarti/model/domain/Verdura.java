package com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.domain;

import javax.persistence.*;



@Entity
@Table(name="verdures")
public class Verdura {

	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="quantitatQuilos")
	private int quantitatQuilos;

	
	public Verdura() {
		
	}
	
	public Verdura(String nom, int quantitatQuilos) {
		this.nom = nom;
		this.quantitatQuilos = quantitatQuilos;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public int getQuantitatQuilos() {
		return quantitatQuilos;
	}

	public void setQuantitatQuilos(int quantitatQuilos) {
		this.quantitatQuilos = quantitatQuilos;
	}

	@Override
	public String toString() {
		return "Verdura [id=" + id + ", nom=" + nom + ", quantitatQuilos=" + quantitatQuilos + "]";
	}
}
