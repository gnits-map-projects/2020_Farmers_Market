// @GENERATOR:play-routes-compiler
// @SOURCE:C:/Users/Kaumudi/Desktop/project/2020_Farmers_Market/service/conf/routes
// @DATE:Fri Apr 03 14:19:30 IST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:7
  RegisterController_3: controllers.RegisterController,
  // @LINE:13
  UncheckedCropController_5: controllers.UncheckedCropController,
  // @LINE:19
  CropController_1: controllers.CropController,
  // @LINE:26
  BiddingController_4: controllers.BiddingController,
  // @LINE:32
  AdminController_0: controllers.AdminController,
  // @LINE:35
  NotificationController_2: controllers.NotificationController,
  // @LINE:38
  Assets_6: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:7
    RegisterController_3: controllers.RegisterController,
    // @LINE:13
    UncheckedCropController_5: controllers.UncheckedCropController,
    // @LINE:19
    CropController_1: controllers.CropController,
    // @LINE:26
    BiddingController_4: controllers.BiddingController,
    // @LINE:32
    AdminController_0: controllers.AdminController,
    // @LINE:35
    NotificationController_2: controllers.NotificationController,
    // @LINE:38
    Assets_6: controllers.Assets
  ) = this(errorHandler, RegisterController_3, UncheckedCropController_5, CropController_1, BiddingController_4, AdminController_0, NotificationController_2, Assets_6, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, RegisterController_3, UncheckedCropController_5, CropController_1, BiddingController_4, AdminController_0, NotificationController_2, Assets_6, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """register""", """controllers.RegisterController.addRegister()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.RegisterController.login()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getFarmer/""" + "$" + """fid<[^/]+>""", """controllers.RegisterController.getFarmer(fid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """updateProfile/""" + "$" + """id<[^/]+>""", """controllers.RegisterController.updateRegister(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """verifyUser/""" + "$" + """id<[^/]+>""", """controllers.RegisterController.verifyRegister(id:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """addUncheckedCrop""", """controllers.UncheckedCropController.addUncheckedCrop()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getUncheckedCrops""", """controllers.UncheckedCropController.getUncheckedCrops()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getUncheckedCrop/""" + "$" + """cid<[^/]+>""", """controllers.UncheckedCropController.getUncheckedCrop(cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """approveCrop/""" + "$" + """cid<[^/]+>""", """controllers.UncheckedCropController.approveCrop(cid:Long)"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rejectCrop/""" + "$" + """cid<[^/]+>""", """controllers.UncheckedCropController.deleteCrop(cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getFarmerCrops/""" + "$" + """fid<[^/]+>""", """controllers.CropController.getFarmerCrops(fid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCrops""", """controllers.CropController.getCrops()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCrop/""" + "$" + """cid<[^/]+>""", """controllers.CropController.getCrop(cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """cropsIn/""" + "$" + """location<[^/]+>""", """controllers.CropController.cropsIn(location:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getLocations""", """controllers.CropController.getLocations()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCropTypes/""" + "$" + """location<[^/]+>""", """controllers.CropController.getCropTypes(location:String)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """insertBid""", """controllers.BiddingController.add()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getCropBids/""" + "$" + """cid<[^/]+>""", """controllers.BiddingController.getCropBids(cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """acceptBid/""" + "$" + """bid<[^/]+>/""" + "$" + """cid<[^/]+>""", """controllers.BiddingController.acceptBid(bid:Long, cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """rejectBid/""" + "$" + """bid<[^/]+>/""" + "$" + """cid<[^/]+>""", """controllers.BiddingController.rejectBid(bid:Long, cid:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getBidTrends/""" + "$" + """cid<[^/]+>""", """controllers.BiddingController.getBidTrends(cid:Long)"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """email/""" + "$" + """to<[^/]+>/""" + "$" + """subject<[^/]+>/""" + "$" + """body<[^/]+>""", """controllers.AdminController.sendEmail(to:String, subject:String, body:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """sendAuthEmail/""" + "$" + """to<[^/]+>/""" + "$" + """id<[^/]+>""", """controllers.AdminController.sendAuthEmail(to:String, id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """getNotifications/""" + "$" + """id<[^/]+>""", """controllers.NotificationController.getNotification(id:Long)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:7
  private[this] lazy val controllers_RegisterController_addRegister0_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_RegisterController_addRegister0_invoker = createInvoker(
    RegisterController_3.addRegister(),
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

  // @LINE:8
  private[this] lazy val controllers_RegisterController_login1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_RegisterController_login1_invoker = createInvoker(
    RegisterController_3.login(),
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

  // @LINE:9
  private[this] lazy val controllers_RegisterController_getFarmer2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFarmer/"), DynamicPart("fid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RegisterController_getFarmer2_invoker = createInvoker(
    RegisterController_3.getFarmer(fakeValue[Long]),
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

  // @LINE:10
  private[this] lazy val controllers_RegisterController_updateRegister3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateProfile/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RegisterController_updateRegister3_invoker = createInvoker(
    RegisterController_3.updateRegister(fakeValue[Long]),
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

  // @LINE:11
  private[this] lazy val controllers_RegisterController_verifyRegister4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("verifyUser/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RegisterController_verifyRegister4_invoker = createInvoker(
    RegisterController_3.verifyRegister(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.RegisterController",
      "verifyRegister",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """verifyUser/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_UncheckedCropController_addUncheckedCrop5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("addUncheckedCrop")))
  )
  private[this] lazy val controllers_UncheckedCropController_addUncheckedCrop5_invoker = createInvoker(
    UncheckedCropController_5.addUncheckedCrop(),
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

  // @LINE:14
  private[this] lazy val controllers_UncheckedCropController_getUncheckedCrops6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUncheckedCrops")))
  )
  private[this] lazy val controllers_UncheckedCropController_getUncheckedCrops6_invoker = createInvoker(
    UncheckedCropController_5.getUncheckedCrops(),
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

  // @LINE:15
  private[this] lazy val controllers_UncheckedCropController_getUncheckedCrop7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getUncheckedCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UncheckedCropController_getUncheckedCrop7_invoker = createInvoker(
    UncheckedCropController_5.getUncheckedCrop(fakeValue[Long]),
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

  // @LINE:16
  private[this] lazy val controllers_UncheckedCropController_approveCrop8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("approveCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UncheckedCropController_approveCrop8_invoker = createInvoker(
    UncheckedCropController_5.approveCrop(fakeValue[Long]),
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

  // @LINE:17
  private[this] lazy val controllers_UncheckedCropController_deleteCrop9_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rejectCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UncheckedCropController_deleteCrop9_invoker = createInvoker(
    UncheckedCropController_5.deleteCrop(fakeValue[Long]),
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

  // @LINE:19
  private[this] lazy val controllers_CropController_getFarmerCrops10_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFarmerCrops/"), DynamicPart("fid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getFarmerCrops10_invoker = createInvoker(
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

  // @LINE:20
  private[this] lazy val controllers_CropController_getCrops11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCrops")))
  )
  private[this] lazy val controllers_CropController_getCrops11_invoker = createInvoker(
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

  // @LINE:21
  private[this] lazy val controllers_CropController_getCrop12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getCrop12_invoker = createInvoker(
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

  // @LINE:22
  private[this] lazy val controllers_CropController_cropsIn13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cropsIn/"), DynamicPart("location", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_cropsIn13_invoker = createInvoker(
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

  // @LINE:23
  private[this] lazy val controllers_CropController_getLocations14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLocations")))
  )
  private[this] lazy val controllers_CropController_getLocations14_invoker = createInvoker(
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

  // @LINE:24
  private[this] lazy val controllers_CropController_getCropTypes15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCropTypes/"), DynamicPart("location", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getCropTypes15_invoker = createInvoker(
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

  // @LINE:26
  private[this] lazy val controllers_BiddingController_add16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("insertBid")))
  )
  private[this] lazy val controllers_BiddingController_add16_invoker = createInvoker(
    BiddingController_4.add(),
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

  // @LINE:27
  private[this] lazy val controllers_BiddingController_getCropBids17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCropBids/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_getCropBids17_invoker = createInvoker(
    BiddingController_4.getCropBids(fakeValue[Long]),
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

  // @LINE:28
  private[this] lazy val controllers_BiddingController_acceptBid18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("acceptBid/"), DynamicPart("bid", """[^/]+""",true), StaticPart("/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_acceptBid18_invoker = createInvoker(
    BiddingController_4.acceptBid(fakeValue[Long], fakeValue[Long]),
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

  // @LINE:29
  private[this] lazy val controllers_BiddingController_rejectBid19_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rejectBid/"), DynamicPart("bid", """[^/]+""",true), StaticPart("/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_rejectBid19_invoker = createInvoker(
    BiddingController_4.rejectBid(fakeValue[Long], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.BiddingController",
      "rejectBid",
      Seq(classOf[Long], classOf[Long]),
      "GET",
      this.prefix + """rejectBid/""" + "$" + """bid<[^/]+>/""" + "$" + """cid<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_BiddingController_getBidTrends20_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getBidTrends/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_getBidTrends20_invoker = createInvoker(
    BiddingController_4.getBidTrends(fakeValue[Long]),
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

  // @LINE:32
  private[this] lazy val controllers_AdminController_sendEmail21_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("email/"), DynamicPart("to", """[^/]+""",true), StaticPart("/"), DynamicPart("subject", """[^/]+""",true), StaticPart("/"), DynamicPart("body", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminController_sendEmail21_invoker = createInvoker(
    AdminController_0.sendEmail(fakeValue[String], fakeValue[String], fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "sendEmail",
      Seq(classOf[String], classOf[String], classOf[String]),
      "POST",
      this.prefix + """email/""" + "$" + """to<[^/]+>/""" + "$" + """subject<[^/]+>/""" + "$" + """body<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_AdminController_sendAuthEmail22_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("sendAuthEmail/"), DynamicPart("to", """[^/]+""",true), StaticPart("/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminController_sendAuthEmail22_invoker = createInvoker(
    AdminController_0.sendAuthEmail(fakeValue[String], fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AdminController",
      "sendAuthEmail",
      Seq(classOf[String], classOf[Long]),
      "GET",
      this.prefix + """sendAuthEmail/""" + "$" + """to<[^/]+>/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:35
  private[this] lazy val controllers_NotificationController_getNotification23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getNotifications/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_NotificationController_getNotification23_invoker = createInvoker(
    NotificationController_2.getNotification(fakeValue[Long]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.NotificationController",
      "getNotification",
      Seq(classOf[Long]),
      "GET",
      this.prefix + """getNotifications/""" + "$" + """id<[^/]+>""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_Assets_at24_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at24_invoker = createInvoker(
    Assets_6.at(fakeValue[String], fakeValue[String]),
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
    case controllers_RegisterController_addRegister0_route(params@_) =>
      call { 
        controllers_RegisterController_addRegister0_invoker.call(RegisterController_3.addRegister())
      }
  
    // @LINE:8
    case controllers_RegisterController_login1_route(params@_) =>
      call { 
        controllers_RegisterController_login1_invoker.call(RegisterController_3.login())
      }
  
    // @LINE:9
    case controllers_RegisterController_getFarmer2_route(params@_) =>
      call(params.fromPath[Long]("fid", None)) { (fid) =>
        controllers_RegisterController_getFarmer2_invoker.call(RegisterController_3.getFarmer(fid))
      }
  
    // @LINE:10
    case controllers_RegisterController_updateRegister3_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RegisterController_updateRegister3_invoker.call(RegisterController_3.updateRegister(id))
      }
  
    // @LINE:11
    case controllers_RegisterController_verifyRegister4_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RegisterController_verifyRegister4_invoker.call(RegisterController_3.verifyRegister(id))
      }
  
    // @LINE:13
    case controllers_UncheckedCropController_addUncheckedCrop5_route(params@_) =>
      call { 
        controllers_UncheckedCropController_addUncheckedCrop5_invoker.call(UncheckedCropController_5.addUncheckedCrop())
      }
  
    // @LINE:14
    case controllers_UncheckedCropController_getUncheckedCrops6_route(params@_) =>
      call { 
        controllers_UncheckedCropController_getUncheckedCrops6_invoker.call(UncheckedCropController_5.getUncheckedCrops())
      }
  
    // @LINE:15
    case controllers_UncheckedCropController_getUncheckedCrop7_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_getUncheckedCrop7_invoker.call(UncheckedCropController_5.getUncheckedCrop(cid))
      }
  
    // @LINE:16
    case controllers_UncheckedCropController_approveCrop8_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_approveCrop8_invoker.call(UncheckedCropController_5.approveCrop(cid))
      }
  
    // @LINE:17
    case controllers_UncheckedCropController_deleteCrop9_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_deleteCrop9_invoker.call(UncheckedCropController_5.deleteCrop(cid))
      }
  
    // @LINE:19
    case controllers_CropController_getFarmerCrops10_route(params@_) =>
      call(params.fromPath[Long]("fid", None)) { (fid) =>
        controllers_CropController_getFarmerCrops10_invoker.call(CropController_1.getFarmerCrops(fid))
      }
  
    // @LINE:20
    case controllers_CropController_getCrops11_route(params@_) =>
      call { 
        controllers_CropController_getCrops11_invoker.call(CropController_1.getCrops())
      }
  
    // @LINE:21
    case controllers_CropController_getCrop12_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_CropController_getCrop12_invoker.call(CropController_1.getCrop(cid))
      }
  
    // @LINE:22
    case controllers_CropController_cropsIn13_route(params@_) =>
      call(params.fromPath[String]("location", None)) { (location) =>
        controllers_CropController_cropsIn13_invoker.call(CropController_1.cropsIn(location))
      }
  
    // @LINE:23
    case controllers_CropController_getLocations14_route(params@_) =>
      call { 
        controllers_CropController_getLocations14_invoker.call(CropController_1.getLocations())
      }
  
    // @LINE:24
    case controllers_CropController_getCropTypes15_route(params@_) =>
      call(params.fromPath[String]("location", None)) { (location) =>
        controllers_CropController_getCropTypes15_invoker.call(CropController_1.getCropTypes(location))
      }
  
    // @LINE:26
    case controllers_BiddingController_add16_route(params@_) =>
      call { 
        controllers_BiddingController_add16_invoker.call(BiddingController_4.add())
      }
  
    // @LINE:27
    case controllers_BiddingController_getCropBids17_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_BiddingController_getCropBids17_invoker.call(BiddingController_4.getCropBids(cid))
      }
  
    // @LINE:28
    case controllers_BiddingController_acceptBid18_route(params@_) =>
      call(params.fromPath[Long]("bid", None), params.fromPath[Long]("cid", None)) { (bid, cid) =>
        controllers_BiddingController_acceptBid18_invoker.call(BiddingController_4.acceptBid(bid, cid))
      }
  
    // @LINE:29
    case controllers_BiddingController_rejectBid19_route(params@_) =>
      call(params.fromPath[Long]("bid", None), params.fromPath[Long]("cid", None)) { (bid, cid) =>
        controllers_BiddingController_rejectBid19_invoker.call(BiddingController_4.rejectBid(bid, cid))
      }
  
    // @LINE:30
    case controllers_BiddingController_getBidTrends20_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_BiddingController_getBidTrends20_invoker.call(BiddingController_4.getBidTrends(cid))
      }
  
    // @LINE:32
    case controllers_AdminController_sendEmail21_route(params@_) =>
      call(params.fromPath[String]("to", None), params.fromPath[String]("subject", None), params.fromPath[String]("body", None)) { (to, subject, body) =>
        controllers_AdminController_sendEmail21_invoker.call(AdminController_0.sendEmail(to, subject, body))
      }
  
    // @LINE:33
    case controllers_AdminController_sendAuthEmail22_route(params@_) =>
      call(params.fromPath[String]("to", None), params.fromPath[Long]("id", None)) { (to, id) =>
        controllers_AdminController_sendAuthEmail22_invoker.call(AdminController_0.sendAuthEmail(to, id))
      }
  
    // @LINE:35
    case controllers_NotificationController_getNotification23_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_NotificationController_getNotification23_invoker.call(NotificationController_2.getNotification(id))
      }
  
    // @LINE:38
    case controllers_Assets_at24_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at24_invoker.call(Assets_6.at(path, file))
      }
  }
}
