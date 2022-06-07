package com.generation.zerowaste.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table(name = "tb_postagens")
public class Postagem {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotNull( message =  "O Atributo é obrigatório")
	@Size(min =10, max = 255 , message = "O atributo aceita minímo 10 e no máximo 255 caractéres")
	private String titulo;
	
	
	@NotNull( message =  "O Atributo é obrigatório")
	@Size(min =10, max = 1000 , message = "O atributo aceita minímo 10 e no máximo 1000 caractéres")
	private String texto;
	
	@JsonFormat(pattern="dd-MM-yyyy")
	private LocalDate data;
	
	@Size(min =10, max = 255 , message = "O atributo aceita minímo 10 e no máximo 255 caractéres")
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
    private Usuario usuario;
	
	@ManyToOne
	@JsonIgnoreProperties("postagem")
	private Tema tema;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}
	
	
	
	
}
