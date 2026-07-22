
package com.dio.budgeting.application.services.input;


import org.springframework.ai.tool.annotation.ToolParam;

import com.dio.budgeting.domain.enums.Category;

public record PersistTransactionInput(

		@ToolParam(description = "Descrição do gasto") String description,

		@ToolParam(description = "Valor do gasto (em centavos)") long amount,

		@ToolParam(description = "Categoria de uma transação") Category category) {
}
