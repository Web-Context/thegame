package com.webcontext.apps.thegame.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.arquillian.persistence.UsingDataSet;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.webcontext.apps.thegame.data.GameRepository;
import com.webcontext.apps.thegame.model.Game;
import com.webcontext.apps.thegame.util.Resources;

/**
 * @author frede_000
 *
 */
@RunWith(Arquillian.class)
@UsingDataSet("dataset/games.json")
public class GameRepositoryTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(Game.class, GameRepository.class, Resources.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml");
	}

	@Inject
	GameRepository gameRepository;

	/**
	 * Test method for
	 * {@link com.webcontext.apps.thegame.data.GameRepository#findById(java.lang.Long)}
	 * .
	 */
	@Test
	public void testFindById() {
		Game game = gameRepository.findById(0L);
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
	 * {@link com.webcontext.apps.thegame.data.GameRepository#save(com.webcontext.apps.thegame.model.Game)}
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
