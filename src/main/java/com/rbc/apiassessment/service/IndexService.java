package com.rbc.apiassessment.service;

import com.rbc.apiassessment.model.Index;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface IndexService {

    public List<Index> getIndexByStock(String stock);

    public void addIndexRecord(Index index);

    public void bulkUploadIndexRecords(String encodedData);
}
