package br.com.banco.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.modelo.Conta;
import br.com.banco.service.ContaService;

@RestController
@RequestMapping("/contas")
public class ContaController {

	@Autowired
	ContaService contaService;
	
	@GetMapping
	public List<Conta> findAll(){
		return contaService.findAll();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> getContaById(@PathVariable Long id){
		Optional<Conta> contaOptional = contaService.findById(id);
		return ResponseEntity.status(HttpStatus.OK).body(contaOptional.get());
	}
	
}
