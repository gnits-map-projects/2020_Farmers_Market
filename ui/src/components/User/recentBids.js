import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

class Recents extends Component {
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
                        <Col xs="3">{item.name}</Col><Col xs="3">{item.area} acres</Col><Col xs="4">{item.location}</Col>
                        {/* <Col>{item.price}</Col> */}
                        <Col xs="2"><button type="submit" id={item.id} className="btn btn-success" onClick={() => {window.location.href = "/cropBid/" + item.id + '/' + item.fid}}>Bid</button></Col>
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
                <Col xs="2">CROP</Col><Col xs="1"></Col><Col xs="3">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="1">PRICE</Col><Col xs="1"></Col><Col xs="1">BID</Col>
            </Row><hr/>
            </div>
                <ul>
                   {this.renderList()}
               </ul>
            </div>

        );
    }
}

export default Recents;

