package com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.exceptions.MissingEntityException;
import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.domain.Fruita;
import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.repositories.FruitaRepository;

@Service
public class FruitaService {

	
	@Autowired
	FruitaRepository fruitaRepository;
	
	
	public Fruita getOne(int id) {
		return fruitaRepository.findById(id).orElseThrow(()->new MissingEntityException("No s'ha trobat cap fruita amb aquest id"));
	}
	
	
	public List<Fruita> getAll() {
		return fruitaRepository.findAll();
	}
	
	
	public Fruita addOne(Fruita fruita) {
		return fruitaRepository.save(fruita);
	}
	
	
	public Fruita updateOne(Fruita fruita, int id) {
		Fruita f = getOne(id);
		
		f.setNom(fruita.getNom());
		f.setQuantitatQuilos(fruita.getQuantitatQuilos());
		
		return fruitaRepository.save(f);
	}
	
	
	public void deleteOne(int id) {
		fruitaRepository.deleteById(id);
	}
	
}
