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
import TandC from '../home/tandc.js';
import Trends from './Trends';

var body;

export default class CropBid extends Component{
    constructor(props) {
        super(props);
        this.state = {
            'data': [],
            cid: this.props.match.params.id,
            fid: this.props.match.params.fid,
            buyerId: this.props.match.params.buyerId,
            'price': '',
            'biddingPrice': '',
            showBidForm: false,
            
        };
        this.getPrice = this.getPrice.bind(this);
        this.bidding = this.bidding.bind(this);
        this.handleBiddingPriceChange = this.handleBiddingPriceChange.bind(this);
    }

    getPrice(price){
        this.setState({price : price});
    }

    getAdvPayment(price){
    }

    handleBidForm () {
      this.setState({showBidForm: !this.state.showBidForm})
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
            biddingPrice: this.state.biddingPrice,
            status : "waiting"
        }
        if(this.state.biddingPrice > this.state.price){
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
        }
        else{
            alert('Bidding price not sufficient')
        } 
    }
    
    render() {
        const {showBidForm} = this.state;
        return (<div>
            <Nav  uid = {this.state.buyerId} role={'buyer'}/>
        <div className = "userhomebg">
        <div className="wrapper">
        <div className="main_content">
        </div>
        </div>
        <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
        <Row>
            <Col>
                <Row>
                    <CropProfile id = {this.state.cid}
                    getPrice = {this.getPrice}
                    getAdvPayment = {this.getAdvPayment}/>
                    <br/>
                </Row>
                <Row><br/></Row>
                <Row>
                    <Trends id = {this.state.cid}/>
                    <br/>
                </Row>
                <Row><br/></Row>
                <Row>
                    <FarmerProfile id = {this.state.fid}/>
                    <br/>
                </Row>
            </Col>
            <Col>
                <Row>
                  <TandC handleBidForm={() => this.handleBidForm()}/>
                </Row>
                <Row><br/></Row>
                <Row>
                <form className="auth-inner">
                <input type="number" className="col-8" min = {this.state.price + 1} placeholder={'Enter amount > '+this.state.price} name="biddingPrice" onChange = {this.handleBiddingPriceChange}/> ₹
                <button type="submit" className="btn btn-primary btn-lg float-right ml-auto" disabled = {!showBidForm} onClick={this.bidding}>BID</button>   
                </form></Row>
            </Col>  
            </Row>          
        </div>
        </div>
        </div>
        );
    }
}
