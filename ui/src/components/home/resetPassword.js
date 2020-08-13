import React, { Component } from "react";
import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Navigation from './Nav.js';
import Form from 'react-bootstrap/Form';
import TandC from './tandcSU.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

var result;
var body;

export default class ResetPassword extends Component {
constructor(props) {
super(props);
this.handlePasswordChange = this.handlePasswordChange.bind(this);
this.handleConfirmpasswordChange = this.handleConfirmpasswordChange.bind(this);
this.handleSubmit = this.handleSubmit.bind(this);
this.state = {
    id: this.props.match.params.id,
    p:false,
    cp:false,
    password: "",
    confirmpassword: "",
    errors: {
        password: '',
        confirmpassword: '',
    }
};
}

validateForm() {
return this.state.name.length > 0 && this.state.passwordd.length > 5 ;
}

componentDidMount(){
    window.localStorage.removeItem('uid')
}

handlePasswordChange = event => {
    const { name, value } = event.target;
    let errors = this.state.errors;
    errors.password = value.length < 8 ? 'Password must be 8 characters long' : '';
    if(errors.password == '')
    {
        this.setState({p : true});
    }
    this.setState({errors, [name]: value});
}

handleConfirmpasswordChange = event => {
    const { name, value } = event.target;
    let errors = this.state.errors;
    errors.confirmpassword = this.state.password != value ? 'Passwords don\'t match' : '';
    if(errors.password == '')
    {
        this.setState({cp : true});
    }
    this.setState({errors, [name]: value});
}

handleSubmit(event) {
event.preventDefault();
var body = {
        password : this.state.password,
        id : this.state.id,
    }
console.log(body);
if(this.state.password==""){
    alert('Please enter the password')
}
else if(this.state.confirmpassword==""){
    alert('Please confirm the password')
}

else{
    console.log(this.state)
    if(this.state.p == true && this.state.cp == true){
        console.log(this.state)
        const url = "http://localhost:9000/resetPassword";
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
            alert("Password has been changed.");
            result = response.json();
            console.log(result);
            window.location.href = '/login'
        }})
        .catch(()=> console.log("Can't access " + url + " response. "))
    }
}

}

render() {
const {errors} = this.state;
return (<div className ="bg">
<Navigation/>
<br/><br/><br/><br/>

<div className="auth-wrapper1">
<div className="auth-inner">
<form>
<h1>RESET PASSWORD</h1><hr/>
 
    <div className="form-group">
        <label>Password</label>
        <input type="password" name="password" id="examplePassword" placeholder="********" className="form-control" value = {this.state.psw} onChange = {this.handlePasswordChange} required/>
        <span className='error'>{errors.password}</span>
    </div>

    <div className="form-group">
        <label>Confirm password</label>
        <input type="password" name="confirmpassword" id="exampleConfirmPassword" placeholder="********" className="form-control" value = {this.state.confirmpsw} onChange = {this.handleConfirmpasswordChange} required/>
        <span className='error'>{errors.confirmpassword}</span>
    </div>

    <button type="submit" className="btn btn-primary btn-block btn-lg" onClick = {this.handleSubmit}>CHANGE PASSWORD</button>
</form>
</div>

</div>
<br/><br/><br/><br/><br/>
</div>
);
}
}
