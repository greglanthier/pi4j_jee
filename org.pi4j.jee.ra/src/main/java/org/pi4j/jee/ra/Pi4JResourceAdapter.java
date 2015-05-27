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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Connector
public final class Pi4JResourceAdapter implements ResourceAdapter {

  private static final transient Logger LOG = LoggerFactory.getLogger(  Pi4JResourceAdapter.class );

  private GpioController gpio = null;

  @Override
  public void start( final BootstrapContext _ctx ) throws ResourceAdapterInternalException {
    gpio = GpioFactory.getInstance( );
    LOG.info( "Started gpio controller: {}", gpio );
  }

  @Override
  public void stop( ) {
    LOG.info( "Shutting down gpio controller: {}", gpio );
    gpio.shutdown( );
  }

  @Override
  public void endpointActivation( final MessageEndpointFactory _endpointFactory, final ActivationSpec _spec )
      throws ResourceException {
  }

  @Override
  public void endpointDeactivation( final MessageEndpointFactory _endpointFactory, final ActivationSpec _spec ) {
  }

  @Override
  public XAResource[ ] getXAResources( final ActivationSpec[ ] _specs ) throws ResourceException {
    return new XAResource[ 0 ];
  }

}
