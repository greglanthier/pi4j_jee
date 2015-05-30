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
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;
import javax.resource.spi.ManagedConnection;

public class Pi4JConnection implements Connection, AutoCloseable {

  private ManagedConnection managedConnection = null;

  public Pi4JConnection( ) {
    this( null );
  }

  public Pi4JConnection( ManagedConnection _managedConnection ) {
    managedConnection = _managedConnection;
  }

  @Override
  public Interaction createInteraction( ) throws ResourceException {
    return null;
  }

  @Override
  public LocalTransaction getLocalTransaction( ) throws ResourceException {
    throw new ResourceException( "local transactions not supported" );
  }

  @Override
  public ConnectionMetaData getMetaData( ) throws ResourceException {
    return null;
  }

  @Override
  public ResultSetInfo getResultSetInfo( ) throws ResourceException {
    return null;
  }

  @Override
  public void close( ) throws ResourceException {

    if ( null != managedConnection ) {
      // Let the managed connection know this physical connection is being
      // closed.
      //
      // for now I'll invoke 'cleanup' but the physical connection should
      // never do this (at least according to http://docs.oracle.com/javaee/6/api/index.html?javax/resource/spi/ResourceAdapter.html).

      managedConnection.cleanup( );
    }
  }

}
