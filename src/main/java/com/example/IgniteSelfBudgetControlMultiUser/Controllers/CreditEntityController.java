package com.example.IgniteSelfBudgetControlMultiUser.Controllers;

import com.example.IgniteSelfBudgetControlMultiUser.Controllers.Abstract.IAbstractController;
import com.example.IgniteSelfBudgetControlMultiUser.DTO.CreditEntityDTO;
import com.example.IgniteSelfBudgetControlMultiUser.Services.CreditEntityServiceImp;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/CreditEntity")
@RestController
public class CreditEntityController implements IAbstractController<CreditEntityDTO> {

    @Autowired
    CreditEntityServiceImp creditEntityService;


    @Override
    @Operation(operationId = "loadCreditEntity")
    @GetMapping(value = "/Load/{id}", produces = "application/json")
    public ResponseEntity<CreditEntityDTO> load(@PathVariable Long id) {
        CreditEntityDTO creditEntity = creditEntityService.load(id);
        return new ResponseEntity<>(creditEntity,HttpStatus.OK);
    }


    @Override
    @Operation(operationId = "getAllCreditEntity")
    @GetMapping(value = "/GetAll", produces = "application/json")
    public ResponseEntity<List<CreditEntityDTO>> getAll() throws Exception {
        List<CreditEntityDTO> creditEntities = creditEntityService.getAll();
        return new ResponseEntity<>(creditEntities,HttpStatus.OK);
    }


    @Override
    @Operation(operationId = "SaveCreditEntity")
    @PostMapping("/Save")
    public ResponseEntity<CreditEntityDTO> save(@RequestBody CreditEntityDTO creditEntity) throws Exception {
        CreditEntityDTO newCreditEntityDTO = creditEntityService.save(creditEntity) ;
        return new ResponseEntity<>(newCreditEntityDTO, HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<List<CreditEntityDTO>> saveAll(List<CreditEntityDTO> entities) throws Exception {
        return null;
    }

    @Override
    @Operation(operationId = "deleteCreditEntity")
    @DeleteMapping("/Delete/{id}")
    public void delete(@PathVariable Long id) {
        creditEntityService.delete(id);
    }



//    @Operation(operationId = "getAllCreditEntitiesDTO")
//    @GetMapping(value = "/GetAllDTO", produces = "application/json")
//    public ResponseEntity<List<CreditEntityDTO>> getCreditEntities() throws Exception {
//        List<CreditEntityDTO> creditEntities = creditEntityService.getCreditEntities();
//        return new ResponseEntity<>(creditEntities,HttpStatus.OK);
//    }

}
