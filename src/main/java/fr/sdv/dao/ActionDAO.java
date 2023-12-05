package entities;

import java.util.List;

public interface ActionDAO <T>{
    public boolean create(T o);
    public T update(T o);
    public boolean delete(T o);
    public boolean deleteById(int id);
    public List<T> retrieveAll();
    public List<T> retrieveById(int id);

}
