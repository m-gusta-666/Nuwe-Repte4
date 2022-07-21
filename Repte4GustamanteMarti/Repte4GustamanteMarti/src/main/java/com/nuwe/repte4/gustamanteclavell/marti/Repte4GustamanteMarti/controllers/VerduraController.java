package com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.domain.Verdura;
import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.services.VerduraService;

@Controller
public class VerduraController {

	
	@Autowired
	VerduraService verduraService;
	
	
	
	@GetMapping("/verdures")
	public ResponseEntity<List<Verdura>> getAll() {
		return new ResponseEntity<>(verduraService.getAll(),HttpStatus.OK);
	}
	
	@GetMapping("/verdures/{id}")
	public ResponseEntity<Verdura> getOne(@PathVariable("id") int id) {
		return new ResponseEntity<>(verduraService.getOne(id),HttpStatus.OK);
	}
	
	
	@PostMapping("/verdures")
	public ResponseEntity<Verdura> addOne(@RequestBody @Valid Verdura verdura) {
		return new ResponseEntity<>(verduraService.addOne(verdura),HttpStatus.CREATED);
	}
	
	
	@PutMapping("/verdures/{id}")
	public ResponseEntity<Verdura> updateOne(@RequestBody @Valid Verdura verdura, @PathVariable("id") int id) {
		return new ResponseEntity<>(verduraService.updateOne(verdura,id),HttpStatus.CREATED);
	}
	
	
	@DeleteMapping("/verdures/{id}")
	public ResponseEntity<HttpStatus> deleteOne(@PathVariable("id") int id) {
		verduraService.deleteOne(id);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
}


