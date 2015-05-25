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

import java.io.PrintWriter;
import java.util.Set;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.security.auth.Subject;

public class Pi4JManagedConnectionFactory implements ManagedConnectionFactory, ResourceAdapterAssociation {

  private static final long serialVersionUID = 1L;

  private ResourceAdapter resourceAdapter;
  
  @Override
  public ResourceAdapter getResourceAdapter( ) {
    return resourceAdapter;
  }

  @Override
  public void setResourceAdapter( final ResourceAdapter ra ) throws ResourceException {
    if ( null != resourceAdapter ) {
      throw new ResourceException( "Resource already set" );
    }
    resourceAdapter = ra;
  }

  @Override
  public Object createConnectionFactory( final ConnectionManager cxManager ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Object createConnectionFactory( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ManagedConnection createManagedConnection( final Subject subject, final ConnectionRequestInfo cxRequestInfo )
      throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @SuppressWarnings( "rawtypes" )
  @Override
  public ManagedConnection matchManagedConnections( final Set connectionSet, final Subject subject,
      final ConnectionRequestInfo cxRequestInfo ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setLogWriter( final PrintWriter out ) throws ResourceException {
    // TODO Auto-generated method stub

  }

  @Override
  public PrintWriter getLogWriter( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

}
