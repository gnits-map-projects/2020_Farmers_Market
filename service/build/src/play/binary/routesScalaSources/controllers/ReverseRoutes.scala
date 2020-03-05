// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/projects/2020_Farmers_Market/service/conf/routes
// @DATE:Tue Mar 03 12:02:23 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReversePersonController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def addPersonJson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "personJson")
    }
  
    // @LINE:10
    def delPersons(): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "persons")
    }
  
    // @LINE:7
    def addPerson(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "person")
    }
  
    // @LINE:9
    def getPersons(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "persons")
    }
  
    // @LINE:6
    def index(): Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:43
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:43
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:20
  class ReverseRegisterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:38
    def getFarmer(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getFarmer/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
    // @LINE:22
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:20
    def addRegister(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "register")
    }
  
  }

  // @LINE:24
  class ReverseCropController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def getCropTypes(location:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCropTypes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("location", location)))
    }
  
    // @LINE:28
    def getCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:26
    def getCrops(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCrops")
    }
  
    // @LINE:30
    def cropsIn(location:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cropsIn/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("location", location)))
    }
  
    // @LINE:32
    def getLocations(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getLocations")
    }
  
    // @LINE:24
    def getFarmerCrops(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getFarmerCrops/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
  }

  // @LINE:40
  class ReverseBiddingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:40
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "insertBid")
    }
  
  }

  // @LINE:12
  class ReverseUncheckedCropController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
    def approveCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "approveCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:14
    def getUncheckedCrops(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getUncheckedCrops")
    }
  
    // @LINE:12
    def addUncheckedCrop(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addUncheckedCrop")
    }
  
    // @LINE:36
    def deleteCrop(cid:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "rejectCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:16
    def getUncheckedCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getUncheckedCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
  }


}
