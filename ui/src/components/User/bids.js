import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'
import BuyerProfile from './BuyerProfile'

var profile;
var buyer;
var bid;
var flag = 0;
var i;

export default class Bids extends Component{
    constructor(props) {
        super(props);
        this.state = {
            cid : this.props.match.params.cid,
            fid : this.props.match.params.fid,
            profile : false,
            'items' : [],
            buyer : '',
            bid: ''
        };
        this.getPrice = this.getPrice.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    getPrice(price){
        this.setState({price : price});
    }

    getAdvPayment(price){}

    handleClick = (event, buyerId, bid) => {
        this.setState({
          profile: true,
          buyer : buyerId,
          bid: bid
        });
        console.log("BUYER ID:" + this.state.buyer)
    }

    // componentWillUpdate(){
    // this.state.profile &&
    //     (<Row>
    //     <br/>
    //     <BuyerProfile id = {this.state.buyer} bid = {this.state.bid}/>
    //     <br/></Row>)
    // }

    componentDidMount(){
            const url = 'http://localhost:9000/getCropBids/'+this.state.cid;
            let headers = new Headers();

            headers.append('Content-Type', 'application/json');
            headers.append('Accept', 'application/json');

            headers.append('Access-Control-Allow-origin', url);
            headers.append('Access-Control-Allow-Credentials', 'true');

            headers.append('POST', 'GET', 'DELETE');

            fetch(url,{
                headers: headers,
                method : 'GET',
            })
            .then(response => response.json()) 
            .then(response => this.setState({ 'items' : response})); 
            console.log('length: '+this.state.items)
            if(this.state.items == null) flag =2;
            else{
                for(i=0;i< this.state.items.length ;i++)
                    if(this.state.items[i].status == "accepted")
                        flag = 1;
                    else
                        flag = 0;
            }
            console.log(flag)
        }

    renderBids() {
        return this.state.items.map((item) => {
            console.log('In render bids')
            console.log(item)
            console.log(item.status)
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="2">{item.name}</Col><Col xs="1"></Col><Col xs="3">{item.rating}  &nbsp; &nbsp; (out of {item.numrating})</Col><Col xs="1"></Col><Col xs="2">{item.biddingPrice} ₹</Col><Col xs="1"></Col>
                        <Col xs="2">
                        {item.status == "waiting" && <button type="submit" id={item.buyerId} className="btn btn-primary btn-lg" onClick={(event) => this.handleClick(event, item.buyerId, item.id)}>PROCEED</button>}
                        {item.status == "rejected" && <p>Rejected</p>}
                        </Col>
                    </Row><hr/>
                </div>
            )
        })
    }
    
    render() {
        return (<div>
            <Nav uid = {this.state.fid} role={'farmer'}/>
        <div className = "userhomebg">
        
        <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
        <Row>        
            <Col xs = "7">
            <div className="auth-inner">
            <div className = "cropList">
                <h1>Bids</h1><hr/>
            {flag == 0 && 
                <React.Fragment>
                <Row>
                    <Col xs="2">NAME</Col>
                    <Col xs="1"></Col>
                    <Col xs="3">RATING</Col>
                    <Col xs="1"></Col>
                    <Col xs="2">BIDDING PRICE</Col>
                    <Col xs="1"></Col>
                    <Col xs="2">VIEW PROFILE</Col>
                </Row><hr/>
                <ul>
                {this.renderBids()}
                </ul>
                </React.Fragment>
            }
            {flag == 1 && <h3>Bids closed.</h3>}
            {flag == 2 && <h3>No bids yet.</h3>}
            </div>
            </div>
            </Col>

            <Col xs="5">
                <Row>
                <CropProfile id = {this.state.cid} getPrice = {this.getPrice} getAdvPayment = {this.getAdvPayment}/>
                <br/></Row>
                <br/>
                {this.state.profile &&
                <Row>
                <br/>
                <BuyerProfile id = {this.state.buyer} bid = {this.state.bid} cid = {this.state.cid} fid={this.state.fid}/>
                <br/></Row> }     
            </Col>
        </Row>          
        </div>
        </div>
        </div>
        );
    }
}

//onClick={(event) => this.handleClick(event, item.buyerId, item.id)}
//onClick={window.location.href = "/buyerProfile/"+buyer+"/"+bid}