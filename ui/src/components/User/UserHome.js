import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import Recents from "./recentBids";
import CropForm from "../home/crop";
import BidsToFarmer from "./bidsToFarmer";

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
        <Nav uid = {uid}/>
    <div className = "userhomebg">
    <div className="wrapper">
    <div className="main_content">
    </div>
    </div>
    <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
                <Col xs="6">
                    <div>
                        <CropForm id={uid}/>
                    </div> 
                </Col>
                <Col xs="6">
                    <Row> 
                        <div>
                            <Recents id={uid}/>
                        </div>
                    </Row>
                        <br/>
                    <Row>
                        <div>               
                            <BidsToFarmer/>
                        </div>
                    </Row>
                </Col>
                
            </Row>

    </div>
    </div>
   
    </div>
    );
}
}
