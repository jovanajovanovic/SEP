import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { PaymentSuccessComponent } from './component/payment-success/payment-success.component';
import { PaymentFailedComponent } from './component/payment-failed/payment-failed.component';
import { PaymentErrorComponent } from './component/payment-error/payment-error.component';


const routes: Routes = [
  { path: 'payment-success/:transaction-id', component: PaymentSuccessComponent },
  { path: 'payment-failed/:transaction-id', component: PaymentFailedComponent },
  { path: 'payment-error/:transaction-id', component: PaymentErrorComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
