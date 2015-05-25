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

import javax.naming.NamingException;
import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.cci.ConnectionSpec;
import javax.resource.cci.RecordFactory;
import javax.resource.cci.ResourceAdapterMetaData;

public class Pi4JConnectionFactory implements ConnectionFactory {

  private static final long serialVersionUID = 1L;

  private Reference reference;

  @Override
  public void setReference( final Reference _reference ) {
    reference = _reference;
  }

  @Override
  public Reference getReference( ) throws NamingException {
    return reference;
  }

  @Override
  public Connection getConnection( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Connection getConnection( final ConnectionSpec _properties ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public RecordFactory getRecordFactory( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResourceAdapterMetaData getMetaData( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

}
