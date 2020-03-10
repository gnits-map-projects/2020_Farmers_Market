import React, { Component } from "react";
import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Navigation from './Nav.js';
import Form from 'react-bootstrap/Form';
import TandC from './tandc.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

var result;
var body;
const validEmailRegex = RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);
const validMobileRegex = RegExp(/^[6-9]{1}[0-9]{9}$/);

export default class Signup extends Component {
constructor(props) {
super(props);
this.handleNameChange = this.handleNameChange.bind(this);
this.handleEmailChange = this.handleEmailChange.bind(this);
this.handlePasswordChange = this.handlePasswordChange.bind(this);
this.handleMobileChange = this.handleMobileChange.bind(this);
this.handleRoleChange = this.handleRoleChange.bind(this);
this.handleSubmit = this.handleSubmit.bind(this);
this.validateForm = this.validateForm.bind(this);
this.state = {
n:false,
e:false,
p:false,
m:false,
r:false,
name: "",
email:"",
password: "",
mobile:"",
role:"",
errors: {
name: '',
email: '',
password: '',
mobile : '',
role : '',
}
//confirmPassword: ""
};

}
validateForm() {
return this.state.name.length > 0 && this.state.passwordd.length > 5 ;
}


handleNameChange = event => {
    const { name, value } = event.target;
    let errors = this.state.errors;
    errors.name = value.length < 5 ? 'Full Name must be 5 characters long!' : '';
    if(errors.name == '')
    {
        this.setState({n : true});
    }
    this.setState({errors, [name]: value});
}

handleEmailChange = event => {
const { name, value } = event.target;
let errors = this.state.errors;
errors.email =
validEmailRegex.test(value)
? ''
: 'Email is not valid!';
if(errors.email == '')
{
this.setState({e : true});
}
this.setState({errors, [name]: value});
}

handlePasswordChange = event => {
const { name, value } = event.target;
let errors = this.state.errors;
errors.password =
value.length < 8
? 'Password must be 8 characters long!'
: '';
if(errors.password == '')
{
this.setState({p : true});
}
this.setState({errors, [name]: value});
}

handleMobileChange = event => {
const { name, value } = event.target;
let errors = this.state.errors;
errors.mobile =
(validMobileRegex.test(value))
? ''
: 'Enter a valid phone number!';
if(errors.mobile== '')
{
this.setState({m : true});
}
this.setState({errors, [name]: value});
}
handleRoleChange(event) {
this.setState({
role: event.target.value,
r : true
});
}


handleSubmit(event) {
event.preventDefault();
var body = {
name : this.state.name,
email : this.state.email,
password : this.state.password,
mobile : this.state.mobile,
role : this.state.role
}
console.log(body);
if(this.state.name==""){
alert('Please enter the name')
}
else if(this.state.email==""){
alert('Please enter the email')
}
else if(this.state.password==""){
alert('Please enter the password')
}
else if(this.state.mobile==""){
alert('Please enter the phone number')
}

else if(this.state.role==""){
alert('Please enter the role')
}

else{
    console.log(this.state)
if(this.state.r == true && this.state.n == true && this.state.e == true && this.state.m == true && this.state.p == true){
console.log(this.state)
const url = "http://localhost:9000/register";
let headers = new Headers();
headers.append('Content-Type','application/json');
headers.append('Accept','application/json');
headers.append('Access-Control-Allow-origin',url);
headers.append('Access-Control-Allow-Credentials','true');
headers.append('POST','GET');
fetch(url, {
headers:headers,
method: 'POST',
body: JSON.stringify(body)
})
.then(response => {if(response.ok){
    alert("Registration successful!");
    result = response.json();
    console.log(result);
}})
.catch(()=> console.log("can't access " + url + " response. "))

//this.props.history.push("/login");
window.location.href = '/login'
}
}

}

render() {
const {errors} = this.state;
return (<div className ="bg">
<Navigation/>

<br></br><br/>
<br/><br/><br/><br/>
<Row>
<Col>
    <TandC/>
</Col>
<Col>

<div className="auth-wrapper1">
<div className="auth-inner">
<form>
<center><h3>Sign Up</h3></center>
 
    <div className="form-group">
        <label>Name</label>
        <input type="name" name="name" id="examplename" className="form-control" placeholder="Enter name" value = {this.state.name} onChange = {this.handleNameChange} required/>
        <span className='error'>{errors.name}</span>
    </div>

    <div className="form-group">
        <label>Email address</label>
        <input type="email" name="email" id="exampleEmail" className="form-control" placeholder="mygmail@gmail.com" value = {this.state.email}  onChange = {this.handleEmailChange} required/>
        <span className='error'>{errors.email}</span>
    </div>

    <div className="form-group">
        <label>Mobile</label>
        <input type="phone" name="mobile" className="form-control" id="examplePhone" placeholder="Enter mobile number" value = {this.state.phoneNumber} onChange = {this.handleMobileChange} required/>
        <span className='error'>{errors.mobile}</span>
    </div>

    <div key={'inline-radio'} className='form-group'>
        <Form.Label>Role</Form.Label><br />
        <Form.Check inline type='radio' name='role' value='farmer' label='Farmer' onChange={this.handleRoleChange} />
        <Form.Check inline type='radio' name='role' value='buyer' label='Buyer' onChange={this.handleRoleChange} />
    </div>

    <div className="form-group">
        <label>Password</label>
        <input type="password" name="password" id="examplePassword" placeholder="********" className="form-control" value = {this.state.psw} onChange = {this.handlePasswordChange} required/>
        <span className='error'>{errors.password}</span>
    </div>
    <button type="submit" className="btn btn-primary btn-block" onClick = {this.handleSubmit}>SIGN UP</button>
    <p className="forgot-password text-right"> Already registered? <a href="/Login">Login</a></p>
    </form>
</div>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
</div>
</Col>
</Row>
</div>
);
}
}

