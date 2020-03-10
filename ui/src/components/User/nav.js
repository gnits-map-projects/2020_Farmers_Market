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
        this.state ={
            uid : this.props.uid,
        }
    }
    render(){
        return (
            <div>
            <Navbar className="navbar-light" expand="md">
                <Navbar.Brand href="/Home"><h3><b>FARMER'S MARKET</b></h3></Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="mr-auto"></Nav>
                    <Nav>
                        <Nav.Link href="/Home">HOME</Nav.Link>
                        <NavDropdown title={window.localStorage.getItem("username")} id="basic-nav-dropdown">
                            <NavDropdown.Item href={"/updateProfile/" + this.state.uid}>Profile</NavDropdown.Item>
                            <NavDropdown.Item href="/Home" onClick={() => window.sessionStorage.clear() }>Sign out</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
            </div>
        );
}}

export default Navigation;
