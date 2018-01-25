<%-- 
    Document   : reviewer-review-form
    Created on : 2018-01-24, 17:24:28
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

                        <div class="row">
                            <div class="col-xs-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Informacje o artykule
                                    </div>
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label>Tytuł</label>
                                            <p class="form-control-static">${article.title}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Status artykułu</label>
                                            <p class="form-control-static">${article.articleStatus.plName}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="/reviewer/review/save" method="post">
                                    <div class="form-group">
                                        <label>Ocena</label>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-status" id="POSITIVE" value="POSITIVE" checked />Pozytywna
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-status" id="NEGATIVE" value="NEGATIVE" />Negatywna
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <input type="radio" name="review-status" id="TO_REVIEW_ONCE_MORE" value="TO_REVIEW_ONCE_MORE" />Do ponownej recenzji
                                            </label>
                                        </div>
                                    </div>

                                    <div class="form-group">
                                        <label>Opis i uwagi</label>
                                        <textarea class="form-control" rows="5" name="description" id="description"></textarea>
                                    </div>

                                    <input type="hidden" name="article-id" value="${article.articleId}" />
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <button type="submit" value="submit" class="btn btn-success">Oceń</button>
                                    <button type="reset" value="submit" class="btn btn-primary">Zresetuj</button>
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