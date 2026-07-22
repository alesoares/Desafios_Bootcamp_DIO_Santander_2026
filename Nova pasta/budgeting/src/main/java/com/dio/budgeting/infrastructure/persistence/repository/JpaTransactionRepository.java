
package com.dio.budgeting.infrastructure.persistence.repository;


import org.springframework.stereotype.Repository;

import com.dio.budgeting.domain.Transaction;
import com.dio.budgeting.domain.enums.Category;
import com.dio.budgeting.domain.interfaces.TransactionRepository;
import com.dio.budgeting.infrastructure.persistence.entity.TransactionEntity;

import java.util.List;

@Repository
public class JpaTransactionRepository implements TransactionRepository {
    private final TransactionEntityRepository transactionEntityRepository;

    public JpaTransactionRepository(TransactionEntityRepository transactionEntityRepository) {
        this.transactionEntityRepository = transactionEntityRepository;
    }

    @Override
    public Transaction save(Transaction transaction) {
        var entity = TransactionEntity.from(transaction);
        return transactionEntityRepository.save(entity).toDomain();
    }

    @Override
    public List<Transaction> findAllByCategory(Category category) {
        return transactionEntityRepository.findAllByCategory(category)
                .stream()
                .map(TransactionEntity::toDomain)
                .toList();
    }
}
