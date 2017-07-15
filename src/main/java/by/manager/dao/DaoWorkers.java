package by.manager.dao;


import by.manager.model.Workers;

import java.util.Collection;
import java.util.List;

public interface DaoWorkers {

    public void addWorkers(Workers workers);

    public void updateWorkers(Workers workers);

    public void removeWorkers(int id);

    public Workers getWorkersById(int id);

    public List<Workers> listWorkers();

    Collection<Workers> getWorkers(String search);

}
