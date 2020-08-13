import React, { Component } from "react";
import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Navigation  from './Nav.js';
import {createBrowserHistory} from 'history';

var body;
var arole;
var aname;
var aid;
var result;
let token="";

class AdminLogin extends Component{
  constructor(props) {
    super(props);
    this.state={
      email : '',
      password : '',
      role : '',
    }
    this.handlePasswordChange = this.handlePasswordChange.bind(this);
    this.handleEmailChange = this.handleEmailChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }
  handleSubmit(event) {

  event.preventDefault();
    console.log(this.state)
     var body = {
      email : this.state.email,
      password : this.state.password,
    }
    console.log(body);
    if(this.state.email==""){
      alert('Please enter the email')

    }
    else if(this.state.password==""){
      alert('Please enter the password')
    }
    
    else{
        const url = "http://localhost:9000/login";
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
              arole = result.role
              aname = result.name
              aid = result.id
              console.log(result)
              if(arole=="admin"){
                window.localStorage.setItem("username",aname);
                window.localStorage.setItem("uid",aid);
                window.sessionStorage.setItem("uid",aid);
                window.sessionStorage.setItem("role",arole);
                window.localStorage.setItem("role",arole);;
                window.location.href  = "/adminhome/"+aid;
                }  //"/userhome" 
              else{
                alert("Sorry, you are unauthenticated.")
            }
            })
            
          }else{
            console.log("Please check your username and password.");
            alert("Invalid username or password.");
          }
         
       })     
    } 
  }

  validateForm() {
    return this.state.name.length > 0 && this.state.password.length > 5;
  }

  handlePasswordChange (event) {
    this.setState({
      
      password: event.target.value

    });
    console.log(event.target.value)
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
                <h1>ADMIN LOGIN</h1><hr/>
                <div className="form-group">
                    <label>Email address</label>
                    <input type="email" name="email" id="exampleEmail" className="form-control" placeholder="Enter email"
                    onChange = {this.handleEmailChange} />
                </div>

                <div className="form-group">
                    <label>Password</label>
                    <input type="password" name="password" id="examplePassword" className="form-control" placeholder="Enter password" 
                    onChange = {this.handlePasswordChange}/>
                </div>

                

                <button type="submit" className="btn btn-primary btn-block" onClick={this.handleSubmit}>Login</button>
                <p className="forgot-password text-right">
                    Forgot <a href="#">password?</a>
                </p>
            </form>
            </div>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>

            </div>
            </div>
        );
    }
}
export default withRouter(AdminLogin);