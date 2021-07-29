package br.com.Cliente.Service;

import java.util.List;

import br.com.Cliente.Model.ClienteModel;



public interface ClienteService {
	
	List<ClienteModel> listAll();

	List<ClienteModel> findByNomeContainingIgnoreCase(String nome);
	
	ClienteModel saveOrUpdate(ClienteModel cm);

	boolean alterar(ClienteModel dto);

	ClienteModel getId(Long id);	

	void delete(Long id);

}
