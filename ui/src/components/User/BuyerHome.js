import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import PastBids from "./pastBids";
import BidsToBuy from "./bidsToBuy";
import ListLocations from "./listLocations";

export default class BuyerHome extends Component{
render() {
    return (<div>
        <Nav/>
    <div className = "userhomebg">
    <div className="wrapper">
    <div className="main_content">
    </div>
    </div>
    <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
        <Container >
        <ListLocations/>
        <br/>
        <Row>
        <Col>
        <div background-color="#aacfb0">
         <br/><h1>Recent Crops</h1><br/>
        <BidsToBuy/>
        </div>
        </Col>
        <Col>
        <div background-color="#c3b899">
        <br/><h1>Past Bids</h1><br/>
        
        
        {/*<PastBids id =  {uid}/>*/}
        </div>
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
