package com.rschir.db_admin.Repositories;

import com.rschir.db_admin.Entities.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

    // Можно добавить дополнительные методы для поиска документов
    Document findByName(String name);

    // Например, поиск документов по проекту
    List<Document> findByProject_ProjectId(int projectId);
}
