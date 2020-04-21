import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './home.css';
import {Navbar, Nav,} from 'react-bootstrap'

class Navigation extends Component {
  constructor(props) {
    super(props);
  }
  render(){
  return (
    <div>
      <Navbar className="navbar-light fixed-top" expand="md">
        <Navbar.Brand href="/Home"><h1><b>FARMER'S MARKET</b></h1></Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="mr-auto"></Nav>
          <Nav>
            <Nav.Link className="nlink" href="/Home">HOME</Nav.Link>
            <Nav.Link className="nlink" href="/signup">SIGN UP</Nav.Link>
            <Nav.Link className="nlink" href="/login">LOGIN</Nav.Link>
            <Nav.Link className="nlink" href="/adminlogin">ADMIN</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    </div>            
  );
}}

export default Navigation;