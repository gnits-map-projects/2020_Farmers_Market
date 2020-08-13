import React ,{ Component } from 'react';
import '../../../node_modules/bootstrap/dist/css/bootstrap.min.css';
import './UserHome.css'
import Select from 'react-select';

var locationOptions
var result
var i
var tempJson
var larray

export default class ListLocations extends Component {
  selectRef: ElementRef<*>;
  focus = () => {
    console.log(this.selectRef);
    this.selectRef.focus();
  };
  
  handleChange(selectedOption){
    console.log(selectedOption.value)
    window.location.href  = "/cropsIn/" + selectedOption.value +'/' +this.state.id;
  }

  constructor(props) {
        super(props);
        this.state = {
            'locationOptions' : [],
            location:"",
            'id' : this.props.id
        };
        this.handleChange = this.handleChange.bind(this);
    }
 
  componentDidMount(){
    const url = 'http://localhost:9000/getLocations'
    console.log(this.props.fid)
    let headers = new Headers();

    headers.append('Content-Type', 'application/json');
    headers.append('Accept', 'application/json');

    headers.append('Access-Control-Allow-origin', url);
    headers.append('Access-Control-Allow-Credentials', 'true');

    headers.append('POST', 'GET');

    fetch(url,{
        headers: headers,
        method: 'GET',
    })
    .then(response => {if(response.ok){
    result = response.json()
    .then(result => {
      console.log(result)
      larray = result
      console.log(typeof larray)     
     
      for(i = 0; i < larray.length; i++ ){
        tempJson = {}
        var tag1 = 'value'
        var value1 = larray[i]
        var tag2 = 'label'
        var value2 = larray[i]
        tempJson[tag1] = value1
        tempJson[tag2] = value2
        this.state.locationOptions[i] = tempJson
      }
      console.log("locationOptions", this.state.locationOptions);
    })
    }})     
  }

    render(){
        return (
            <div>  
            <Select className="form-group"
              ref={ref => {
                this.selectRef = ref;
              }}
              defaultValue="Select Location"
              name="location"
              placeholder = "Select Location..."
              options={this.state.locationOptions}
              onMouseEnter={this.focus}
              onChange = {this.handleChange}/>
            </div>

                   
        );
    }
}