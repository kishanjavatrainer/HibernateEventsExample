package com.infotech.events;

import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.event.spi.RefreshEvent;
import org.hibernate.event.spi.RefreshEventListener;

import com.infotech.entities.Person;

public class RefreshEventListenerImpl implements RefreshEventListener {
   
   private static final long serialVersionUID = 1L;
   private static Logger logger = LogManager
            .getLogger(RefreshEventListenerImpl.class);

   @Override
   public void onRefresh(RefreshEvent e) throws HibernateException {
      logger.info("onRefresh is called.");
      Object obj = e.getObject();
      if (obj instanceof Person) {
         Person person = (Person) obj;
         logger.info(person);
      }
   }

   @SuppressWarnings("rawtypes")
   @Override
   public void onRefresh(RefreshEvent e, Map refreshedAlready) 
         throws HibernateException {
      logger.info("onRefresh is called.");
   }

}