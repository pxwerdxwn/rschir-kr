package com.rschir.db_admin.Repositories;

import com.rschir.db_admin.Entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

    Optional<Status> findByStatusName(String statusName);
}
