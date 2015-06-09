package org.pi4j.jee.war;

/*
 * #%L
 * org.pi4j.jee.war
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

import javax.ejb.MessageDriven;

import org.pi4j.jee.ra.Pi4JGpioListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;

@MessageDriven(
    messageListenerInterface = Pi4JGpioListener.class 
    )
public class Pi4JMessageDrivenBean implements Pi4JGpioListener {

  private static transient final Logger LOG = LoggerFactory.getLogger( Pi4JMessageDrivenBean.class );

  @Override
  public void onGpioEvent( GpioPinDigitalStateChangeEvent _event ) {
    LOG.info(  "{}#onGpioEvent( {} )", this, _event );
  }
}
