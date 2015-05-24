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

import javax.resource.ResourceException;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;

@Connector
public class Pi4JResourceAdapter implements ResourceAdapter {

  GpioController m_gpio = null;

  @Override
  public void start( BootstrapContext ctx ) throws ResourceAdapterInternalException {
    m_gpio = GpioFactory.getInstance( );
  }

  @Override
  public void stop( ) {
    m_gpio.shutdown( );
  }

  @Override
  public void endpointActivation( MessageEndpointFactory endpointFactory, ActivationSpec spec )
      throws ResourceException {
  }

  @Override
  public void endpointDeactivation( MessageEndpointFactory endpointFactory, ActivationSpec spec ) {
  }

  @Override
  public XAResource[ ] getXAResources( ActivationSpec[ ] specs ) throws ResourceException {
    return new XAResource[0];
  }

}
