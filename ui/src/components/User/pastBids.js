import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

class PastBids extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
            buyerid: this.props.id,
        };
        console.log(this.state.buyerid);        //prints buyer id.
    }
    
    componentDidMount() {
        fetch('http://localhost:9000/getPastBids/'+this.state.buyerid)
        .then(response => response.json())
        .then(data => this.setState({ 'items' : data }));
    }

    renderList(buyerid){
        return(
            this.state.items.map(function(item){
                return(
                    <div key={item.id} className = "cropList">
                        <Row>
                            <Col xs="1">{item.name}</Col><Col xs="1"></Col><Col xs="2">{item.area} acres</Col><Col xs="2">{item.location}</Col><Col xs="1"></Col><Col xs="2">{item.price} ₹</Col>
                            <Col xs="3">
                            {item.status == "bidding" && <button type="submit" id={item.id} className="btn btn-success btn-lg" onClick={() => {window.location.href = "/updateBid/" + item.id + "/" + item.fid + "/" + buyerid}}>UPDATE BID</button>}
                            {item.status != "bidding" && <button type="submit" id={item.id} className="btn btn-danger btn-lg" onClick={() => {window.location.href = "/viewBuyer/" + item.id + "/" + buyerid + "/b"}}>CHECK WINNER</button>}
                            </Col>
                        </Row><hr/>
                    </div>
                )
            })
        )
    }

    render(){
        return (
            <div class = "auth-inner-half">
            <Row>
            <h1>Your Bids</h1><hr/>
            <button type="submit" className="btn btn-primary btn-lg float-right ml-auto" onClick={() => {window.location.href = "/allPastBids/"+ this.state.buyerid}}>VIEW ALL</button>
            </Row><hr/>
            <Row>
                <Col xs="1">CROP</Col><Col xs="1"></Col><Col xs="2">AREA</Col><Col xs="2">LOCATION</Col><Col xs="1"></Col><Col xs="2">YOUR BID</Col><Col xs="3">ACTION</Col>
            </Row><hr/>
                <ul>
                   {console.log(this.state.buyerid)}
                   {this.renderList(this.state.buyerid)}
               </ul>
            </div>
        );
    }
}

export default PastBids;
