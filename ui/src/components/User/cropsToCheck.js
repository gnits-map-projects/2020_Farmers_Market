import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'


class CropsToCheck extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
        };
    
        //this.handleChange = this.handleChange.bind(this);
    }

    handleClick = (event) => {
        console.log("hello")
        //console.log(event.target.getAttribute('id'));
    }; 
    
    
    componentDidMount() {
        const url = 'http://localhost:9000/getUncheckedCrops'
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
        return this.state.items.map(function(item){
            return(
                <div key={item.id} className= "cropList">

                    <Row>
                        <Col xs="2">CROP</Col><Col xs="1"></Col><Col xs="2">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="2">PRICE</Col><Col xs="1"></Col><Col xs="1">CHECK</Col>
                    </Row><hr/>
                    <Row>
                        <Col xs="2">{item.name}</Col><Col xs="1"></Col><Col xs="2">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="2">{item.price} ₹</Col><Col xs="1"></Col>
                        <Col xs="1"><button type="submit" id={item.id} className="btn btn-primary" onClick={() => {window.location.href = "/cropCheck/" + item.id + "/" + item.fid}}>Check</button></Col>
                    </Row>
                    <Row><br/></Row>
                </div>
            )
        })
    }

    // render(){
    //     this.hc()
    //     return (
    //         <div className = "recentbids">
    //         <div className="auth-inner">
    //             <ul>
    //                {this.renderList()}
    //            </ul>
    //         </div>
    //         </div>
    //     );
    // }

    // render(){
    //     return (
    //         <div>
    //         <div>
    //             <br/><h1 align = "center">Crops to check:</h1><br/>
    //             <div className="inner">
    //             <Container className="cont">
    //             <ul>
    //                {this.state.items.map(function(item){
    //                    return(
    //                        <div key={item.id}>
    //                             <Row>
    //                             <Col>{item.name}</Col><Col>{item.area}</Col><Col>{item.price}</Col><Col>{item.id}</Col>
    //                             <Col><button id={item.id} className="btn btn-success">Approve</button></Col>
    //                             <Col><button id={item.id} className="btn btn-danger">Reject</button></Col>
    //                             </Row><Row><br/></Row>
    //                         </div>
    //                    );
    //                }.bind(this))}
    //            </ul>
    //            </Container>
    //            </div>
    //            <br/>
    //         </div>
    //         </div>
    //     );
    // }
}
export default CropsToCheck;

