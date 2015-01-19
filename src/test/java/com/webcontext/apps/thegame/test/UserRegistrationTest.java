package com.webcontext.apps.thegame.test;

import static org.junit.Assert.assertNotNull;

import java.util.logging.Logger;

import javax.inject.Inject;
import javax.validation.ConstraintViolationException;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.webcontext.apps.thegame.model.User;
import com.webcontext.apps.thegame.service.UserRegistration;
import com.webcontext.apps.thegame.util.Resources;

@RunWith(Arquillian.class)
public class UserRegistrationTest {
	@Deployment
	public static Archive<?> createTestArchive() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addClasses(User.class, UserRegistration.class, Resources.class)
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml");
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
