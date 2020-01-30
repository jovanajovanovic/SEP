import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { TypePaymentsComponent } from './type-payments/type-payments.component';
import { PayingTypeComponent } from './paying-type/paying-type.component';
import { SubscriptionPlansComponent } from './subscription-plans/subscription-plans.component';
import { SubscriptionAgreementComponent } from './subscription-agreement/subscription-agreement.component';


const routes: Routes = [
  {
    path: '',
    component: HomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegisterComponent
  },
  {
    path: 'typePayments',
    component: TypePaymentsComponent
  },
  {
    path: 'payment-method/:token',
    component: PayingTypeComponent
  },
  {
    path: 'subscriptionPlans',
    component: SubscriptionPlansComponent
  },
  {
    path: 'subscription-agreement/:token',
    component: SubscriptionAgreementComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
