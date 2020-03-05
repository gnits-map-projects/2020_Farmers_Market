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

var body;

export default class CropBid extends Component{
    constructor(props) {
        super(props);
        this.state = {
            'data' : [],
            cid: this.props.match.params.id,
            fid: this.props.match.params.fid,
            buyerId: this.props.match.params.buyerId,
            'price': '',
            'biddingPrice': '',
            
        };
        this.getPrice = this.getPrice.bind(this);
        this.bidding = this.bidding.bind(this);
        this.handleBiddingPriceChange = this.handleBiddingPriceChange.bind(this);
    }

    getPrice(price){
        this.setState({price : price});
    }

    handleBiddingPriceChange (event) {
    this.setState({
      
      biddingPrice: event.target.value

    });
    console.log(event.target.value)
  }



    bidding(event) {
        event.preventDefault();
        body = {
            buyerId: this.state.buyerId,
            cropId: this.state.cid,
            biddingPrice: this.state.biddingPrice
        }
        const url = 'http://localhost:9000/insertBid'
        console.log("ON CLICK BIDDING.")
        console.log(body)
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        headers.append('Access-Control-Allow-origin', url);
        headers.append('Access-Control-Allow-Credentials', 'true');

        headers.append('POST', 'GET', 'DELETE');

        fetch(url,{
            headers: headers,
            method : 'POST',
            body: JSON.stringify(body)
        })
        .then(response => {if(response.ok){alert("Bid Successful.");
        window.location.href = "/buyerhome/" + this.state.buyerId}
        else{alert("Bid UnSuccessful.")}})

        //TO DO
        //window.location.href = "/buyerhome/" + this.state.buyerId
 
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
                <br/><h1>Crop Profile:</h1><br/>
                <CropProfile id = {this.state.cid}
                getPrice = {this.getPrice}/>
                <br/>
                </Col>
            </Row>
                <Col>
                <br/><h1>Farmer Profile:</h1><br/>
                <FarmerProfile id = {this.state.fid}/>
                <br/>
                </Col>
            <Row>
            <form>
            <Col><input type="number" min = {this.state.price + 1} placeholder={'Enter > '+this.state.price} name="biddingPrice" onChange = {this.handleBiddingPriceChange}/></Col>
            <Col><button type="submit" className="btn btn-primary" onClick={this.bidding}>Bid</button></Col>    
            {/* // TO DO */}
            </form>
            </Row>
            <Row>
            Highest Bids        
            {/* //TO DO */}
            </Row>            
            </Container>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/></div>
        </div>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
        );
    }
}
