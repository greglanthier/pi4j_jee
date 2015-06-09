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

import java.io.Serializable;

import javax.resource.ResourceException;
import javax.resource.spi.Activation;
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.ConfigProperty;
import javax.resource.spi.InvalidPropertyException;
import javax.resource.spi.ResourceAdapter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Activation(
    messageListeners = {Pi4JGpioListener.class}
    )
public class Pi4JGpioActivationSpec implements ActivationSpec, Serializable {

  private static final long serialVersionUID = 1L;

  private static transient Logger LOG = LoggerFactory.getLogger( Pi4JGpioActivationSpec.class );

  private ResourceAdapter resourceAdapter;

  @ConfigProperty( defaultValue = "x" )
  private String pinName = "";

  public String getPinName() {
    return pinName;
  }

  public void setPinName( final String _name ) {
    LOG.info( "SET NAME {} ", _name );
    pinName = _name;
  }

  @Override
  public ResourceAdapter getResourceAdapter( ) {
    return resourceAdapter;
  }

  @Override
  public void setResourceAdapter( ResourceAdapter _ra ) throws ResourceException {
    LOG.info( "{}#setResourceAdapter( {} )", this, _ra );
    resourceAdapter = _ra;
  }

  @Override
  public void validate( ) throws InvalidPropertyException {
    // TODO Auto-generated method stub

  }

}
