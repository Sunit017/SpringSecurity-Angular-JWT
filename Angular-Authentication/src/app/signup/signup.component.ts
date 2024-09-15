import { Component } from '@angular/core';
import { AuthService } from '../service/auth.service';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.css']
})
export class SignupComponent {

  signupForm:FormGroup|undefined

  constructor(private service:AuthService,
    private fb:FormBuilder){
  }

  ngOnInit(){
    this.signupForm=this.fb.group({
      name:['',Validators.required],
      email:['',[Validators.required,Validators.email]],
      password:['',Validators.required],
      confirmPassword:['',Validators.required]

  }, {validators:this.passwordMatchValidator})
  }
  private passwordMatchValidator(fg:FormGroup){
    const password=fg.get('password')?.value;
    const confirmmPassword=fg.get('confirmPassword')?.value;
    if(password != confirmmPassword)
    {
      fg.get("confirmPassword")?.setErrors({passwordMismatch:true});
    }
    else
    {
      fg.get("confirmPassword")?.setErrors(null);
    }
  }
  signup(){
    console.log(this.signupForm.value);
    this.service.signup(this.signupForm.value).subscribe((response) =>{
      console.log(response);
      
    })
    
  }

}
