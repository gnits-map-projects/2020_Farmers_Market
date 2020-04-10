// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Kaumudi/Desktop/project/2020_Farmers_Market/service/conf/routes
// @DATE:Fri Apr 10 13:13:18 IST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:7
package controllers.javascript {

  // @LINE:45
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:45
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:7
  class ReverseRegisterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:11
    def verifyRegister: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.verifyRegister",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "verifyUser/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:9
    def getFarmer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.getFarmer",
      """
        function(fid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getFarmer/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("fid", fid0))})
        }
      """
    )
  
    // @LINE:10
    def updateRegister: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.updateRegister",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateProfile/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:7
    def addRegister: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.addRegister",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
    // @LINE:8
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:37
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:37
    def sendEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.sendEmail",
      """
        function(to0,subject1,body2) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "email/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("to", to0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("subject", subject1)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("body", body2))})
        }
      """
    )
  
    // @LINE:39
    def sendAuthEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.sendAuthEmail",
      """
        function(to0,id1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "sendAuthEmail/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("to", to0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id1))})
        }
      """
    )
  
    // @LINE:38
    def mailToAdmin: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.mailToAdmin",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "mailToAdmin/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }

  // @LINE:19
  class ReverseCropController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:28
    def getCropTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getCropTypes",
      """
        function(location0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCropTypes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("location", location0))})
        }
      """
    )
  
    // @LINE:20
    def getAllFarmerCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getAllFarmerCrops",
      """
        function(fid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllFarmerCrops/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("fid", fid0))})
        }
      """
    )
  
    // @LINE:23
    def getOthersCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getOthersCrops",
      """
        function(fid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getOthersCrops/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("fid", fid0))})
        }
      """
    )
  
    // @LINE:25
    def getCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getCrop",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCrop/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
    // @LINE:21
    def getCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getCrops",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCrops"})
        }
      """
    )
  
    // @LINE:24
    def getAllOthersCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getAllOthersCrops",
      """
        function(fid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllOthersCrops/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("fid", fid0))})
        }
      """
    )
  
    // @LINE:26
    def cropsIn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.cropsIn",
      """
        function(location0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cropsIn/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("location", location0))})
        }
      """
    )
  
    // @LINE:27
    def getLocations: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getLocations",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getLocations"})
        }
      """
    )
  
    // @LINE:22
    def getAllCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getAllCrops",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getAllCrops"})
        }
      """
    )
  
    // @LINE:19
    def getFarmerCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getFarmerCrops",
      """
        function(fid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getFarmerCrops/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("fid", fid0))})
        }
      """
    )
  
  }

  // @LINE:30
  class ReverseBiddingController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:33
    def rejectBid: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.rejectBid",
      """
        function(bid0,cid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rejectBid/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("bid", bid0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid1))})
        }
      """
    )
  
    // @LINE:30
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "insertBid"})
        }
      """
    )
  
    // @LINE:32
    def acceptBid: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.acceptBid",
      """
        function(bid0,cid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acceptBid/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("bid", bid0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid1))})
        }
      """
    )
  
    // @LINE:31
    def getCropBids: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.getCropBids",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCropBids/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
    // @LINE:35
    def getWinner: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.getWinner",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getWinner/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
    // @LINE:34
    def getBidTrends: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.getBidTrends",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getBidTrends/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
  }

  // @LINE:13
  class ReverseUncheckedCropController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:16
    def approveCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UncheckedCropController.approveCrop",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "approveCrop/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
    // @LINE:14
    def getUncheckedCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UncheckedCropController.getUncheckedCrops",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getUncheckedCrops"})
        }
      """
    )
  
    // @LINE:13
    def addUncheckedCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UncheckedCropController.addUncheckedCrop",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addUncheckedCrop"})
        }
      """
    )
  
    // @LINE:17
    def deleteCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UncheckedCropController.deleteCrop",
      """
        function(cid0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "rejectCrop/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
    // @LINE:15
    def getUncheckedCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UncheckedCropController.getUncheckedCrop",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getUncheckedCrop/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
  }

  // @LINE:41
  class ReverseNotificationController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:41
    def getNotification: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotificationController.getNotification",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getNotifications/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:42
    def notificationsRead: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.NotificationController.notificationsRead",
      """
        function(id0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "notificationsRead/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
  }


}
