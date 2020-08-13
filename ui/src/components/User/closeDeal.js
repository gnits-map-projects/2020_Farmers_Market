import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import CropProfile from './CropProfile'
import Rating from './Rating'

var body;

export default class CloseDeal extends Component{
    constructor(props) {
        super(props);
        this.state = {
            cid: this.props.match.params.cid,
            fid: this.props.match.params.fid,
            winner : {},
            rating:'',
        };
        this.handleClick = this.handleClick.bind(this);
    }

    handleRatingChange (event) {
        this.setState({
        rating: event.target.value
        });
        console.log(this.state.rating)
    }

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

    handleClick(event){
        event.preventDefault();
        body = {
            buyerId: this.state.winner.id,
            cropId: this.state.cid,
            rating: this.state.rating,
        }
        console.log(body)
        if(this.state.rating == "")
            alert("Please rate the farmer.")
        else{
            const url = 'http://localhost:9000/closeDeal'
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
            .then(response => {if(response.ok){alert("Deal closed successfully.");
            window.location.href = "/userhome/" + this.state.fid}
            else{alert("Deal closing unsuccessful.")}})
        }
    }
    
    renderWinner(){
        if(this.state.winner.rating>5.0)
            this.state.winner.rating = "No rating yet";
        return (
            <div className="auth-inner-half">
                <h1>Buyer Profile:</h1><hr/>
                <Row><Col>Name:</Col><Col>{this.state.winner.name}<br/></Col></Row>
                <Row><Col>Mobile:</Col><Col>{this.state.winner.mobile}<br/></Col></Row>
                <Row><Col>Email:</Col><Col>{this.state.winner.email}<br/></Col></Row>
                <Row><Col>Rating:</Col><Col>{this.state.winner.rating} &nbsp; &nbsp; (out of {this.state.winner.numrating})<br/></Col></Row>
                <hr/>
                <b>Rate buyer and close this deal.</b><Rating handleRatingChange = {(event) => this.handleRatingChange(event)}/>
                <form>
                <button type="submit" className="btn btn-danger btn-lg float-right ml-auto" onClick={this.handleClick}>CLOSE THIS DEAL</button>   
                </form>
            </div>
        );
    }

    render() {
        return (<div>
            <Nav uid = {this.state.fid} role={'farmer'}/>
            <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
            <Col>
            <Row>
                <div className= "auth-inner-half"><h1>This crop was bought at price: {this.state.winner.price} ₹</h1></div>
            </Row>
            <Row><br/></Row>
            <CropProfile id = {this.state.cid}/>
            </Col> 
            <Col>
            <br/>
            <Row>
                {this.renderWinner()}
            </Row>
            </Col>
            </Row>            
        </div>
        </div>
        );
    }
}
