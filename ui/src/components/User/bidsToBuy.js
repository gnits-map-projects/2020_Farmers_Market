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
            'items' : []
        };
    }
    componentDidMount() {
        const url = 'http://localhost:9000/getCrops'
        console.log(this.props.fid)
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

   renderList(){
        return this.state.items.map(function(item){
            return(
                <div key={item.id}>
                    <Row>
                        <Col xs="3">{item.name}</Col><Col xs="3">{item.area}</Col><Col xs="4">{item.location}</Col>
                        {/* <Col xs="3">{item.price}</Col> */}
                        <Col xs="2"><button type="submit" id={item.id} className="btn btn-success" onClick={() => {window.location.href = "/cropBid/" + item.id + "/" + item.fid}}>Bid</button></Col>
                    </Row><Row><br/></Row>
                </div>
            )
        })
    }

    render(){
        return (
            <div className = "recentbids">
            <div className="auth-inner">
                <ul>
                   {this.renderList()}
               </ul>
            </div>
            </div>
        );
    }
}

export default BidsToBuy;
