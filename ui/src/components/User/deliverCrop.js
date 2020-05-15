import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'

var body;

export default class DeliverCrop extends Component{
    constructor(props) {
        super(props);
        this.state = {
            cid: this.props.match.params.cid,
            fid: this.props.match.params.fid,
            winner : {},
            'advPayment': '',
            harvestQuantity : 0,
        };
        this.getAdvPayment = this.getAdvPayment.bind(this);
        this.handleHarvestedQuantityChange = this.handleHarvestedQuantityChange.bind(this);
        this.bidding = this.bidding.bind(this);
    }

    getAdvPayment(advPayment){
        this.setState({advPayment : advPayment});
    }

    getPrice(price){}

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

    handleHarvestedQuantityChange (event) {
        this.setState({
        harvestQuantity: event.target.value
        });
    }

    bidding(event) {
        event.preventDefault();
        body = {
            cropId: this.state.cid,
            harvestedQuantity: this.state.harvestQuantity,
        }
        console.log(body)
        const url = 'http://localhost:9000/harvested'
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
        .then(response => {if(response.ok){alert("Form submitted.");
        window.location.href = "/userhome/" + this.state.fid
        }
        else{alert("Error.")}})
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
                <Row><Col>Rating:</Col><Col>{this.state.winner.rating}<br/></Col></Row>
            </div>
        );
    }

    render() {
        return (<div>
            <Nav uid = {this.state.fid} role={'farmer'}/>
            <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
                <div className= "auth-inner">
                <h1>Crop Harvested Quantity Form</h1><hr/>
                Please fill this form after harvest of the crop to get payable price and thereby, close this crop.<br/>
                The quantity will be cross verified by your buyer.<br/><br/>
                <form>
                <input type="number" step="0.01" className="col-8" placeholder={'Enter quantity as measured.'} name="haevestedQuantity" onChange = {this.handleHarvestedQuantityChange}/> Quintals
                <button type="submit" className="btn btn-primary btn-lg float-right ml-auto" onClick={this.bidding}>SUBMIT</button>   
                </form>
                <br/><hr/>
                <Row><Col>Total price :</Col><Col>{this.state.winner.price} ₹</Col></Row>
                <Row><Col>Advance payment received :</Col><Col>{this.state.advPayment} ₹</Col></Row>
                </div>
            </Row>
            <Row><br/></Row>
            <br/>
            <Row>
                <Col>
                    <CropProfile id = {this.state.cid}
                    getAdvPayment = {this.getAdvPayment}
                    getPrice = {this.getPrice}/>
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
