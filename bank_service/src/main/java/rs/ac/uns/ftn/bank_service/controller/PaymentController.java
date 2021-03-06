package rs.ac.uns.ftn.bank_service.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.bank_service.dto.*;
import rs.ac.uns.ftn.bank_service.model.TransactionStatus;
import rs.ac.uns.ftn.bank_service.service.PaymentService;

@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Value("${client.port}")
    private Long clientPort;

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ResponseEntity<CardPaymentResponseDTO> createPaymentRequest(@RequestBody CardPaymentRequestDTO cardPaymentRequestDTO){
        return ResponseEntity.ok(paymentService.createPaymentRequest(cardPaymentRequestDTO));
    }

    @RequestMapping(value = "/payment-success/{transaction-id}", method = RequestMethod.PUT)
    public ResponseEntity<SimpleResponseDTO> paymentSuccess(@PathVariable("transaction-id") String transactionId){
        return ResponseEntity.ok().body(paymentService.completePayment(transactionId, TransactionStatus.SUCCESS));
    }

    @RequestMapping(value = "/payment-failed/{transaction-id}", method = RequestMethod.PUT)
    public ResponseEntity<SimpleResponseDTO> paymentFailed(@PathVariable("transaction-id") String transactionId){
        return ResponseEntity.ok().body(paymentService.completePayment(transactionId, TransactionStatus.FAILED));
    }

    @RequestMapping(value = "/payment-error/{transaction-id}", method = RequestMethod.PUT)
    public ResponseEntity<SimpleResponseDTO> paymentError(@PathVariable("transaction-id") String transactionId){
        return ResponseEntity.ok().body(paymentService.completePayment(transactionId, TransactionStatus.ERROR));
    }
    
    @RequestMapping(value = "/payment-registration", method = RequestMethod.POST)
    public ResponseEntity<SimpleResponseDTO> paymentRegistration(@RequestBody PaymentRegistrationDTO paymentRegistrationDTO){
        return ResponseEntity.ok().body(paymentService.paymentRegistration(paymentRegistrationDTO));
    }

    @RequestMapping(value = "/frontendPort", method = RequestMethod.GET)
    public Long getClientPort(){
        return clientPort;
    }

    @RequestMapping(value = "/unfinished-transactions-check", method = RequestMethod.GET)
    public ResponseEntity<SimpleResponseDTO> unfinishedTransactionsCheck(){
        paymentService.unfinishedTransactionsCheck();
        return ResponseEntity.ok().body(new SimpleResponseDTO("Checked"));
    }

}
