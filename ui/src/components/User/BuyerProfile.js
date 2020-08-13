import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';
import Rating from './Rating.js';

class BuyerProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'buyer' : {},
            id: '',
            bid : '',
            checkbx: false,
            fid: this.props.fid,
        };

    }

    accept(){
       const url = 'http://localhost:9000/acceptBid/'+this.props.bid+'/'+this.props.cid
       console.log("ON CLICK ACCEPT.")
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        headers.append('Access-Control-Allow-origin', url);
        headers.append('Access-Control-Allow-Credentials', 'true');

        headers.append('POST', 'GET');

        fetch(url,{
            headers: headers,
            method: 'GET'
        })
        .then(response => response) ////for alert, convert response promise object to string
        .then(response => {this.setState({ 'data' : response});
        console.log(this.state.data);
        alert('You have accepted this bid for this crop.')
        window.location.href = "/userhome/"+this.state.fid}
        );
         
    }

    reject() {
        const url = 'http://localhost:9000/rejectBid/'+this.props.bid+'/'+this.props.cid
        console.log("ON CLICK REJECT." + url)
        let headers = new Headers();

        headers.append('Content-Type', 'application/json');
        headers.append('Accept', 'application/json');

        headers.append('Access-Control-Allow-origin', url);
        headers.append('Access-Control-Allow-Credentials', 'true');

        headers.append('POST', 'GET', 'DELETE');

        fetch(url,{
            headers: headers,
            method : 'GET'
        })
        .then(response => response.json()) 
        .then(response => this.setState({ 'data' : response}));
        console.log(this.state.data);
        alert('You have rejected this bid.')
        window.location.href = "/userhome/"+this.state.fid 
 
    }

    componentDidUpdate(prevProps){
    if(prevProps.id !== this.props.id){
        this.setState({          
            id: this.props.id
        });
        console.log("component did mount")
        const url = 'http://localhost:9000/getFarmer/'+this.props.id
        console.log(this.state.id)
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
        .then(response => this.setState({ 'buyer' : response}),
        console.log(this.state.buyer))
        .catch((error) => {console.error('Error:', error);}); 
    }
}
    
    componentDidMount() {
        console.log("component did mount")
        const url = 'http://localhost:9000/getFarmer/'+this.props.id
        console.log(this.state.id)
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
        .then(response => this.setState({ 'buyer' : response}),
        console.log(this.state.buyer))
        .catch((error) => {console.error('Error:', error);}); 
                  
    }

    render(){
        console.log(this.state.buyer)
        
        console.log(this.state.bid)

        let s=this.state.buyer
        if(this.state.buyer.rating>5.0){
            this.state.buyer.rating = "No rating yet"
        }
        return (
            <div className = "recentbids">
            <div className="auth-inner-half">
                <h1>Buyer Profile:</h1><hr/>
                <Row><Col>Name:</Col><Col>{this.state.buyer.name}<br/></Col></Row>
                <Row><Col>Mobile:</Col><Col>{this.state.buyer.mobile}<br/></Col></Row>
                <Row><Col>Email:</Col><Col>{this.state.buyer.email}<br/></Col></Row>
                <Row><Col>Rating:</Col><Col>{this.state.buyer.rating} &nbsp; &nbsp; (out of {this.state.buyer.numrating})<br/></Col></Row>
                <hr/>
                <input type="checkbox" onChange={() => this.setState({checkbx : !this.state.checkbx})}/><span className='error'>  I understand that other bids will be rejected when I accept this bid.</span><br/><br/>
                <Row>
                    <Col><button id={this.state.id} className="btn btn-success btn-lg" onClick={() => {this.accept()}} disabled = {!this.state.checkbx}>ACCEPT</button></Col>
                    <Col><button id={this.state.id} className="btn btn-danger btn-lg" onClick={() => {this.reject()}}>REJECT</button></Col>
                </Row>
                {/*Buttons to accept and reject */}
            </div>
            </div>
        );
    }
}

export default BuyerProfile;
