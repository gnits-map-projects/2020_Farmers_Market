// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/macadmin/projects/2020_Farmers_Market/service/conf/routes
// @DATE:Sat Mar 14 14:27:00 IST 2020


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
