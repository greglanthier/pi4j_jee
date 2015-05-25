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

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import java.io.PrintWriter;
import java.util.Collections;

import javax.resource.ResourceException;
import javax.resource.spi.ConnectionManager;
import javax.resource.spi.ConnectionRequestInfo;
import javax.resource.spi.ManagedConnection;
import javax.resource.spi.ResourceAdapter;
import javax.security.auth.Subject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith( MockitoJUnitRunner.class )
public class Pi4JManagedConnectionFactoryTest {

  @Mock private PrintWriter logWriter;

  @Mock private ResourceAdapter resourceAdapter;

  @Mock private ConnectionManager connectionManager;
  
  @Mock private ConnectionRequestInfo cxRequestInfo;

  private Subject subject;

  private Pi4JManagedConnectionFactory factory;

  @Before
  public void setUp( ) throws ResourceException {
    PrintWriter out = new PrintWriter( System.out );
    subject = new Subject( );
    factory = new Pi4JManagedConnectionFactory( );
    factory.setLogWriter( out );
    factory.setResourceAdapter( resourceAdapter );
  }

  @Test(expected = ResourceException.class )
  public void testSetResourceAdapterTwice( ) throws ResourceException {
    factory.setResourceAdapter( resourceAdapter );
  }

  @Test
  public void testGetResourceAdapter( ) throws Exception {
    assertThat( factory.getResourceAdapter( ), equalTo( resourceAdapter ) );
  }

  @Test
  public void testCreateConnectionFactoryConnectionManager( ) throws Exception {
    assertThat( factory.createConnectionFactory(  connectionManager ), nullValue() );
  }

  @Test
  public void testCreateConnectionFactory( ) throws Exception {
    assertThat( factory.createConnectionFactory( ), nullValue() );
  }

  @Test
  public void testCreateManagedConnection( ) throws Exception {
    assertThat( factory.createManagedConnection( subject, cxRequestInfo ), nullValue( ) );
  }

  @Test
  public void testMatchManagedConnections( ) throws Exception {
    ManagedConnection mc = factory.matchManagedConnections( Collections.emptySet( ), subject, cxRequestInfo );
    assertThat( mc, nullValue( ) );
  }

  @Test
  public void testGetLogWriter( ) throws Exception {
    assertThat( factory.getLogWriter( ), nullValue( ) );
  }

}