import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'
import FarmerProfile from './FarmerProfile'

var body;

export default class Payment extends Component{
    constructor(props) {
        super(props);
        this.state = {
            cid: this.props.match.params.cid,
            buyerId: this.props.match.params.buyerId,
            fid: this.props.match.params.fid,
            priceBade : this.props.match.params.priceBade,
        };
        this.handleBiddingPriceChange = this.handleBiddingPriceChange.bind(this);
        this.bidding = this.bidding.bind(this);
    }

    handleBiddingPriceChange (event) {
        this.setState({
        advancePayment: event.target.value
        });
        console.log(event.target.value)
    }

    bidding(event) {
        event.preventDefault();
        body = {
            buyerId: this.state.buyerId,
            cropId: this.state.cid,
            advancePayment: this.state.advancePayment,
            fid: this.state.fid,
            priceBade : this.state.priceBade,
        }
        console.log(body)
        if(this.state.advancePayment >= this.state.priceBade/5){
            const url = 'http://localhost:9000/advPayment'
            let headers = new Headers();
            headers.append('Content-Type', 'application/json');
            headers.append('Accept', 'application/json');
            headers.append('Access-Control-Allow-origin', url);
            headers.append('Access-Control-Allow-Credentials', 'true');
            headers.append('POST', 'GET');

            fetch(url,{
                headers: headers,
                method : 'POST',
                body: JSON.stringify(body)
            })
            .then(response => {if(response.ok){alert("Advance payment successful.");
            window.location.href = "/buyerhome/" + this.state.buyerId
        }
        else{alert("Advance payment unSuccessful.")}})
        }
        else{
            alert('Advance payment price not sufficient')
        }
    }

    render() {
        return (<div>
            <Nav uid = {this.state.buyerId} role={'buyer'}/>
            <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
                <div className= "auth-inner"><h1>Payment</h1><hr/>
                <Row><Col>Your total price as bade :</Col><Col>{this.state.priceBade} ₹</Col></Row>
                <Row><Col>Advance payment (minimum 20%) :</Col><Col>{this.state.priceBade/5} ₹</Col></Row>
                <hr/>
                <form>
                <input type="number" className="col-8" min = {this.state.priceBade/5} placeholder={'Enter amount > '+this.state.priceBade/5} name="advancePayment" onChange = {this.handleBiddingPriceChange}/> ₹
                <button type="submit" className="btn btn-primary btn-lg float-right ml-auto" onClick={this.bidding}>PAY</button>   
                </form>
                </div>
            </Row>
            <Row><br/></Row>
            <br/>
            <Row>
                <Col>
                    <CropProfile id = {this.state.cid}/>
                </Col>
                <Col>
                    <FarmerProfile id = {this.state.fid}/>
                </Col>
            </Row>            
        </div>
        </div>
        );
    }
}
