import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import ListCropTypes from './listCropTypes.js'

var buyer
class CropsIn extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
            location : this.props.match.params.location,
            id : this.props.match.params.id
        };
    
        //this.handleChange = this.handleChange.bind(this);
    }

    handleClick = (event) => {
        console.log("hello")
        //console.log(event.target.getAttribute('id'));
    }; 
    
    
    componentDidMount() {
        const url = 'http://localhost:9000/cropsIn/'+this.state.location
        console.log(this.state.location)
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
        .then(response => this.setState({ 'items' : response}));
        console.log(this.state.items);   

             
    }

    render(){
        return (
            <div>
            <Nav/>
            <div className = "userhomebg">
            <div class = "recentbids">
                <br/><h1 align = "center">Crops Found in {this.state.location}</h1><br/>
                <Container>
                <ListCropTypes location = {this.state.location}/>
                <br/>
                <div className="auth-inner">
                <ul>
                   {this.state.items.map(function(item){
                       return(
                           <div key={item.id}>
                                <Row>
                                <Col xs="3">{item.name}</Col><Col xs="3">{item.area}</Col><Col xs="4">{item.location}</Col>
                                {/* <Col>{item.price}</Col> */}
                                <Col xs = "2"><button id={item.id} className="btn btn-success btn-lg" onClick={() => {window.location.href = "/cropBid/" + item.id + "/" + item.fid + "/" + this.state.id}}>BID</button></Col>
                                </Row><Row><br/></Row>
                            </div>
                       );
                   }.bind(this))}
               </ul>
               </div>
               </Container>
               <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/>
               <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/><br/> <br/>
               <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/> <br/><br/> <br/>
            </div>
            </div>
            </div>
        );
    }
}
export default CropsIn;

