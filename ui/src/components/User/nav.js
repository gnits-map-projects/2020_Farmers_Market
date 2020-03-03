import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import {
Navbar,
Nav,
NavDropdown,
} from 'react-bootstrap'

class Navigation extends Component {
    constructor(props) {
        super(props);
    }
    render(){
        return (
            <div>
            <Navbar bg="light" expand="md">
                <Navbar.Brand href="#home"><h3><b>FARMER'S MARKET</b></h3></Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto"></Nav>
                    <Nav>
                        <Nav.Link href="/Home">HOME</Nav.Link>
                        <NavDropdown title={window.localStorage.getItem("username")} id="basic-nav-dropdown">
                            <NavDropdown.Item href="">Profile</NavDropdown.Item>
                            <NavDropdown.Item href="/Home" onClick={ sessionStorage.clear() }>Sign out</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
            </div>
        );
}}

export default Navigation;
