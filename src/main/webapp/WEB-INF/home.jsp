<%-- 
    Document   : home
    Created on : 2018-01-24, 11:33:28
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
                    <div class="col-xs-12 col-md-6 col-md-offset-3">
                        <c:if test="${success eq 'success'}">
                            <div class="alert alert-success">Utworzono nowego użytkownika! Czekaj na włączenie konta przez Administratora!</div>
                        </c:if>
                    </div>
                </div>
                <div class="row row-content">
                    <div class="col-xs-12 col-md-4">

                        <div class="panel panel-primary">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <!--<div class="huge"><h:outputText value="" /></div>-->
                                        <div>Panel autora</div>
                                    </div>
                                </div>
                            </div>
                            <a id="seeBooks" href="/author">
                                <div class="panel-footer">
                                    <span class="pull-left">Zaloguj się</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>

                    </div>
                    <div class="col-xs-12 col-md-4">
                        <div class="panel panel-green">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <!--<div class="huge"><h:outputText value="" /></div>-->
                                        <div>Panel recenzenta</div>
                                    </div>
                                </div>
                            </div>
                            <a id="seeAlbums" href="/reviewer">
                                <div class="panel-footer">
                                    <span class="pull-left">Zaloguj się</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                    <div class="col-xs-12 col-md-4">
                        <div class="panel panel-yellow">
                            <div class="panel-heading">
                                <div class="row">
                                    <div class="col-xs-3">
                                        <i class="fa fa-user fa-5x"></i>
                                    </div>
                                    <div class="col-xs-9 text-right">
                                        <!--<div class="huge"><h:outputText value="" /></div>-->
                                        <div>Panel administratora</div>
                                    </div>
                                </div>
                            </div>
                            <a id="seeMovies" href="/admin">
                                <div class="panel-footer">
                                    <span class="pull-left">Zaloguj się</span>
                                    <span class="pull-right"><i class="fa fa-arrow-circle-right"></i></span>
                                    <div class="clearfix"></div>
                                </div>
                            </a>
                        </div>
                    </div>
                </div>

            </div>
        </section>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>
