package com.webcontext.apps.thegame.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.webcontext.apps.thegame.model.User;
import com.webcontext.apps.thegame.service.UserRegistration;

/**
 * Unit test class to unit test the UserRegistration service.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 *
 */
@RunWith(Arquillian.class)
public class UserRegistrationTest extends BasicUnitTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return createTestArchive();
	}

	@Inject
	UserRegistration userRegistration;

	@Inject
	Logger log;

	@Test(expected = ConstraintViolationException.class)
	public void testRegisterError() throws Exception {
		User newMember = new User();
		newMember.setName("Jane Doe");
		newMember.setEmail("jane@mailinator.com");
		newMember.setPhoneNumber("2125551234");
		userRegistration.register(newMember);
		assertNotNull(newMember.getId());
		log.info(newMember.getName() + " was persisted with id "
				+ newMember.getId());
	}

	@Test
	public void testRegister() throws Exception {
		User newMember = new User();
		newMember.setName("Jane Doe");
		newMember.setEmail("jane@mailinator.com");
		newMember.setPhoneNumber("2125551234");
		newMember.setPassword("testesttests");
		userRegistration.register(newMember);
		assertNotNull(newMember.getId());
		log.info(newMember.getName() + " was persisted with id "
				+ newMember.getId());
	}
}
