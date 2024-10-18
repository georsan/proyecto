import { Component } from '@angular/core';
import { FormBuilder, FormGroup, ReactiveFormsModule, Validators } from '@angular/forms';
import { AuthService } from '../../service/auth.service';
import { CommonModule } from '@angular/common';
import { DepartamentService } from '../../service/departament.service';
import { Departament } from '../../interfaces/departament';
import { Route, Router, RouterLink } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [ReactiveFormsModule,CommonModule,RouterLink],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {
  registerForm!:FormGroup;
  hasErrorRegister:boolean=false;
  departaments?:Departament[];

  constructor(private readonly fb:FormBuilder,private readonly authService:AuthService,private readonly departamentService:DepartamentService,private readonly route:Router){
    this.registerForm=this.initForm();
  }

  ngOnInit(){
    this.departamentService.getAllDepartament().subscribe(departaments=>{
      this.departaments=departaments
    })
    
  }



  private  initForm():FormGroup{

    return this.fb.group({
      username:['',[Validators.required,Validators.email]],
      password:['',[Validators.required,Validators.pattern('^(?=\\w*\\d)(?=\\w*[A-Z])(?=\\w*[a-z])\\S{8,16}$')]],
      first_name: ['',[Validators.required,]],
      last_name: ['',[Validators.required,]],
      age: ['',[Validators.required,Validators.pattern('^(100|[1-9]?[0-9])$')]],
      id_address:['',[Validators.required]]
    })


  }

  register(){
    if(this.registerForm.valid){
      this.authService.register(this.registerForm.value).subscribe({
        next:(data)=>{
         localStorage.setItem('token',data.toLocaleString())
         this.route.navigate(['/home']);
        },
        error:()=>{
          this.hasErrorRegister=true;
        }
      });
    }
  }
}
