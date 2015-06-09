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
import javax.resource.spi.ActivationSpec;
import javax.resource.spi.BootstrapContext;
import javax.resource.spi.Connector;
import javax.resource.spi.ResourceAdapter;
import javax.resource.spi.ResourceAdapterInternalException;
import javax.resource.spi.endpoint.MessageEndpointFactory;
import javax.transaction.xa.XAResource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//import com.pi4j.io.gpio.GpioController;
//import com.pi4j.io.gpio.GpioPinDigitalInput;

@Connector
public final class Pi4JResourceAdapter implements ResourceAdapter {

  private static final transient Logger LOG = LoggerFactory.getLogger( Pi4JResourceAdapter.class );

//  private GpioController gpio = null;
//
//  private GpioPinDigitalInput myButton = null;

  @Override
  public void start( final BootstrapContext _ctx ) throws ResourceAdapterInternalException {
//    gpio = GpioFactory.getInstance( );
//    LOG.info( "{}#start( {} ) (setting gpio controller: {})", this, _ctx, gpio );
//
//    // http://pi4j.com/example/listener.html
//    //
//    myButton = gpio.provisionDigitalInputPin( RaspiPin.GPIO_02, PinPullResistance.PULL_DOWN );
//
//    myButton.addListener( new GpioPinListenerDigital( ) {
//      @Override
//      public void handleGpioPinDigitalStateChangeEvent( GpioPinDigitalStateChangeEvent _event ) {
//        LOG.info( " --> GPIO PIN STATE CHANGE: {} = {}", _event.getPin( ), _event.getState( ) );
//      }
//
//    } );
//
//    LOG.info( "Added button listener" );
    
//    try {
//      _ctx.getWorkManager( ).startWork( new Work( ) {
//        
//        @Override
//        public void run( ) {
//          // TODO Auto-generated method stub
//        }
//        
//        @Override
//        public void release( ) {
//          // TODO Auto-generated method stub
//          
//        }
//      } );
//    } catch ( WorkException e ) {
//      // TODO Auto-generated catch block
//      e.printStackTrace();
//    }
  }

  @Override
  public void stop( ) {
//    LOG.info( "{}#stop( ) (shutting down gpio controller: {})", this, gpio );
//    gpio.removeAllListeners( );
//    gpio.shutdown( );
  }

  @Override
  public void endpointActivation( final MessageEndpointFactory _endpointFactory, final ActivationSpec _spec )
      throws ResourceException {
    LOG.info( "{}#endpointActivation( {}, {}  )", this, _endpointFactory, _spec );
  }

  @Override
  public void endpointDeactivation( final MessageEndpointFactory _endpointFactory, final ActivationSpec _spec ) {
    LOG.info( "{}#endpointDeactivation( {}, {}  )", this, _endpointFactory, _spec );
  }

  @Override
  public XAResource[ ] getXAResources( final ActivationSpec[ ] _specs ) throws ResourceException {
    return new XAResource[ 0 ];
  }

}
