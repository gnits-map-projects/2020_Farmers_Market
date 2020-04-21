import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

class CropProfile extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'crop' : {},
            id: this.props.id,
        };
        this.setPrice = this.setPrice.bind(this);
        this.setAdvPayment = this.setAdvPayment.bind(this);
    }

    setAdvPayment(price){
        this.props.getAdvPayment(price);
    }

    setPrice(price){
        this.props.getPrice(price);
    }
    
    componentDidMount() {
        console.log("component did mount")
        const url = 'http://localhost:9000/getCrop/'+this.state.id
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
        .then(response => 
        {this.setState({ 'crop' : response});
        this.setAdvPayment(this.state.crop.advPayment);
        this.setPrice(this.state.crop.price)},
        console.log(this.state.crop))
        .catch((error) => {console.error('Error:', error);}); 
    }

    render(){
        console.log(this.state.crop)
        return (
            <div className="auth-inner-half">
            <h1>Crop Profile:</h1><hr/>
                <Row><Col>Crop :</Col><Col>{this.state.crop.name}<br/></Col></Row>
                <Row><Col>Location :</Col><Col>{this.state.crop.location}<br/></Col></Row>
                <Row><Col>Area :</Col><Col>{this.state.crop.area} acres<br/></Col></Row>
                <Row><Col>Quantity :</Col><Col>{this.state.crop.quantitymin} - {this.state.crop.quantitymax} quintals<br/></Col></Row>
                <Row><Col>Transport provision :</Col><Col>{this.state.crop.transport}<br/></Col></Row>
                <Row><Col>Farming start date :</Col><Col>{this.state.crop.starttime}<br/></Col></Row>
                <Row><Col>Harvest date :</Col><Col>{this.state.crop.endtime}<br/></Col></Row>
                <Row><Col>Bid end date :</Col><Col>{this.state.crop.bidendtime}<br/></Col></Row>
                <Row><Col>More details/condition :</Col><Col>{this.state.crop.description=="" && <p>None</p>} {this.state.crop.description!="" && <p>{this.state.crop.description}</p>}</Col></Row>
                <Row><Col><b>Price :</b></Col><Col><b>{this.state.crop.price} ₹</b><br/></Col></Row>
            </div>
        );
    }
}

export default CropProfile;

