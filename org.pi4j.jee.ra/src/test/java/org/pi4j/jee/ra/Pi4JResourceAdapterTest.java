package org.pi4j.jee.ra;

/*
 * #%L
 * org.pi4j.jee.ra
 * %%
 * Copyright (C) 2015 Greg Lanthier
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *      http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

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
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioProvider;

@RunWith( MockitoJUnitRunner.class )
public class Pi4JResourceAdapterTest {

    @Mock BootstrapContext m_bootstrapContext;

    @Mock MessageEndpointFactory m_endpointFactory;

    @Mock ActivationSpec m_activationSpec;

    @Mock static GpioProvider m_mockGpioProvider;

    static Pi4JResourceAdapter adapter = new Pi4JResourceAdapter( );

    @BeforeClass
    public static void beforeClass( ) {
        m_mockGpioProvider = Mockito.mock( GpioProvider.class );
        GpioFactory.setDefaultProvider( m_mockGpioProvider );
    }

    @Test
    public void testStart( ) throws ResourceAdapterInternalException {
        adapter.start( m_bootstrapContext );
    }

    @Test
    public void testStop( ) {
        adapter.stop( );
    }

    @Test
    public void testEndpointActivation( ) throws ResourceException {
        adapter.endpointActivation( m_endpointFactory, m_activationSpec );
    }

    @Test
    public void testEndpointDeactivation( ) {
        adapter.endpointDeactivation( m_endpointFactory, m_activationSpec );
    }

    @Test
    public void testGetXAResources( ) throws ResourceException {
        ActivationSpec[ ] specs = new ActivationSpec[] { m_activationSpec };
        assertThat( adapter.getXAResources( specs ), is( nullValue( ) ) );
    }
}
