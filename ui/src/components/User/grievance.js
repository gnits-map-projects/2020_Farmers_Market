import React, { Component } from "react";
import '../images/bgimage.css';
import './UserHome.css'
import Nav from './nav.js';
import Select from 'react-select';

var body;
var urole;
var uname;
var uid;
var status;
var result;
let token="";

class Grievance extends Component{

  selectRef: ElementRef<*>;
  focus = () => {
    console.log(this.selectRef);
    this.selectRef.focus();
  };
  
  constructor(props) {
    super(props);
    this.state={
      uid : this.props.match.params.id,
      role : this.props.match.params.role,
      subject : '',
      decription: '',
      subjectOptions : [
        {'label':'Request to extend bid end time', 'value':'Request to extend bid end time'},
        {'label':'Advance payment delay', 'value':'Advance payment delay'},
        {'label':'Crop delivery delay', 'value':'Crop delivery delay'},
        {'label':'Total payable amount calculation', 'value':'Total payable amount calculation'},
        {'label':'Advance Payment Delay', 'value':'Advance Payment Delay'},
        {'label':'Suggestion to improve', 'value':'Suggestion to improve'},
        {'label':'Other', 'value':'Other'},
      ],
    }
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleDescriptionChange = this.handleDescriptionChange.bind(this);
    this.handleSubjectChange = this.handleSubjectChange.bind(this);
  }

  handleSubjectChange(selectedOption){
    console.log(selectedOption.value);
    this.setState({
      subject : selectedOption.value
    });
  }

  handleDescriptionChange = event => {
    this.setState({
      description : event.target.value
    })
  } 

  handleSubmit(event) {
    event.preventDefault();
    console.log(this.state)
    var body = {
      subject : this.state.subject,
      description : this.state.description,
    }
    console.log(body);
    if(this.state.subject==""){
      alert('Please enter the subject')

    }
    else if(this.state.description==""){
      alert('Please enter the description')
    }
    
    else{
      const url = "http://localhost:9000/mailToAdmin/"+this.state.uid;
      let headers = new Headers();
  
      headers.append('Content-Type','application/json');
      headers.append('Accept','application/json');
      headers.append('Access-Control-Allow-origin',url);
      headers.append('Access-Control-Allow-Credentials','true');
      headers.append('POST','GET');
  
      fetch(url, {
        headers: headers,
        method: 'POST',
        body: JSON.stringify(body)
      })
      .then(response => {if(response.ok){
        alert("Email sent to admin. Thank you.");
        document.getElementById("subject").value = "";
        document.getElementById("description").value = "";
      }})
    } 
  }

  render() {

    return (<div className="bg">
    <Nav uid={this.state.uid} role={this.state.role}/>

        <div className="auth-wrapper">
        <div className="auth-inner">
            
        <form>
            <h1>GRIEVANCE</h1><hr/>
            <h3>Write to us and our admin will respond to you soon.</h3>
            <div className="form-group">
            <Select
                ref={ref => {
                    this.selectRef = ref;
                }}
                name="subject"
                placeholder = "Select a subject"
                options={this.state.subjectOptions}
                onMouseEnter={this.focus}
                onChange = {this.handleSubjectChange}
                id = "subject"/>
            </div>

            <div className="form-group">
                <label>Description</label>
                <textarea rows = "5" cols = "70" className="form-control" name = "description" id = "description"
                placeholder = "Let us know the details of your complaint." onChange={this.handleDescriptionChange}/><br/>
            </div>             

            <button type="submit" className="btn btn-primary btn-block btn-lg" onClick={this.handleSubmit}>SEND</button>
        </form>
        </div>
        <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
        </div>
        </div>
    );
  }
}
export default Grievance;