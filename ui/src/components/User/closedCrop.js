import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'

export default class ClosedCrop extends Component{
    constructor(props) {
        super(props);
        this.state = {
            cid: this.props.match.params.cid,
            fid: this.props.match.params.fid,
            winner : {},
        };
    }

    componentDidMount() {
        const url = 'http://localhost:9000/getWinner/'+this.state.cid
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
        .then(response => this.setState({ 'winner' : response}));
    }
    
    renderWinner(){
        if(this.state.winner.rating>5.0)
            this.state.winner.rating = "No rating yet";
        return (
            <div className="auth-inner-half">
                <h1>Winner Profile:</h1><hr/>
                <Row><Col>Name:</Col><Col>{this.state.winner.name}<br/></Col></Row>
                <Row><Col>Mobile:</Col><Col>{this.state.winner.mobile}<br/></Col></Row>
                <Row><Col>Email:</Col><Col>{this.state.winner.email}<br/></Col></Row>
                <Row><Col>Rating:</Col><Col>{this.state.winner.rating} &nbsp; &nbsp; (out of {this.state.winner.numrating})<br/></Col></Row>
            </div>
        );
    }

    render() {
        return (<div>
            <Nav uid = {this.state.fid} role={'farmer'}/>
            <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
                <div className= "auth-inner"><h1>Your crop was sold at price: {this.state.winner.price} ₹</h1></div>
            </Row>
            <br/>
            <Row>
                <Col>
                    <CropProfile id = {this.state.cid}/>
                </Col>
                <Col>
                    {this.renderWinner()}
                </Col>
            </Row>            
        </div>
        </div>
        );
    }
}
