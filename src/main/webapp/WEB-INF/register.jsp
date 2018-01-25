<%-- 
    Document   : register
    Created on : 2018-01-24, 12:57:52
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

                        <div class="col-md-4 col-md-offset-4">
                            
                            <c:if test="${failed eq '1'}">
                                <div class="alert alert-danger">Błędny adres email!</div>
                            </c:if>
                            <c:if test="${failed eq '2'}">
                                <div class="alert alert-danger">Podane hasła się nie zgadzają!</div>
                            </c:if>
                            <c:if test="${failed eq '3'}">
                                <div class="alert alert-danger">Błędny adres email! Podane hasła się nie zgadzają!</div>
                            </c:if>
                            <c:if test="${failed eq '4'}">
                                <div class="alert alert-danger">Podana nazwa użytkownika już istnieje!</div>
                            </c:if>
                            <c:if test="${failed eq '5'}">
                                <div class="alert alert-danger">Błędny adres email! Podana nazwa użytkownika już istnieje!</div>
                            </c:if>
                            <c:if test="${failed eq '6'}">
                                <div class="alert alert-danger">Podane hasła się nie zgadzają! Podana nazwa użytkownika już istnieje!</div>
                            </c:if>
                            <c:if test="${failed eq '7'}">
                                <div class="alert alert-danger">Błędny adres email! Podane hasła się nie zgadzają! Podana nazwa użytkownika już istnieje!</div>
                            </c:if>
                            
                            <div class="panel panel-default">
                                <div class="panel-heading">
                                    Rejestracja
                                </div>
                                <div class="panel-body">
                                    <div class="row">
                                        <div class="col-lg-12 text-center">
                                            <form role="form" action="/register/add-account" method="POST">
                                                <div class="form-group">
                                                    <input id="nameField" class="form-control" value="" placeholder="Imię" name="firstname" required=""/>
                                                </div>

                                                <div class="form-group">
                                                    <input  id="lastnameField" class="form-control" value="" placeholder="Nazwisko" name="lastname" required=""/>
                                                </div>

                                                <div class="form-group">
                                                    <input id="titleField" class="form-control" value="" placeholder="Tytuł naukowy" name="title" required=""/>
                                                </div>

                                                <div class="form-group">
                                                    <input id="organizationField" class="form-control" value="" placeholder="Organizacja" name="organization" required=""/>
                                                </div>
                                                
                                                <div class="form-group">
                                                    <input id="loginField" class="form-control" value="" placeholder="Login" name="login" required=""/>
                                                </div>

                                                <div class="form-group">
                                                    <input id="emailField" class="form-control" value="" placeholder="Email" name="email" required=""/>
                                                </div>

                                                <div class="form-group">
                                                    <input id="passwordField" class="form-control" value="" placeholder="Hasło" type="password" name="password" required=""/>
                                                </div>
                                                <div class="form-group">
                                                    <input id="password2Field" class="form-control" value="" placeholder="Potwierdź hasło" type="password" name="confirmPassword" required=""/>
                                                </div>
                                                
                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                <button id="registerButton" type="submit" class="btn btn-primary btn-lg btn-block">Załóż konto</button>
                                            </form>
                                        </div>

                                    </div>
                                </div>
                            </div>
                        </div>

                    </div>
                </div>

            </div>
        </section>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>