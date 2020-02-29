import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

class CropProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'crop' : {},
            id: this.props.id,
        };
    }
    
    componentDidMount() {
        console.log("component did mount")
        const url = 'http://localhost:9000/getUncheckedCrop/'+this.state.id
        console.log(this.state.id)
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
        .then(response => this.setState({ 'crop' : response}),
        console.log(this.state.crop))
        .catch((error) => {console.error('Error:', error);}); 
                  
    }

    render(){
        console.log(this.state.crop)
        let s=this.state.crop
        return (
            <div className = "recentbids">
            <div className="auth-inner">
                {this.state.crop.name}<br/>
                {this.state.crop.location}<br/>
                {this.state.crop.area}<br/>
                {this.state.crop.duration}<br/>
                {this.state.crop.price}<br/>
            </div>
            </div>
        );
    }
}

export default CropProfile;

