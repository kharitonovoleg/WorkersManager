package by.manager.service;

import by.manager.dao.DaoWorkers;
import by.manager.model.Workers;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;

@Service
public class WorkersServiceImpl implements WorkersService {

    private DaoWorkers daoWorkers;

    public void setDaoWorkers(DaoWorkers daoWorkers) {
        this.daoWorkers = daoWorkers;
    }

    @Override
    @Transactional
    public void addWorkers(Workers workers) {
        this.daoWorkers.addWorkers(workers);
    }

    @Override
    @Transactional
    public void updateWorkers(Workers workers) {
        this.daoWorkers.updateWorkers(workers);
    }

    @Override
    @Transactional
    public void removeWorkers(int id) {
        this.daoWorkers.removeWorkers(id);
    }

    @Override
    @Transactional
    public Workers getWorkersById(int id) {
        return this.daoWorkers.getWorkersById(id);
    }

    @Override
    @Transactional
    public List<Workers> listWorkers() {
        return this.daoWorkers.listWorkers();
    }

    @Override
    @Transactional
    public Collection<Workers> getWorkers(String search) {
        return this.daoWorkers.getWorkers(search);
    }


}
