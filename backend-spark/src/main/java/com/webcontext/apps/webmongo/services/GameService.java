package com.webcontext.apps.webmongo.services;

import java.util.ArrayList;
import java.util.List;

import com.webcontext.apps.webmongo.model.Game;
import com.webcontext.apps.webmongo.repository.GameRepository;

/**
 * Main Service to serve Game data.
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 */
public class GameService{

	private List<Game> games = null;

	GameRepository	gameRepo = new GameRepository();


	public GameService(){
		games = new ArrayList<Game>();
	}


	/**
	 * @param 
 	 */
	public List<Game> findAll(long offset, long pageSize){
		return gameRepo.findAll(offset,pageSize);

	}

	public Game findById(String id){
		return gameRepo.findById(id);
	}

} 