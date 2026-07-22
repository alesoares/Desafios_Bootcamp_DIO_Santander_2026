
package com.dio.budgeting.infrastructure.persistence.repository;


import org.springframework.data.repository.CrudRepository;

import com.dio.budgeting.domain.enums.Category;
import com.dio.budgeting.infrastructure.persistence.entity.TransactionEntity;

import java.util.List;
import java.util.UUID;

public interface TransactionEntityRepository extends CrudRepository<TransactionEntity, UUID> {
    
	List<TransactionEntity> findAllByCategory(Category category);

}
