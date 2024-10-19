package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.Controllers.Abstract.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditStatusDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Services.CreditStatusServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/CreditStatus")
@RestController
public class CreditStatusController implements IAbstractController<CreditStatusDTO> {

    @Autowired
    CreditStatusServiceImp creditStatusService;

    @Override
    @Operation(operationId = "loadCreditStatus")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<CreditStatusDTO> load(@PathVariable Long id) {
        CreditStatusDTO creditStatus = creditStatusService.load(id);
        return new ResponseEntity<>(creditStatus,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "getAllCreditStatus")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<CreditStatusDTO>> getAll() throws Exception {
        List<CreditStatusDTO> creditStatuss = creditStatusService.getAll();
        return new ResponseEntity<>(creditStatuss,HttpStatus.OK);
    }

    @Override
    @Operation(operationId = "saveCreditStatus")
    @PostMapping("/Save")
    public ResponseEntity<CreditStatusDTO> save(@RequestBody CreditStatusDTO creditStatus) throws Exception {
        CreditStatusDTO newCreditStatusDTO = creditStatusService.save(creditStatus) ;
        return new ResponseEntity<>(newCreditStatusDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CreditStatusDTO>> saveAll(List<CreditStatusDTO> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "deleteCreditStatus")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        creditStatusService.delete(id);
    }

}
