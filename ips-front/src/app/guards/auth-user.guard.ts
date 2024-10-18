import { inject } from '@angular/core';
import { CanActivateFn, Router } from '@angular/router';

export const authUserGuard: CanActivateFn = (route, state) => {
  if(localStorage.getItem('token')){

    return true
  }
  return false ;
};
