
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/jon-bassi/Documents/javaworkspace/CS480SwiftCode/TipsySwift/conf/routes
// @DATE:Tue Nov 03 09:47:44 PST 2015


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
