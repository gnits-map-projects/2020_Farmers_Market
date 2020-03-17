// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Kaumudi/Desktop/project/2020_Farmers_Market/service/conf/routes
// @DATE:Tue Mar 17 08:35:42 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:52
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:52
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:15
  class ReverseRegisterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def updateRegister(id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateProfile/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:33
    def getFarmer(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getFarmer/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
    // @LINE:17
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
    // @LINE:15
    def addRegister(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "register")
    }
  
  }

  // @LINE:41
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def sendEmail(to:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "email/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("to", to)))
    }
  
  }

  // @LINE:19
  class ReverseCropController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:29
    def getCropTypes(location:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCropTypes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("location", location)))
    }
  
    // @LINE:23
    def getCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:21
    def getCrops(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCrops")
    }
  
    // @LINE:25
    def cropsIn(location:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cropsIn/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("location", location)))
    }
  
    // @LINE:27
    def getLocations(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getLocations")
    }
  
    // @LINE:19
    def getFarmerCrops(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getFarmerCrops/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
  }

  // @LINE:35
  class ReverseBiddingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def rejectBid(bid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "rejectBid/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("bid", bid)))
    }
  
    // @LINE:35
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "insertBid")
    }
  
    // @LINE:43
    def acceptBid(bid:Long, cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "acceptBid/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("bid", bid)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:39
    def getCropBids(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCropBids/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:47
    def getBidTrends(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getBidTrends/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
  }

  // @LINE:7
  class ReverseUncheckedCropController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def approveCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "approveCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:9
    def getUncheckedCrops(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getUncheckedCrops")
    }
  
    // @LINE:7
    def addUncheckedCrop(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addUncheckedCrop")
    }
  
    // @LINE:31
    def deleteCrop(cid:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "rejectCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:11
    def getUncheckedCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getUncheckedCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
  }


}
