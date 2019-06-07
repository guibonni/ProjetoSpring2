package com.projetoSpring2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.projetoSpring2.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Integer> { }