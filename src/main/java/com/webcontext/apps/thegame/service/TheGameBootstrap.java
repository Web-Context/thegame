package com.webcontext.apps.thegame.service;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.webcontext.apps.thegame.data.GameRepository;
import com.webcontext.apps.thegame.rest.JaxRsActivator;

@Startup
@Singleton
public class TheGameBootstrap {
	private static final Logger logger = Logger.getLogger(JaxRsActivator.class);

	@Inject
	GameRepository games;

	private static Properties settings;

	@PostConstruct
	public void initialize() {

		if (games.count() == 0) {
			try {
				//games.loadObjectFromJSONFile("dataset/games.json", true);

			} catch (Exception e) {
				logger.error("Unable to read data from games.json file.", e);
			}

		}
	}
}
