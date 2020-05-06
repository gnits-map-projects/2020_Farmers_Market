import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'
import FarmerProfile from './FarmerProfile'

export default class Bill extends Component{
    constructor(props){
        super(props);
        this.state = {
            'id' :this.props.match.params.cid,
            'fid': this.props.match.params.fid,
            'buyer' : this.props.match.params.buyerId,
            'crop': '',
        };
    }

    componentDidMount(){
        fetch('http://localhost:9000/getCrop/'+this.state.id) //i.e. crops won
            .then(response => response.json())
            .then(data => this.setState({ crop: data}));
    }

    render() {
        window.localStorage.setItem('buyerId',this.state.buyer);
        return (<div>
            <Nav uid = {this.state.buyer} role={'buyer'}/>
            <Col>
            <Row>
                <h1>Bill</h1> 
                <Row><Col>Quantity of crop:</Col><Col>{this.state.crop.harvestedQuantity}<br/></Col></Row>
                <Row><Col>Total amount paid:</Col><Col>{this.state.crop.totalPayable}<br/></Col></Row>
                <Row><Col>Advance paid:</Col><Col>{this.state.crop.advPayment}<br/></Col></Row>
            </Row>
            </Col>
            <Col>
            <Row>
            <CropProfile id = {this.state.id}/>
            </Row>
            <Row>
            <FarmerProfile id = {this.state.fid}/>
            </Row>
            </Col>
            </div>
        );
    }
}