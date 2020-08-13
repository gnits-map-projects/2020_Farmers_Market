import React, { Component } from "react";
//import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Form from 'react-bootstrap/Form';
import Col from 'react-bootstrap/Col'
import Row from 'react-bootstrap/Row'

var body;

//var uid = window.uid;

var dt = new Date();
var month = dt.getMonth()+1;
if(month<10){
  month = "0"+month.toString();
}
var date = dt.getDate();
if(date<10){
  date = "0"+date.toString();
}
var year = dt.getFullYear().toString();
var today = year+"-"+month+"-"+date;

var days = 15; //BID WINDOW
var dtR = new Date(dt.getTime() + (days * 24 * 60 * 60 * 1000));
month = dtR.getMonth()+1;
if(month<10){
  month = "0"+month.toString();
}
date = dtR.getDate();
if(date<10){
  date = "0"+date.toString();
}
year = dtR.getFullYear().toString();
var restrictTo = year+"-"+month+"-"+date;

class CropForm extends Component{
    constructor(props) {
      super(props);
      this.state={
        name : '',
        area : '',
        price : '',
        starttime : '',
        endtime : '',
        bidendtime : '',
        location : '',
        transport : '',
        description : '',
        quantitymin : null,
        quantitymax : null,
        uid : this.props.id,
      }
      this.handleNameChange = this.handleNameChange.bind(this);
      this.handleAreaChange = this.handleAreaChange.bind(this);
      this.handlePriceChange = this.handlePriceChange.bind(this);
      this.handleStarttimeChange = this.handleStarttimeChange.bind(this);
      this.handleEndtimeChange = this.handleEndtimeChange.bind(this);
      this.handleLocationChange = this.handleLocationChange.bind(this);
      this.handleBidendtimeChange = this.handleBidendtimeChange.bind(this);
      this.handleTransportChange = this.handleTransportChange.bind(this);
      this.handleDescriptionChange = this.handleDescriptionChange.bind(this);
      this.handleQuantityminChange = this.handleQuantityminChange.bind(this);
      this.handleQuantitymaxChange = this.handleQuantitymaxChange.bind(this);
      this.handleSubmit = this.handleSubmit.bind(this);
      //alert(today)
    }

    handleNameChange = event => {
        this.setState({
          name: event.target.value
        });
      }

    handleAreaChange = event => {
        this.setState({
          area: event.target.value
        });
      }

    handlePriceChange = event => {
        this.setState({
          price: event.target.value
        });
      }

    handleStarttimeChange = event => {
        this.setState({
          starttime: event.target.value
        });
      }

    handleEndtimeChange = event => {
        this.setState({
          endtime: event.target.value
        });
      }

    handleBidendtimeChange = event => {
        this.setState({
          bidendtime: event.target.value
        });
      }

    handleLocationChange = event => {
        this.setState({
          location: event.target.value
        });
      }

    handleTransportChange = event => {
        this.setState({
          transport: event.target.value
        });
      }

    handleDescriptionChange = event => {
        this.setState({
          description: event.target.value
        });
      }

    handleQuantityminChange = e => {
        this.setState({
          quantitymin:  e.target.type === 'number' ? parseFloat(e.target.value) : e.target.value
        });
      }

    handleQuantitymaxChange = e => {
        this.setState({
          quantitymax:  e.target.type === 'number' ? parseFloat(e.target.value) : e.target.value
        });
      }

    handleSubmit(event) {
        event.preventDefault();
        body = {
          name: this.state.name,
          area: this.state.area,
          price: this.state.price,
          starttime: this.state.starttime,
          endtime: this.state.endtime,
          bidendtime: this.state.bidendtime,
          location: this.state.location,
          transport: this.state.transport,
          description: this.state.description,
          quantitymin: this.state.quantitymin,
          quantitymax: this.state.quantitymax,
          fid: this.state.uid,
          status : 'bidding',
          harvestedQuantity : 0,
          advPayment : 0,
          totalPayable : 0,
        }
        console.log(body);
        if (this.state.name == "") {
          alert('Please enter the crop name')
        }
    
    
        else if (this.state.area == "") {
          alert('Please enter the area')
        }
    
        else if (this.state.price == "") {
          alert('Please enter the price')
        }

        else if(this.state.quantitymin == null)
          alert("Please enter minimum quantity")

        else if(this.state.quantitymin == null)
          alert("Please enter minimum quantity")

        else if(this.state.quantitymin <= 0)
          alert("Minimum quantity cannot be zero")

        else if(this.state.quantitymax < this.state.quantitymin)
          alert("Maximum quantity must be greater than minimum quantity")

        else if(this.state.quantitymax > this.state.quantitymin + 10)
          alert("Maximum and minimum quantity range cannot exceed 10 quintals.")

        else if (this.state.starttime == "") {
          alert('Please enter the start date')
    
        }
    
        else if (this.state.endtime == "") {
          alert('Please enter the end date')
    
        }

        else if (this.state.bidendtime == "") {
          alert('Please enter the bid end date')
    
        }

        else if (this.state.transport == "") {
          alert('Please select the transport option')
    
        }

        else if (this.state.quantitymin == "") {
          alert('Please enter the minimum quantity')
    
        }

        else if (this.state.quantitymax == "") {
          alert('Please enter the maximum quantity')
    
        }
    
        else {
          const url = "http://localhost:9000/addUncheckedCrop";
          let headers = new Headers();
    
          headers.append('Content-Type', 'application/json');
          headers.append('Accept', 'application/json');
    
          headers.append('Access-Control-Allow-origin', url);
          headers.append('Access-Control-Allow-Credentials', 'true');
    
          headers.append('POST', 'GET');
    
          fetch(url, {
            headers: headers,
            method: 'POST',
            body: JSON.stringify(body)
          })
    
             
            .then(response => response.json())
            .then(contents => {
              console.log(contents);
    
            })
            .catch(() => console.log("can't access" + url + "response. "))
            
           //window.location.href = '/login'
            alert("Successful");
    
        }
        
      }
    
