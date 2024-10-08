package com.telefonica.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pruebaestudiante")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Eid;
	
	private String Nombre;
	
	private String Especialidad;
	
	private String Grado;

	public Long getEid() {
		return Eid;
	}

	public void setEid(Long eid) {
		Eid = eid;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public String getEspecialidad() {
		return Especialidad;
	}

	public void setEspecialidad(String especialidad) {
		Especialidad = especialidad;
	}

	public String getGrado() {
		return Grado;
	}

	public void setGrado(String grado) {
		Grado = grado;
	}
	
	
	

}
