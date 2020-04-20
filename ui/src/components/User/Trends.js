import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import Nav from './nav.js';
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import CropProfile from './CropProfile'

export default class Trends extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cid : this.props.id,
            'trend' : '',
        };
    }
    
    componentDidMount() {
        console.log("component did mount:   " + this.state.cid)
        const url = 'http://localhost:9000/getBidTrends/'+this.state.cid
        console.log(this.state.cid)
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
        .then(response => this.setState({ 'trend' : response}),
        console.log(this.state.trend))
        .catch((error) => {console.error('Error:', error);});               
    }

    render(){
        if(this.state.trend.noBids == "NoBidsYet")
        return(
            <div className="auth-inner-half">
            <h1>Trends:</h1><hr/>
            No bids yet.                   
            </div>
        );
        else
        return(
            <div className="auth-inner-half">
            <h1>Trends:</h1><hr/>
            <Row>
                <Col>Maximum bid:</Col>
                <Col>{this.state.trend.maxBid}</Col>
            </Row>
            <Row>
                <Col>Minimum bid:</Col>
                <Col>{this.state.trend.minBid}</Col>
            </Row>                    
            </div>
        )
    }
}