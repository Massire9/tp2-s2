package fr.sdv.dao;

import java.util.List;

public interface ActionDAO <T>{
    public boolean create(T o);
    public T update(T o);
    public boolean delete(T o);
    public boolean deleteById(int id);
    public List<T> retrieveAll();
    public T retrieveById(int id);

}
