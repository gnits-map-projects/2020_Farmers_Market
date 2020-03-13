import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Rating from './Rating.js';

class BuyerProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'buyer' : {},
            id: this.props.id,
            bid : this.props.bid,
        };

    }

    componentWillReceiveProps(newProps){
        console.log('componentWillReceiveProps is triggered')
    }
    
    componentDidMount() {
        console.log("component did mount")
        const url = 'http://localhost:9000/getFarmer/'+this.state.id
        console.log(this.state.id)
        console.log(url)
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
        .then(response => this.setState({ 'buyer' : response}),
        console.log(this.state.buyer))
        .catch((error) => {console.error('Error:', error);}); 
                  
    }

    render(){
        console.log(this.state.buyer)
        
        console.log(this.state.bid)

        let s=this.state.buyer
        if(this.state.buyer.rating>5.0){
            this.state.buyer.rating = "No rating yet"
        }
        return (
            <div className = "recentbids">
            <div className="auth-inner">
                <h1>Buyer Profile:</h1>
                <Rating/><hr/>
                <Row><Col>Name:</Col><Col>{this.state.buyer.name}<br/></Col></Row>
                <Row><Col>Mobile:</Col><Col>{this.state.buyer.mobile}<br/></Col></Row>
                <Row><Col>Email:</Col><Col>{this.state.buyer.email}<br/></Col></Row>
                <Row><Col>Rating:</Col><Col>{this.state.buyer.rating}<br/></Col></Row>
                <hr/>
                <Row>
                    <Col><button id={this.state.id} className="btn btn-success" onClick={() => {this.accept(this.state.id)}}>Accept</button></Col>
                    <Col><button id={this.state.id} className="btn btn-danger" onClick={() => {this.reject(this.state.id)}}>Reject</button></Col>
                </Row>
                {/*Buttons to accept and reject */}
            </div>
            </div>
        );
    }
}

export default BuyerProfile;

