import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'
import FarmerProfile from './FarmerProfile'

export default class CropCheck extends Component{
    constructor(props) {
        super(props);
        this.state = {
            'data' : [],
            id: this.props.match.params.id,
            fid: this.props.match.params.fid,
        };
    }

    approve() {
        const url = 'http://localhost:9000/approveCrop'+this.state.id
        console.log(this.state.location)
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        headers.append('Access-Control-Allow-origin', url);
        headers.append('Access-Control-Allow-Credentials', 'true');

        headers.append('POST', 'GET');

        fetch(url,{
            headers: headers,
            method: 'GET'
        })
        .then(response => response.json()) 
        .then(response => this.setState({ 'data' : response}));
        console.log(this.state.data);
        window.location.href = "/adminhome/"+window.localStorage.getItem('uid') 
    }

    reject() {
        const url = 'http://localhost:9000/rejectCrop'+this.state.id
        console.log(this.state.location)
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        headers.append('Access-Control-Allow-origin', url);
        headers.append('Access-Control-Allow-Credentials', 'true');

        headers.append('POST', 'GET');

        fetch(url,{
            headers: headers
        })
        .then(response => response.json()) 
        .then(response => this.setState({ 'data' : response}));
        console.log(this.state.data);
        window.location.href = "/adminhome/"+window.localStorage.getItem('uid') 
 
    }
    
    render() {
        return (<div>
            <Nav/>
        <div className = "userhomebg">
        <div className="wrapper">
        <div className="main_content">
        </div>
        </div>
        <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Container>
            <Row>
                <Col>
                <br/><h1>Crop Profile</h1><br/>
                <CropProfile id = {this.state.id}/>
                <br/>
                </Col>
            </Row>
                <Col>
                <br/><h1>Farmer:</h1><br/>
                {/* <FarmerProfile id = {this.state.fid}/> */}
                <br/>
                </Col>
            <Row>
            <Col><button id={this.state.id} className="btn btn-success" onClick={() => {this.approve(this.state.id)}}>Approve</button></Col>
            <Col><button id={this.state.id} className="btn btn-danger" onClick={() => {this.reject(this.state.id)}}>Reject</button></Col>
            </Row>
            
            </Container>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></div>
        </div>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
        );
    }
}
