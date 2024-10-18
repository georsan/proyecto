import { Routes } from '@angular/router';
import { authUserGuard } from './guards/auth-user.guard';
import { loginGuardGuard } from './guards/login-guard.guard';

export const routes: Routes = [
    {
        path:'login',
        canActivate:[loginGuardGuard],
        loadComponent:()=>import('./pages/login/login.component').then(c=>c.LoginComponent)
    },
    {
        path:'register',
        canActivate:[loginGuardGuard],
        loadComponent:()=>import('./pages/register/register.component').then(c=>c.RegisterComponent)
    },
    {
        path:'home',
        canActivate:[authUserGuard],
        loadComponent:()=>import('./pages/home/home.component').then(c=>c.HomeComponent)
    },
    {
        path:'**',
        redirectTo:'login',
        pathMatch:'full'
    }
];
