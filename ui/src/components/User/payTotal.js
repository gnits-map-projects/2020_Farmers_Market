import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'
import FarmerProfile from './FarmerProfile'
import Rating from './Rating'

var body;

export default class PayTotal extends Component{
    constructor(props) {
        super(props);
        this.state = {
            cid: this.props.match.params.cid,
            buyerId: this.props.match.params.buyerId,
            fid: this.props.match.params.fid,
            priceBade : this.props.match.params.priceBade,
            paid : this.props.match.params.paid,
            harvestedQuantity : this.props.match.params.harvestedQuantity,
            totalPayable : this.props.match.params.totalPayable,
            showBidForm: false,
            rating:'',
        };
        this.bidding = this.bidding.bind(this);
        this.handleBidForm = this.handleBidForm.bind(this);
    }

    handleBidForm () {
      this.setState({showBidForm: !this.state.showBidForm})
    }

    handleRatingChange (event) {
        this.setState({
        rating: event.target.value
        });
        console.log(this.state.rating)
    }

    bidding(event) {
        event.preventDefault();
        body = {
            buyerId: this.state.buyerId,
            cropId: this.state.cid,
            fid: this.state.fid,
            rating: this.state.rating,
        }
        console.log(body)
        if(this.state.rating == "")
            alert("Please rate the farmer.")
        else{
            const url = 'http://localhost:9000/totalPayment'
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
            window.location.href = "/buyerhome/" + this.state.buyerId}
            else{alert("Advance payment unSuccessful.")}})
        }
    }

    render() {
        return (<div>
            <Nav uid = {this.state.buyerId} role={'buyer'}/>
            <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
            <Col>
                <div className= "auth-inner"><h1>Payment</h1><hr/>
                <Row><Col>Your total price as bade :</Col><Col>{this.state.priceBade} ₹</Col></Row>
                <Row><Col>Total payable price :</Col><Col>{this.state.totalPayable} ₹</Col></Row>
                <Row><Col>Advance paid :</Col><Col>{this.state.paid} ₹</Col></Row>
                <Row><Col>Remaining amount :</Col><Col>{this.state.totalPayable - this.state.paid} ₹</Col></Row>
                <Row><Col>Crop Quantity harvested :</Col><Col>{this.state.harvestedQuantity} quintals</Col></Row>
                <Row><Col><br/><b>The price is calculated based on the quantity harvested by your farmer. Please verify quantiy of the crop before payment. If there is any mismatch, please proceed to grievances page. Our Admin will help you.</b></Col></Row>
                <hr/>
                Please rate your farmer.<Rating handleRatingChange = {(event) => this.handleRatingChange(event)}/>
                <form>
                <input type="checkbox" onChange={this.handleBidForm}/><span className='error'>  I recieved the crop and quantity of the crop is as above.</span>
                <button type="submit" className="btn btn-primary btn-lg float-right ml-auto" disabled = {!this.state.showBidForm} onClick={this.bidding}>PAY</button>   
                </form>
                </div>
                <Row><br/></Row>
            </Col>
            <Col>
                <Row>
                    <CropProfile id = {this.state.cid}/>
                </Row>
                <Row><br/></Row>
                <Row>
                    <FarmerProfile id = {this.state.fid}/>
                </Row>
            </Col> 
            </Row>           
        </div>
        </div>
        );
    }
}
