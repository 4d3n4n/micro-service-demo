package org.example.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoanDto {
    private Long id;
    private Double amount;
    private String type;
    private Long accountId;
}
