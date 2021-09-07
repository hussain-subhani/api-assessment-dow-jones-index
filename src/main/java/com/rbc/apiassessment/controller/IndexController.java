package com.rbc.apiassessment.controller;

import com.rbc.apiassessment.model.Index;
import com.rbc.apiassessment.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Validated
@RequestMapping(value = "/api/v1/index")
@Slf4j
public class IndexController {

    @Autowired
    IndexService indexService;

    @GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getIndexesByStock(@RequestParam(value="stock", required = true) String stock){
        return ResponseEntity.ok().body(indexService.getIndexByStock(stock));
    }

    @PostMapping(value = "")
    public ResponseEntity<?> addIndexRecord(@Valid @RequestBody Index index){
        try{
            indexService.addIndexRecord(index);
            return ResponseEntity.ok().build();
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(ex);
        }
    }

    @PostMapping(value = "/bulk")
    public ResponseEntity<?> bulkUploadIndexRecords(@RequestBody String encodedCSV){
        try{
            indexService.bulkUploadIndexRecords(encodedCSV);
            return ResponseEntity.ok().build();
        } catch (Exception ex){
            return ResponseEntity.badRequest().body(ex);
        }
    }
}
