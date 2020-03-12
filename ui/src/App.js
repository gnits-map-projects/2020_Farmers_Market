import React ,{ Component } from 'react';

import { BrowserRouter as Router, 
  Switch, 
  Route,
   Link } from "react-router-dom";
   import Login from "./components/home/login";
   import SignUp from "./components/home/signup";
   import Home from "./components/home/home";
   import UserHome from "./components/User/UserHome";
   import BuyerHome from "./components/User/BuyerHome";
   import AdminHome from "./components/User/AdminHome";
   import CropsIn from "./components/User/cropsIn";
   import AdminLogin from "./components/home/AdminLogin.js";
   import CropCheck from "./components/User/cropCheck.js";
   import CropBid from "./components/User/cropBid.js";
   import UpdateProfile from "./components/home/updateProfile.js";
   import Bids from './components/User/bids.js';

   import Rating from './components/User/Rating.js';


class App extends Component {
  constructor(props) {
    super(props);
  }

  componentWillMount(){
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
                    <Route path="/signup" component={ SignUp } />
                    <Route path="/userhome/:id" component={ UserHome }/>
                    <Route path="/adminhome/:id" component={ AdminHome }/>
                    <Route path="/buyerhome/:id" component={ BuyerHome }/>
                    <Route path="/adminlogin" component= { AdminLogin }/>
                    <Route path="/cropsIn/:location/:id" component= { CropsIn }/>
                    <Route path="/cropCheck/:id/:fid" component= { CropCheck }/>
                    <Route path="/cropBid/:id/:fid/:buyerId" component= { CropBid }/>
                    <Route path="/updateProfile/:id" component= { UpdateProfile }/>
                    <Route path="/bids/:cid/:fid" component= { Bids}/>

                    <Route path="/rating" component= { Rating}/>
                  
                </Switch>
            </Router>
            </div>
        
  );
}}

export default App;
