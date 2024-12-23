package com.rschir.db_admin.Services;

import com.rschir.db_admin.DTO.TypeDTO;
import com.rschir.db_admin.Entities.Type;
import com.rschir.db_admin.Repositories.TypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TypeService {

    @Autowired
    TypeRepository typeRepository;

    @Transactional
    public Optional<Type> findTypeByName(String name) {

        return typeRepository.findByName(name);
    }

    @Transactional
    public void saveNewType(Type type) {

        typeRepository.save(type);
    }

    @Transactional
    public List<TypeDTO> getAllTypes() {

        List<Type> allTypes = typeRepository.findAll();
        List<TypeDTO> typeDTOS = new ArrayList<>();

        for (Type type :
                allTypes) {
            TypeDTO temp = new TypeDTO();
            temp.typeId = type.getTypeId();
            temp.typeName = type.getName();
            typeDTOS.add(temp);
        }
        return typeDTOS;
    }

    @Transactional
    public void deleteTypeById(Integer id) {

        typeRepository.deleteById(id);
    }
}
