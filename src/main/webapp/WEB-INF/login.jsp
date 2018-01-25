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
                    <div class="col-md-4 col-md-offset-4">
                        <c:if test="${param.error ne null}">
                            <div class="alert alert-danger">Nieprawidłowy login lub hasło! <a href="/" class="alert-link">Wróć na stronę główną</a></div>
                        </c:if>
                        <c:if test="${param.logout ne null}">
                            <div class="alert alert-success">Pomyślnie wylogowano! <a href="/" class="alert-link">Wróć na stronę główną</a></div>
                        </c:if>
                        <div class="login-panel panel panel-default">
                            <div class="panel-heading">
                                <h3 class="panel-title">Logowanie</h3>
                            </div>
                            <div class="panel-body">
                                <form action="/login" method="post">
                                    <fieldset>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Login" name="username" type="text" autofocus>
                                        </div>
                                        <div class="form-group">
                                            <input class="form-control" placeholder="Hasło" name="password" type="password" value="">
                                        </div>
                                        <input type="submit" value="Zaloguj się" class="btn btn-lg btn-success btn-block"/>
                                        <a href="/register" class="btn btn-lg btn-primary btn-block">Rejestracja</a>
                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    </fieldset>
                                </form>
                            </div>
                        </div>
                    </div>  
                </div>

            </div>
        </section>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>