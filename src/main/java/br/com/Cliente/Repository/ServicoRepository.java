package br.com.Cliente.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.Cliente.Controller.ServicoModel;

public interface ServicoRepository extends JpaRepository<ServicoModel, Integer>{

}
