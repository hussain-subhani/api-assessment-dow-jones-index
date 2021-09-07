package com.rbc.apiassessment.mapper.impl;

import com.rbc.apiassessment.entity.IndexEntity;
import com.rbc.apiassessment.mapper.IndexMapper;
import com.rbc.apiassessment.model.Index;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class IndexMapperImpl implements IndexMapper {

    @Override
    public IndexEntity toIndexEntity(Index index) {
        IndexEntity indexEntity = new IndexEntity();
        indexEntity.setQuarter(index.getQuarter());
        indexEntity.setStock(index.getStock());
        indexEntity.setDate(index.getDate());
        indexEntity.setOpen(Double.parseDouble(index.getOpen().substring(1)));
        indexEntity.setHigh(Double.parseDouble(index.getHigh().substring(1)));
        indexEntity.setLow(Double.parseDouble(index.getLow().substring(1)));
        indexEntity.setClose(Double.parseDouble(index.getClose().substring(1)));
        indexEntity.setVolume(index.getVolume());
        indexEntity.setPercentChangePrice(index.getPercentChangePrice());
        indexEntity.setPercentChangeVolumeOverLastWeek(index.getPercentChangeVolumeOverLastWeek());
        indexEntity.setPreviousWeeksVolume(index.getPreviousWeeksVolume());
        indexEntity.setNextWeeksOpen(Double.parseDouble(index.getNextWeeksOpen().substring(1)));
        indexEntity.setNextWeeksClose(Double.parseDouble(index.getNextWeeksClose().substring(1)));
        indexEntity.setPercentChangeNextWeeksPrice(index.getPercentChangeNextWeeksPrice());
        indexEntity.setPercentChangeNextWeeksPrice(index.getPercentChangeNextWeeksPrice());
        indexEntity.setDaysToNextDividend(index.getDaysToNextDividend());
        indexEntity.setPercentReturnNextDividend(index.getPercentReturnNextDividend());
        return indexEntity;
    }

    @Override
    public Index toIndex(IndexEntity indexEntity) {
        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        Index index = new Index();
        index.setQuarter(indexEntity.getQuarter());
        index.setStock(indexEntity.getStock());
        index.setDate(indexEntity.getDate());
        index.setOpen(formatter.format(indexEntity.getOpen()));
        index.setHigh(formatter.format(indexEntity.getHigh()));
        index.setLow(formatter.format(indexEntity.getLow()));
        index.setClose(formatter.format(indexEntity.getClose()));
        index.setVolume(indexEntity.getVolume());
        index.setPercentChangePrice(indexEntity.getPercentChangePrice());
        index.setPercentChangeVolumeOverLastWeek(indexEntity.getPercentChangeVolumeOverLastWeek());
        index.setPreviousWeeksVolume(indexEntity.getPreviousWeeksVolume());
        index.setNextWeeksOpen(formatter.format(indexEntity.getNextWeeksOpen()));
        index.setNextWeeksClose(formatter.format(indexEntity.getNextWeeksClose()));
        index.setPercentChangeNextWeeksPrice(indexEntity.getPercentChangeNextWeeksPrice());
        index.setPercentChangeNextWeeksPrice(indexEntity.getPercentChangeNextWeeksPrice());
        index.setDaysToNextDividend(indexEntity.getDaysToNextDividend());
        index.setPercentReturnNextDividend(indexEntity.getPercentReturnNextDividend());
        return index;
    }

    @Override
    public List<IndexEntity> toIndexEntities(List<Index> index) {
        return Optional.ofNullable(index)
                .orElseGet(Collections::emptyList).stream().map(this::toIndexEntity).collect(Collectors.toList());
    }

    @Override
    public List<Index> toIndexes(List<IndexEntity> indexEntity) {
        return Optional.ofNullable(indexEntity)
                .orElseGet(Collections::emptyList).stream().map(this::toIndex).collect(Collectors.toList());
    }
}