      render() {
        return (
            <div className = "auth-inner-half">
            
            <Form onSubmit={this.handleSubmit}><h1>Add Crop</h1><hr/>         
                <div className="form-group">
                    <label>Crop Name</label>
                    <input type="Text" name="name" id="examplename" className="form-control" placeholder="Enter name"
                                value = {this.state.name} onChange = {this.handleNameChange} />
                </div>
                <div className="form-group">
                    <label>Farm Location</label>
                    <input type="Text" name="location" className="form-control" id="examplelocation" placeholder="Enter location"
                                value = {this.state.location} onChange = {this.handleLocationChange} />
                </div>
                <div className="form-group">
                    <label>Area</label>
                    <input type="Number" step="0.01" name="area" id="examplearea" className="form-control" placeholder="Enter area in acres"
                                value = {this.state.area} onChange = {this.handleAreaChange} />
                </div>

                <div className="form-group">
                    <label>Price</label>
                    <input type="Number" name="price" className="form-control" id="exampleprice" placeholder="Enter price in ₹"
                                value = {this.state.price} onChange = {this.handlePriceChange} />
                </div>

                <div className="form-group">
                    <label>Quantity range (In quintals): <i>Try to keep the range small.</i></label>
                    <Row>
                    <Col><input type="Number" step="0.1" name="quantitymin" min="0" className="form-control" id="examplequantitymin" placeholder="Enter minimum quantity"
                                value = {this.state.quantitymin} onChange = {this.handleQuantityminChange} /></Col>
                    <Col><input type="Number" step="0.1" name="quantitymax" min={this.state.quantitymin} max={this.state.quantitymin+10} className="form-control" id="examplequantitymax" placeholder="Enter maximum quantity"
                                value = {this.state.quantitymax} onChange = {this.handleQuantitymaxChange} /></Col>
                    </Row>
                </div>

                <div className="form-group">
                    <label>Farming start date</label>
                    <input type="Date" min={today} name="starttime" className="form-control" id="exampleendtime" placeholder="Enter farming start date"
                                value = {this.state.starttime} onChange = {this.handleStarttimeChange} />
                </div>

                <div className="form-group">
                    <label>Harvest date</label>
                    <input type="Date" min={today} name="endtime" className="form-control" id="exampleendtime" placeholder="Enter harvest date"
                                value = {this.state.endtime} onChange = {this.handleEndtimeChange} />
                </div>

                <div className="form-group">
                    <label>Bid end date</label>
                    <input type="Date" min={today} max={restrictTo} name="bidendtime" className="form-control" id="exampleendtime" placeholder="Enter bid end date"
                                value = {this.state.bidendtime} onChange = {this.handleBidendtimeChange} />
                </div>

                <div key={'inline-radio'} className='form-group'>
                    <Form.Label>Is transport cost included? </Form.Label><br />
                    <Form.Check inline type='radio' name='transport' value='Yes' label='Yes' onChange={this.handleTransportChange} />
                    <Form.Check inline type='radio' name='transport' value='No' label='No' onChange={this.handleTransportChange} />
                </div>

                <div className="form-group">
                    <label>Other details/conditions <i>(Optional)</i></label>
                    <textarea rows = "5" cols = "70" className="form-control" name = "description" 
                    placeholder = "Enter any extra information or conditons that you want your buyer to know and accept" onChange={this.handleTransportChange}/><br/>
                </div>

                <button type="submit" className="btn btn-primary btn-block" onClick = {this.handleSubmit}>ADD YOUR CROP</button>
                
            </Form>
                      
            <br/></div>
        );
    }
}

export default CropForm