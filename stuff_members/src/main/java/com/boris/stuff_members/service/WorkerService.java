package com.boris.stuff_members.service;

import com.boris.stuff_members.dto.WorkerClientDto;
import com.boris.stuff_members.entity.Worker;
import com.boris.stuff_members.repo.WorkerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepo workerRepo;

    public List<Worker> getAllWorkers(){
        return workerRepo.findAll();
    }

    public void addWorkerToDatabase(WorkerClientDto workerClientDto){
        Worker worker = new Worker();
        worker.setFirstName(workerClientDto.getFirstName());
        worker.setLastName(workerClientDto.getLastName());
        worker.setMiddleName(workerClientDto.getMiddleName());
        worker.setPersonalId(workerClientDto.getPersonalId());
        worker.setRole(workerClientDto.getRole());
        worker.setEmail(workerClientDto.getEmail());
        worker.setPhone(workerClientDto.getPhone());
        worker.setGender(workerClientDto.getGender());
        workerRepo.save(worker);
    }

    public WorkerClientDto getOneWorker(Long id){
         Worker worker = workerRepo.findById(id).get();
         WorkerClientDto dto = new WorkerClientDto.Builder().firstName(worker.getFirstName())
                 .lastName(worker.getLastName()).middleName(worker.getMiddleName())
                 .email(worker.getEmail()).gender(worker.getGender())
                 .personalId(worker.getPersonalId()).phone(worker.getPhone())
                 .role(worker.getRole()).startingDate(worker.getStartingDate()).id(worker.getId()).build();
         return dto;
    }

    public void deleteWorker(Long id){
        workerRepo.deleteById(id);
    }

    public void updateWorker(WorkerClientDto workerClientDto){
        Worker worker = workerRepo.findById(workerClientDto.getId()).get();
        System.out.println(worker.getFirstName());
        worker.setFirstName(workerClientDto.getFirstName());
        worker.setLastName(workerClientDto.getLastName());
        worker.setMiddleName(workerClientDto.getMiddleName());
        worker.setPersonalId(workerClientDto.getPersonalId());
        worker.setRole(workerClientDto.getRole());
        worker.setEmail(workerClientDto.getEmail());
        worker.setPhone(workerClientDto.getPhone());
        worker.setGender(workerClientDto.getGender());
        workerRepo.save(worker);
    }

}
