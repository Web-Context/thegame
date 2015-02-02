package com.webcontext.apps.thegame.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.webcontext.apps.thegame.data.GameRepository;
import com.webcontext.apps.thegame.model.Game;

/**
 * TestUnit Class to test the GameRepository imlpementation.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 *
 */
@RunWith(Arquillian.class)
@UsingDataSet("dataset/games.json")
public class GameRepositoryTest extends BasicUnitTest {
	@Deployment
	public static Archive<?> createAndDeploy() {
		return createAndDeploy();
	}

	@Inject
	GameRepository gameRepository;

	/**
	 * Test method for
	 * {@link com.webcontext.apps.thegame.data.GameRepository#retrieve(java.lang.Long)}
	 * .
	 */
	@Test
	public void testFindById() {
		Game game = null;
		try {
			game = gameRepository.retrieve(1L);
		} catch (ClassNotFoundException e) {
			fail("Unable to retrieve entity Game");
		}
		assertNotNull("Game id=0 was not found !", game);
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.thegame.data.GameRepository#findByTitle(java.lang.String)}
	 * .
	 */
	@Test
	public void testFindByTitle() {
		Game game = gameRepository.findByTitle("Watch Dogs");
		assertNotNull("Game title='Watch Dogs' was not found !", game);
	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.thegame.data.GameRepository#findAllOrderedByTitle()}
	 * .
	 */
	@Test
	public void testFindAllOrderedByTitle() {
		List<Game> games = gameRepository.findAllOrderedByTitle();
		assertNotNull(games);
		assertEquals(games.size(), 2);
		assertEquals(games.get(1).getTitle(), "Watch Dogs");

	}

	/**
	 * Test method for
	 * {@link com.webcontext.apps.thegame.data.GameRepository#create(com.webcontext.apps.thegame.model.Game)}
	 * .
	 */
	@Test
	public void testSave() {
		Game game = new Game();
		game.setTitle("title:test1");
		game.setHeader("header:test1");
		game.setContent("content:test1");
		game.setHeader("header:test1");

	}

}
