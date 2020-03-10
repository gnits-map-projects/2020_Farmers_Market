import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'

class PastBids extends Component {
    constructor(props) {
        super(props);
        this.state = {
            'items' : [],
            buyerid: this.props.id,
        };
    }
    
    componentDidMount() {
        fetch('http://localhost:9000/pastBids/'+this.state.buyerid)
        .then(response => response.json())
        .then(data => this.setState({ 'items' : data }));
    }

    render(){
        return (
            <div class = "recentbids">
                <ul>
                   {this.state.items.map(function(item){
                       return(
                           <div key={item.id} className = "cropList">
                                <h2>{item.name},{item.area},{item.location},{item.price}</h2>
                                <button className="btn btn-warning btn-block" onClick={() => this.handleSubmit(item.id).bind(this)}>Bid</button>
                           </div>
                       )
                   })}
               </ul>
            </div>
        );
    }
}

export default PastBids;
