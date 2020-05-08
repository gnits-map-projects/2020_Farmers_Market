import React ,{ Component } from 'react';

import { BrowserRouter as Router, 
  Switch, 
  Route,
  Link } from "react-router-dom";
import Login from "./components/home/login";
import VerifyEmail from "./components/home/verifyEmail";
import ResendVerify from "./components/home/resendVerify";
import SignUp from "./components/home/signup";
import Home from "./components/home/home";
import UserHome from "./components/User/UserHome";
import BuyerHome from "./components/User/BuyerHome";
import AdminHome from "./components/User/AdminHome";
import CropsIn from "./components/User/cropsIn";
import AdminLogin from "./components/home/AdminLogin.js";
import CropCheck from "./components/User/cropCheck.js";
import CropBid from "./components/User/cropBid.js";
import UpdateBid from "./components/User/updateBid.js";
import UpdateProfile from "./components/home/updateProfile.js";
import Bids from './components/User/bids.js';
import BuyerProfile from './components/User/BuyerProfile.js';
import ViewingTrends from './components/User/ViewingTrends.js';
import Rating from './components/User/Rating.js';
import ViewBuyer from './components/User/viewBuyer.js';
import AllRecentCrops from './components/User/allRecentCrops.js'
import AllCropsFarmer from './components/User/allCropsFarmer';
import AllCropsBuyer from './components/User/allCropsBuyer';
import AllPastBids from './components/User/allPastBids';
import Grievance from './components/User/grievance'
import Payment from './components/User/payment'
import PayTotal from './components/User/payTotal'
import DeliverCrop from './components/User/deliverCrop'
import ClosedDeals from './components/User/closedDeals'
import ViewCrop from './components/User/viewCrop'
import ViewBill from './components/User/viewBill'
import CloseDeal from './components/User/closeDeal'
import ClosedCrop from './components/User/closedCrop'

class App extends Component {
  constructor(props) {
    super(props);
  }

  componentDidMount(){
    window.localStorage.removeItem('uid')
  }

  render(){
  return (
    <div className="bg">
      <Router>
        <Switch>
        {/* <Route exact path="/" component={App} /> */}
          <Route exact path='/' component={ Home } />
          <Route exact path='/Home' component={ Home } />
          <Route path="/Login" component={ Login } />
          <Route path="/verifyEmail/:id" component={ VerifyEmail } />
          <Route path="/resendVerify/:email/:id" component={ ResendVerify } />
          <Route path="/signup" component={ SignUp } />
          <Route path="/userhome/:id" component={ UserHome }/>
          <Route path="/adminhome/:id" component={ AdminHome }/>
          <Route path="/buyerhome/:id" component={ BuyerHome }/>
          <Route path="/adminlogin" component= { AdminLogin }/>
          <Route path="/cropsIn/:location/:id" component= { CropsIn }/>
          <Route path="/cropCheck/:id/:fid" component= { CropCheck }/>
          <Route path="/cropBid/:id/:fid/:buyerId" component= { CropBid }/>
          <Route path="/updateBid/:id/:fid/:buyerId" component= { UpdateBid }/>
          <Route path="/updateProfile/:id" component= { UpdateProfile }/>
          <Route path="/bids/:cid/:fid" component= { Bids }/>
          <Route path="/buyerProfile/:buyerId/:bid" component= { BuyerProfile }/>
          <Route path="/viewBuyer/:cid/:fid/:role" component= { ViewBuyer }/>
          <Route path="/viewingTrends/:cid/:fid" component= { ViewingTrends }/>
          <Route path="/rating" component= { Rating }/>   
          <Route path="/allRecentCrops/:id" component= { AllRecentCrops }/>   
          <Route path="/allCropsFarmer/:id" component= { AllCropsFarmer }/>   
          <Route path="/allCropsBuyer/:id" component= { AllCropsBuyer }/>   
          <Route path="/allPastBids/:id" component= { AllPastBids }/>   
          <Route path="/grievance/:id/:role" component= { Grievance }/>   
          <Route path="/payment/:cid/:buyerId/:fid/:priceBade" component= { Payment }/>
          <Route path="/payTotal/:cid/:buyerId/:fid/:priceBade/:paid/:harvestedQuantity" component= { PayTotal }/>
          <Route path="/deliverCrop/:cid/:fid" component= { DeliverCrop }/>
          <Route path="/closedCrop/:cid/:fid" component= { ClosedCrop }/>
          <Route path="/closedDeals/:id" component= { ClosedDeals }/>
          <Route path="/viewCrop/:cid/:fid/:buyerId" component= { ViewCrop }/>
          <Route path="/viewBill/:cid/:fid/:buyerId" component= {ViewBill}/>
          <Route path="/closeDeal/:cid/:fid" component = {CloseDeal}/>
        </Switch>
      </Router>
    </div>
  );
}}

export default App;
