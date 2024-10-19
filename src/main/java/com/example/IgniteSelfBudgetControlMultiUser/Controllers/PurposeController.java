package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.Controllers.Abstract.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.PurposeDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Purpose;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Services.PurposeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Purpose")
@RestController
public class PurposeController implements IAbstractController<PurposeDTO> {

    @Autowired
    PurposeServiceImp purposeService;

    @Override
    @Operation(operationId = "loadPurpose")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<PurposeDTO> load(@PathVariable Long id) {
        PurposeDTO purpose = purposeService.load(id);
        return new ResponseEntity<>(purpose,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "GetAllPurpose")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<PurposeDTO>> getAll() throws Exception {
        List<PurposeDTO> purposes = purposeService.getAll();
        return new ResponseEntity<>(purposes,HttpStatus.OK);
    }


    @Override
    @PostMapping("/Save")
    @Operation(operationId = "savePurpose")
    public ResponseEntity<PurposeDTO> save(@RequestBody PurposeDTO purpose) throws Exception {
        PurposeDTO newPurposeDTO = purposeService.save(purpose) ;
        return new ResponseEntity<>(newPurposeDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<PurposeDTO>> saveAll(List<PurposeDTO> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "deletePurpose")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) { purposeService.delete(id);}

}
