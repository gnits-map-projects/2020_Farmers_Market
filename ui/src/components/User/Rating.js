import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './rating.css'
import { Container } from "react-bootstrap";
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

class Rating extends Component {
render(){
    const {handleRatingChange} = this.props;
return (
    <div>
<form className="rating" onClick = {handleRatingChange}>
<label>
<input type="radio" name="stars" value="0" />
<span className="icon"></span>
</label>
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