package com.rschir.db_admin.RestControllers;

import com.rschir.db_admin.DTO.StatusDTO;
import com.rschir.db_admin.Services.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class StatusController {

    @Autowired
    StatusService statusService;

    @GetMapping(value = "/status", produces = "application/json")
    public ResponseEntity<List<StatusDTO>> getAllStatus() {

        List<StatusDTO> allStatusDTO = statusService.getAllStatus();
        return new ResponseEntity<List<StatusDTO>>(allStatusDTO, HttpStatus.OK);
    }
}
