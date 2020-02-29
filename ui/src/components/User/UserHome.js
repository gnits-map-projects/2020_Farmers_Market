import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import Recents from "./recentBids";
import CropForm from "../home/crop";
import BidsToBuy from "./bidsToBuy";

//import SignUp from "../components/signup.component";
//import User from "./components/user"
/*function Login(prop){
const onSubmit =() => {
prop.history.push('/User');
}*/
export default class UserHome extends Component{
render() {
    var uid=this.props.match.params.id
    return (<div>
        <Nav/>
    <div className = "userhomebg">
    <div className="wrapper">
    <div className="main_content">
    </div>
    </div>
    <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
        <Container >
            <Row>
                <Col>
                    <br/><h1>Add Crop</h1><br/>
                    <div>
                        <CropForm id={uid}/>
                    </div> 
                </Col>
                
                <Col>
                    <Row>
                        <br/><h1>Your Crops</h1><br/><br/>
                        <div>
                        <br/>
                            <Recents id={uid}/>
                        </div>
                    </Row>
                        <br/><br/><br/>
                    <Row>
                        <br/><h1>Recent Crops</h1><br/><br/>
                        <div>    
                        <br/>                   
                            <BidsToBuy/>
                        </div>
                    </Row>
                </Col>
                
            </Row>
        </Container>
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></div>
    </div>
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </div>
    );
}
}
