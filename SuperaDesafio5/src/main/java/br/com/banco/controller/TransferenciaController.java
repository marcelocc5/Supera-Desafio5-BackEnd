package br.com.banco.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.modelo.Transferencia;
import br.com.banco.repository.TransferenciaRepository;
import br.com.banco.service.TransferenciaService;

@RestController
@RequestMapping("/transferencias")
public class TransferenciaController {

	@Autowired
	TransferenciaService transferenciaService;
	
	@Autowired
	TransferenciaRepository transferenciaRepository;
	
	@GetMapping
	public ResponseEntity<List<Transferencia>> getAllTransferencia() {
		return ResponseEntity.status(HttpStatus.OK).body(transferenciaService.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getTransferenciaById(@PathVariable Long id) {

		Optional<Transferencia> transferenciaOptional = transferenciaService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(transferenciaOptional.get());
	}

	@GetMapping(value = "/findByPeriod")
	public ResponseEntity<List<Transferencia>> findByPeriod(LocalDate inicio, LocalDate termino) {
	    List<Transferencia> collection = transferenciaRepository.findByPeriod(inicio, termino);
	    return ResponseEntity.ok().body(collection);
	}
	

	@GetMapping("/nome")
	public ResponseEntity<Object> getTransferenciaByNomeOperador(String nome) {

		Optional<Transferencia> transferenciaOptional = transferenciaService.findByNomeOperadorTransacao(nome);

		return ResponseEntity.status(HttpStatus.OK).body(transferenciaOptional.get());

	}
}
