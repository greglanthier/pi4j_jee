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

import java.io.PrintWriter;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.spi.ConnectionEventListener;
import javax.resource.spi.ConnectionRequestInfo;
import javax.security.auth.Subject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith( MockitoJUnitRunner.class )
public class Pi4JManagedConnectionTest {

  @Mock private PrintWriter logWriter;

  @Mock private ConnectionRequestInfo requestInfo;

  @Mock private ConnectionEventListener m_listener;

  @InjectMocks private Pi4JManagedConnection managedConnection;

  @Test
  public void testGetConnection( ) throws Exception {
    Subject subject = new Subject( );
    Connection connection = ( Connection ) managedConnection.getConnection( subject, requestInfo );
    connection.close( );
  }

  @Test
  public void testDestroy( ) throws Exception {
    managedConnection.destroy( );
  }

  @Test
  public void testCleanup( ) throws Exception {
    managedConnection.cleanup( );
  }

  @Test
  public void testAssociateConnection( ) throws Exception {
    managedConnection.associateConnection( null );
  }

  @Test
  public void testAddConnectionEventListener( ) throws Exception {
    managedConnection.addConnectionEventListener( m_listener );
    managedConnection.addConnectionEventListener( m_listener );
    managedConnection.removeConnectionEventListener( m_listener );
    managedConnection.removeConnectionEventListener( m_listener );
    managedConnection.removeConnectionEventListener( m_listener );
  }

  @Test
  public void testGetXAResource( ) throws Exception {
    assertThat( managedConnection.getXAResource( ), is( nullValue() ) );
  }

  @Test( expected = ResourceException.class )
  public void testGetLocalTransaction( ) throws Exception {
    managedConnection.getLocalTransaction( );
  }

  @Test
  public void testGetMetaData( ) throws Exception {
    assertThat( managedConnection.getMetaData( ), is( nullValue() ) );
  }

  @Test
  public void testSetLogWriter( ) throws Exception {
    managedConnection.setLogWriter( null );
  }

  @Test
  public void testGetLogWriter( ) throws Exception {
    assertThat( managedConnection.getLogWriter( ), is( nullValue() ) );
  }

}
