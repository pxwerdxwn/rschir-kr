package com.rschir.db_admin.Repositories;

import com.rschir.db_admin.Entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    Optional<Type> findByName(String typeName);
}
