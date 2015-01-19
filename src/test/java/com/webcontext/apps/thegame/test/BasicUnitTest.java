/**
 * 
 */
package com.webcontext.apps.thegame.test;

import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;

/**
 * Build and deploy an archive to unit testing classes.
 * 
 * @author Frédéric Delorme<frederic.delorme@web-context.com>
 *
 */
public class BasicUnitTest {

	/**
	 * package and Deploy a Web Archive (War) ready to test.
	 * 
	 * @return
	 */
	public WebArchive deployWar() {
		return ShrinkWrap
				.create(WebArchive.class, "test.war")
				.addPackages(true, "com.webcontext.apps.thegame")
				.addAsResource("META-INF/test-persistence.xml",
						"META-INF/persistence.xml")
				.addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml")
				// Deploy our test datasource
				.addAsWebInfResource("test-ds.xml");
	}
}
