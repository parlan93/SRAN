<%-- 
    Document   : author-article-add
    Created on : 2018-01-25, 12:19:33
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

                        <c:if test="${error eq '1'}">
                            <div class="alert alert-danger">Błąd przetwarzania plików!</div>
                        </c:if>
                        <c:if test="${error eq '2'}">
                            <div class="alert alert-danger">Podany tytuł artykułu już istnieje!</div>
                        </c:if>

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${currentPage.link}/save" method="POST" enctype="multipart/form-data" accept-charset="utf-8">

                                    <div class="form-group">
                                        <label>Tytuł</label>
                                        <input class="form-control" type="text" name="title" id="title" required="" />
                                    </div>

                                    <div class="form-group">
                                        <label>Autorzy</label>
                                        <textarea class="form-control" rows="3" name="authors" id="authors" required=""></textarea>
                                    </div>

                                    <div class="form-group">
                                        <label>Plik z nazwiskami autorów</label>
                                        <input type="file" name="fileWithNames" id="fileWithNames" required="" />
                                    </div>

                                    <div class="form-group">
                                        <label>Plik bez nazwisk autorów</label>
                                        <input type="file" name="fileWithoutNames" id="fileWithoutNames" required="" />
                                    </div>

                                    <input type="hidden" name="sender-id" value="${sender.userid}" />
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <button type="submit" value="submit" class="btn btn-success">Dodaj</button>
                                    <button type="reset" value="reset" class="btn btn-primary">Zresetuj</button>
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