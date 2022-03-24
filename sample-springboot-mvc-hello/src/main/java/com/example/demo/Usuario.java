package com.example.demo;

import javax.persistence.*;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	public String nombre;
	public String apellido;
	public int DNI;
	
	public Usuario() {}
	
	public Usuario(String name,String surname,int DNI) {
		super();
		this.nombre = name; 
		this.apellido = surname;
		this.DNI = DNI;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getApellido() {
		return this.apellido;
	}
	public int getDNI() {
		return this.DNI;
	}

}

