import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { SERVER_URL } from '../app.constant';

@Injectable({
    providedIn: 'root'
  })
  export class PayPalService {

    constructor(private http:HttpClient){

    }

    saveUserData(user:any){
        return this.http.post(SERVER_URL + '/api-paypal/saveData',user,{responseType: 'text'});
    }

    createOrder(user:any){
      return this.http.post(SERVER_URL + '/api-paypal/pay',user);
    }

    completePayment(complete:any){
      return this.http.post(SERVER_URL + '/api-paypal/complete',complete);
    }

    cancelPayment(username:any){
      return this.http.get(SERVER_URL + '/api-paypal/cancelData/'+username);
    }
}