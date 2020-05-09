import React, { Component } from "react";
import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Navigation  from './Nav.js';
import {createBrowserHistory} from 'history';

var body;
var exists;
var result;

class Login extends Component{
  constructor(props) {
    super(props);
    this.state={
      email : '',
    }
    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  componentDidMount(){
    window.localStorage.removeItem('uid')
  }

  handleSubmit(event) {
    event.preventDefault();
    var body = {
      email : this.state.email,
    }
    console.log(body);
    if(this.state.email=="")
      alert('Please enter the email')
    else{
      const url = "http://localhost:9000/sendResetLink";
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
      result = response.json()
        .then(result => {
          exists = result.exists
          if(exists == "Yes"){
            alert("Password reset link sent to your email.");
            window.location.href = "/login";
          }else{
            alert("This email does not exist. You may register.");
            window.location.href = "/signup";
          }
        })
      }})
    }
  }

  handleEmailChange(event) {
    this.setState({ email: event.target.value})
    console.log(event.target.value)
  }

  render() {
        return (<div className="bg">
        <Navigation/>
            <div className="auth-wrapper">
            <div className="auth-inner">
               
            <form>
                <h1>Lost your password?</h1><hr/>
                Enter your email adress to receive the password reset link.<br/><br/>
                <div className="form-group">
                    <label>Email address</label>
                    <input type="email" name="email" id="exampleEmail" className="form-control" placeholder="Enter email"
                    onChange = {this.handleEmailChange} />
                </div>
                <button type="submit" className="btn btn-primary btn-block btn-lg" onClick={this.handleSubmit}>SUBMIT</button>
            </form>
            </div>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </div>
            </div>
        );
    }
}
export default withRouter(Login);