
package com.dio.budgeting.infrastructure.http.request;

import com.dio.budgeting.application.services.input.PersistTransactionInput;
import com.dio.budgeting.domain.enums.Category;

public record TransactionRequest(String description, Category category, long amount) {
    
	public PersistTransactionInput toInput() {
        
		return new PersistTransactionInput(description, amount, category);
    
	}
}
