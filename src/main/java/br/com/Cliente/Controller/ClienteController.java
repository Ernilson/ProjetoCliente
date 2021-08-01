package br.com.Cliente.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.Cliente.Model.ClienteModel;
import br.com.Cliente.Repository.ClienteRepository;
import br.com.Cliente.Service.ClienteService;


@RestController
@RequestMapping("/api/clientes")
@CrossOrigin("http://localhost:4200")
public class ClienteController {

	@Autowired
	private ClienteRepository cr;

	@Autowired
	private ClienteService cs;

	
	@GetMapping
	public List<ClienteModel> getAllCLientes() {
		
		return cs.listAll();
	}
		
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ClienteModel salvarCliente(@RequestBody @Valid ClienteModel cm) {
		return cs.saveOrUpdate(cm);

	}

	@GetMapping("{id}")
	public ClienteModel buscaId(@PathVariable Long id) {

		return cr.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void update(@PathVariable Long id, @RequestBody @Valid ClienteModel clientes) {
		cr.findById(id).map(cliente -> {
			cliente.setNome(clientes.getNome());
			cliente.setTelefone(clientes.getTelefone());
			cliente.setCpf(clientes.getCpf());
			return cr.save(clientes);
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));
	}

	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id) {
		// cr.existsById(id);
		cr.findById(id).map(cliente -> {
			cr.delete(cliente);
			return Void.TYPE;
		}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado!"));

	}

}
