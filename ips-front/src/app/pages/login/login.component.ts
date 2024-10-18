import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { take } from 'rxjs';
import { RouterLink } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule,RouterLink],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {
  loginForm!:FormGroup;
  hasErrorlogin:boolean=false;

  constructor(private readonly fb:FormBuilder,private readonly authService:AuthService){
    this.loginForm=this.initForm();
  }



  private  initForm():FormGroup{

    return this.fb.group({
      username:['',[Validators.required,Validators.email]],
      password:['',[Validators.required]]
    })


  }

  login(){
    if(this.loginForm.valid){
      this.authService.login(this.loginForm.value).subscribe({
        next:(data)=>{
          console.log(data)
        },
        error:()=>{
          this.hasErrorlogin=true;
        }
      });
    }
  }

}
