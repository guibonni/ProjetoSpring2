package com.projetoSpring2.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.projetoSpring2.model.Game;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.projetoSpring2.repository.GameRepository;


@RestController
public class GameController {
	
	@Autowired
	GameRepository repository;
	
	//http://localhost:8080/game/save
	/*
	 * INSERIR
	   {
	    "gameType": "RPG",
	    "playerNumber": 4,
	    "gameDate": "01/01/2019"
	   }
	 * 
	 * ALTERAR
	   {
	    "id" : 1
	    "gameType": "RPG",
	    "playerNumber": 4,
	    "gameDate": "01/01/2019"
	   }
	 * */

	@PostMapping("game/save")
	public Game save(@RequestBody Game game){
		return repository.save(game);
	}
	
	//http://localhost:8080/game/all
	@GetMapping("game/all")
	public List<Game> all(){
		return (List<Game>) repository.findAll();
	}
	
	//http://localhost:8080/game/delete/2
	@DeleteMapping("game/delete/{id}")
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