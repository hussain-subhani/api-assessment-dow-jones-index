package com.rbc.apiassessment.mapper;

import com.rbc.apiassessment.entity.IndexEntity;
import com.rbc.apiassessment.model.Index;

import java.util.List;

public interface IndexMapper {

    IndexEntity toIndexEntity(Index index);
    Index toIndex (IndexEntity indexEntity);

    List<IndexEntity> toIndexEntities (List<Index> index);
    List<Index> toIndexes (List<IndexEntity> indexEntity);
}
