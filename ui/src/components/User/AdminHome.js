import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropsToCheck from './cropsToCheck.js'


export default class AdminHome extends Component{
    constructor(props){
        super(props);
        this.state = {
            'id' :this.props.match.params.id,
        };
    }
render() {
    return (<div>
        <Nav  uid = {this.state.id} role={'admin'}/>
    <div className = "userhomebg">
    <div className="wrapper">
    <div className="main_content">
    </div>
    </div>
    <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
        <Container>
        <br/>
        <CropsToCheck/>       
        </Container>
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></div>
    </div>
    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
    </div>
    );
}
}
