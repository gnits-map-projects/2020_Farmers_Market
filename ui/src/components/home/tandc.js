import React, { Component } from "react";
import { useHistory, withRouter,Link } from "react-router-dom";
import './home.css';
import Navigation  from './Nav.js';
import {createBrowserHistory} from 'history';

export default class TandC extends Component {
    render() {
        const {handleBidForm} = this.props;
        return (<div className = "auth-inner">
        <h1>TERMS AND CONDITIONS</h1>
        <ul>
        <hr/><li>The bidding shall take place in a fair manner. The winner of the bid shall pay at least 20% of the price qoted by the farmer prior to the start date of farming.</li>
        <hr/><li>If the crop fails due to unseen disasters, the farmers are not bound to pay any kind of compensations. The upfront advance that the bidder has paid shall not be returned.</li>
        <hr/><li>The price quoted for the crops may be subjected to statutory taxes.</li>
        <hr/><li>Amount payments and deductions are carried out by third parties. This website cannot be held responsible in this regard.</li>
        <hr/><li>Transport and other delivery concerns are not within the scope of this website.</li>
        <hr/><li>Beware of fraudulence. If found to be a participant of any kind of malpractice or if reported for malpractise by other users of the wbsite, our admin shall check the correctness of the report. If proven guilty, necessary actions would be taken.</li>
        </ul> 
        <input type="checkbox" onChange={handleBidForm}/><span className='error'>  I accept the above terms and conditions.</span>
        </div>)
    }
}