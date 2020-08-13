import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import Nav from './nav.js';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

class AllCropsFarmer extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
            fid: this.props.match.params.id,
        };
    }
    
    componentDidMount() {
        const url = 'http://localhost:9000/getAllOthersCrops/'+this.state.fid
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

    renderList(farmer){
        return this.state.items.map(function(item){
            return(
                <div key={item.id} className = "cropList">
                    <Row>
                        <Col xs="1">{item.name}</Col><Col xs="1"></Col><Col xs="2">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                        <Col xs="3">
                            {item.status=="bidding" && <button type="submit" id={item.id} className="btn btn-info btn-lg" onClick={() => {window.location.href = "/viewingTrends/" + item.id + '/' + farmer}}>VIEW TREND</button>}
                            {item.status!="bidding" && <button type="submit" id={item.id} className="btn btn-warning btn-lg" onClick={() => {window.location.href = "/viewBuyer/" + item.id +'/'+ item.fid +'/f'}}>CHECK WINNER</button>}
                        </Col>
                    </Row><hr/>
                </div>
            )
        })
    }

    render(){
        return (
            <div>
            <Nav uid = {this.state.fid} role={'farmer'}/>
            <div style={{'background-image' : 'url(' + logo +')' }} className = "auth-home" >
            <div className="auth-inner-full">
            <div className = "cropList">
            <Row>
            <h1>Recent Crops Of Other Farmers</h1>
            </Row><hr/>
            <Row>
                <Col xs="1">CROP</Col><Col xs="1"></Col><Col xs="2">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="2">PRICE</Col><Col xs="3">ACTION</Col>
            </Row><hr/>
            </div>
                <ul>
                   {this.renderList(this.state.fid)}
               </ul>
            </div>
            </div>
            </div>
        );
    }
}

export default AllCropsFarmer;

