
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/cfrancis/projects/TipsySwift/conf/routes
// @DATE:Mon Nov 30 17:50:26 PST 2015


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
