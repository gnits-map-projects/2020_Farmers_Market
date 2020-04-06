// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Kaumudi/Desktop/project/2020_Farmers_Market/service/conf/routes
// @DATE:Mon Apr 06 10:52:25 IST 2020

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers {

  // @LINE:44
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def at(file:String): Call = {
      implicit lazy val _rrc = new play.core.routing.ReverseRouteContext(Map(("path", "/public"))); _rrc
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }

  // @LINE:7
  class ReverseRegisterController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def verifyRegister(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "verifyUser/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:9
    def getFarmer(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getFarmer/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
    // @LINE:10
    def updateRegister(id:Long): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "updateProfile/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:7
    def addRegister(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "register")
    }
  
    // @LINE:8
    def login(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "login")
    }
  
  }

  // @LINE:37
  class ReverseAdminController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def sendEmail(to:String, subject:String, body:String): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "email/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("to", to)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("subject", subject)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("body", body)))
    }
  
    // @LINE:38
    def sendAuthEmail(to:String, id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "sendAuthEmail/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("to", to)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }

  // @LINE:19
  class ReverseCropController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def getCropTypes(location:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCropTypes/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("location", location)))
    }
  
    // @LINE:20
    def getAllFarmerCrops(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllFarmerCrops/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
    // @LINE:23
    def getOthersCrops(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getOthersCrops/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
    // @LINE:25
    def getCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:21
    def getCrops(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCrops")
    }
  
    // @LINE:24
    def getAllOthersCrops(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllOthersCrops/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
    // @LINE:26
    def cropsIn(location:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "cropsIn/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[String]].unbind("location", location)))
    }
  
    // @LINE:27
    def getLocations(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getLocations")
    }
  
    // @LINE:22
    def getAllCrops(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getAllCrops")
    }
  
    // @LINE:19
    def getFarmerCrops(fid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getFarmerCrops/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("fid", fid)))
    }
  
  }

  // @LINE:30
  class ReverseBiddingController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def rejectBid(bid:Long, cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "rejectBid/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("bid", bid)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:30
    def add(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "insertBid")
    }
  
    // @LINE:32
    def acceptBid(bid:Long, cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "acceptBid/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("bid", bid)) + "/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:31
    def getCropBids(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getCropBids/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:35
    def getWinner(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getWinner/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:34
    def getBidTrends(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getBidTrends/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
  }

  // @LINE:13
  class ReverseUncheckedCropController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def approveCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "approveCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:14
    def getUncheckedCrops(): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getUncheckedCrops")
    }
  
    // @LINE:13
    def addUncheckedCrop(): Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "addUncheckedCrop")
    }
  
    // @LINE:17
    def deleteCrop(cid:Long): Call = {
      
      Call("DELETE", _prefix + { _defaultPrefix } + "rejectCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
    // @LINE:15
    def getUncheckedCrop(cid:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getUncheckedCrop/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("cid", cid)))
    }
  
  }

  // @LINE:40
  class ReverseNotificationController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:40
    def getNotification(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "getNotifications/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
    // @LINE:41
    def notificationsRead(id:Long): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "notificationsRead/" + play.core.routing.dynamicString(implicitly[play.api.mvc.PathBindable[Long]].unbind("id", id)))
    }
  
  }


}
