import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'
import BuyerProfile from './BuyerProfile'

export default class ViewBuyer extends Component{
    constructor(props) {
        super(props);
        this.state = {
            'data' : [],
            cid: this.props.match.params.cid,
            fid: this.props.match.params.fid,
        };
    }

    componentDidMount() {
        const url = 'http://localhost:9000/getBuyer/'+this.state.cid
        console.log(this.state.id)
        console.log(url)
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        headers.append('Access-Control-Allow-origin', url);
        headers.append('Access-Control-Allow-Credentials', 'true');

        headers.append('POST', 'GET');

        fetch(url,{
            headers: headers,
        })
        .then(response => response.json()) 
        .then(response => this.setState({ 'buyer' : response}),
        console.log(this.state.buyer))
        .catch((error) => {console.error('Error:', error);}); 
    }

    
    render() {
        return (<div>
            <Nav uid = {this.state.fid} role={'farmer'}/>

        <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
                <Col>
                    <CropProfile id = {this.state.id}/>
                </Col>
                <Col>
                    <BuyerProfile id = {this.state.buyer.id}/>
                </Col>
            </Row>            
        </div>
        </div>
        );
    }
}
