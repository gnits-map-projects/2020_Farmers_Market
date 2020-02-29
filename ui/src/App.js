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


class App extends Component {
  constructor(props) {
    super(props);
  }
  render(){
  return (
    <div>
            <Router>
                <Switch>
            {/* <Route exact path="/" component={App} /> */}
            <Route exact path='/' component={ Home } />
            <Route exact path='/Home' component={ Home } />
            <Route path="/Login" component={ Login } />
            <Route path="/signup" component={ SignUp } />
            <Route path="/userhome/:id" component={ UserHome }/>
            <Route path="/adminhome/:id" component={ AdminHome }/>
            <Route path="/buyerhome" component={ BuyerHome }/>
            <Route path="/adminlogin" component= { AdminLogin }/>
            <Route path="/cropsIn/:location" component= { CropsIn }/>
            <Route path="/cropCheck/:id/:fid" component= { CropCheck }/>
                </Switch>
            </Router>
            </div>
        
  );
}}

export default App;
