package br.com.banco.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.modelo.Conta;
import br.com.banco.repository.ContaRepository;

@Service
public class ContaService {

	@Autowired
	private ContaRepository contaRepository;
	
	public List<Conta> findAll(){
		return contaRepository.findAll();
	}

	public Optional<Conta> findById(Long id) {
		return contaRepository.findById(id);
	}
	
}
