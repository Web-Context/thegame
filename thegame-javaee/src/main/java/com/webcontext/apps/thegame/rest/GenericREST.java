/**
 * 
 */
package com.webcontext.apps.thegame.rest;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.webcontext.apps.thegame.data.repository.IRepository;

/**
 * Generic REST service to provide basic RES CRUD operation to any entity.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 *
 */
public class GenericREST<T, PK> {

	@Inject
	private Logger log;

	@Inject
	protected Validator validator;

	protected IRepository<T, PK> repository;

	public GenericREST(IRepository<T, PK> repo) {
		this.repository = repo;
	}

	@GET
	@Path("/{offset}-{size}")
	@Produces(MediaType.APPLICATION_JSON)
	public List<T> listAllMembers(@PathParam("offset") int offset,
			@PathParam("size") int pageSize) {
		return repository.findAll(offset, pageSize);
	}

	@GET
	@Path("/{id:[0-9][0-9]*}")
	@Produces(MediaType.APPLICATION_JSON)
	public T lookupMemberById(@PathParam("id") Long id)
			throws ClassNotFoundException {
		T game;
		game = repository.retrieve(id);
		if (game == null) {
			throw new WebApplicationException(Response.Status.NOT_FOUND);
		}
		return game;
	}

	/**
	 * Create a new entity <T> on JSON POST request.
	 * 
	 * @param entity
	 * @return
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(T entity) {

		Response.ResponseBuilder builder = null;

		try {
			// Validates member using bean validation
			validate(entity);

			repository.create(entity);

			// Create an "ok" response
			builder = Response.ok();
		} catch (ConstraintViolationException ce) {
			// Handle bean validation issues
			builder = createViolationResponse(ce.getConstraintViolations());
		} catch (ValidationException e) {
			// Handle the unique constrain violation
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("title", "Title taken");
			builder = Response.status(Response.Status.CONFLICT).entity(
					responseObj);
		} catch (Exception e) {
			// Handle generic exceptions
			Map<String, String> responseObj = new HashMap<>();
			responseObj.put("error", e.getMessage());
			builder = Response.status(Response.Status.BAD_REQUEST).entity(
					responseObj);
		}

		return builder.build();
	}

	private void validate(T entity) throws ConstraintViolationException,
			ValidationException {
		// Create a bean validator and check for issues.
		Set<ConstraintViolation<T>> violations = validator.validate(entity);

		if (!violations.isEmpty()) {
			throw new ConstraintViolationException(
					new HashSet<ConstraintViolation<?>>(violations));
		}

		specificValidation(entity);
	}

	private Response.ResponseBuilder createViolationResponse(
			Set<ConstraintViolation<?>> violations) {
		log.fine("Validation completed. violations found: " + violations.size());

		Map<String, String> responseObj = new HashMap<>();

		for (ConstraintViolation<?> violation : violations) {
			responseObj.put(violation.getPropertyPath().toString(),
					violation.getMessage());
		}

		return Response.status(Response.Status.BAD_REQUEST).entity(responseObj);
	}

	/**
	 */
	public void specificValidation(T entity) throws ValidationException {

	}
}
