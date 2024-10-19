package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.Controllers.Abstract.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.RepaymentEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.RepaymentEntity;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Services.RepaymentEntityServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/RepaymentEntity")
@RestController

public class RepaymentEntityController implements IAbstractController<RepaymentEntityDTO> {

    @Autowired
    RepaymentEntityServiceImp repaymentEntityService;


    @Override
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    @Operation(operationId = "loadRepaymentEntity")
    public ResponseEntity<RepaymentEntityDTO> load(@PathVariable Long id) {
        RepaymentEntityDTO repaymentEntity = repaymentEntityService.load(id);
        return new ResponseEntity<>(repaymentEntity,HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/GetAll", produces = "application/json")
    @Operation(operationId = "getAllRepaymentEntitiy")
    public ResponseEntity<List<RepaymentEntityDTO>> getAll() throws Exception {
        List<RepaymentEntityDTO> repaymentEntities = repaymentEntityService.getAll();
        return new ResponseEntity<>(repaymentEntities,HttpStatus.OK);
    }

    @Override
    @PostMapping("/Save")
    @Operation(operationId = "saveRepaymentEntity")
    public ResponseEntity<RepaymentEntityDTO> save(@RequestBody RepaymentEntityDTO repaymentEntity) throws Exception {
        RepaymentEntityDTO newRepaymentEntity = repaymentEntityService.save(repaymentEntity) ;
        return new ResponseEntity<>(newRepaymentEntity, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<RepaymentEntityDTO>> saveAll(List<RepaymentEntityDTO> entities) throws Exception {
        return null;
    }

    @Override
    @DeleteMapping("/Delete/{id}")
    @Operation(operationId = "deleteRepaymentEntity")
    public void delete(@PathVariable Long id) {
        repaymentEntityService.delete(id);
    }

}
