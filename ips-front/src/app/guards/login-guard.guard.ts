import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const loginGuardGuard: CanActivateFn = (route, state) => {
  const router=inject(Router);
  if(localStorage.getItem('token')){
    router.navigate(['/home'])
    return true
  }
  return true ;
};
