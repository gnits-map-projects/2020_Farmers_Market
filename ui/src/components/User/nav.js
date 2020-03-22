import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './notification.css';
import {
Navbar,
Nav,
NavDropdown,
} from 'react-bootstrap';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

class Navigation extends Component {
    constructor(props) {
        super(props);
        this.state ={
            uid : this.props.uid,
            role : this.props.role,
            display: false,
            num : 0,
        }
        this.handleClick = this.handleClick.bind(this);
    }

    componentDidMount(){
        const url = 'http://localhost:9000/getNotifications/'+this.state.uid;
        console.log(this.state.id)
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        headers.append('Access-Control-Allow-origin', url);
        headers.append('Access-Control-Allow-Credentials', 'true');

        headers.append('POST', 'GET');

        fetch(url,{
            headers: headers,
            method: 'GET',
        })
        .then(response => response.json()) 
        .then(response => this.setState({ 'notifications' : response}));  
    }

    handleClick(event){
        event.preventDefault();
        this.setState({
            display : !this.state.display
        })
        // DOESN'T WORK BECAUSE BODY IS ALREADY RENDERED ???
        // if(this.state.display==true)
        //     document.querySelector('body').style.overflow = 'hidden';
        // else
        //     document.querySelector('body').style.overflow = 'auto';
        console.log(this.state.display)
    }

    renderNotifications(){
        return this.state.notifications.map(function(notification){
            return(
                <div key={notification.id} className = "notificationList">
                    <Row>
                        {notification.notification}
                    </Row><hr/>
                </div>
            )
        })
    }

    render(){
        return (
            <div>
            <Navbar className="navbar-light" expand="md">
                <Navbar.Brand href="/Home"><h3><b>FARMER'S MARKET</b></h3></Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="ml-auto">
                        <Nav.Link className="notification" href="/Home">&nbsp;HOME&nbsp;</Nav.Link>
                        {this.state.role== 'admin' && <Nav.Link className="notification" href={"/adminhome/"+this.state.uid}>&nbsp;DASHBOARD&nbsp;</Nav.Link>}
                        {this.state.role== 'farmer' && <Nav.Link className="notification" href={"/userhome/"+this.state.uid}>&nbsp;DASHBOARD&nbsp;</Nav.Link>}
                        {this.state.role== 'buyer' && <Nav.Link className="notification" href={"/buyerhome/"+this.state.uid}>&nbsp;DASHBOARD&nbsp;</Nav.Link>}
                        {/* <Nav.Link className="notification"> */}
                            <button className="notification nav-link btn-lg border-0 link-like" onClick={this.handleClick}>NOTIFICATIONS</button>
                            {this.state.num>0 && <span className="redText">({this.state.num})</span>}
                            {this.state.display==true &&
                            <div className="overlay">
                                <h1>NOTIFICATIONS</h1>
                                {/* {this.renderNotifications()} */}
                            </div>}
                        {/* </Nav.Link> */}
                        <NavDropdown className="notification" title={window.localStorage.getItem("username")} id="basic-nav-dropdown">
                            <NavDropdown.Item href={"/updateProfile/" + this.state.uid}>Update Profile</NavDropdown.Item>
                            <NavDropdown.Item href="/Home" onClick={() => window.sessionStorage.clear() }>Sign out</NavDropdown.Item>
                        </NavDropdown>
                    </Nav>
                </Navbar.Collapse>
            </Navbar>
            </div>
        );
    }
}

export default Navigation;
