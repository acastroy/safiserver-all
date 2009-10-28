package com.safi.workshop.navigator.db;

import org.hibernate.Session;

public interface SessionEstablishedListener {

  void sessionEstablished(Session session);

  void cannotEstablishSession(Exception e);
}
