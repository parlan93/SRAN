<%-- 
    Document   : author-article-show
    Created on : 2018-01-24, 22:16:16
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
                                            <label>Autorzy</label>
                                            <p class="form-control-static">${article.authors}</p>
                                        </div>
                                        <div class="form-group">
                                            <!--TODO: FileCommons name-->
                                            <label>Nazwa pliku z autorami</label>
                                            <p class="form-control-static">${article.filePathWithNames}</p>
                                        </div>
                                        <div class="form-group">
                                            <!--TODO: FileCommons name-->
                                            <label>Nazwa pliku bez autorów</label>
                                            <p class="form-control-static">${article.filePathWithNames}</p>
                                        </div>
                                        <c:choose>
                                            <c:when test="${article.revisedFilePathWithNames eq ''}">
                                            </c:when>
                                            <c:otherwise>
                                                <div class="form-group">
                                                    <!--TODO: FileCommons name-->
                                                    <label>Nazwa poprawionego pliku z autorami</label>
                                                    <p class="form-control-static">${article.revisedFilePathWithNames}</p>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                        <c:choose>
                                            <c:when test="${article.revisedFilePathWithoutNames eq ''}">
                                            </c:when>
                                            <c:otherwise>
                                                <div class="form-group">
                                                    <!--TODO: FileCommons name-->
                                                    <label>Nazwa poprawionego pliku bez autorów</label>
                                                    <p class="form-control-static">${article.revisedFilePathWithoutNames}</p>
                                                </div>
                                            </c:otherwise>
                                        </c:choose>
                                        <div class="form-group">
                                            <label>Status recenzji</label>
                                            <p class="form-control-static">${article.reviewStatus.plName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Status artykułu</label>
                                            <p class="form-control-static">${article.articleStatus.plName}</p>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <!--TODO: RECENZJE TYLKO JAK STATUS OCENIONY-->
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Recenzje
                                    </div>
                                    <c:choose>
                                        <c:when test="${article.articleStatus.plName eq 'Nowy' or article.articleStatus.plName eq 'Czeka na recenzję' or article.articleStatus.plName eq 'Czeka na ponowną recenzję'}">
                                        </c:when>
                                        <c:otherwise>
                                            <div class="panel-body">
                                                <c:forEach items="${reviews}" var="review" varStatus="counter">
                                                    <c:choose>
                                                        <c:when test="${review.reviewStatus.plName eq 'Pozytywna'}">
                                                            <div class="panel panel-green">
                                                                <div class="panel-heading">
                                                                    Recenzja ${counter.index + 1} - ${review.reviewStatus.plName}
                                                                </div>
                                                                <div class="panel-body">
                                                                    <div class="form-group">
                                                                        <label>Recenzent</label>
                                                                        <p class="form-control-static">${review.user.title} ${review.user.firstname} ${review.user.lastname}</p>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>Email</label>
                                                                        <p class="form-control-static">${review.user.email}</p>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>Organizacja</label>
                                                                        <p class="form-control-static">${review.user.organization}</p>
                                                                    </div>
                                                                    <div class="form-group">
                                                                        <label>Recenzja</label>
                                                                        <p class="form-control-static">${review.description}</p>
                                                                    </div>
                                                                    <form action="${currentPage.link}/review/${review.reviewId}" method="post" id="review-${counter.index}">
                                                                        <input type="hidden" name="articleId" value="${review.article.articleId}" />
                                                                        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                                        <input type="submit" name="submit" value="PDF" class="btn btn-default" />
                                                                    </form>
                                                                </div>
                                                            </div>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:choose>
                                                                <c:when test="${review.reviewStatus.plName eq 'Negatywna'}">
                                                                    <div class="panel panel-red">
                                                                        <div class="panel-heading">
                                                                            Recenzja ${counter.index + 1} - ${review.reviewStatus.plName}
                                                                        </div>
                                                                        <div class="panel-body">
                                                                            <div class="form-group">
                                                                                <label>Recenzent</label>
                                                                                <p class="form-control-static">${review.user.title} ${review.user.firstname} ${review.user.lastname}</p>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Email</label>
                                                                                <p class="form-control-static">${review.user.email}</p>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Organizacja</label>
                                                                                <p class="form-control-static">${review.user.organization}</p>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Recenzja</label>
                                                                                <p class="form-control-static">${review.description}</p>
                                                                            </div>
                                                                            <form action="${currentPage.link}/review/${review.reviewId}" method="post" id="review-${counter.index}">
                                                                                <input type="hidden" name="articleId" value="${review.article.articleId}" />
                                                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                                                <input type="submit" name="submit" value="PDF" class="btn btn-default" />
                                                                            </form>
                                                                        </div>
                                                                    </div>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <div class="panel panel-yellow">
                                                                        <div class="panel-heading">
                                                                            Recenzja ${counter.index + 1} - ${review.reviewStatus.plName}
                                                                        </div>
                                                                        <div class="panel-body">
                                                                            <div class="form-group">
                                                                                <label>Recenzent</label>
                                                                                <p class="form-control-static">${review.user.title} ${review.user.firstname} ${review.user.lastname}</p>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Email</label>
                                                                                <p class="form-control-static">${review.user.email}</p>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Organizacja</label>
                                                                                <p class="form-control-static">${review.user.organization}</p>
                                                                            </div>
                                                                            <div class="form-group">
                                                                                <label>Recenzja</label>
                                                                                <p class="form-control-static">${review.description}</p>
                                                                            </div>
                                                                            <form action="${currentPage.link}/review/${review.reviewId}" method="post" id="review-${counter.index}">
                                                                                <input type="hidden" name="articleId" value="${review.article.articleId}" />
                                                                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                                                                <input type="submit" name="submit" value="PDF" class="btn btn-default" />
                                                                            </form>
                                                                        </div>
                                                                    </div>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:forEach>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>
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