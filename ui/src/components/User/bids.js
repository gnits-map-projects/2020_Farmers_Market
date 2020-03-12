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

export default class Bids extends Component{
    constructor(props) {
        super(props);
        this.state = {
            cid : this.props.match.params.cid,
            fid : this.props.match.params.fid,
            profile : false,
            'items' : [],
            buyer : '',
        };
        this.getPrice = this.getPrice.bind(this);
        this.handleClick = this.handleClick.bind(this);
    }

    getPrice(price){
        this.setState({price : price});
    }

    handleClick = (event,id) => {

        console.log("hello, id: " +id)
        console.log(this.state.profile)
        this.setState({'profile': true})
        this.setState({'buyer' : id})
        console.log(this.state.buyer)
        this.renderProfile()
    }
    
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
            console.log(this.state.items)
        }

    renderProfile(){
        console.log(this.state.buyer)
        return(  
            this.state.profile &&
                (<Row>
                <br/>
                <BuyerProfile id = {this.state.buyer}/>
                <br/></Row>))
    }

    renderBids() {
        return this.state.items.map((item) => {
            console.log('In render bids')
            console.log(item)
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="2">{item.name}</Col><Col xs="1"></Col><Col xs="3">{item.rating}</Col><Col xs="1"></Col><Col xs="2">{item.biddingPrice} ₹</Col><Col xs="1"></Col>
                        <Col xs="2"><button type="submit" id={item.buyerId} className="btn btn-success" onClick={(event) => this.handleClick(event, item.buyerId)}
                            >Proceed</button></Col>
                    </Row><hr/>
                </div>
            )
        })
    }
    
    render() {
        return (<div>
            <Nav/>
        <div className = "userhomebg">
        
        <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
        <Row>        
            <Col>
            <div className="auth-inner">
            <div className = "cropList">
            <Row>
                <Col xs="2">NAME</Col><Col xs="1"></Col><Col xs="3">RATING</Col><Col xs="1"></Col><Col xs="2">BIDDING PRICE</Col><Col xs="1"></Col><Col xs="2">VIEW PROFILE</Col>
            </Row><hr/>
                <ul>
                {this.renderBids()}
                </ul>
            </div>
            </div>
            </Col>

            <Col>
                <Row>
                <CropProfile id = {this.state.cid} getPrice = {this.getPrice}/>
                <br/></Row>
                <br/>
                {this.renderProfile()}                
            </Col>
        </Row>          
        </div>
        </div>
        </div>
        );
    }
}