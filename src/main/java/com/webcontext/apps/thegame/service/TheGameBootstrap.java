package com.webcontext.apps.thegame.service;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Singleton;

import org.apache.log4j.Logger;

import com.webcontext.apps.thegame.data.GameRepository;
import com.webcontext.apps.thegame.model.Game;
import com.webcontext.apps.thegame.rest.JaxRsActivator;

@Singleton
public class TheGameBootstrap {
	private static final Logger logger = Logger.getLogger(JaxRsActivator.class);

	@Inject
	GameRepository games;

	@PostConstruct
	public void intialize() {

		if (games.count() == 0) {
			List<Game> list;
			try {
				list = games.loadObjectFromJSONFile("/data/games.json");
				for (Game game : list) {
					games.create((Game) game);
				}
			} catch (Exception e) {
				logger.error("Unable to read data from games.json file.");
			}

		}
	}
}
