package com.generation.zerowaste.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Tema {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotNull(message = "O atributo Descricão é obrigatório e não pode conter espaços em brancos!")
	@Size(min = 5, max = 100, message = "O atributo deve conter no minimo 5 e no máximo 100 caractéres")
	private String titulo_tema;

	@NotBlank(message = "O atributo não pode conter espaços em brancos")
	@Size(min = 10, max = 500, message = "O atributo deve conter no minimo 10 e no máximo 500 caractéres")
	private String descricao;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitulo_tema() {
		return titulo_tema;
	}

	public void setTitulo_tema(String titulo_tema) {
		this.titulo_tema = titulo_tema;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
