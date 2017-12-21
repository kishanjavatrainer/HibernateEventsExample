package com.infotech.interceptor;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.EmptyInterceptor;
import org.hibernate.type.Type;

import com.infotech.entities.Person;

public class LoggerInterceptor extends EmptyInterceptor {

   private static final long serialVersionUID = 1L;
   // Define a static logger
   private static Logger logger = LogManager.getLogger(LoggerInterceptor.class);

   @Override
   public boolean onSave(Object entity, Serializable id, Object[] state,
            String[] propertyNames, Type[] types) {
      logger.info("onSave method is called...");
      if (entity instanceof Person) {
    	  Person person = (Person) entity;
         logger.info(person);
      }
      return super.onSave(entity, id, state, propertyNames, types);
   }
   // Logging SQL statement
   @Override
   public String onPrepareStatement(String sql) {
      logger.info(sql);
      return super.onPrepareStatement(sql);
   }

}