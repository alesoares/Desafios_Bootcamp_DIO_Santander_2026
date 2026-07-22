
package com.dio.budgeting.application.services;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import com.dio.budgeting.application.services.input.PersistTransactionInput;
import com.dio.budgeting.application.services.output.TransactionOutput;
import com.dio.budgeting.domain.Transaction;
import com.dio.budgeting.domain.interfaces.TransactionRepository;

@Service
public class PersistTransactionUseCase {

    private final TransactionRepository transactionRepository;

    public PersistTransactionUseCase(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Tool(name = "persist-transaction", description = "Persiste uma nova transação financeira")
    public TransactionOutput execute(PersistTransactionInput input) {

    	var transaction = transactionRepository.save(
                new Transaction(input.description(), input.amount(), input.category()));

        return TransactionOutput.from(transaction);
    }
}