// import React, { Component } from "react";
// //import { useHistory, withRouter,Link } from "react-router-dom";
// import './home.css';
// import Navigation from './Nav.js';
// import Form from 'react-bootstrap/Form';

// var body;

// export default class SignUp extends Component {
//   constructor(props) {
//     super(props)

//     this.state = {
//       name: "",
//       email:"",
//       password: "",
//       mobile: "",
//       role:""
      
//     }
//     this.handleNameChange = this.handleNameChange.bind(this);
//     this.handleEmailChange = this.handleEmailChange.bind(this);
//     this.handlePasswordChange = this.handlePasswordChange.bind(this);
//     this.handleMobileChange = this.handleMobileChange.bind(this);
//     this.handleRoleChange = this.handleRoleChange.bind(this)
//     this.handleSubmit = this.handleSubmit.bind(this);
//     this.validateForm = this.validateForm.bind(this);

//   }
//   validateForm() {
//     return this.state.username.length > 3 && this.state.password.length > 5 && this.state.password == this.state.confirmPassword;
//   }

//   handleNameChange = event => {
//     this.setState({
//       name: event.target.value
//     });
//   }

//   handleEmailChange = event => {
//     this.setState({
//       email: event.target.value
//     });
//   }

//   handlePasswordChange = event => {
//     this.setState({
//       password: event.target.value
//     });
//   }

//   handleMobileChange = event => {
//     this.setState({
//       mobile: event.target.value
//     });
//   }

//   handleRoleChange = event => {
//     this.setState({
//       role: event.target.value
//     });
//   }



//   handleSubmit(event) {
//     event.preventDefault();
//     body = {
//       name: this.state.name,
//       password: this.state.password,
//       email: this.state.email,
//       mobile: this.state.mobile,
//       role: this.state.role
//      //confirmPassword: this.state.confirmPassword,
//     }
//     console.log(body);
//     if (this.state.name == "") {
//       alert('Please enter the first name')
//     }


//     else if (this.state.email == "") {
//       alert('Please enter the email')
//     }

//     else if (this.state.password == "") {
//       alert('Please enter the password')
//     }

//     else if (this.state.mobile == "") {
//       alert('Please enter the number')

//     }

//     else if (this.state.role == "") {
//       alert('Please enter the role')

//     }

//     else {
//       const url = "http://localhost:9000/register";
//       let headers = new Headers();

//       headers.append('Content-Type', 'application/json');
//       headers.append('Accept', 'application/json');

//       headers.append('Access-Control-Allow-origin', url);
//       headers.append('Access-Control-Allow-Credentials', 'true');

//       headers.append('POST', 'GET');

//       fetch(url, {
//         headers: headers,
//         method: 'POST',
//         body: JSON.stringify(body)
//       })

         
//         .then(response => response.json())
//         .then(contents => {
//           console.log(contents);

//         })
//         .catch(() => console.log("can't access" + url + "response."))
        
//         window.location.href = '/login'
//         alert("successful");

//     }
    
//   }

//     render() {
//         return (<div className ="bg">
            
//             <Navigation/>

//             <br></br><br/>
//             <br/>
           

//             <div className="auth-wrapper">
//             <div className="auth-inner">
//             <Form onSubmit={this.handleSubmit}>
//                 <h3>Sign Up</h3>

//                 <div className="form-group">
//                     <label>Name</label>
//                     <input type="name"
//                 name="name"
//                 id="examplename"
//                 className="form-control"
//                 placeholder="Enter name"
                
//                 value = {this.state.name} 
//                                     onChange = {this.handleNameChange} />
//                 </div>

//                 <div className="form-group">
//                     <label>Email address</label>
//                     <input type="email"
//                 name="email"
//                 id="exampleEmail"
//                 className="form-control"
//                 placeholder="mygmail@gmail.com"
               
//                 value = {this.state.email} 
//                                     onChange = {this.handleEmailChange} />
//                 </div>

//                 <div className="form-group">
//                     <label>Mobile</label>
//                     <input type="phone" name="mobile" className="form-control" id="examplePhone" 
//                     placeholder="Enter mobile number"
//                     value = {this.state.mobile}
//                     onChange = {this.handleMobileChange} />
//                 </div>


//               <div key={'inline-radio'} className='form-group'>
//                 <Form.Label>Role</Form.Label><br />
//                 <Form.Check inline type='radio' name='role' value='farmer' label='Farmer' onChange={this.handleRoleChange} />
//                 <Form.Check inline type='radio' name='role' value='buyer' label='Buyer' onChange={this.handleRoleChange} />
//               </div>


//                 <div className="form-group">
//                     <label>Password</label>
//                     <input type="password"
//                 name="password"
//                 id="examplePassword"
//                 placeholder="********"
//                 className="form-control"
                
//                 value = {this.state.password} 
//                                     onChange = {this.handlePasswordChange} />
//                 </div>

//                 <button type="submit" className="btn btn-primary btn-block" onClick = {this.handleSubmit}>Sign Up</button>
//                 <p className="forgot-password text-right">
//                     Already registered <a href="/Login">Login?</a>
//                 </p>
//             </Form>
//             </div>
//             <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
//             <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

//             </div>
//             <br/><br/><br/><br/><br/><br/><br/><br/></div>
//         );
//     }
// }