package com.rschir.db_admin.EntityConverter;

public interface EntityConverter<ENTITY, DTO> {

    public DTO convertToDTO(ENTITY entity);
    public ENTITY convertToEntity (DTO dto);
}
