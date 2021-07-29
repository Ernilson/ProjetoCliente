package br.com.Cliente.ServiceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.Cliente.Model.ClienteModel;
import br.com.Cliente.Service.ClienteService;
import br.com.Cliente.Repository.ClienteRepository;


@Service
public class ClienteServiceImpl implements ClienteService {
	
	@Autowired
	private ClienteRepository cr;

	@Override
	public List<ClienteModel> listAll() {
		List<ClienteModel> cm = new ArrayList<>();
		cr.findAll().forEach(cm::add); // fun with Java 8
		return cm;
	}

	@Override
	public List<ClienteModel> findByNomeContainingIgnoreCase(String nome) {
		return cr.findByNomeContainingIgnoreCase(nome);
	}

	@Override
	public ClienteModel saveOrUpdate(ClienteModel cm) {
		cr.save(cm);
		return cm;
	}

	@Override
	public boolean alterar(ClienteModel dto) {
		try {
			 cr.save(dto);
	            return true;
	        } catch (Exception e) {
	            return false;
	        }
	}

	@Override
	public ClienteModel getId(Long id) {
		return cr.findById(id).get();
	}

	@Override
	public void delete(Long id) {
		cr.deleteById(id);
	}

	
	
}
