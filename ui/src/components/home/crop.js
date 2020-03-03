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
        duration : '',
        endtime : '',
        location : '',
        uid : this.props.id,
      }
      this.handleNameChange = this.handleNameChange.bind(this);
      this.handleAreaChange = this.handleAreaChange.bind(this);
      this.handlePriceChange = this.handlePriceChange.bind(this);
      this.handleDurationChange = this.handleDurationChange.bind(this);
      this.handleEndtimeChange = this.handleEndtimeChange.bind(this);
      this.handleLocationChange = this.handleLocationChange.bind(this);
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

    handleDurationChange = event => {
        this.setState({
          duration: event.target.value
        });
      }

    handleEndtimeChange = event => {
        this.setState({
          endtime: event.target.value
        });
      }

    handleLocationChange = event => {
        this.setState({
          location: event.target.value
        });
      }

    handleSubmit(event) {
        event.preventDefault();
        body = {
          name: this.state.name,
          area: this.state.area,
          price: this.state.price,
          duration: this.state.duration,
          endtime: this.state.endtime,
          location: this.state.location,
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
    
        else if (this.state.duration == "") {
          alert('Please enter the duration')
    
        }
    
        else if (this.state.endtime == "") {
          alert('Please enter the endtime')
    
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
            <div class = "recentbids">
            <div className="cropform">
            <Form onSubmit={this.handleSubmit}><h3>Fill crop form</h3><br/>            
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
                    <input type="Number" name="area" id="examplearea" className="form-control" placeholder="Enter area in hectares"
                                value = {this.state.area} onChange = {this.handleAreaChange} />
                </div>

                <div className="form-group">
                    <label>Price</label>
                    <input type="Number" name="price" className="form-control" id="exampleprice" placeholder="Enter price"
                                value = {this.state.price} onChange = {this.handlePriceChange} />
                </div>

                <div className="form-group">
                    <label>Duration</label>
                    <input type="Number" name="duration" className="form-control" id="exampleduration" placeholder="Enter duration in days"
                                value = {this.state.duration} onChange = {this.handleDurationChange} />
                </div>

                <div className="form-group">
                    <label>End time</label>
                    <input type="Date" min={today} max={restrictTo} name="endtime" className="form-control" id="exampleendtime" placeholder="Enter bid end time"
                                value = {this.state.endtime} onChange = {this.handleEndtimeChange} />
                </div>

                <button type="submit" className="btn btn-primary btn-block" onClick = {this.handleSubmit}>ADD</button>
                
            </Form>
            </div>          
            <br/><br/><br/><br/><br/><br/><br/><br/></div>
        );
    }
}

export default CropForm