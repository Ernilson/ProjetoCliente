package br.com.Cliente.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Cliente.Model.ClienteModel;

public interface ClienteRepository extends JpaRepository<ClienteModel, Long> {
	
	List<ClienteModel> findByNomeContainingIgnoreCase(String nome);
}
