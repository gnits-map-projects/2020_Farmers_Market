import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'


class CropsToCheck extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
        };
    
        //this.handleChange = this.handleChange.bind(this);
    }

    handleClick = (event) => {
        console.log("hello")
        //console.log(event.target.getAttribute('id'));
    }; 
    
    
    componentDidMount() {
        const url = 'http://localhost:9000/getUncheckedCrops'
        console.log(this.state.location)
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
        .then(response => this.setState({ 'items' : response}));
        console.log(this.state.items);   

             
    }

    renderList(farmer){
        return this.state.items.map(function(item){
            return(
                <div key={item.id} className= "cropList">
                    <Row>
                        <Col xs="2">{item.name}</Col><Col xs="2">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                        <Col xs="1"><button type="submit" id={item.id} className="btn btn-primary btn-lg" onClick={() => {window.location.href = "/cropCheck/" + item.id + "/" + item.fid}}>CHECK</button></Col>
                    </Row>
                    <Row><br/></Row>
                </div>
            )
        })
    }

    render(){
        return (
            <div className= "auth-inner-full">
            <Row>
            <h1>Crops To Check</h1><hr/>
            </Row><hr/>
            {this.state.items.length == 0 && <h3>No crops here</h3>}
            {this.state.items.length > 0 &&
            <Row>
                <Col xs="1">CROP</Col><Col xs="1"></Col><Col xs="2">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="2">PRICE</Col><Col xs="3">ACTION</Col>
            </Row>}
            <hr/>
            <ul>
                {this.renderList(this.state.id)}
            </ul>
            </div>
        );
    }
}
export default CropsToCheck;

