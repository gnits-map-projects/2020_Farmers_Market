import React, { Component } from "react";
import '../images/bgimage.css';
import './home.css';
import NavUnset from './Nav.js';

var body;

export default class VerifyEmail extends Component { 

    constructor(props){
        super(props);
        this.state = {
            uid : this.props.match.params.id,
            verify: '',
        }
    }
    
    componentDidMount(){
        const url = "http://localhost:9000/verifyUser/"+this.state.uid;
        let headers = new Headers();
        headers.append('Content-Type','application/json');
        headers.append('Accept','application/json');
        headers.append('Access-Control-Allow-origin',url);
        headers.append('Access-Control-Allow-Credentials','true');
        headers.append('POST','GET');
        fetch(url, {
        headers:headers,
        method: 'GET',
        body: JSON.stringify(body)
        })
        .then(response => response.json()) 
        .then(response => {
            this.setState({ 'verify' : response});
            console.log(this.state.verify.verify)
            if(this.state.verify.verify == "Already verified")
                window.location.href = "/login";
        })
    }
    
    render() {
        return (<div className="bg">
                    <NavUnset/>
                    <br/><br/><br/><br/><br/>
                    <div className="auth-wrapper">
                        <div className="auth-inner-half"><center>
                            Your has been activated. Thank you for using Farmer's Market.<br/>
                            You can login.</center>
                        </div>
                    </div>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                </div>
        );
    }
}