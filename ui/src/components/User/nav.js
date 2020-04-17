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
            read : false
        }
        this.handleClick = this.handleClick.bind(this);
        this.renderNotifications = this.renderNotifications.bind(this);
    }

    componentDidMount(){
        const url = 'http://localhost:9000/getNotifications/'+this.state.uid;
        console.log(this.state.id+"FECTCHING NOTIFICAITONS")
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
        .then(response => {
            this.setState({ 'notifications' : response})
            this.state.notifications.forEach(notification => {if(notification.status == "unread") this.setState( {num : this.state.num + 1});}) 
        }); 
    }

    handleClick(event){
        event.preventDefault();
        this.setState({
            display : !this.state.display
        })
        // DOESN'T WORK BECAUSE BODY IS ALREADY RENDERED ?
        if(this.state.display==true)
            // document.querySelector('body').style.overflow = 'hidden';
            document.body.style.overflow = 'hidden;'
        else
            // document.body.classList.remove("no-sroll");
            document.body.style.overflow = 'auto'
            if(this.state.read == false)
                this.handleRead(this.state.uid);
        console.log(this.state.display)
    }

    handleRead(uid){
        const url = 'http://localhost:9000/notificationsRead/'+uid;
        console.log(uid+"FECTCHING NOTIFICAITONS")
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
        .then(this.setState({ 'read' : true}));             
    }

    renderNotifications(){
        return this.state.notifications.map(function(notification){
            return(
                <div key={notification.id}>
                    {notification.status == "unread" && <div key={notification.id} className="notificationUnreadList">  
                        <p id="text">
                            <div className="badge">New</div>
                            <div className="dateBadge">{notification.created}</div>
                        <br/>
                        {notification.notification}</p><hr/>
                            {/* <button type="submit" className="btn btn-light btn-sm float-right ml-auto" onClick = {"http://localhost:9000/NotifocationRead/"+notification.id}>Mark as read</button>    */}
                    </div>}
                    {notification.status == "read" && <div key={notification.id} className="notificationReadList">
                        <p id="text">
                            <div className="dateBadge">{notification.created}</div>
                        <br/>
                        {notification.notification}</p><hr/>
                    </div>}
                </div>
            )
        })
    }

    render(){
        return (
            <div>
                {this.state.display==true &&
                <div className="restrictingOverlay" onClick={this.handleClick}></div>}
                <Navbar className="navbar-light" expand="md">
                <Navbar.Brand href="/Home"><h3><b>FARMER'S MARKET</b></h3></Navbar.Brand>
                <Navbar.Toggle aria-controls="basic-navbar-nav" />
                <Navbar.Collapse id="basic-navbar-nav">
                    <Nav className="ml-auto">
                        <Nav.Link className="notification" href="/Home">&nbsp;HOME&nbsp;</Nav.Link>
                        {this.state.role== 'admin' && <Nav.Link className="notification" href={"/adminhome/"+this.state.uid}>&nbsp;DASHBOARD&nbsp;</Nav.Link>}
                        {this.state.role== 'farmer' && <Nav.Link className="notification" href={"/userhome/"+this.state.uid}>&nbsp;DASHBOARD&nbsp;</Nav.Link>}
                        {this.state.role== 'buyer' && <Nav.Link className="notification" href={"/buyerhome/"+this.state.uid}>&nbsp;DASHBOARD&nbsp;</Nav.Link>}
                        {this.state.role!= 'admin' &&
                        <button className="notificationTop nav-link btn-lg border-0 link-like" onClick={this.handleClick}>NOTIFICATIONS
                            {this.state.num>0 && <span className="redText">({this.state.num})</span>}
                        </button>}
                        
                        {this.state.display==true &&
                        <div className="overlay">
                            {this.renderNotifications()}
                        </div>}

                        {this.state.role != 'admin' &&
                        <Nav.Link className="notification" href={"/grievance/"+this.state.uid+'/' + this.state.role}>&nbsp;GRIEVANCE&nbsp;</Nav.Link>}
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
