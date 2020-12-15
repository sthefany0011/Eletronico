package com.eletrodomestico.Eletronico.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eletrodomestico.Eletronico.model.TipoEletro;
import com.eletrodomestico.Eletronico.repository.TipoEletroRepository;



@RestController
@RequestMapping("/TipoEletro")
@CrossOrigin("*")
public class TipoEletroController {
	@Autowired
	private TipoEletroRepository repositoty;
	
	@GetMapping
	public ResponseEntity<List<TipoEletro>>GetAll(){
		return ResponseEntity.ok(repositoty.findAll());
	}
	
	
	@GetMapping("/{id")
	public ResponseEntity<TipoEletro>GetById(@PathVariable long id){
		return repositoty.findById(id)
				.map(resp->ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	@GetMapping("/descricao/{descricao}")
	public ResponseEntity<List<TipoEletro>>GetByDescricao(@PathVariable String descricao){
		return ResponseEntity.ok(repositoty.findAllBydescricaoContaningIgnoreCase(descricao));
		
	}
	@PostMapping
	public ResponseEntity <TipoEletro>post (@RequestBody TipoEletro tipoeletro){
		return ResponseEntity.status(HttpStatus.CREATED).body(repositoty.save(tipoeletro));
	}
	
	@PutMapping
	public ResponseEntity <TipoEletro>put (@RequestBody TipoEletro tipoeletro){
		return ResponseEntity.status(HttpStatus.OK).body(repositoty.save(tipoeletro));
	}
	
	@DeleteMapping("/{id}")
	
	public void delete(@PathVariable long id) {
		repositoty.deleteById(id);
	}
}
