import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

var body

class ClosedDeals extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
            'id' : this.props.match.params.id
        };
    }
    componentDidMount() {
        const url = 'http://localhost:9000/getClosedDeals/'+this.state.id
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
                        <Col xs="1">{item.name}</Col><Col xs="1"></Col><Col xs="2">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                        <Col xs="3">
                        <button type="submit" id={item.id} className="btn btn-danger btn-lg" onClick={() => {window.location.href = "/viewBill/" + item.id + "/" + item.fid + "/" + buyer}}>VIEW BILL</button>
                        </Col>
                    </Row><hr/>
                </div>
            )
        })
    }

    render(){
        return (
            <div>
            <Nav uid = {this.state.id} role={'buyer'}/>
            <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <div className= "auth-inner-full">
            <Row>
            <h1>Your Closed Deals</h1><hr/>
            </Row><hr/>
            {this.state.items.length>0 && <React.Fragment>
            <Row>
                <Col xs="1">CROP</Col><Col xs="1"></Col><Col xs="2">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="2">FINAL PRICE</Col><Col xs="3">ACTION</Col>
            </Row><hr/>
            <ul>
                {this.renderList(this.state.id)}
            </ul>
            </React.Fragment>}

            {this.state.items.length == 0 && <React.Fragment>
            <h3>You have no past deals.</h3></React.Fragment>}

            </div>
            </div>
            </div>
        );
    }
}

export default ClosedDeals;
