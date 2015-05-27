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
import java.util.ArrayList;
import java.util.List;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.LocalTransaction;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ManagedConnectionMetaData;
import javax.security.auth.Subject;
import javax.transaction.xa.XAResource;

public class Pi4JManagedConnection implements ManagedConnection {

  List<ConnectionEventListener> listeners = new ArrayList<ConnectionEventListener>( );

  /*
   * Answer a connection handle. Multiple connection handles could be tied to a
   * single managed connection.
   * 
   * For a CCI resource adapter this will be an object that implements {@link
   * javax.resource.cci.Connection}.
   */
  @Override
  public Object getConnection( final Subject _subject, final ConnectionRequestInfo _cxRequestInfo )
      throws ResourceException {
    return new Pi4JConnection( this );
  }

  @Override
  public void destroy( ) throws ResourceException {
    // TODO Auto-generated method stub

  }

  @Override
  public void cleanup( ) throws ResourceException {
    // TODO Auto-generated method stub

  }

  @Override
  public void associateConnection( final Object _connection ) throws ResourceException {
  }

  @Override
  public void addConnectionEventListener( final ConnectionEventListener _listener ) {
    synchronized ( listeners ) {
      listeners.add( _listener );
    }
  }

  @Override
  public void removeConnectionEventListener( final ConnectionEventListener _listener ) {
    synchronized ( listeners ) {
      listeners.remove( _listener );
    }
  }

  @Override
  public XAResource getXAResource( ) throws ResourceException {
    return null;
  }

  @Override
  public LocalTransaction getLocalTransaction( ) throws ResourceException {
    throw new ResourceException( "Local transactions not supported" );
  }

  @Override
  public ManagedConnectionMetaData getMetaData( ) throws ResourceException {
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
