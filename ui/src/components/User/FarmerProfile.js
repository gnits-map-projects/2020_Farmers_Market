import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

class FarmerProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'farmer' : {},
            id: this.props.id,
        };
    }
    
    componentDidMount() {
        console.log("component did mount")
        const url = 'http://localhost:9000/getFarmer/'+this.state.id
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
        .then(response => this.setState({ 'farmer' : response}),
        console.log(this.state.farmer))
        .catch((error) => {console.error('Error:', error);}); 
                  
    }

    render(){
        console.log(this.state.farmer)
        let s=this.state.farmer
        if(this.state.farmer.rating>5.0){
            this.state.farmer.rating = "No rating yet"
        }
        return (

            <div className="auth-inner-half">
                <h1>Farmer Profile:</h1><hr/>
                <Row><Col>Name:</Col><Col>{this.state.farmer.name}<br/></Col></Row>
                <Row><Col>Mobile:</Col><Col>{this.state.farmer.mobile}<br/></Col></Row>
                <Row><Col>Email:</Col><Col>{this.state.farmer.email}<br/></Col></Row>
                <Row><Col>Rating:</Col><Col>{this.state.farmer.rating} &nbsp; &nbsp; (out of {this.state.farmer.numrating})<br/></Col></Row>
            </div>
        );
    }
}

export default FarmerProfile;

