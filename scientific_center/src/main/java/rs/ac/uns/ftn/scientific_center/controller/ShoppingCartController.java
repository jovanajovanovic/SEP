package rs.ac.uns.ftn.scientific_center.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import rs.ac.uns.ftn.scientific_center.dto.PricelistItemDTO;
import rs.ac.uns.ftn.scientific_center.dto.request.PaymentOrderRequest;
import rs.ac.uns.ftn.scientific_center.dto.response.PaymentOrderResponse;
import rs.ac.uns.ftn.scientific_center.dto.response.SimpleResponse;
import rs.ac.uns.ftn.scientific_center.service.ShoppingCartService;

import java.util.Set;


@RequestMapping(value = "/shopping-cart")
@RestController
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    @RequestMapping(value = "/add-item/{magazineId}", method = RequestMethod.POST)
    public ResponseEntity<SimpleResponse> addItem(@PathVariable("magazineId") Long magazineId){
        try{
            shoppingCartService.addItem(magazineId);
        }
        catch (NullPointerException e){
            return ResponseEntity.badRequest().body(new SimpleResponse(false, "Something went wrong."));
        }
        return ResponseEntity.ok(new SimpleResponse("Item successfully added."));
    }

    @RequestMapping(value = "/items", method = RequestMethod.GET)
    public ResponseEntity<Set<PricelistItemDTO>> getItems(){
        try{
            return ResponseEntity.ok(shoppingCartService.getItems());
        }
        catch (NullPointerException e){
            return ResponseEntity.badRequest().body(null);
        }

    }

    @RequestMapping(value = "/pay", method = RequestMethod.POST)
    public ResponseEntity<PaymentOrderResponse> pay(@RequestBody PaymentOrderRequest paymentOrderRequest){
        PaymentOrderResponse paymentOrderResponse = shoppingCartService.pay(paymentOrderRequest);
        return ResponseEntity.ok().body(paymentOrderResponse);
    }

}