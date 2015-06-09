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

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebListener
public class ContextListener implements ServletContextListener {

  private static final Logger LOG = LoggerFactory.getLogger( ContextListener.class );

//  @Resource( lookup = "pi4jwar/Pi4JMessageDrivenBean")
//  Pi4JMessageDrivenBean mdb;
  
  @Override
  public void contextInitialized( ServletContextEvent sce ) {
    LOG.debug( "{}#contextIntialized( {}  )", this, sce );
  }

  @Override
  public void contextDestroyed( ServletContextEvent sce ) {
  }

}
