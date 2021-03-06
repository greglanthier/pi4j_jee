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
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionFactory;
import javax.resource.spi.ConnectionDefinition;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionFactory;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterAssociation;
import javax.security.auth.Subject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ConnectionDefinition(
    connectionFactory = ConnectionFactory.class,
    connectionFactoryImpl = Pi4JConnectionFactory.class,
    connection = Connection.class,
    connectionImpl = Pi4JConnection.class
    )
public class Pi4JManagedConnectionFactory implements ManagedConnectionFactory, ResourceAdapterAssociation {

  private static final long serialVersionUID = 1L;

  private static final transient Logger LOG = LoggerFactory.getLogger( Pi4JManagedConnectionFactory.class );

  private transient ResourceAdapter resourceAdapter = null;

  @Override
  public ResourceAdapter getResourceAdapter( ) {
    return resourceAdapter;
  }

  @Override
  public void setResourceAdapter( final ResourceAdapter _ra ) throws ResourceException {
    if ( null != resourceAdapter ) {
      throw new ResourceException( "Resource already set" );
    }
    LOG.info( "{}#setResourceAdapter( {} )", this, _ra );
    resourceAdapter = _ra;
  }

  @Override
  public Object createConnectionFactory( final ConnectionManager _cxManager ) throws ResourceException {
    return new Pi4JConnectionFactory( this, _cxManager );
  }

  @Override
  public Object createConnectionFactory( ) throws ResourceException {
    return new Pi4JConnectionFactory( this );
  }

  @Override
  public ManagedConnection createManagedConnection( final Subject _subject, final ConnectionRequestInfo _cxRequestInfo )
      throws ResourceException {
    // TODO Auto-generated method stub
    return new Pi4JManagedConnection( );
  }

  @SuppressWarnings( "rawtypes" )
  @Override
  public ManagedConnection matchManagedConnections( final Set _connectionSet, final Subject _subject,
      final ConnectionRequestInfo _cxRequestInfo ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void setLogWriter( final PrintWriter _out ) throws ResourceException {
    // TODO Auto-generated method stub

  }

  @Override
  public PrintWriter getLogWriter( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

}
