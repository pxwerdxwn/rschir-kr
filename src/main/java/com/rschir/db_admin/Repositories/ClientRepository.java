package com.rschir.db_admin.Repositories;

import com.rschir.db_admin.Entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    // Можно добавить дополнительные методы поиска по полям
    // Например, поиск клиента по имени
    Client findByName(String name);
}
