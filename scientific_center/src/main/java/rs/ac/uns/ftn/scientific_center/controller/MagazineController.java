package rs.ac.uns.ftn.scientific_center.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import rs.ac.uns.ftn.scientific_center.dto.CompletePaymentDTO;
import rs.ac.uns.ftn.scientific_center.dto.MagazineDTO;
import rs.ac.uns.ftn.scientific_center.dto.request.SubscribeRequest;
import rs.ac.uns.ftn.scientific_center.dto.response.PaymentOrderResponse;
import rs.ac.uns.ftn.scientific_center.dto.response.SimpleResponse;
import rs.ac.uns.ftn.scientific_center.service.MagazineService;

import java.util.List;

@RequestMapping(value = "/magazine")
@RestController
public class MagazineController {

    @Autowired
    private MagazineService magazineService;

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<MagazineDTO>> getAllMagazines(){
        return ResponseEntity.ok().body(magazineService.getAllMagazines());
    }

    @RequestMapping(value = "/{magazineId}", method = RequestMethod.GET)
    public ResponseEntity<MagazineDTO> getMagazine(@PathVariable Long magazineId){
        return ResponseEntity.ok().body(magazineService.getMagazine(magazineId));
    }
    
    @RequestMapping(value = "/subscribe", method = RequestMethod.POST)
    public ResponseEntity<PaymentOrderResponse> subscribe(@RequestBody SubscribeRequest subscribeRequest){
        return ResponseEntity.ok().body(magazineService.subscribe(subscribeRequest));
    }
    
    @RequestMapping(value = "/complete-subscribe", method = RequestMethod.POST)
    public ResponseEntity<SimpleResponse> completeSubscribe(@RequestBody CompletePaymentDTO completePaymentDTO){
        return ResponseEntity.ok().body(magazineService.completePayment(completePaymentDTO));
    }

}
