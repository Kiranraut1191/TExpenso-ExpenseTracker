import { Routes } from '@angular/router';
import { LoginComponent } from './user/login/login.component';
import { RegisterComponent } from './user/register/register.component';
import { HomeComponent } from './user/home/home.component';
import { DeleteUserComponent } from './user/delete/delete-user.component';
import { UserdetailsComponent } from './userdetails/userdetails.component';
import { SendComponent } from './user/send/send.component';
import { ReciveComponent } from './user/recive/recive.component';
import { AlltrancComponent } from './user/alltranc/alltranc.component';
import { BalanceComponent } from './user/balance/balance.component';
import { GetdatesComponent } from './user/alltranc/getdates/getdates.component';
import { AllusersComponent } from './allusers/allusers.component';

import { AuthGuard } from './guards/auth.guard'; // ✅ updated import path

export const routes: Routes = [
  { path: '', redirectTo: 'login', pathMatch: 'full' }, // ✅ Default redirect
  { path: 'login', component: LoginComponent },
  { path: 'register', component: RegisterComponent },

  // ✅ Protected routes below
  { path: 'home', component: HomeComponent, canActivate: [AuthGuard] },
  { path: 'delete', component: DeleteUserComponent, canActivate: [AuthGuard] },
  { path: 'userdetails', component: UserdetailsComponent, canActivate: [AuthGuard] },
  { path: 'send', component: SendComponent, canActivate: [AuthGuard] },
  { path: 'recive', component: ReciveComponent, canActivate: [AuthGuard] },
  { path: 'alltranc', component: AlltrancComponent, canActivate: [AuthGuard] }, // ✅ Renamed from trancaction
  { path: 'balance', component: BalanceComponent, canActivate: [AuthGuard] },
  { path: 'getdates', component: GetdatesComponent, canActivate: [AuthGuard] },
  { path: 'allusers', component: AllusersComponent, canActivate: [AuthGuard] },

  // Optional: wildcard to redirect unknown routes
  { path: '**', redirectTo: 'login' }
];
