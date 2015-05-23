package org.pi4j.jee.ra;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith( MockitoJUnitRunner.class )
public class Pi4JResourceAdapterTest {

	@Mock BootstrapContext m_bootstrapContext;

	@Mock MessageEndpointFactory m_endpointFactory;

	@Mock ActivationSpec m_activationSpec;

	Pi4JResourceAdapter adapter = new Pi4JResourceAdapter();

	@Test
	public void testStart() throws ResourceAdapterInternalException {
		adapter.start( m_bootstrapContext );
	}

	@Test
	public void testStop() {
		adapter.stop();
	}

	@Test
	public void testEndpointActivation() throws ResourceException {
		adapter.endpointActivation( m_endpointFactory, m_activationSpec );
	}

	@Test
	public void testEndpointDeactivation() {
		adapter.endpointDeactivation(m_endpointFactory, m_activationSpec);
	}

	@Test
	public void testGetXAResources() throws ResourceException {
		ActivationSpec[] specs = new ActivationSpec[] { m_activationSpec };
		assertThat( adapter.getXAResources( specs ), is( nullValue() ) );
	}
}
