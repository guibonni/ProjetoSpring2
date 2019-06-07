package com.projetoSpring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projetoSpring2.model.Music;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpring2.repository.MusicRepository;


@RestController
public class MusicController {
	
	@Autowired
	MusicRepository repository;
	
	//http://localhost:8080/music/save	
	/*
	 * INSERIR
	   {
	    "name": "Leif Erikson",
	    "genre": "Modern Rock",
	    "releaseYear": 2001,
	    "singer": "Interpol",
	    "rating": 5
	   }
	 * 
	 * ALTERAR
	   {
	    "id" : 1
	    "name": "Leif Erikson",
	    "genre": "Modern Rock",
	    "releaseYear": 2001,
	    "singer": "Interpol",
	    "rating": 5
	   }
	 * */

	@PostMapping("music/save")
	public Music save(@RequestBody Music music){
		return repository.save(music);
	}
	
	//http://localhost:8080/music/all
	@GetMapping("music/all")
	public List<Music> all(){
		return (List<Music>) repository.findAll();
	}
	
	//http://localhost:8080/music/delete/2
	@DeleteMapping("music/delete/{id}")
	public boolean delete(@PathVariable("id") int id) {
		try {
			repository.deleteById(id);
			
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}