package br.com.Cliente.Model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.br.CPF;

import com.fasterxml.jackson.annotation.JsonFormat;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@SuppressWarnings("deprecation")
@Entity
@Table(name = "cliente")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ClienteModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable = false, length= 150)	
	@NotEmpty(message= "{campo.nome.obrigatorio}")
	private String nome;
	
	@Column(nullable = false, length= 150)
	@NotNull	
	private String telefone;
	
	@Column(nullable = true, length= 11)
	@NotNull(message = "{O campo CPF é obrigatório.}")
	@CPF(message = "{o campo.cpf.invalido}")
	private String cpf;
	
	@Column(name = "data_cadastro", updatable = false)
	@JsonFormat(pattern ="dd/MM/yyyy")
	private LocalDate dataCadastro;
		
	@PrePersist
	public void prePersist() {
		setDataCadastro(LocalDate.now());
	}
	
}
