import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

class RecentCrops extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
            fid: this.props.id,
        };
    }
    
    componentDidMount() {
        const url = 'http://localhost:9000/getFarmerCrops/'+this.props.id
        console.log(this.state.fid)
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
    }

    renderList(){
        return this.state.items.map(function(item){
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="1">{item.name}</Col><Col xs="1"></Col><Col xs="2">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                        <Col xs="3"><button type="submit" id={item.id} className="btn btn-success btn-lg" onClick={() => {window.location.href = "/bids/" + item.id +'/'+ item.fid}}>VIEW BIDS</button></Col>
                    </Row><hr/>
                </div>
            )
        })
    }

    render(){
        return (
            <div className="auth-inner">
            <div className = "cropList">
            <Row>
            <h1>Your Crops</h1>
            <button type="submit" className="btn btn-primary btn-lg float-right ml-auto" onClick={() => {window.location.href = "/allBids/"+ this.state.fid}}>VIEW ALL CROPS</button>
            </Row><hr/>
            <Row>
                <Col xs="1">CROP</Col><Col xs="1"></Col><Col xs="2">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="2">PRICE</Col><Col xs="3">VIEW BIDS</Col>
            </Row><hr/>
            </div>
                <ul>
                   {this.renderList()}
               </ul>
            </div>

        );
    }
}

export default RecentCrops;

