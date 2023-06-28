package com.boris.stuff_members.repo;

import com.boris.stuff_members.entity.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface WorkerRepo extends JpaRepository<Worker, Long> {
}
