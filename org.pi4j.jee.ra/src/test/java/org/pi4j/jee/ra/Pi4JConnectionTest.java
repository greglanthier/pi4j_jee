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

import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

import javax.resource.ResourceException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class Pi4JConnectionTest {

  private Pi4JConnection connection = null;

  @Before
  public void setUp() {
    connection = new Pi4JConnection( );
  }

  @After
  public void tearDown() throws ResourceException {
    connection.close( );
  }
  @Test
  public void testCreateInteraction( ) throws ResourceException {
    assertThat( connection.createInteraction( ), nullValue( ) );
  }

  @Test( expected = ResourceException.class )
  public void testGetLocaltTransaction( ) throws ResourceException {
    assertThat( connection.getLocalTransaction( ), nullValue( ) );
  }

  @Test
  public void testGetMetaData( ) throws ResourceException {
    assertThat( connection.getMetaData( ), nullValue( ) );
  }

  @Test
  public void testGetResultSetInfo( ) throws ResourceException {
    assertThat( connection.getResultSetInfo( ), nullValue( ) );
  }

  @Test
  public void testClose() throws ResourceException {
    try ( Pi4JConnection c = new Pi4JConnection( ) ){};
  }
}
