import React, { Component } from "react";
import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Navigation  from './Nav.js';
import {createBrowserHistory} from 'history';

var body;
var urole;
var uname;
var uid;
var status;
var result;
let token="";

class Login extends Component{
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

  componentDidMount(){
    window.localStorage.removeItem('uid')
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
              urole = result.role
              uname = result.name
              uid = result.id
              status = result.status
              if(status=="authenticated"){
                if(urole=="farmer"){
                  window.localStorage.setItem("username",uname)
                  window.localStorage.setItem("uid",uid);
                  window.localStorage.setItem("role",urole);
                  window.sessionStorage.setItem("uid",uid);
                  window.sessionStorage.setItem("role",urole);
                  window.location.href  = "/userhome/"+uid;
                  }  //"/userhome" 
                else if(urole=="buyer"){
                  window.localStorage.setItem("username",uname)
                  window.localStorage.setItem("uid",uid);
                  window.localStorage.setItem("role",urole);
                  window.sessionStorage.setItem("uid",uid);
                  window.sessionStorage.setItem("role",urole);
                  window.location.href  = "/buyerhome/"+uid;  
                  
                  //alert("buyer")
              }
              else{
                alert("Please login from Admin page.")
                window.location.href  = "/adminlogin"; 
              }
            }
            else{
              window.location.href = "/resendVerify/"+this.state.email+"/"+uid
            }
          }
          )
            
           // window.localStorage.getItem('uid');
            
          }else{
            console.log("Please check your username and password.");
            alert("Invalid username or password.");
          }
         
       })
      
    
          //.then(response => {if(response.redirected){
          //  window.location.href="/userhome";
          //}
          //else if(response.ok){
           // console.log("Wrong email or password")
           // alert("Wrong email or password")
         // }
          //})
          //{/*}.catch((error)=> {console.log("can't access" + url + "response. " +error )},
           // alert("Wrong email or password"))*/}

          //}
      
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
                <h1>LOGIN</h1><hr/>
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

                

                <button type="submit" className="btn btn-primary btn-block btn-lg" onClick={this.handleSubmit}>LOGIN</button>
                <p className="forgot-password text-right">
                    <a href="/forgotPassword">Forgot password?</a>
                </p>
                
         
             
                <p className="forgot-password text-right">
                    Not registered yet? <a href="/signup">Sign Up</a>
                </p>
            
        

            </form>
            </div>
            <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
            </div>
            </div>
        );
    }
}
export default withRouter(Login);