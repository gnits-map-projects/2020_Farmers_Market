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
            'won':[],
            'data':[],
        };
    }

    seggregate(data){
        console.log(data)
        for(var i=0; i<data.length; i++){
            if(data[i].status == 'closed' || data[i].status == 'harvested')
                this.setState(
                    { items: [...this.state.items, data[i]] }
                );
            if(data[i].status == 'payed')                   //sold goes into past deals
                this.setState(
                    { won: [...this.state.won, data[i]] }
                );
        }
        console.log(this.state.items)
        console.log(this.state.won)
    }

    componentDidMount(){
        fetch('http://localhost:9000/cropsToPay/'+this.state.id) //i.e. crops won
            .then(response => response.json())
            .then(data => this.seggregate(data));
    }

    renderList(buyer){
        return this.state.items.map(function(item){
            console.log("in render list" + buyer);
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="1">{item.name}</Col><Col xs="1"></Col>
                        <Col xs="2">{item.area} acres</Col>
                        <Col xs="2">{item.location}</Col>
                        <Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                        <Col xs="3">
                        {item.status == 'closed' && <button type="submit" id={item.id} className="btn btn-info btn-lg" onClick={() => {
                            window.location.href = "/payment/" + item.id + "/" + buyer + "/" + item.fid+"/"+item.price
                        }}>PAY ADVANCE</button>}
                        {item.status == 'harvested' && <button type="submit" id={item.id} className="btn btn-info btn-lg" onClick={() => {
                            window.location.href = "/payTotal/" + item.id + "/" + buyer + "/" + item.fid+"/"+ item.price + "/" + item.advPayment + "/" + item.harvestedQuantity +"/"+ item.totalPayable
                        }}>PAY TOTAL</button>}
                        </Col>
                    </Row><hr/>
                </div>
            )
        })
    }

    renderWonList(buyer){
        return this.state.won.map(function(item){
            console.log("in render list" + buyer);
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="1">{item.name}</Col><Col xs="1"></Col>
                        <Col xs="2">{item.area} acres</Col>
                        <Col xs="2">{item.location}</Col>
                        <Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                        <Col xs="3">
                        <button type="submit" id={item.id} className="btn btn-info btn-lg" onClick={() => {
                            window.location.href = "/viewCrop/" + item.id + "/" + item.fid + "/" + buyer
                        }}>VIEW CROP</button>
                        {/* After advance payment and before harvest by farmer */}
                        
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

            <Row>
                <div className= "auth-inner-half">

                <Row>
                <h1><center>Pending Payments</center></h1><hr/>

                <button type="submit" className="btn btn-danger btn-lg float-right ml-auto" onClick={() => {window.location.href = "/closedDeals/"+ this.state.id}}>VIEW CLOSED DEALS</button>
                {/* TO CHECK accepted and sold in backend and a page. */}


                </Row><hr/>
                {this.state.items.length>0 && <React.Fragment>
                <Row>
                    <Col xs="1">CROP</Col><Col xs="1"></Col>
                    <Col xs="2">AREA</Col><Col xs="2">LOCATION</Col>
                    <Col xs="1"></Col><Col xs="2">YOUR BID</Col><Col xs="3">ACTION</Col>
                </Row><hr/>
                <ul>
                    {this.renderList(this.state.id)}
                </ul>
                </React.Fragment>}
                
                {this.state.items.length == 0 && <React.Fragment>
                <h3>You have no pending payments.</h3></React.Fragment>}
                <Row><br/></Row> 
                <Row>
                <h1><center>Other Deals In Progress</center></h1><hr/>
                </Row><hr/>
                {this.state.won.length>0 && <React.Fragment>
                <Row>
                    <Col xs="1">CROP</Col><Col xs="1"></Col>
                    <Col xs="2">AREA</Col><Col xs="2">LOCATION</Col>
                    <Col xs="1"></Col><Col xs="2">YOUR BID</Col><Col xs="3">ACTION</Col>
                </Row><hr/>
                <ul>
                    {this.renderWonList(this.state.id)}
                </ul>
                </React.Fragment>}
                
                {this.state.won.length == 0 && <React.Fragment>
                <h3>You have no deals in progress.</h3></React.Fragment>}

                </div>  
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
            <Row><br/></Row><Row><br/></Row><Row><br/></Row>
            </div>
        );
    }
}