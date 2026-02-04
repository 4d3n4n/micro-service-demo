package org.example.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDto {
    private Long id;
    private String name;
    private String email;
    private Integer solde;
    private List<CardDto> cards;
    private List<LoanDto> loans;
}
