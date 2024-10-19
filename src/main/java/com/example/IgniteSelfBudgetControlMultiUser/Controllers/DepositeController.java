package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.Controllers.Abstract.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.DepositeDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Entities.Deposite;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SearchCriteria;
import com.example.IgniteSelfBudgetControlMultiUser.Services.DepositeServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/Deposite")
@RestController

public class DepositeController implements IAbstractController<DepositeDTO> {

    @Autowired
    DepositeServiceImp depositeService;


    @Override
    @Operation(operationId = "loadDeposite")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<DepositeDTO> load(@PathVariable Long id) {
        DepositeDTO deposite = depositeService.load(id);
        return new ResponseEntity<>(deposite,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "getAllDeposite")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<DepositeDTO>> getAll() throws Exception {
        List<DepositeDTO> deposites = depositeService.getAll();
        return new ResponseEntity<>(deposites,HttpStatus.OK);
    }

    @Override
    @PostMapping("/Save")
    @Operation(operationId = "saveDeposite")
    public ResponseEntity<DepositeDTO> save(@RequestBody DepositeDTO deposite) throws Exception {
        DepositeDTO newDepositeDTO = depositeService.save(deposite) ;
        return new ResponseEntity<>(newDepositeDTO, HttpStatus.CREATED);
    }



    @Override
    public ResponseEntity<List<DepositeDTO>> saveAll(List<DepositeDTO> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "deleteDeposite")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        depositeService.delete(id);
    }



//    @Operation(operationId = "getDepositesByAccount")
//    @GetMapping(value = "/GetDepositesByAccount/{accountId}", produces = "application/json")
//    public ResponseEntity<List<DepositeDTO>> getDepositesByAccount(@PathVariable Long accountId) throws Exception {
//        List<DepositeDTO> depositesByAccountId = depositeService.getDepositesByAccount(accountId);
//        return new ResponseEntity<>(depositesByAccountId,HttpStatus.OK);
//    }
}
