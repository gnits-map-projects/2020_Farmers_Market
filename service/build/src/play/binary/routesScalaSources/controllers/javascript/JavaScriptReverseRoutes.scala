// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/projects/2020_Farmers_Market/service/conf/routes
// @DATE:Sat Mar 14 09:13:18 IST 2020

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReversePersonController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:8
    def addPersonJson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.addPersonJson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "personJson"})
        }
      """
    )
  
    // @LINE:10
    def delPersons: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.delPersons",
      """
        function() {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "persons"})
        }
      """
    )
  
    // @LINE:7
    def addPerson: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.addPerson",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "person"})
        }
      """
    )
  
    // @LINE:9
    def getPersons: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.getPersons",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "persons"})
        }
      """
    )
  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.PersonController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:54
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:54
    def at: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.at",
      """
        function(file1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file1)})
        }
      """
    )
  
  }

  // @LINE:20
  class ReverseRegisterController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:42
    def updateRegister: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.updateRegister",
      """
        function(id0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "updateProfile/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("id", id0))})
        }
      """
    )
  
    // @LINE:38
    def getFarmer: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.getFarmer",
      """
        function(fid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getFarmer/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("fid", fid0))})
        }
      """
    )
  
    // @LINE:22
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.login",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
    // @LINE:20
    def addRegister: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.RegisterController.addRegister",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "register"})
        }
      """
    )
  
  }

  // @LINE:46
  class ReverseAdminController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:46
    def sendEmail: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AdminController.sendEmail",
      """
        function(to0) {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "email/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("to", to0))})
        }
      """
    )
  
  }

  // @LINE:24
  class ReverseCropController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def getCropTypes: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getCropTypes",
      """
        function(location0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCropTypes/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("location", location0))})
        }
      """
    )
  
    // @LINE:28
    def getCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getCrop",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCrop/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
    // @LINE:26
    def getCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getCrops",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCrops"})
        }
      """
    )
  
    // @LINE:30
    def cropsIn: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.cropsIn",
      """
        function(location0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "cropsIn/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("location", location0))})
        }
      """
    )
  
    // @LINE:32
    def getLocations: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getLocations",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getLocations"})
        }
      """
    )
  
    // @LINE:24
    def getFarmerCrops: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.CropController.getFarmerCrops",
      """
        function(fid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getFarmerCrops/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("fid", fid0))})
        }
      """
    )
  
  }

  // @LINE:40
  class ReverseBiddingController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:44
    def getCropBids: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.getCropBids",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getCropBids/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
    // @LINE:48
    def acceptBid: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.acceptBid",
      """
        function(bid0,cid1) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "acceptBid/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("bid", bid0)) + "/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid1))})
        }
      """
    )
  
    // @LINE:40
    def add: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.add",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "insertBid"})
        }
      """
    )
  
    // @LINE:50
    def rejectBid: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.BiddingController.rejectBid",
      """
        function(bid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "rejectBid/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("bid", bid0))})
        }
      """
    )
  
  }

  // @LINE:12
  class ReverseUncheckedCropController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:18
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
  
    // @LINE:12
    def addUncheckedCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UncheckedCropController.addUncheckedCrop",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "addUncheckedCrop"})
        }
      """
    )
  
    // @LINE:36
    def deleteCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UncheckedCropController.deleteCrop",
      """
        function(cid0) {
          return _wA({method:"DELETE", url:"""" + _prefix + { _defaultPrefix } + """" + "rejectCrop/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
    // @LINE:16
    def getUncheckedCrop: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.UncheckedCropController.getUncheckedCrop",
      """
        function(cid0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "getUncheckedCrop/" + encodeURIComponent((""" + implicitly[play.api.mvc.PathBindable[Long]].javascriptUnbind + """)("cid", cid0))})
        }
      """
    )
  
  }


}
