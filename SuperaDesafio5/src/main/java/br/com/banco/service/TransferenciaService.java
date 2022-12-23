package br.com.banco.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.modelo.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service
public class TransferenciaService {

	@Autowired
	private TransferenciaRepository transferenciaRepository;

	public List<Transferencia> findAll() {
		return transferenciaRepository.findAll();
	}

	public Optional<Transferencia> findById(Long id) {
		return transferenciaRepository.findById(id);
	}

	public Optional<Transferencia> findByNomeOperadorTransacao(String nome) {
		return transferenciaRepository.findByNomeOperadorTransacao(nome);
	}
	
	public List<Transferencia> findByPeriod (LocalDate inicio, LocalDate termino){
		return transferenciaRepository.findByPeriod(inicio, termino);
	} 
}
