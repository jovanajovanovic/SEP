package rs.ac.uns.ftn.bank_service.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@Data
public class CardPaymentRequestDTO {
    @NotNull
    private String merchantUsername;
    @NotNull
    private String merchantOrderId;
    @Positive
    private Double amount;

}