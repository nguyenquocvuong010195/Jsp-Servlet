/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2020-08-04 18:19:19 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class createStudentByAdmin_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

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

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
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
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("<link\r\n");
      out.write("\thref=\"//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.min.css\"\r\n");
      out.write("\trel=\"stylesheet\" id=\"bootstrap-css\">\r\n");
      out.write("<script\r\n");
      out.write("\tsrc=\"//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/js/bootstrap.min.js\"></script>\r\n");
      out.write("<script src=\"//code.jquery.com/jquery-1.11.1.min.js\"></script>\r\n");
      out.write("<!------ Include the above in your HEAD tag ---------->\r\n");
      out.write("\r\n");
      out.write("<form class=\"form-horizontal\" action='StudentsController?action=CreateStudentByAdminTT'\r\n");
      out.write("\tmethod=\"POST\">\r\n");
      out.write("\t<fieldset>\r\n");
      out.write("\t\t<div id=\"legend\">\r\n");
      out.write("\t\t\t<h2 style=\"text-align: center; color: blue;\">UPDATE STUDENT</h2>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<!-- Username -->\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"fullname\">Full Name</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"fullname\" name=\"fullname\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\tclass=\"input-xlarge\">\r\n");
      out.write("\t\t\t\t<p class=\"help-block\">Input full name</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<!-- Username -->\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"username\">Username</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"username\" name=\"username\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\tclass=\"input-xlarge\">\r\n");
      out.write("\t\t\t\t<p class=\"help-block\">Username can contain any letters or\r\n");
      out.write("\t\t\t\t\tnumbers, without spaces</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<!--age -->\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"age\">Age</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t<input type=\"text\" id=\"age\" name=\"age\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\tclass=\"input-xlarge\">\r\n");
      out.write("\t\t\t\t<p class=\"help-block\">Please provide your age</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<!-- Gender-->\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"gender\">Gender</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t<input type=\"radio\" name=\"gender\" value=\"1\"> Male<br> <input\r\n");
      out.write("\t\t\t\t\ttype=\"radio\" name=\"gender\" value=\"0\"> Female<br>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<!-- Password -->\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"role\">Role</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t<input type=\"role\" id=\"role\" name=\"role\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\tclass=\"input-xlarge\">\r\n");
      out.write("\t\t\t\t<p class=\"help-block\">Please provide role</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<!-- Password -->\r\n");
      out.write("\t\t\t<label class=\"control-label\" for=\"password\">Password</label>\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t<input type=\"password\" id=\"password\" name=\"password\" placeholder=\"\"\r\n");
      out.write("\t\t\t\t\tclass=\"input-xlarge\">\r\n");
      out.write("\t\t\t\t<p class=\"help-block\">Please provide password</p>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\r\n");
      out.write("\t\t<div class=\"control-group\">\r\n");
      out.write("\t\t\t<!-- Button -->\r\n");
      out.write("\t\t\t<div class=\"controls\">\r\n");
      out.write("\t\t\t\t<button class=\"btn btn-success\">Register</button>\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t</fieldset>\r\n");
      out.write("</form>\r\n");
      out.write("<style>\r\n");
      out.write("div#legend {\r\n");
      out.write("\tmargin-left: 45%%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#legend {\r\n");
      out.write("\tborder-bottom: none;\r\n");
      out.write("\tmargin-left: 5%;\r\n");
      out.write("\tmargin-bottom: 3%;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("div.control-group {\r\n");
      out.write("\tmargin-left: 30%;\r\n");
      out.write("}\r\n");
      out.write("</style>");
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