// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/projects/2020_Farmers_Market/service/conf/routes
// @DATE:Fri Mar 13 12:11:52 IST 2020

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  PersonController_0: controllers.PersonController,
  // @LINE:12
  UncheckedCropController_5: controllers.UncheckedCropController,
  // @LINE:20
  RegisterController_3: controllers.RegisterController,
  // @LINE:24
  CropController_2: controllers.CropController,
  // @LINE:40
  BiddingController_4: controllers.BiddingController,
  // @LINE:46
  AdminController_1: controllers.AdminController,
  // @LINE:50
  Assets_6: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    PersonController_0: controllers.PersonController,
    // @LINE:12
    UncheckedCropController_5: controllers.UncheckedCropController,
    // @LINE:20
    RegisterController_3: controllers.RegisterController,
    // @LINE:24
    CropController_2: controllers.CropController,
    // @LINE:40
    BiddingController_4: controllers.BiddingController,
    // @LINE:46
    AdminController_1: controllers.AdminController,
    // @LINE:50
    Assets_6: controllers.Assets
  ) = this(errorHandler, PersonController_0, UncheckedCropController_5, RegisterController_3, CropController_2, BiddingController_4, AdminController_1, Assets_6, "/")

  def withPrefix(prefix: String): Routes = {
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, PersonController_0, UncheckedCropController_5, RegisterController_3, CropController_2, BiddingController_4, AdminController_1, Assets_6, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.PersonController.index()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """person""", """controllers.PersonController.addPerson()"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """personJson""", """controllers.PersonController.addPersonJson()"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """persons""", """controllers.PersonController.getPersons()"""),
    ("""DELETE""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """persons""", """controllers.PersonController.delPersons()"""),
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
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.at(path:String = "/public", file:String)"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_PersonController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_PersonController_index0_invoker = createInvoker(
    PersonController_0.index(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ Home page""",
      Seq()
    )
  )

  // @LINE:7
  private[this] lazy val controllers_PersonController_addPerson1_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("person")))
  )
  private[this] lazy val controllers_PersonController_addPerson1_invoker = createInvoker(
    PersonController_0.addPerson(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "addPerson",
      Nil,
      "POST",
      this.prefix + """person""",
      """""",
      Seq()
    )
  )

  // @LINE:8
  private[this] lazy val controllers_PersonController_addPersonJson2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("personJson")))
  )
  private[this] lazy val controllers_PersonController_addPersonJson2_invoker = createInvoker(
    PersonController_0.addPersonJson(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "addPersonJson",
      Nil,
      "POST",
      this.prefix + """personJson""",
      """""",
      Seq()
    )
  )

  // @LINE:9
  private[this] lazy val controllers_PersonController_getPersons3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("persons")))
  )
  private[this] lazy val controllers_PersonController_getPersons3_invoker = createInvoker(
    PersonController_0.getPersons(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "getPersons",
      Nil,
      "GET",
      this.prefix + """persons""",
      """""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_PersonController_delPersons4_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("persons")))
  )
  private[this] lazy val controllers_PersonController_delPersons4_invoker = createInvoker(
    PersonController_0.delPersons(),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.PersonController",
      "delPersons",
      Nil,
      "DELETE",
      this.prefix + """persons""",
      """""",
      Seq()
    )
  )

  // @LINE:12
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

  // @LINE:16
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

  // @LINE:18
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

  // @LINE:20
  private[this] lazy val controllers_RegisterController_addRegister9_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("register")))
  )
  private[this] lazy val controllers_RegisterController_addRegister9_invoker = createInvoker(
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

  // @LINE:22
  private[this] lazy val controllers_RegisterController_login10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_RegisterController_login10_invoker = createInvoker(
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

  // @LINE:24
  private[this] lazy val controllers_CropController_getFarmerCrops11_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFarmerCrops/"), DynamicPart("fid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getFarmerCrops11_invoker = createInvoker(
    CropController_2.getFarmerCrops(fakeValue[Long]),
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

  // @LINE:26
  private[this] lazy val controllers_CropController_getCrops12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCrops")))
  )
  private[this] lazy val controllers_CropController_getCrops12_invoker = createInvoker(
    CropController_2.getCrops(),
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

  // @LINE:28
  private[this] lazy val controllers_CropController_getCrop13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getCrop13_invoker = createInvoker(
    CropController_2.getCrop(fakeValue[Long]),
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

  // @LINE:30
  private[this] lazy val controllers_CropController_cropsIn14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("cropsIn/"), DynamicPart("location", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_cropsIn14_invoker = createInvoker(
    CropController_2.cropsIn(fakeValue[String]),
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

  // @LINE:32
  private[this] lazy val controllers_CropController_getLocations15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getLocations")))
  )
  private[this] lazy val controllers_CropController_getLocations15_invoker = createInvoker(
    CropController_2.getLocations(),
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

  // @LINE:34
  private[this] lazy val controllers_CropController_getCropTypes16_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCropTypes/"), DynamicPart("location", """[^/]+""",true)))
  )
  private[this] lazy val controllers_CropController_getCropTypes16_invoker = createInvoker(
    CropController_2.getCropTypes(fakeValue[String]),
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

  // @LINE:36
  private[this] lazy val controllers_UncheckedCropController_deleteCrop17_route = Route("DELETE",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("rejectCrop/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_UncheckedCropController_deleteCrop17_invoker = createInvoker(
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

  // @LINE:38
  private[this] lazy val controllers_RegisterController_getFarmer18_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getFarmer/"), DynamicPart("fid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RegisterController_getFarmer18_invoker = createInvoker(
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

  // @LINE:40
  private[this] lazy val controllers_BiddingController_add19_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("insertBid")))
  )
  private[this] lazy val controllers_BiddingController_add19_invoker = createInvoker(
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

  // @LINE:42
  private[this] lazy val controllers_RegisterController_updateRegister20_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("updateProfile/"), DynamicPart("id", """[^/]+""",true)))
  )
  private[this] lazy val controllers_RegisterController_updateRegister20_invoker = createInvoker(
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

  // @LINE:44
  private[this] lazy val controllers_BiddingController_getCropBids21_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("getCropBids/"), DynamicPart("cid", """[^/]+""",true)))
  )
  private[this] lazy val controllers_BiddingController_getCropBids21_invoker = createInvoker(
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

  // @LINE:46
  private[this] lazy val controllers_AdminController_sendEmail22_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("email/"), DynamicPart("to", """[^/]+""",true)))
  )
  private[this] lazy val controllers_AdminController_sendEmail22_invoker = createInvoker(
    AdminController_1.sendEmail(fakeValue[String]),
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

  // @LINE:50
  private[this] lazy val controllers_Assets_at23_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_at23_invoker = createInvoker(
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
  
    // @LINE:6
    case controllers_PersonController_index0_route(params@_) =>
      call { 
        controllers_PersonController_index0_invoker.call(PersonController_0.index())
      }
  
    // @LINE:7
    case controllers_PersonController_addPerson1_route(params@_) =>
      call { 
        controllers_PersonController_addPerson1_invoker.call(PersonController_0.addPerson())
      }
  
    // @LINE:8
    case controllers_PersonController_addPersonJson2_route(params@_) =>
      call { 
        controllers_PersonController_addPersonJson2_invoker.call(PersonController_0.addPersonJson())
      }
  
    // @LINE:9
    case controllers_PersonController_getPersons3_route(params@_) =>
      call { 
        controllers_PersonController_getPersons3_invoker.call(PersonController_0.getPersons())
      }
  
    // @LINE:10
    case controllers_PersonController_delPersons4_route(params@_) =>
      call { 
        controllers_PersonController_delPersons4_invoker.call(PersonController_0.delPersons())
      }
  
    // @LINE:12
    case controllers_UncheckedCropController_addUncheckedCrop5_route(params@_) =>
      call { 
        controllers_UncheckedCropController_addUncheckedCrop5_invoker.call(UncheckedCropController_5.addUncheckedCrop())
      }
  
    // @LINE:14
    case controllers_UncheckedCropController_getUncheckedCrops6_route(params@_) =>
      call { 
        controllers_UncheckedCropController_getUncheckedCrops6_invoker.call(UncheckedCropController_5.getUncheckedCrops())
      }
  
    // @LINE:16
    case controllers_UncheckedCropController_getUncheckedCrop7_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_getUncheckedCrop7_invoker.call(UncheckedCropController_5.getUncheckedCrop(cid))
      }
  
    // @LINE:18
    case controllers_UncheckedCropController_approveCrop8_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_approveCrop8_invoker.call(UncheckedCropController_5.approveCrop(cid))
      }
  
    // @LINE:20
    case controllers_RegisterController_addRegister9_route(params@_) =>
      call { 
        controllers_RegisterController_addRegister9_invoker.call(RegisterController_3.addRegister())
      }
  
    // @LINE:22
    case controllers_RegisterController_login10_route(params@_) =>
      call { 
        controllers_RegisterController_login10_invoker.call(RegisterController_3.login())
      }
  
    // @LINE:24
    case controllers_CropController_getFarmerCrops11_route(params@_) =>
      call(params.fromPath[Long]("fid", None)) { (fid) =>
        controllers_CropController_getFarmerCrops11_invoker.call(CropController_2.getFarmerCrops(fid))
      }
  
    // @LINE:26
    case controllers_CropController_getCrops12_route(params@_) =>
      call { 
        controllers_CropController_getCrops12_invoker.call(CropController_2.getCrops())
      }
  
    // @LINE:28
    case controllers_CropController_getCrop13_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_CropController_getCrop13_invoker.call(CropController_2.getCrop(cid))
      }
  
    // @LINE:30
    case controllers_CropController_cropsIn14_route(params@_) =>
      call(params.fromPath[String]("location", None)) { (location) =>
        controllers_CropController_cropsIn14_invoker.call(CropController_2.cropsIn(location))
      }
  
    // @LINE:32
    case controllers_CropController_getLocations15_route(params@_) =>
      call { 
        controllers_CropController_getLocations15_invoker.call(CropController_2.getLocations())
      }
  
    // @LINE:34
    case controllers_CropController_getCropTypes16_route(params@_) =>
      call(params.fromPath[String]("location", None)) { (location) =>
        controllers_CropController_getCropTypes16_invoker.call(CropController_2.getCropTypes(location))
      }
  
    // @LINE:36
    case controllers_UncheckedCropController_deleteCrop17_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_UncheckedCropController_deleteCrop17_invoker.call(UncheckedCropController_5.deleteCrop(cid))
      }
  
    // @LINE:38
    case controllers_RegisterController_getFarmer18_route(params@_) =>
      call(params.fromPath[Long]("fid", None)) { (fid) =>
        controllers_RegisterController_getFarmer18_invoker.call(RegisterController_3.getFarmer(fid))
      }
  
    // @LINE:40
    case controllers_BiddingController_add19_route(params@_) =>
      call { 
        controllers_BiddingController_add19_invoker.call(BiddingController_4.add())
      }
  
    // @LINE:42
    case controllers_RegisterController_updateRegister20_route(params@_) =>
      call(params.fromPath[Long]("id", None)) { (id) =>
        controllers_RegisterController_updateRegister20_invoker.call(RegisterController_3.updateRegister(id))
      }
  
    // @LINE:44
    case controllers_BiddingController_getCropBids21_route(params@_) =>
      call(params.fromPath[Long]("cid", None)) { (cid) =>
        controllers_BiddingController_getCropBids21_invoker.call(BiddingController_4.getCropBids(cid))
      }
  
    // @LINE:46
    case controllers_AdminController_sendEmail22_route(params@_) =>
      call(params.fromPath[String]("to", None)) { (to) =>
        controllers_AdminController_sendEmail22_invoker.call(AdminController_1.sendEmail(to))
      }
  
    // @LINE:50
    case controllers_Assets_at23_route(params@_) =>
      call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_at23_invoker.call(Assets_6.at(path, file))
      }
  }
}
