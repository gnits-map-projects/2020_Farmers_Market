import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import Col from 'react-bootstrap/Col';
import Row from 'react-bootstrap/Row';

class WinnerProfile extends Component {
    constructor(props) {
        super(props);
        console.log("PROPS: "+this.props.id) //prints undefined
        this.state = {
            'winner' : {},
            id: this.props.id,
        };
    }
    
    componentDidMount() {
        console.log("component did mount: "+this.state.id)
        const url = 'http://localhost:9000/getFarmer/'+this.state.id //getting user (common)
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
        .then(response => this.setState({ 'winner' : response}),
        console.log(this.state.winner))
        .catch((error) => {console.error('Error:', error);}); 
                  
    }

    render(){
        console.log(this.state.winner)
        let s=this.state.winner
        if(this.state.winner.rating>5.0){
            this.state.winner.rating = "No rating yet"
        }
        return (

            <div className="auth-inner-half">
                <h1>Winner Profile:</h1><hr/>
                <Row><Col>Name:</Col><Col>{this.state.winner.name}<br/></Col></Row>
                <Row><Col>Mobile:</Col><Col>{this.state.winner.mobile}<br/></Col></Row>
                <Row><Col>Email:</Col><Col>{this.state.winner.email}<br/></Col></Row>
                <Row><Col>Rating:</Col><Col>{this.state.winner.rating}<br/></Col></Row>
            </div>
        );
    }
}

export default WinnerProfile;

