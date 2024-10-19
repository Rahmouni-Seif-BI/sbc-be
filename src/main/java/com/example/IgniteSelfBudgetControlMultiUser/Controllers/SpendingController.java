package com.example.IgniteSelfBudgetControlMultiUser.Controllers;
import com.example.IgniteSelfBudgetControlMultiUser.Controllers.Abstract.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.SpendingDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Services.SpendingServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/SpendingDTO")
@RestController

public class SpendingController implements IAbstractController<SpendingDTO> {

    @Autowired
    SpendingServiceImp spendingService;

    @Override
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    @Operation(operationId = "loadSpending")
    public ResponseEntity<SpendingDTO> load(@PathVariable Long id) {
        SpendingDTO spending = spendingService.load(id);
        return new ResponseEntity<>(spending,HttpStatus.OK);
    }

    @Override
    @GetMapping(value = "/GetAll", produces = "application/json")
    @Operation(operationId = "getAllSpending")
    public ResponseEntity<List<SpendingDTO>> getAll() throws Exception {
        List<SpendingDTO> spendings = spendingService.getAll();
        return new ResponseEntity<>(spendings,HttpStatus.OK);
    }
    
    @Override
    @PostMapping("/Save")
    @Operation(operationId = "saveSpending")
    public ResponseEntity<SpendingDTO> save(@RequestBody SpendingDTO spending) throws Exception {
        SpendingDTO newSpending = spendingService.save(spending) ;
        return new ResponseEntity<>(newSpending, HttpStatus.CREATED);
    }


    @Override
    public ResponseEntity<List<SpendingDTO>> saveAll(List<SpendingDTO> entities) throws Exception {
        return null;
    }

    
    @Override
    @DeleteMapping("/Delete/{id}")
    @Operation(operationId = "deleteSpending")
    public void delete(@PathVariable Long id) { spendingService.delete(id);}


//    @GetMapping(value = "/GetSpendingsByAccount/{accountId}", produces = "application/json")
//    @Operation(operationId = "getSpendingsByAccount")
//    public ResponseEntity<List<SpendingDTO>> getSpendingsByAccount(@PathVariable Long accountId) throws Exception {
//        List<SpendingDTO> spendingsByAccountId = spendingService.getSpendingsByAccount(accountId);
//        return new ResponseEntity<>(spendingsByAccountId,HttpStatus.OK);
//    }
}
