import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import Nav from './nav.js';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import CropProfile from './CropProfile'
import Trends from './Trends';

export default class ViewingTrends extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cid : this.props.match.params.cid,
            fid : this.props.match.params.fid,
            'trend' : '',
        };
    }
    
    render(){
        return(
            <div>
            <Nav uid = {this.state.fid} role={'farmer'}/>
            <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <Row>
                <Col>
                    <CropProfile id = {this.state.cid}/>
                </Col>
                <Col>
                    <Trends id = {this.state.cid}/>
                </Col>
            </Row>
            </div>
        </div>
        )
    }

}