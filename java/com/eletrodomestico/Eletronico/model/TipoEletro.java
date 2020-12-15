package com.eletrodomestico.Eletronico.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table (name ="TipoEletro")

public class TipoEletro {

    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
    
    @NotNull
    @Size(max = 100)
	private String descricao;
	
	
	private boolean ativo;


	public long getId() {
		return id;
	}


	public void setId(long id) {
		this.id = id;
	}


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public boolean isAtivo() {
		return ativo;
	}


	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	
}
