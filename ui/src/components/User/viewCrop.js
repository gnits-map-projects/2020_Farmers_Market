import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'
import FarmerProfile from './FarmerProfile'

export default class ViewCrop extends Component{
    constructor(props){
        super(props);
        this.state = {
            'id' :this.props.match.params.cid,
            'fid': this.props.match.params.fid,
            'buyerId': this.props.match.params.buyerId,
            'crop': '',
        };
    }

    componentDidMount(){
        fetch('http://localhost:9000/getCrop/'+this.state.id) //i.e. crops won
            .then(response => response.json())
            .then(data => this.setState({ crop: data}));
    }

    render() {
        window.localStorage.setItem('buyerId',this.state.buyerId);
        return (<div>
                <Nav uid = {this.state.buyerId} role={'buyer'}/>
                <Row><br/></Row><Row><br/></Row><Row><br/></Row> 
                <Row>
                <div className = "auth-inner">
                    <h1>Advance payment of {this.state.crop.advPayment} ₹ done.</h1>
                </div>  
                </Row>
                <Row><br/></Row><Row><br/></Row><Row><br/></Row> 
                <Row>            
                    <Col>
                        <CropProfile id = {this.state.id}/>
                    </Col>
                    <Col>
                        <FarmerProfile id = {this.state.fid}/>
                    </Col>
                </Row>
                <Row><br/></Row><Row><br/></Row><Row><br/></Row><Row><br/></Row>  
            </div>
        );
    }
}