package br.com.rruffer.cadastro.beneficio.dto;

import java.io.Serializable;

public class ClienteDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String email;
	private Long totalSaldoAposentadoria;
	private Integer qtdAnosAposentadoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getTotalSaldoAposentadoria() {
		return totalSaldoAposentadoria;
	}

	public void setTotalSaldoAposentadoria(Long totalSaldoAposentadoria) {
		this.totalSaldoAposentadoria = totalSaldoAposentadoria;
	}

	public Integer getQtdAnosAposentadoria() {
		return qtdAnosAposentadoria;
	}

	public void setQtdAnosAposentadoria(Integer qtdAnosAposentadoria) {
		this.qtdAnosAposentadoria = qtdAnosAposentadoria;
	}


}
