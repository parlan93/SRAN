<%-- 
    Document   : login
    Created on : 2018-01-24, 11:33:41
    Author     : Bartłomiej Skibiński
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
    <%@include file="jspf/head.jspf" %>
    <body>
        <%@include file="jspf/header.jspf" %>
        <section class="section">
            <div class="container-fluid">

                <%@include file="jspf/title.jspf" %>

                <div class="row row-content">
                    <div class="col-xs-12">
                        <!--TODO: Logowanie-->
                        <form action="/login" method="post">

                            <div class="lc-block">
                                <div>
                                    <input type="text" class="style-4" name="username"
                                           placeholder="User Name" />
                                </div>
                                <div>
                                    <input type="password" class="style-4" name="password"
                                           placeholder="Password" />
                                </div>
                                <div>
                                    <input type="submit" value="Sign In" class="button red small" />
                                </div>
                                <c:if test="${param.error ne null}">
                                    <div class="alert-danger">Invalid username and password.</div>
                                </c:if>
                                <c:if test="${param.logout ne null}">
                                    <div class="alert-normal">You have been logged out.</div>
                                </c:if>
                            </div>
                            <input type="hidden" name="${_csrf.parameterName}"
                                   value="${_csrf.token}" />
                        </form>

                    </div>
                </div>

            </div>
        </section>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>