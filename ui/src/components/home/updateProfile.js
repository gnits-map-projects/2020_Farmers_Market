import React, { Component } from "react";
import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Nav from '../User/nav.js';
import Form from 'react-bootstrap/Form';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

var a=window.localStorage.getItem("name")
var b=window.localStorage.getItem("email")
var c=window.localStorage.getItem("mobile")
//var d=window.localStorage.getItem("role")
const validEmailRegex = RegExp(/^(([^<>()\[\]\.,;:\s@\"]+(\.[^<>()\[\]\.,;:\s@\"]+)*)|(\".+\"))@(([^<>()[\]\.,;:\s@\"]+\.)+[^<>()[\]\.,;:\s@\"]{2,})$/i);
const validMobileRegex = RegExp(/^[6-9]{1}[0-9]{9}$/);


class UpdateProfile extends Component {

  constructor(props) {
    super(props)
    this.state = {
      user : this.props.match.params.id,
      n:false,
      e:false,
      p:false,
      m:false,
      //r:false,
      name: a,
      email: b,
      mobile: c,
      //role: d,
      errors: {
          name: '',
          email: '',
          mobile : '',
          //role : '',
        }
    }

    this.handleNameChange = this.handleNameChange.bind(this)
    this.handleEmailChange = this.handleEmailChange.bind(this)
    this.handleMobileChange = this.handleMobileChange.bind(this)
    //this.handleRoleChange = this.handleRoleChange.bind(this)
    //this.handleImageChange = this.handleImageChange.bind(this)
    this.handleSubmit = this.handleSubmit.bind(this)

  }
  
  
handleNameChange = event => {
const { name, value } = event.target;
let errors = this.state.errors;
errors.name =
value.length < 5
? 'Full Name must be 5 characters long!'
: '';
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
// handleRoleChange(event) {
// this.setState({
// role: event.target.value,
// r : true
// });
// }

  
  /*handleImageChange = event => {
    this.setState({
      profilepic: event.target.value
    });
  }*/

  handleSubmit(event) {
    event.preventDefault();

    console.log(this.state)
    var body = {
        name : this.state.name,
        email : this.state.email,
        mobile : this.state.mobile,
        //role : this.state.role
      }
      //profilpic: this.state.profilepic,
    console.log(body);
     if(this.state.name==""){
        alert('Please enter the name')
        }
        else if(this.state.email==""){
        alert('Please enter the email')
        }
        else if(this.state.mobile==""){
        alert('Please enter the phone number')
        }

        // else if(this.state.role==""){
        // alert('Please enter the role')
        // }

    /*else if (this.state.image != '') {
      const allowedFiles = [".jpg", ".jpeg", ".png"];
      const regex = new RegExp("([a-zA-Z0-9\s_\\.\-:])+(" + allowedFiles.join('|') + ")$");
      if (!regex.test(this.state.image.toLowerCase())) {
        alert("Please upload files having extensions: .jpg or .jpeg or .png only.");
      }
    }*/

    else {
      const url = "http://localhost:9000/updateProfile/"+this.state.user;
      let headers = new Headers();

      headers.append('Content-Type', 'application/json');
      headers.append('Accept', 'application/json');

      headers.append('Access-Control-Allow-origin', url);
      headers.append('Access-Control-Allow-Credentials', 'true');

      headers.append('POST', 'GET');

      fetch(url, {
        headers: headers,
        method: 'POST',
        body: JSON.stringify(body)
      })
      .then(response => {if(response.ok){
        alert("Update successful. Re-Login required.")

    }
    else {
        alert("not successful")
    }
})
      //window.location.href = '/profile'
    }
  }


  render() {
      return (<div className ="bg">
<Nav uid={this.state.user} role={window.sessionStorage.getItem("role")}/>

<br></br><br/><br/>
<div className="auth-wrapper1">
<div className="auth-inner">
<form>
<center><h3>Update Profile</h3></center>
 
<div className="form-group">
<label>Name</label>
<input type="name"
name="name"
id="examplename"
className="form-control"
placeholder="Enter name"
value = {this.state.name}
onChange = {this.handleNameChange} required/>
<span className='error'>{this.state.errors.name}</span>
</div>

<div className="form-group">
<label>Email address</label>
<input type="email"
name="email"
id="exampleEmail"
className="form-control"
placeholder="mygmail@gmail.com"
value = {this.state.email}
onChange = {this.handleEmailChange} required/>
<span className='error'>{this.state.errors.email}</span>
</div>

<div className="form-group">
<label>Mobile</label>
<input type="phone" name="mobile" className="form-control" id="examplePhone"
placeholder="Enter mobile number"
value = {this.state.phoneNumber}
onChange = {this.handleMobileChange} required/>
<span className='error'>{this.state.errors.mobile}</span>
</div>

{/* <div key={'inline-radio'} className='form-group'>
<Form.Label>Role</Form.Label><br />
<Form.Check inline type='radio' name='role' value='farmer' label='Farmer' onChange={this.handleRoleChange} />
<Form.Check inline type='radio' name='role' value='buyer' label='Buyer' onChange={this.handleRoleChange} />
</div> */}


<button type="submit" className="btn btn-primary btn-block" onClick = {this.handleSubmit}>Update</button>

</form>
</div>

</div>
<br/><br/><br/><br/>
</div>
);
}

}

export default UpdateProfile;