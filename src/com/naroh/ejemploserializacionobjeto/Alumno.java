package com.naroh.ejemploserializacionobjeto;

import java.io.Serializable;
import java.util.ArrayList;

public class Alumno implements Serializable {

	private static final long serialVersionUID = 5680898935329497057L;
	private String nombre;
	private String apellido;
	private ArrayList<String> asignaturas;
	private double notamedia;
	private boolean pasadecurso;
	
	public Alumno() {
	}
	
	public Alumno(String nombre, String apellido, ArrayList<String> asignaturas, int notamedia, boolean pasadecurso) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.asignaturas = asignaturas;
		this.notamedia = notamedia;
		this.pasadecurso = pasadecurso;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public ArrayList<String> getAsignaturas() {
		return asignaturas;
	}

	public void setAsignaturas(ArrayList<String> asignaturas) {
		this.asignaturas = asignaturas;
	}

	public double getNotamedia() {
		return notamedia;
	}

	public void setNotamedia(double d) {
		this.notamedia = d;
	}

	public boolean isPasadecurso() {
		return pasadecurso;
	}

	public void setPasadecurso(boolean pasadecurso) {
		this.pasadecurso = pasadecurso;
	}

	@Override
	public String toString() {
		return "Alumno [nombre=" + nombre + ", apellido=" + apellido + ", asignaturas=" + asignaturas + ", notamedia=" + notamedia + ", pasadecurso=" + pasadecurso + "]";
	}
	
	
}
