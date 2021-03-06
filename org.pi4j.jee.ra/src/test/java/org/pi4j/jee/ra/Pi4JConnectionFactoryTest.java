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
import static org.hamcrest.core.IsNull.notNullValue;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import javax.naming.Reference;
import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionSpec;
import javax.resource.spi.ConnectionManager;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith( MockitoJUnitRunner.class )
public class Pi4JConnectionFactoryTest {

  @Mock private Reference reference;

  @Mock private ConnectionManager connectionManager;

  @InjectMocks private Pi4JConnectionFactory factory;

  Pi4JManagedConnectionFactory mcf = new Pi4JManagedConnectionFactory( );

  @Before
  public void setUp( ) {
    factory = new Pi4JConnectionFactory( mcf, connectionManager );
    factory.setReference( null );
  }

  @Test
  public void testGetConnectionNoConnectionManager() throws ResourceException {
    Pi4JConnectionFactory testFactory = new Pi4JConnectionFactory( mcf );
    Connection c = testFactory.getConnection( );
    assertThat( c, is( notNullValue( ) ) );
    c.close( );
  }
  
  @Test
  public void testGetReference( ) throws Exception {
    assertThat( factory.getReference( ), is( nullValue( ) ) );
  }

  @Test
  public void testGetConnection( ) throws Exception {
    Connection c = factory.getConnection( ); 
    assertThat( c, is( notNullValue( ) ) );
    c.close( );
  }

  @Test
  public void testGetConnectionConnectionSpec( ) throws Exception {
    ConnectionSpec spec = Mockito.mock( ConnectionSpec.class );
    assertThat( factory.getConnection( spec ), is( nullValue( ) ) );
  }

  @Test
  public void testGetRecordFactory( ) throws Exception {
    assertThat( factory.getRecordFactory( ), is( nullValue( ) ) );
  }

  @Test
  public void testGetMetaData( ) throws Exception {
    assertThat( factory.getMetaData( ), is( nullValue( ) ) );
  }

}
