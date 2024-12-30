package org.example.dao.impl;

import org.example.dao.ConnectDao;

public abstract class DaoFactory {
    public static final String H2 = "h2";
    public abstract ConnectDao getConnectionDao();
    public abstract Redirec
}
