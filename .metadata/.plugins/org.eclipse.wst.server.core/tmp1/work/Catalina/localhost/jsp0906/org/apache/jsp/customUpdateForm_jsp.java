/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/9.0.39
 * Generated at: 2023-09-16 09:19:18 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class customUpdateForm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(2);
    _jspx_dependants.put("/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar", Long.valueOf(1694681066300L));
    _jspx_dependants.put("jar:file:/C:/jsp/jspSrc/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/wtpwebapps/jsp0906/WEB-INF/lib/javax.servlet.jsp.jstl-1.2.1.jar!/META-INF/c.tld", Long.valueOf(1323225978000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    if (!javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      final java.lang.String _jspx_method = request.getMethod();
      if ("OPTIONS".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        return;
      }
      if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method)) {
        response.setHeader("Allow","GET, HEAD, POST, OPTIONS");
        response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
        return;
      }
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("    \r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"UTF-8\">\r\n");
      out.write("<title>Insert title here</title>\r\n");
      out.write("</head>\r\n");
      out.write("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC\" crossorigin=\"anonymous\">\r\n");
      out.write("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("<body>\r\n");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "navHeader.jsp", out, false);
      out.write("\r\n");
      out.write("<div id=\"header\">\r\n");
      out.write("\t\t<nav class=\"navbar navbar-expand-md navbar-dark fixed-top bg-dark\">\r\n");
      out.write("\t\t  <div class=\"container-fluid\">\r\n");
      out.write("\t\t    <a class=\"navbar-brand\"href=\"main.do\" >YYA</a>\r\n");
      out.write("\t\t    <button class=\"navbar-toggler\" type=\"button\" data-bs-toggle=\"collapse\" data-bs-target=\"#navbarSupportedContent\" aria-controls=\"navbarSupportedContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n");
      out.write("\t\t      <span class=\"navbar-toggler-icon\"></span>\r\n");
      out.write("\t\t    </button>\r\n");
      out.write("\t\t \r\n");
      out.write("\t\t    <div class=\"collapse navbar-collapse\" id=\"navbarSupportedContent\">\r\n");
      out.write("\t\t      <ul class=\"navbar-nav me-auto mb-2 mb-lg-0\">\r\n");
      out.write("\t\t        <li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\" color = \"black\">\r\n");
      out.write("\t\t            사원관리\r\n");
      out.write("\t\t          </a>\r\n");
      out.write("\t\t          <ul class=\"dropdown-menu dropdown-menu-dark\">\r\n");
      out.write("\t\t            <li><a class=\"dropdown-item\" href=\"sawonList.do\" >사원조회</a></li>\r\n");
      out.write("\t\t            <li><a class=\"dropdown-item\" href=\"insertSawon.do\">사원등록</a></li>\r\n");
      out.write("\t\t          </ul>\r\n");
      out.write("\t\t        </li>\r\n");
      out.write("\r\n");
      out.write("\t\t        <li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("\t\t            제품관리\r\n");
      out.write("\t\t          </a>\r\n");
      out.write("\t\t          <ul class=\"dropdown-menu dropdown-menu-dark\">\r\n");
      out.write("\t\t            <li><a class=\"dropdown-item\" href=\"itemSelectAction.do\">제품조회</a></li>\r\n");
      out.write("\t\t            <li><a class=\"dropdown-item\" href=\"itemInsertFormAction.do\">제품등록</a></li>\r\n");
      out.write("\t\t          </ul>\r\n");
      out.write("\t\t        </li>\r\n");
      out.write("\r\n");
      out.write("\t\t        <li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("\t\t            거래처관리\r\n");
      out.write("\t\t          </a>\r\n");
      out.write("\t\t           <ul class=\"dropdown-menu dropdown-menu-dark\">\r\n");
      out.write("\t\t            <li><a class=\"dropdown-item\" href=\"#\">거래처조회</a></li>\r\n");
      out.write("\t\t            <li><a class=\"dropdown-item\" href=\"#\">거래처등록</a></li>\r\n");
      out.write("\t\t          </ul>\r\n");
      out.write("\t\t        </li>\r\n");
      out.write("\r\n");
      out.write("\t\t        <li class=\"nav-item dropdown\">\r\n");
      out.write("\t\t          <a class=\"nav-link dropdown-toggle\" href=\"#\" id=\"navbarDropdown\" role=\"button\" data-bs-toggle=\"dropdown\" aria-expanded=\"false\">\r\n");
      out.write("\t\t            주문관리\r\n");
      out.write("\t\t          </a>\r\n");
      out.write("\t\t         <ul class=\"dropdown-menu dropdown-menu-dark\">\r\n");
      out.write("\t\t            <li><a class=\"dropdown-item\" href=\"#\">주문조회</a></li>\r\n");
      out.write("\t\t            <li><a class=\"dropdown-item\" href=\"#\">주문등록</a></li>\r\n");
      out.write("\t\t          </ul>\r\n");
      out.write("\t\t        </li>\r\n");
      out.write("\t\t        \r\n");
      out.write("\r\n");
      out.write("\t\t      </ul>\r\n");
      out.write("\t\t      <form class=\"d-flex\">\r\n");
      out.write("\t\t        <input class=\"form-control me-2\" type=\"search\" placeholder=\"Search\" aria-label=\"Search\">\r\n");
      out.write("\t\t        <button class=\"btn btn-outline-success\" type=\"submit\">Search</button>\r\n");
      out.write("\t\t      </form>\r\n");
      out.write("\t\t    </div>\r\n");
      out.write("\t\t  </div>\r\n");
      out.write("\t\t</nav>   \r\n");
      out.write("\t</div>\r\n");
      out.write("\t\r\n");
      out.write(" <section class=\"py-3 text-center container\">\r\n");
      out.write("<div class=\"col-lg-15 col-md-15 mx-auto\">\r\n");
      out.write(" </div>\r\n");
      out.write("</section> \r\n");
      out.write("  <div class=\"album py-5 bg-body-tertiary\">\r\n");
      out.write("\t\r\n");
      out.write("\t<form action=\"updateCustom.do\" method=\"post\">\r\n");
      out.write("\t<input type=\"hidden\" name=\"custcode\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custom.custcode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("\t");
      out.write("\r\n");
      out.write("\t<fieldset>\r\n");
      out.write("\t<legend>거래처정보수정</legend>\r\n");
      out.write("\t<table>\r\n");
      out.write("\t<tr>\r\n");
      out.write("\t\t<td>거래처코드:</td> <td>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custom.custcode}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</td> \r\n");
      out.write("   </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td>거래처명:</td> <td> <input type=\"text\" name=\"custname\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custom.custname}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\"></td>  \r\n");
      out.write("    </tr>\r\n");
      out.write("    <tr>\r\n");
      out.write("    <td>거래처tel:</td> <td> <input type=\"text\" name=\"cust_tel\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custom.cust_tel}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\"></td>  \r\n");
      out.write("     </tr>\r\n");
      out.write("    <tr> \r\n");
      out.write("    <td>거래처구분: </td> <td> <input type=\"text\" name=\"cust_gubun\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custom.cust_gubun}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\"></td>  \r\n");
      out.write("    </tr>\r\n");
      out.write("     <tr> \r\n");
      out.write("    <td>거래처대표: </td> <td> <input type=\"text\" name=\"cust_ceo\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${custom.cust_ceo}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required=\"required\"></td>  \r\n");
      out.write("    </tr>\r\n");
      out.write("  \r\n");
      out.write("    </table>\r\n");
      out.write("   \r\n");
      out.write("    <input type=\"submit\" value=\"수정완료\"> \r\n");
      out.write("    \r\n");
      out.write("     \r\n");
      out.write("</fieldset>\r\n");
      out.write("</form>\r\n");
      out.write("</div>\r\n");
      out.write("\t\t\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
