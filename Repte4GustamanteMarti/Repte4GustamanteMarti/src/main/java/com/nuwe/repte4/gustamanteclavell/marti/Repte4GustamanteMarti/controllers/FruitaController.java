package com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.domain.Fruita;
import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.services.FruitaService;

@Controller
public class FruitaController {

	
	@Autowired
	FruitaService fruitaService;
	
	
	
	@GetMapping("/fruites")
	public ResponseEntity<List<Fruita>> getAll() {
		return new ResponseEntity<>(fruitaService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/fruites/{id}")
	public ResponseEntity<Fruita> getOne(@PathVariable("id") int id) {
		return new ResponseEntity<>(fruitaService.getOne(id),HttpStatus.OK);
	}
	
	
	@PostMapping("/fruites")
	public ResponseEntity<Fruita> addOne(@RequestBody @Valid Fruita fruita) {
		return new ResponseEntity<>(fruitaService.addOne(fruita),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/fruites/{id}")
	public ResponseEntity<Fruita> updateOne(@RequestBody @Valid Fruita fruita, @PathVariable("id") int id) {
		return new ResponseEntity<>(fruitaService.updateOne(fruita,id),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/fruites/{id}")
	public ResponseEntity<HttpStatus> deleteOne(@PathVariable("id") int id) {
		fruitaService.deleteOne(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}
