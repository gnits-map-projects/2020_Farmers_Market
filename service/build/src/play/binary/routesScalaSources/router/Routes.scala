// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Kaumudi/Desktop/project/2020_Farmers_Market/service/conf/routes
// @DATE:Tue Mar 17 08:35:42 IST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  UncheckedCropController_4: controllers.UncheckedCropController,
  // @LINE:15
  RegisterController_2: controllers.RegisterController,
  // @LINE:19
  CropController_1: controllers.CropController,
  // @LINE:35
  BiddingController_3: controllers.BiddingController,
  // @LINE:41
  AdminController_0: controllers.AdminController,
  // @LINE:52
  Assets_5: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    UncheckedCropController_4: controllers.UncheckedCropController,
    // @LINE:15
    RegisterController_2: controllers.RegisterController,
    // @LINE:19
    CropController_1: controllers.CropController,
    // @LINE:35
    BiddingController_3: controllers.BiddingController,
    // @LINE:41
    AdminController_0: controllers.AdminController,
    // @LINE:52
    Assets_5: controllers.Assets
  ) = this(errorHandler, UncheckedCropController_4, RegisterController_2, CropController_1, BiddingController_3, AdminController_0, Assets_5, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, UncheckedCropController_4, RegisterController_2, CropController_1, BiddingController_3, AdminController_0, Assets_5, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addUncheckedCrop""", """controllers.UncheckedCropController.addUncheckedCrop()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getUncheckedCrops""", """controllers.UncheckedCropController.getUncheckedCrops()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getUncheckedCrop/""" + "$" + """cid<[^/]+>""", """controllers.UncheckedCropController.getUncheckedCrop(cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """approveCrop/""" + "$" + """cid<[^/]+>""", """controllers.UncheckedCropController.approveCrop(cid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.RegisterController.addRegister()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.RegisterController.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getFarmerCrops/""" + "$" + """fid<[^/]+>""", """controllers.CropController.getFarmerCrops(fid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCrops""", """controllers.CropController.getCrops()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCrop/""" + "$" + """cid<[^/]+>""", """controllers.CropController.getCrop(cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cropsIn/""" + "$" + """location<[^/]+>""", """controllers.CropController.cropsIn(location:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLocations""", """controllers.CropController.getLocations()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCropTypes/""" + "$" + """location<[^/]+>""", """controllers.CropController.getCropTypes(location:String)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rejectCrop/""" + "$" + """cid<[^/]+>""", """controllers.UncheckedCropController.deleteCrop(cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getFarmer/""" + "$" + """fid<[^/]+>""", """controllers.RegisterController.getFarmer(fid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """insertBid""", """controllers.BiddingController.add()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateProfile/""" + "$" + """id<[^/]+>""", """controllers.RegisterController.updateRegister(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCropBids/""" + "$" + """cid<[^/]+>""", """controllers.BiddingController.getCropBids(cid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """email/""" + "$" + """to<[^/]+>""", """controllers.AdminController.sendEmail(to:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """acceptBid/""" + "$" + """bid<[^/]+>/""" + "$" + """cid<[^/]+>""", """controllers.BiddingController.acceptBid(bid:Long, cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rejectBid/""" + "$" + """bid<[^/]+>""", """controllers.BiddingController.rejectBid(bid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getBidTrends/""" + "$" + """cid<[^/]+>""", """controllers.BiddingController.getBidTrends(cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_UncheckedCropController_addUncheckedCrop0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addUncheckedCrop")))
  )
  private[this] lazy val controllers_UncheckedCropController_addUncheckedCrop0_invoker = createInvoker(
    UncheckedCropController_4.addUncheckedCrop(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UncheckedCropController",
      "addUncheckedCrop",
      Nil,
      "POST",
      this.prefix + """addUncheckedCrop""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_UncheckedCropController_getUncheckedCrops1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUncheckedCrops")))
  )
  private[this] lazy val controllers_UncheckedCropController_getUncheckedCrops1_invoker = createInvoker(
    UncheckedCropController_4.getUncheckedCrops(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UncheckedCropController",
      "getUncheckedCrops",
      Nil,
      "GET",
      this.prefix + """getUncheckedCrops""",
      """""",
      Seq()
    )
  )

  // @LINE:11
  private[this] lazy val controllers_UncheckedCropController_getUncheckedCrop2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUncheckedCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UncheckedCropController_getUncheckedCrop2_invoker = createInvoker(
    UncheckedCropController_4.getUncheckedCrop(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UncheckedCropController",
      "getUncheckedCrop",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """getUncheckedCrop/""" + "$" + """cid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UncheckedCropController_approveCrop3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("approveCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UncheckedCropController_approveCrop3_invoker = createInvoker(
    UncheckedCropController_4.approveCrop(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UncheckedCropController",
      "approveCrop",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """approveCrop/""" + "$" + """cid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_RegisterController_addRegister4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_RegisterController_addRegister4_invoker = createInvoker(
    RegisterController_2.addRegister(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RegisterController",
      "addRegister",
      Nil,
      "POST",
      this.prefix + """register""",
      """""",
      Seq()
    )
  )

  // @LINE:17
  private[this] lazy val controllers_RegisterController_login5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_RegisterController_login5_invoker = createInvoker(
    RegisterController_2.login(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RegisterController",
      "login",
      Nil,
      "POST",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:19
  private[this] lazy val controllers_CropController_getFarmerCrops6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFarmerCrops/"), DynamicPart("fid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getFarmerCrops6_invoker = createInvoker(
    CropController_1.getFarmerCrops(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CropController",
      "getFarmerCrops",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """getFarmerCrops/""" + "$" + """fid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_CropController_getCrops7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCrops")))
  )
  private[this] lazy val controllers_CropController_getCrops7_invoker = createInvoker(
    CropController_1.getCrops(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CropController",
      "getCrops",
      Nil,
      "GET",
      this.prefix + """getCrops""",
      """""",
      Seq()
    )
  )

  // @LINE:23
  private[this] lazy val controllers_CropController_getCrop8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getCrop8_invoker = createInvoker(
    CropController_1.getCrop(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CropController",
      "getCrop",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """getCrop/""" + "$" + """cid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:25
  private[this] lazy val controllers_CropController_cropsIn9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cropsIn/"), DynamicPart("location", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_cropsIn9_invoker = createInvoker(
    CropController_1.cropsIn(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CropController",
      "cropsIn",
      Seq(classOf[String]),
      "GET",
      this.prefix + """cropsIn/""" + "$" + """location<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_CropController_getLocations10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLocations")))
  )
  private[this] lazy val controllers_CropController_getLocations10_invoker = createInvoker(
    CropController_1.getLocations(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CropController",
      "getLocations",
      Nil,
      "GET",
      this.prefix + """getLocations""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_CropController_getCropTypes11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCropTypes/"), DynamicPart("location", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getCropTypes11_invoker = createInvoker(
    CropController_1.getCropTypes(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.CropController",
      "getCropTypes",
      Seq(classOf[String]),
      "GET",
      this.prefix + """getCropTypes/""" + "$" + """location<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:31
  private[this] lazy val controllers_UncheckedCropController_deleteCrop12_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rejectCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UncheckedCropController_deleteCrop12_invoker = createInvoker(
    UncheckedCropController_4.deleteCrop(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.UncheckedCropController",
      "deleteCrop",
      Seq(classOf[Long]),
      "DELETE",
      this.prefix + """rejectCrop/""" + "$" + """cid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_RegisterController_getFarmer13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFarmer/"), DynamicPart("fid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RegisterController_getFarmer13_invoker = createInvoker(
    RegisterController_2.getFarmer(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RegisterController",
      "getFarmer",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """getFarmer/""" + "$" + """fid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_BiddingController_add14_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("insertBid")))
  )
  private[this] lazy val controllers_BiddingController_add14_invoker = createInvoker(
    BiddingController_3.add(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BiddingController",
      "add",
      Nil,
      "POST",
      this.prefix + """insertBid""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_RegisterController_updateRegister15_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateProfile/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RegisterController_updateRegister15_invoker = createInvoker(
    RegisterController_2.updateRegister(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RegisterController",
      "updateRegister",
      Seq(classOf[Long]),
      "POST",
      this.prefix + """updateProfile/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:39
  private[this] lazy val controllers_BiddingController_getCropBids16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCropBids/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_getCropBids16_invoker = createInvoker(
    BiddingController_3.getCropBids(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BiddingController",
      "getCropBids",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """getCropBids/""" + "$" + """cid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:41
  private[this] lazy val controllers_AdminController_sendEmail17_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("email/"), DynamicPart("to", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminController_sendEmail17_invoker = createInvoker(
    AdminController_0.sendEmail(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "sendEmail",
      Seq(classOf[String]),
      "POST",
      this.prefix + """email/""" + "$" + """to<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:43
  private[this] lazy val controllers_BiddingController_acceptBid18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("acceptBid/"), DynamicPart("bid", """[^/]+""",true), StaticPart("/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_acceptBid18_invoker = createInvoker(
    BiddingController_3.acceptBid(fakeValue[Long], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BiddingController",
      "acceptBid",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      this.prefix + """acceptBid/""" + "$" + """bid<[^/]+>/""" + "$" + """cid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:45
  private[this] lazy val controllers_BiddingController_rejectBid19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rejectBid/"), DynamicPart("bid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_rejectBid19_invoker = createInvoker(
    BiddingController_3.rejectBid(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BiddingController",
      "rejectBid",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """rejectBid/""" + "$" + """bid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:47
  private[this] lazy val controllers_BiddingController_getBidTrends20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getBidTrends/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_getBidTrends20_invoker = createInvoker(
    BiddingController_3.getBidTrends(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BiddingController",
      "getBidTrends",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """getBidTrends/""" + "$" + """cid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:52
  private[this] lazy val controllers_Assets_at21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at21_invoker = createInvoker(
    Assets_5.at(fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "at",
      Seq(classOf[String], classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:7
    case controllers_UncheckedCropController_addUncheckedCrop0_route(params@_) =>
      call { 
        controllers_UncheckedCropController_addUncheckedCrop0_invoker.call(UncheckedCropController_4.addUncheckedCrop())
      }
  
    // @LINE:9
    case controllers_UncheckedCropController_getUncheckedCrops1_route(params@_) =>
      call { 
        controllers_UncheckedCropController_getUncheckedCrops1_invoker.call(UncheckedCropController_4.getUncheckedCrops())
      }
  
    // @LINE:11
    case controllers_UncheckedCropController_getUncheckedCrop2_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_getUncheckedCrop2_invoker.call(UncheckedCropController_4.getUncheckedCrop(cid))
      }
  
    // @LINE:13
    case controllers_UncheckedCropController_approveCrop3_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_approveCrop3_invoker.call(UncheckedCropController_4.approveCrop(cid))
      }
  
    // @LINE:15
    case controllers_RegisterController_addRegister4_route(params@_) =>
      call { 
        controllers_RegisterController_addRegister4_invoker.call(RegisterController_2.addRegister())
      }
  
    // @LINE:17
    case controllers_RegisterController_login5_route(params@_) =>
      call { 
        controllers_RegisterController_login5_invoker.call(RegisterController_2.login())
      }
  
    // @LINE:19
    case controllers_CropController_getFarmerCrops6_route(params@_) =>
      call(params.fromPath[Long]("fid", None)) { (fid) =>
        controllers_CropController_getFarmerCrops6_invoker.call(CropController_1.getFarmerCrops(fid))
      }
  
    // @LINE:21
    case controllers_CropController_getCrops7_route(params@_) =>
      call { 
        controllers_CropController_getCrops7_invoker.call(CropController_1.getCrops())
      }
  
    // @LINE:23
    case controllers_CropController_getCrop8_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_CropController_getCrop8_invoker.call(CropController_1.getCrop(cid))
      }
  
    // @LINE:25
    case controllers_CropController_cropsIn9_route(params@_) =>
      call(params.fromPath[String]("location", None)) { (location) =>
        controllers_CropController_cropsIn9_invoker.call(CropController_1.cropsIn(location))
      }
  
    // @LINE:27
    case controllers_CropController_getLocations10_route(params@_) =>
      call { 
        controllers_CropController_getLocations10_invoker.call(CropController_1.getLocations())
      }
  
    // @LINE:29
    case controllers_CropController_getCropTypes11_route(params@_) =>
      call(params.fromPath[String]("location", None)) { (location) =>
        controllers_CropController_getCropTypes11_invoker.call(CropController_1.getCropTypes(location))
      }
  
    // @LINE:31
    case controllers_UncheckedCropController_deleteCrop12_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_deleteCrop12_invoker.call(UncheckedCropController_4.deleteCrop(cid))
      }
  
    // @LINE:33
    case controllers_RegisterController_getFarmer13_route(params@_) =>
      call(params.fromPath[Long]("fid", None)) { (fid) =>
        controllers_RegisterController_getFarmer13_invoker.call(RegisterController_2.getFarmer(fid))
      }
  
    // @LINE:35
    case controllers_BiddingController_add14_route(params@_) =>
      call { 
        controllers_BiddingController_add14_invoker.call(BiddingController_3.add())
      }
  
    // @LINE:37
    case controllers_RegisterController_updateRegister15_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RegisterController_updateRegister15_invoker.call(RegisterController_2.updateRegister(id))
      }
  
    // @LINE:39
    case controllers_BiddingController_getCropBids16_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_BiddingController_getCropBids16_invoker.call(BiddingController_3.getCropBids(cid))
      }
  
    // @LINE:41
    case controllers_AdminController_sendEmail17_route(params@_) =>
      call(params.fromPath[String]("to", None)) { (to) =>
        controllers_AdminController_sendEmail17_invoker.call(AdminController_0.sendEmail(to))
      }
  
    // @LINE:43
    case controllers_BiddingController_acceptBid18_route(params@_) =>
      call(params.fromPath[Long]("bid", None), params.fromPath[Long]("cid", None)) { (bid, cid) =>
        controllers_BiddingController_acceptBid18_invoker.call(BiddingController_3.acceptBid(bid, cid))
      }
  
    // @LINE:45
    case controllers_BiddingController_rejectBid19_route(params@_) =>
      call(params.fromPath[Long]("bid", None)) { (bid) =>
        controllers_BiddingController_rejectBid19_invoker.call(BiddingController_3.rejectBid(bid))
      }
  
    // @LINE:47
    case controllers_BiddingController_getBidTrends20_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_BiddingController_getBidTrends20_invoker.call(BiddingController_3.getBidTrends(cid))
      }
  
    // @LINE:52
    case controllers_Assets_at21_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at21_invoker.call(Assets_5.at(path, file))
      }
  }
}
