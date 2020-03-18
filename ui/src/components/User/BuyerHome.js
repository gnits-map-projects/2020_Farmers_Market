import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import PastBids from "./pastBids";
import CropsToBuyer from "./cropsToBuyer";
import ListLocations from "./listLocations";

export default class BuyerHome extends Component{
    constructor(props){
        super(props);
        this.state = {
            'id' :this.props.match.params.id,
        };
    }
render() {
    window.localStorage.setItem('buyerId',this.state.id);
    return (<div>
        <Nav uid = {this.state.id} role={'buyer'}/>

    <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
        <ListLocations id={this.state.id}/>
        <br/>
        <Row>
        <Col>
        <CropsToBuyer id={this.state.id}/>
        </Col>
        <Col>
        <br/><h1>Past Bids</h1><br/>
        
        
        {/*<PastBids id =  {uid}/>*/}
        </Col>
        </Row>
<br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></div>
    </div>
    );
}
}
