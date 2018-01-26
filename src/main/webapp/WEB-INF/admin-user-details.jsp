<%-- 
    Document   : admin-user-details
    Created on : 2018-01-25, 19:09:54
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
                                <div class="panel panel-default">
                                    <div class="panel-heading">
                                        Informacje o Użytkowniku
                                    </div>
                                    <div class="panel-body">
                                        <div class="form-group">
                                            <label>Użytkownik</label>
                                            <p class="form-control-static">${user.title} ${user.firstname} ${user.lastname}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Organizacja</label>
                                            <p class="form-control-static">${user.organization}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Email</label>
                                            <p class="form-control-static">${user.email}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Login</label>
                                            <p class="form-control-static">${user.userName}</p>
                                        </div>
                                        <div class="form-group">
                                            <label>Aktywny</label>
                                            <c:choose>
                                                <c:when test="${user.enabled eq 1}">
                                                    <p class="form-control-static">Tak</p>
                                                </c:when>
                                                <c:otherwise>
                                                    <p class="form-control-static">Nie</p>
                                                </c:otherwise>
                                            </c:choose>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!-- end of user info -->

                        <div class="row">
                            <div class="col-xs-12">
                                <c:choose>
                                    <c:when test="${role eq 'AUTHOR'}">
                                        <span class="segment-title">Przesłane artykuły</span>
                                    </c:when>
                                    <c:otherwise>
                                        <c:choose>
                                            <c:when test="${role eq 'REVIEWER'}">
                                                <span class="segment-title">Przypisane artykuły</span>
                                            </c:when>
                                            <c:otherwise>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:otherwise>
                                </c:choose>
                            </div>
                        </div>

                        <!--user articles-->
                        <div class="row">
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
                                                <!-- To jest if który sprawdza czy jest parzysty czy nieparzysty wiersz, jedyna różnica to table-row-even lub table-row-odd-->
                                                <c:choose>
                                                    <c:when test="${counter.count % 2 == 0}">
                                                        <tr class="table-row table-row-even">
                                                            <td class="table-cell row-actions">
                                                                <a href="/admin/articles/show/${item.articleId}" title="Podgląd" class="btn btn-info button-table"><i class="fa fa-eye"></i></a>
                                                                <a href="/admin/articles/reviewers/${item.articleId}" title="Przydziel recenzentów" class="btn btn-success button-table"><i class="fa fa-user-plus"></i></a>
                                                                <a href="/admin/articles/edit/${item.articleId}" title="Edycja" class="btn btn-warning button-table"><i class="fa fa-pencil"></i></a>
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
                                                                <a href="/admin/articles/show/${item.articleId}" title="Podgląd" class="btn btn-info button-table"><i class="fa fa-eye"></i></a>
                                                                <a href="/admin/articles/reviewers/${item.articleId}" title="Przydziel recenzentów" class="btn btn-success button-table"><i class="fa fa-user-plus"></i></a>
                                                                <a href="/admin/articles/edit/${item.articleId}" title="Edycja" class="btn btn-warning button-table"><i class="fa fa-pencil"></i></a>
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
                        </div><!--end user articles-->

                    </div>
                </div>

            </div>
        </section>
        <%@include file="jspf/footer.jspf" %>
    </body>
</html>