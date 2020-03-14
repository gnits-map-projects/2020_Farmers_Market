import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

export default class ViewingTrends extends Component {
    constructor(props) {
        super(props);
        this.state = {
            cid : this.props.match.params.cid,
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
        return(
        <div className="auth-inner-white">
        <h1>Trends:</h1><hr/>
        Maximum bid: {this.state.trend.maxBid}<br/>
        Minimum bid: {this.state.trend.minBid}<br/>
        </div>
        )
    }

}