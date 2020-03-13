import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './rating.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

class Rating extends Component {
constructor(props) {
super(props);
this.state = {
'rate':0
};
this.handleChange = this.handleChange.bind(this);
}

handleChange(event){
this.setState({'rate' : event.target.value})

}

render(){
    console.log('Rating: ' + this.state.rate)
let s=this.state.crop
return (
    <div>
<form className="rating" onClick = {this.handleChange}>
<label>
<input type="radio" name="stars" value="1" />
<span className="icon">★</span>
</label>
<label>
<input type="radio" name="stars" value="2" />
<span className="icon">★</span>
<span className="icon">★</span>
</label>
<label>
<input type="radio" name="stars" value="3" />
<span className="icon">★</span>
<span className="icon">★</span>
<span className="icon">★</span>
</label>
<label>
<input type="radio" name="stars" value="4" />
<span className="icon">★</span>
<span className="icon">★</span>
<span className="icon">★</span>
<span className="icon">★</span>
</label>
<label>
<input type="radio" name="stars" value="5" />
<span className="icon">★</span>
<span className="icon">★</span>
<span className="icon">★</span>
<span className="icon">★</span>
<span className="icon">★</span>
</label>
</form>
</div>
);
}
}

export default Rating;