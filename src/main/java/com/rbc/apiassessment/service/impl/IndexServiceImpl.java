package com.rbc.apiassessment.service.impl;

import com.rbc.apiassessment.entity.IndexEntity;
import com.rbc.apiassessment.mapper.IndexMapper;
import com.rbc.apiassessment.model.Index;
import com.rbc.apiassessment.repository.IndexRepository;
import com.rbc.apiassessment.service.IndexService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Base64Utils;

import java.io.BufferedReader;
import java.io.StringReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
@Slf4j
public class IndexServiceImpl implements IndexService {

    @Autowired
    private IndexRepository indexRepository;

    @Autowired
    private IndexMapper indexMapper;

    @Override
    public List<Index> getIndexByStock(String stock) {

        Optional<List<IndexEntity>> indexEntities = indexRepository.findByStock(stock);

        if(indexEntities.isPresent()==false) {
            log.info("No Index Found for Stock [{}]", stock);
            return Collections.emptyList();
        }

        List<IndexEntity> indexList = indexEntities.get();
        log.info("[{}] records found for Stock [{}]", indexList.size(),stock);
        return indexMapper.toIndexes(indexList);
    }

    @Override
    public void addIndexRecord(Index index) {
        IndexEntity indexEntity = indexRepository.save(indexMapper.toIndexEntity(index));
        log.info("Index Saved [{}]", indexEntity.getId());
    }

    @Override
    public void bulkUploadIndexRecords(String encodedData) {
        try {
            List<Index> indexList = parseEncodedCSVData(encodedData);
            List<IndexEntity> indexEntities = indexMapper.toIndexEntities(indexList);
            indexRepository.saveAll(indexEntities);
            log.info("Saved [{}] Index Records", indexEntities.size());
        } catch (Exception e) {
           log.debug(e.toString());
        }
    }

    private List<Index> parseEncodedCSVData(String encodedData){
        byte[] decodedBytes = Base64Utils.decode(encodedData.getBytes());
        String decodedString = new String(decodedBytes);
        Pattern pattern = Pattern.compile(",");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("M/d/yyyy");
        BufferedReader reader = new BufferedReader(new StringReader(decodedString));
        List<Index> indexList = reader.lines().skip(1).map(line -> {
            String[] index = pattern.split(line);
            return new Index(
                    Integer.parseInt(numberParsePreCheck(index[0])),
                    index[1],
                    LocalDate.parse(index[2],formatter),
                    index[3],
                    index[4],
                    index[5],
                    index[6],
                    Long.parseLong(numberParsePreCheck(index[7])),
                    Double.parseDouble(numberParsePreCheck(index[8])),
                    Double.parseDouble(numberParsePreCheck(index[9])),
                    Long.parseLong(numberParsePreCheck(index[10])),
                    index[11],
                    index[12],
                    Double.parseDouble(numberParsePreCheck(index[13])),
                    Integer.parseInt(numberParsePreCheck(index[14])),
                    Double.parseDouble(numberParsePreCheck(index[15])));
        }).collect(Collectors.toList());
        log.info("Parsed [{}] Index Records", indexList.size());
        return indexList;
    }

    private String numberParsePreCheck(String value){
        if(value == null || value.isEmpty()) {
            return "0";
        }
        return value;
    }
}
