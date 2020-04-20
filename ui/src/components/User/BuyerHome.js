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
    console.log("Crops to pay of: "+this.state.id)
}

renderList(buyer){
    return this.state.items.map(function(item){
        console.log("in render list" + buyer);
        return(
            <div key={item.id} className = "cropList">
                <Row>
                    <Col xs="1">{item.name}</Col><Col xs="1"></Col><Col xs="2">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                    <Col xs="3">
                    <button type="submit" id={item.id} className="btn btn-info btn-lg" onClick={() => {window.location.href = "/payment/" + item.id + "/" + buyer + "/b"}}>PAY NOW</button>
                    </Col>
                </Row><hr/>
            </div>
        )
    })
}

render() {
    window.localStorage.setItem('buyerId',this.state.id);
    return (<div>
        <Nav uid = {this.state.id} role={'buyer'}/>
        <div className="auth-inner-half-transparent">
        <ListLocations id={this.state.id}/></div>

        {/* <CROPS TO PAY/> */}
        <Row>
            {this.state.items.length>0 && 
            <div className= "auth-inner-half">
            <Row>
            <h1><center>Pending Payments</center></h1><hr/>
            <button type="submit" className="btn btn-primary btn-lg float-right ml-auto" onClick={() => {window.location.href = "/allPendingPayment/"+ this.state.id}}>VIEW ALL</button>
            </Row><hr/>
            <Row>
                <Col xs="1">CROP</Col><Col xs="1"></Col><Col xs="2">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="2">PRICE</Col><Col xs="3">ACTION</Col>
            </Row><hr/>
            <ul>
                {this.renderList(this.state.id)}
            </ul>
            </div>}
            
            {this.state.items.length == 0 && 
            <div className= "auth-inner-half">
            <h2>You have no pending payments.</h2>
            </div>}    
        </Row>
        {/* crops to pay end */}
        <Row><br/></Row>
        <Row>
        <Col>
        <CropsToBuyer id={this.state.id}/>
        </Col>
        <Col>
        <PastBids id =  {this.state.id}/>
        </Col>
        </Row>
        <Row><br/></Row>
        </div>
    );
}
}
