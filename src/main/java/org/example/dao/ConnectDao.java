package org.example.dao;

import org.example.model.Connect;

import java.util.List;

public interface ConnectDao {
    public Connect getById(int id);
    public List<Connect> getAll();
    public List<Connect> getLastNConn(int amount);
    public List<>
}
