package com.ms.hrworker.services;

import com.ms.hrworker.entities.Worker;
import com.ms.hrworker.repositories.WorkerRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkerService {

    @Autowired
    private WorkerRepository workerRepository;

    public List<Worker> listAllWorkers(){
        return workerRepository.findAll();
    }

    public Worker findWorkerById(Long id){
        return workerRepository.findById(id).orElseThrow(
                () -> new EntityNotFoundException("Worker not found with id: " + id)
        );
    }
}
