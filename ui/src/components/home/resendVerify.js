import React, { Component } from "react";
import '../images/bgimage.css';
import './home.css';
import NavUnset from './Nav.js';

var body;
var result;

export default class ResendVerify extends Component {

    constructor(props){
        super(props);
        this.state = {
            email : this.props.match.params.email,
            uid : this.props.match.params.id,
        }
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleSubmit(event) {
        event.preventDefault();
        const url = "http://localhost:9000/sendAuthEmail/"+this.state.email+"/"+this.state.uid;
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
        .then(response => {if(response.ok){
            alert("Verification link sent to your registered email.");
            result = response.json();
            console.log(result);
            window.location.href = '/home'
        }})
        .catch(()=> console.log("Can't access " + url + " response. "))
    }      
    
    render() {
        return (<div className="bg">
                    <NavUnset/>
                    <br/><br/><br/><br/><br/>
                    <div className="auth-wrapper">
                        <div className="auth-inner-half"><center>
                            You did not activate your account. Please use the link sent to your registered emial to activate your account.<br/><br/>
                            <div className="col text-center">
                                <button type="submit" className="btn btn-primary btn-lg" onClick={this.handleSubmit}>RESEND VERIFICATION LINK</button>
                            </div></center>
                        </div>
                    </div>
                    <br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/><br/>
                </div>
        );
    }
}