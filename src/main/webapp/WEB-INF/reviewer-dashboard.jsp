<%-- 
    Document   : reviewer-dashboard
    Created on : 2018-01-24, 11:34:26
    Author     : Bartłomiej Skibiński
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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

                        <c:if test="${success eq 'success'}">
                            <div class="alert alert-success">
                                Zapisano recenzję!
                            </div>
                        </c:if>

                        <div class="table-wrapper">
                            <table class="table table-striped table-bordered table-hover no-footer table-common">

                                <!-- THEAD -->
                                <thead>
                                    <tr class="table-header-row">
                                        <th class="table-header-cell width-100">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Akcje</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Tytuł</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Recenzja</span>
                                            </div>
                                        </th>
                                    </tr>
                                </thead>

                                <!-- TBODY -->
                                <tbody>
                                    <c:forEach items="${data}" var="item" varStatus="counter">
                                        <!-- To jest if który sprawdza czy jest parzysty czy nieparzysty wiersz, jedyna różnica to table-row-even lub table-row-odd-->
                                        <c:choose>
                                            <c:when test="${counter.count % 2 == 0}">
                                                <tr class="table-row table-row-even">
                                                    <td class="table-cell row-actions">
                                                        <c:choose>
                                                            <c:when test="${item.article.revisedFilePathWithoutNames eq ''}">
                                                                <a href="${currentPage.link}/show/${item.article.articleId}" title="Podgląd artykułu" class="btn btn-info button-table">
                                                                    <i class="fa fa-file-pdf-o"></i>
                                                                </a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="${currentPage.link}/show/revised/${item.article.articleId}" title="Podgląd artykułu" class="btn btn-info button-table">
                                                                    <i class="fa fa-file-pdf-o"></i>
                                                                </a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:choose>
                                                            <c:when test="${item.reviewDetails.reviewFinalRecommendation eq null}">
                                                                <a href="${currentPage.link}/review/${item.article.articleId}" title="Wystaw recenzję" class="btn btn-warning button-table">
                                                                    <i class="fa fa-pencil-square-o"></i>
                                                                </a>
                                                            </c:when>
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td class="table-cell">${item.article.title}</td>
                                                    <td class="table-cell">${item.reviewDetails.reviewFinalRecommendation.name}</td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr class="table-row table-row-odd">
                                                    <td class="table-cell row-actions">
                                                        <c:choose>
                                                            <c:when test="${item.article.revisedFilePathWithoutNames eq ''}">
                                                                <a href="${currentPage.link}/show/${item.article.articleId}" title="Podgląd artykułu" class="btn btn-info button-table">
                                                                    <i class="fa fa-file-pdf-o"></i>
                                                                </a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="${currentPage.link}/show/revised/${item.article.articleId}" title="Podgląd artykułu" class="btn btn-info button-table">
                                                                    <i class="fa fa-file-pdf-o"></i>
                                                                </a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                        <c:choose>
                                                            <c:when test="${item.reviewDetails.reviewFinalRecommendation eq null}">
                                                                <a href="${currentPage.link}/review/${item.article.articleId}" title="Wystaw recenzję" class="btn btn-warning button-table">
                                                                    <i class="fa fa-pencil-square-o"></i>
                                                                </a>
                                                            </c:when>
                                                            <c:otherwise>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td class="table-cell">${item.article.title}</td>
                                                    <td class="table-cell">${item.reviewDetails.reviewFinalRecommendation.name}</td>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                </tbody>

                            </table>
                        </div>

                    </div>
                </div>

            </div>
        </section>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>