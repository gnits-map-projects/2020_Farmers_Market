import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

var body
var result
var key

class CropsToFarmer extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
            id : this.props.id
        };
    }
    componentDidMount() {
        const url = 'http://localhost:9000/getOthersCrops/'+this.state.id
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
        .then(response => this.setState({ 'items' : response}))
        .then(response => console.log(this.state.items.length));          
    }

   renderList(farmer){
        return this.state.items.map(function(item){
            console.log("in render list: " + farmer);
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="1">{item.name}</Col><Col xs="1"></Col><Col xs="2">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                        <Col xs="3">
                            {item.status=="bidding" && <button type="submit" id={item.id} className="btn btn-info btn-lg" onClick={() => {window.location.href = "/viewingTrends/" + item.id + '/' +farmer}}>VIEW TREND</button>}
                            {item.status!="bidding" && <button type="submit" id={item.id} className="btn btn-warning btn-lg" onClick={() => {window.location.href = "/viewBuyer/" + item.id +'/'+ item.fid +'/f'}}>CHECK WINNER</button>}
                        </Col>
                    </Row><hr/>
                </div>
            )
        })
    }

    render(){
        return (
            <div className= "auth-inner">
            <Row>
            <h1>Recent Crops Of Other Farmers</h1><hr/>
            {this.state.items.length > 0 && <button type="submit" className="btn btn-primary btn-lg float-right ml-auto" onClick={() => {window.location.href = "/allCropsFarmer/"+ this.state.id}}>VIEW ALL CROPS</button>}
            </Row><hr/>
            {this.state.items.length == 0 && <h3>No Crops Yet</h3>}
            {this.state.items.length > 0 &&
            <Row>
                <Col xs="1">CROP</Col><Col xs="1"></Col><Col xs="2">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="2">PRICE</Col><Col xs="3">ACTION</Col>
            </Row>}
            <hr/>
            <ul>
                {this.renderList(this.state.id)}
            </ul>
            </div>
        );
    }
}

export default CropsToFarmer;
