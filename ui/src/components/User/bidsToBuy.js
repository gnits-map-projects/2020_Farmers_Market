import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

var body
var result
var key

class BidsToBuy extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
            'id' : this.props.id
        };
    }
    componentDidMount() {
        const url = 'http://localhost:9000/getCrops'
        console.log(this.state.id)
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        headers.append('Access-Control-Allow-origin', url);
        headers.append('Access-Control-Allow-Credentials', 'true');

        headers.append('POST', 'GET');

        fetch(url,{
            headers: headers,
            method: 'GET',
            body: JSON.stringify(body)
        })
        .then(response => response.json()) 
        .then(response => this.setState({ 'items' : response}));          
    }

   renderList(buyer){
        return this.state.items.map(function(item){
            console.log("in render list" + buyer);
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="2">{item.name}</Col><Col xs="1"></Col><Col xs="3">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="1">{item.price} ₹</Col><Col xs="1"></Col>
                        <Col xs="1"><button type="submit" id={item.id} className="btn btn-success" onClick={() => {window.location.href = "/cropBid/" + item.id + "/" + item.fid + "/" + buyer}}>Bid</button></Col>
                    </Row><hr/>
                </div>
            )
        })
    }

    render(){
        return (
            <div className= "auth-inner">
            <div className = "cropList">
            <Row>
                <Col xs="2">CROP</Col><Col xs="1"></Col><Col xs="3">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="1">PRICE</Col><Col xs="1"></Col><Col xs="1">BID</Col>
            </Row><hr/>
            </div>
            <ul>
                {this.renderList(this.state.id)}
            </ul>
            </div>
        );
    }
}

export default BidsToBuy;
