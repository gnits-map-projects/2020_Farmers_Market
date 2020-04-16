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
            'items':[],
        };
    }

componentDidMount(){
    fetch('http://localhost:9000/cropsToPay/'+this.state.id)
        .then(response => response.json())
        .then(data => this.setState({ items : data }));
}

render() {
    window.localStorage.setItem('buyerId',this.state.id);
    return (<div>
        <Nav uid = {this.state.id} role={'buyer'}/>
        <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >

        {/* <CROPS TO PAY/> */}
        
        <ListLocations id={this.state.id}/>
        <br/>
        <Row>
        <Col>
        <CropsToBuyer id={this.state.id}/>
        </Col>
        <Col>
        <PastBids id =  {this.state.id}/>
        </Col>
        </Row>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></div>
    </div>
    );
}
}
