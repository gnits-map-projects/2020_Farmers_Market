import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'

var body;

export default class Bids extends Component{
    constructor(props) {
        super(props);
        this.state = {
            cid : this.props.match.params.cid,
            fid : this.props.match.params.fid,
        };
        this.getPrice = this.getPrice.bind(this);
        this.bidding = this.bidding.bind(this);
        this.handleBiddingPriceChange = this.handleBiddingPriceChange.bind(this);
    }

    getPrice(price){
        this.setState({price : price});
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
            biddingPrice: this.state.biddingPrice
        }
        if(this.state.biddingPrice > this.state.price){
            const url = 'http://localhost:9000/getCropBids/'+this.state.cid
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
            window.location.href = "/userhome/" + this.state.fid}
            else{alert("Bid UnSuccessful.")}})
        }
        else{
            alert('Bidding price not sufficient')
        } 
    }

    renderBids() {
        return this.state.items.map(function(item){
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="2">{item.name}</Col><Col xs="1"></Col><Col xs="3">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="1">{item.price} ₹</Col><Col xs="1"></Col>
                        <Col xs="1"><button type="submit" id={item.id} className="btn btn-success" onClick={() => {window.location.href = "/bids/" + item.id}}>View bids</button></Col>
                    </Row><hr/>
                </div>
            )
        })
    }
    
    render() {
        const {showBidForm} = this.state;
        return (<div>
            <Nav/>
        <div className = "userhomebg">
        <div className="wrapper">
        <div className="main_content">
        </div>
        </div>
        <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
        <Row>
            <Col>
                {renderBids()}
            </Col>
            <Col>
                <br/><h1>Crop Profile:</h1><br/>
                <hr/></Row><Row>
                <CropProfile id = {this.state.cid}
                getPrice = {this.getPrice}/>
                <br/>
                
            </Col>
        </Row>          
        </div>
        </div>
        </div>
        );
    }
}
