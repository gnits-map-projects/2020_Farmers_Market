import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'
import RecentCrops from "./recentCrops";
import CropForm from "../home/crop";
import CropsToFarmer from "./CropsToFarmer";

//import SignUp from "../components/signup.component";
//import User from "./components/user"
/*function Login(prop){
const onSubmit =() => {
prop.history.push('/User');
}*/
export default class UserHome extends Component{
render() {
    var uid=this.props.match.params.id
    return (<div>
        <Nav uid = {uid} role={'farmer'}/>
    <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
                <Col xs="6">
                        <CropForm id={uid}/>
                </Col>
                <Col xs="6">
                    <Row> 
                            <RecentCrops id={uid}/>
                    </Row>
                        <br/>
                    <Row>
                            <CropsToFarmer id={uid}/>
                    </Row>
                </Col>
                
            </Row>

    </div>
    </div>
    );
}
}
