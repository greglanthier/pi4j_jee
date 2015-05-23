package org.pi4j.jee.ra;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioProvider;
import com.pi4j.io.gpio.Pin;
import com.pi4j.io.gpio.PinMode;
import com.pi4j.io.gpio.PinPullResistance;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.event.PinListener;

@RunWith( MockitoJUnitRunner.class )
public class Pi4JResourceAdapterTest {

	@Mock BootstrapContext m_bootstrapContext;

	@Mock MessageEndpointFactory m_endpointFactory;

	@Mock ActivationSpec m_activationSpec;
	
	@Mock static GpioProvider m_mockGpioProvider;

	static Pi4JResourceAdapter adapter = new Pi4JResourceAdapter();

	@BeforeClass
	public static void beforeClass() {
		GpioFactory.setDefaultProvider( new GpioProvider() {
			
			@Override
			public void unexport(Pin pin) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void shutdown() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setValue(Pin pin, double value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setState(Pin pin, PinState state) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPwm(Pin pin, int value) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setPullResistance(Pin pin, PinPullResistance resistance) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void setMode(Pin pin, PinMode mode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeListener(Pin pin, PinListener listener) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void removeAllListeners() {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public boolean isShutdown() {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean isExported(Pin pin) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public boolean hasPin(Pin pin) {
				// TODO Auto-generated method stub
				return false;
			}
			
			@Override
			public double getValue(Pin pin) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public PinState getState(Pin pin) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public int getPwm(Pin pin) {
				// TODO Auto-generated method stub
				return 0;
			}
			
			@Override
			public PinPullResistance getPullResistance(Pin pin) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public String getName() {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public PinMode getMode(Pin pin) {
				// TODO Auto-generated method stub
				return null;
			}
			
			@Override
			public void export(Pin pin, PinMode mode, PinState defaultState) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void export(Pin pin, PinMode mode) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void addListener(Pin pin, PinListener listener) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
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
