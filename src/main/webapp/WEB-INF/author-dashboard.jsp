<%-- 
    Document   : author-dashboard
    Created on : 2018-01-24, 11:34:18
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

                        <div class="table-wrapper">
                            <table class="table table-striped table-bordered table-hover no-footer table-common">

                                <!-- THEAD -->
                                <thead>
                                    <tr class="table-header-row">
                                        <th class="table-header-cell width-80">
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
                                                <span class="cell-content-text">Autor główny</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Status recenzji</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Status artykułu</span>
                                            </div>
                                        </th>
                                    </tr>
                                </thead>

                                <!-- TBODY -->
                                <tbody>
                                    <c:forEach items="${data}" var="item" varStatus="counter">
                                        <c:choose>
                                            <c:when test="${counter.count % 2 == 0}">
                                                <tr class="table-row table-row-even">
                                                    <td class="table-cell row-actions">
                                                        <a href="${currentPage.link}/show/${item.articleId}" title="Podgląd artykułu" class="btn btn-info button-table"><i class="fa fa-file-pdf-o"></i></a>
                                                        <a href="${currentPage.link}/details/${item.articleId}" title="Szczegóły artykułu" class="btn btn-warning button-table"><i class="fa fa-eye"></i></a>
                                                    </td>
                                                    <td class="table-cell">${item.title}</td>
                                                    <td class="table-cell">${item.sender.firstname} ${item.sender.lastname}</td>
                                                    <td class="table-cell">${item.reviewStatus.plName}</td>
                                                    <td class="table-cell">${item.articleStatus.plName}</td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr class="table-row table-row-odd">
                                                    <td class="table-cell row-actions">
                                                        <a href="${currentPage.link}/show/${item.articleId}" title="Podgląd artykułu" class="btn btn-info button-table"><i class="fa fa-file-pdf-o"></i></a>
                                                        <a href="${currentPage.link}/details/${item.articleId}" title="Szczegóły artykułu" class="btn btn-warning button-table"><i class="fa fa-eye"></i></a>
                                                    </td>
                                                    <td class="table-cell">${item.title}</td>
                                                    <td class="table-cell">${item.sender.firstname} ${item.sender.lastname}</td>
                                                    <td class="table-cell">${item.reviewStatus.plName}</td>
                                                    <td class="table-cell">${item.articleStatus.plName}</td>
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