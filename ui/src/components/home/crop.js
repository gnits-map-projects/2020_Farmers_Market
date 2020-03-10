import React, { Component } from "react";
//import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Form from 'react-bootstrap/Form';
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
          fid: this.state.uid,
         
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
            <div className = "auth-inner">
            
            <Form onSubmit={this.handleSubmit}><h3>Fill crop form</h3><br/>            
                <div className="form-group">
                    <label>Crop Name</label>
                    <input type="Text" name="name" id="examplename" className="form-control" placeholder="Enter name."
                                value = {this.state.name} onChange = {this.handleNameChange} />
                </div>
                <div className="form-group">
                    <label>Farm Location</label>
                    <input type="Text" name="location" className="form-control" id="examplelocation" placeholder="Enter location."
                                value = {this.state.location} onChange = {this.handleLocationChange} />
                </div>
                <div className="form-group">
                    <label>Area</label>
                    <input type="Number" name="area" id="examplearea" className="form-control" placeholder="Enter area in acres."
                                value = {this.state.area} onChange = {this.handleAreaChange} />
                </div>

                <div className="form-group">
                    <label>Price</label>
                    <input type="Number" name="price" className="form-control" id="exampleprice" placeholder="Enter price."
                                value = {this.state.price} onChange = {this.handlePriceChange} />
                </div>

                {/* <div className="form-group">
                    <label>Duration</label>
                    <input type="Number" name="duration" className="form-control" id="exampleduration" placeholder="Enter duration in days"
                                value = {this.state.duration} onChange = {this.handleDurationChange} />
                </div> */}

                <div className="form-group">
                    <label>Farming start date</label>
                    <input type="Date" min={today} name="starttime" className="form-control" id="exampleendtime" placeholder="Enter farming start date."
                                value = {this.state.starttime} onChange = {this.handleStarttimeChange} />
                </div>

                <div className="form-group">
                    <label>Harvest date</label>
                    <input type="Date" min={today} name="endtime" className="form-control" id="exampleendtime" placeholder="Enter harvest date."
                                value = {this.state.endtime} onChange = {this.handleEndtimeChange} />
                </div>

                <div className="form-group">
                    <label>Bid end date</label>
                    <input type="Date" min={today} max={restrictTo} name="bidendtime" className="form-control" id="exampleendtime" placeholder="Enter bid end date."
                                value = {this.state.bidendtime} onChange = {this.handleBidendtimeChange} />
                </div>

                <div key={'inline-radio'} className='form-group'>
                    <Form.Label>Is transport cost included? </Form.Label><br />
                    <Form.Check inline type='radio' name='transport' value='Yes' label='Yes' onChange={this.handleTransportChange} />
                    <Form.Check inline type='radio' name='transport' value='No' label='No' onChange={this.handleTransportChange} />
                </div>

                <div className="form-group">
                    <label>Other details <i>(Optional)</i></label>
                    <textarea rows = "5" cols = "70" className="form-control" name = "description" 
                    placeholder = "Enter any extra information that you want your buyer to know and accept." onChange={this.handleTransportChange}/><br/>
                </div>

                <button type="submit" className="btn btn-primary btn-block" onClick = {this.handleSubmit}>ADD YOUR CROP</button>
                
            </Form>
                      
            <br/></div>
        );
    }
}

export default CropForm