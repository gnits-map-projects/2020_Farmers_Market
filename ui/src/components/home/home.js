import React, { Component } from "react";
import logo from '../images/userhome.jpg';
import '../images/bgimage.css';
import './home.css';
import Nav from './Nav.js';
import Carousel from 'react-bootstrap/Carousel';
import { Slide } from 'react-slideshow-image';
import slide1 from '../images/f1.jpeg';
import slide2 from '../images/f2.jpeg';
import slide3 from '../images/f3.jpeg';

//import { useHistory, withRouter,Link } from "react-router-dom";

const properties = {
  duration: 2000,
  transitionDuration: 500,
  infinite: true,
  indicators: true,
  arrows: true
}

export default class Home extends Component {
    render() {
        return (<div>
            <Nav/>
            <div  style={{'background-image' : 'url(' + logo +')' }}  className = "auth-home">
    
            <h2>
                <p align = "justify">
                    Welcome to Farmer's Market!

                    Register your crops and get the right price yout deserve.

                    <br/><br/><h1>About us</h1><br/>
                    Farmer’s Market is a web application that brings corporate to the farmers. The buyers of
produce can bid for a farmer’s stock beforehand. Then, as per the farmer’s choice of the bidder,
the bidder can pay a nominal upfront advance to the farmer. When the crop is delivered, the
buyer may pay the pre-agreed full price irrespective of the market demand and current price.
Farmers can use the upfront money to pay for the crop and insure it against any unexpected
scenarios.
                </p></h2>


      <div className="containerSlide">
          <Slide {...properties}>
              <div  className="each-slide">
                  <div><img src={slide1} height = "500px" width = "2000px"/></div>
              </div>
              <div className="each-slide" >
                  <div><img src={slide2} height = "500px" width = "2000px"/></div>
              </div>
               <div  className="each-slide">
                  <div><img src={slide3} height = "500px" width = "2000px"/></div>
              </div>
          </Slide>
      </div>







    {/* <Carousel>
  <Carousel.Item>
    <img
      className="d-block w-100"
      src="../images/f3.jpeg"
      alt="First slide"
    />
    <Carousel.Caption>
      <h3>First slide label</h3>
      <p>Nulla vitae elit libero, a pharetra augue mollis interdum.</p>
    </Carousel.Caption>
  </Carousel.Item>
  <Carousel.Item>
    <img
      className="d-block w-100"
      src="../images/f1.jpeg"
      alt="Third slide"
    />

    <Carousel.Caption>
      <h3>Second slide label</h3>
      <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
    </Carousel.Caption>
  </Carousel.Item>
  <Carousel.Item>
    <img
      className="d-block w-100"
      src="../images/f2.jpeg"      
      alt="Third slide"
    />

    <Carousel.Caption>
      <h3>Third slide label</h3>
      <p>Praesent commodo cursus magna, vel scelerisque nisl consectetur.</p>
    </Carousel.Caption>
  </Carousel.Item>
</Carousel> */}

            </div>
            
            <div>
                
            </div>
            </div>
        );
    }
}