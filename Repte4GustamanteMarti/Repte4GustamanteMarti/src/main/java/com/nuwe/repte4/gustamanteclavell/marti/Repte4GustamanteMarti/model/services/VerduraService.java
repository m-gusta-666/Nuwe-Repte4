package com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.exceptions.MissingEntityException;
import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.domain.Verdura;
import com.nuwe.repte4.gustamanteclavell.marti.Repte4GustamanteMarti.model.repositories.VerduraRepository;

@Service
public class VerduraService {

	
	@Autowired
	VerduraRepository verduraRepository;
	
	
	public Verdura getOne(int id) {
		return verduraRepository.findById(id).orElseThrow(()->new MissingEntityException("No s'ha trobat cap verdura amb aquest id"));
	}
	
	
	public List<Verdura> getAll() {
		return verduraRepository.findAll();
	}
	
	
	public Verdura addOne(Verdura verdura) {
		return verduraRepository.save(verdura);
	}
	
	
	public Verdura updateOne(Verdura verdura, int id) {
		Verdura f = getOne(id);
		
		f.setNom(verdura.getNom());
		f.setQuantitatQuilos(verdura.getQuantitatQuilos());
		
		return verduraRepository.save(f);
	}
	
	
	public void deleteOne(int id) {
		verduraRepository.deleteById(id);
	}
}
