import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './home.css';
//import './App.css';
import { BrowserRouter as Router, 
  Switch, 
  Route,
   Link } from "react-router-dom";
   import {
    Navbar,
    Nav,
    Form,
    FormControl,
    NavDropdown,
    Button,
    Image
  } from 'react-bootstrap'

class Navigation extends Component {
  constructor(props) {
    super(props);
  }
  render(){
  return (
    <div>
      {/* <nav className="navbar navbar-expand-lg navbar-light fixed-top">
        <div className="container">
          <div className="collapse navbar-collapse" id="navbarTogglerDemo02"> 
          <div className="navbar-nav mr-auto">
          <Link className="nav-link" ><b>CITIZENS ENGAGE</b></Link>
          </div>

            <ul className="navbar-nav ml-auto">

            <li className="nav-item">
                <Link className="nav-link" to={"/Home"}>Home</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/Login"}>Login</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/sign-up"}>Sign up</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/adminlogin"}>Admin</Link>
              </li>
              <li className="nav-item">
                <Link className="nav-link" to={"/about"}>About</Link>
              </li>
             
            </ul>
          </div>
        </div>
        
      </nav> */}

  <Navbar bg="light" expand="md">
    <Navbar.Brand href="#home"><h3><b>FARMER'S MARKET</b></h3></Navbar.Brand>
    <Navbar.Toggle aria-controls="basic-navbar-nav" />
    <Navbar.Collapse id="basic-navbar-nav">
      <Nav className="mr-auto"></Nav>
      <Nav>
      
        <Nav.Link href="/Home">HOME</Nav.Link>
        <Nav.Link href="/signup">SIGN UP</Nav.Link>
        <Nav.Link href="/login">LOGIN</Nav.Link>
        <Nav.Link href="/adminlogin">ADMIN</Nav.Link>
      </Nav>
    </Navbar.Collapse>
  </Navbar>

</div>
         
        
  );
}}

export default Navigation;