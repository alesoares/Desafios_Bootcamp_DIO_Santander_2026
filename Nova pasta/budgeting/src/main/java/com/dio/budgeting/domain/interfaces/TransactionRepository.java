
package com.dio.budgeting.domain.interfaces;


import java.util.List;

import com.dio.budgeting.domain.Transaction;
import com.dio.budgeting.domain.enums.Category;

public interface TransactionRepository {

	Transaction save(Transaction transaction);

	List<Transaction> findAllByCategory(Category category);

}
