<%-- 
    Document   : admin-user-role
    Created on : 2018-01-25, 20:05:37
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

                        <!-- user info -->
                        <div class="row">
                            <div class="col-xs-12">

                                <form action="${currentPage.link}/save" method="post">
                                    <div class="form-group">
                                        <label>Ranga</label>
                                        <div class="radio">
                                            <c:choose>
                                                <c:when test="${role ne '[AUTHOR]' and role ne '[REVIEWER]' and role ne '[ADMIN]'}">
                                                    <label>
                                                        <input type="radio" name="role" id="NONE" value="NONE" checked />Brak
                                                    </label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label>
                                                        <input type="radio" name="role" id="NONE" value="NONE" />Brak
                                                    </label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="radio">
                                            <c:choose>
                                                <c:when test="${role eq '[AUTHOR]'}">
                                                    <label>
                                                        <input type="radio" name="role" id="AUTHOR" value="AUTHOR" checked />Autor
                                                    </label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label>
                                                        <input type="radio" name="role" id="AUTHOR" value="AUTHOR" />Autor
                                                    </label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="radio">
                                            <c:choose>
                                                <c:when test="${role eq '[REVIEWER]'}">
                                                    <label>
                                                        <input type="radio" name="role" id="REVIEWER" value="REVIEWER" checked />Recenzent
                                                    </label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label>
                                                        <input type="radio" name="role" id="REVIEWER" value="REVIEWER" />Recenzent
                                                    </label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                        <div class="radio">
                                            <c:choose>
                                                <c:when test="${role eq '[ADMIN]'}">
                                                    <label>
                                                        <input type="radio" name="role" id="ADMIN" value="ADMIN" checked />Administrator
                                                    </label>
                                                </c:when>
                                                <c:otherwise>
                                                    <label>
                                                        <input type="radio" name="role" id="ADMIN" value="ADMIN" />Administrator
                                                    </label>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                    <input type="hidden" name="userId" value="${userId}" />
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <button type="submit" value="submit" class="btn btn-success">Zapisz</button>
                                </form>

                            </div>
                        </div><!-- end of user info -->

                    </div>
                </div>

            </div>
        </section>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>