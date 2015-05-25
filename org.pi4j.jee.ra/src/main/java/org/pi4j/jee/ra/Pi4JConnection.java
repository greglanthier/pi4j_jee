package org.pi4j.jee.ra;

import javax.resource.ResourceException;
import javax.resource.cci.Connection;
import javax.resource.cci.ConnectionMetaData;
import javax.resource.cci.Interaction;
import javax.resource.cci.LocalTransaction;
import javax.resource.cci.ResultSetInfo;

public class Pi4JConnection implements Connection, AutoCloseable {

  @Override
  public Interaction createInteraction( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public LocalTransaction getLocalTransaction( ) throws ResourceException {
    throw new ResourceException( "local transactions not supported" );
  }

  @Override
  public ConnectionMetaData getMetaData( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public ResultSetInfo getResultSetInfo( ) throws ResourceException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void close( ) throws ResourceException {
    // TODO Auto-generated method stub

  }

}
