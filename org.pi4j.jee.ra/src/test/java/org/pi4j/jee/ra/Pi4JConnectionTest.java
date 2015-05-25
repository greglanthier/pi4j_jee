package org.pi4j.jee.ra;

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
