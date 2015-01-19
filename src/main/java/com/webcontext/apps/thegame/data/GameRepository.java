/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.webcontext.apps.thegame.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.webcontext.apps.thegame.data.repository.GenericRepository;
import com.webcontext.apps.thegame.model.Game;

@ApplicationScoped
public class GameRepository extends GenericRepository<Game, Long> {

	/**
	 * Retrieve games on a title search.
	 * 
	 * @param title
	 *            the title to search for.
	 * @return The first Game found.
	 */
	public Game findByTitle(String title) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Game> criteria = cb.createQuery(Game.class);
		Root<Game> game = criteria.from(Game.class);
		criteria.select(game).where(cb.equal(game.get("title"), title));
		return em.createQuery(criteria).getSingleResult();
	}

	/**
	 * Retrieve all games with a sort order on title.
	 * 
	 * @return List of Game entities with an ascending sort on their title.
	 */
	public List<Game> findAllOrderedByTitle() {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Game> criteria = cb.createQuery(Game.class);
		Root<Game> game = criteria.from(Game.class);
		criteria.select(game).orderBy(cb.asc(game.get("title")));
		return em.createQuery(criteria).getResultList();
	}

}
