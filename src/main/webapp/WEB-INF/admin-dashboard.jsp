<%-- 
    Document   : admin-dashboard
    Created on : 2018-01-24, 11:34:09
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

                <c:if test="${enabled eq 'successed'}">
                    <div class="row segment-row">
                        <div class="col-xs-12">
                            <div class="alert alert-success">Pomyślnie aktywowano konto Użytkownika!</div>
                        </div>
                    </div>
                </c:if>  
                <c:if test="${disabled eq 'successed'}">
                    <div class="row segment-row">
                        <div class="col-xs-12">
                            <div class="alert alert-success">Pomyślnie dezaktywowano konto Użytkownika!</div>
                        </div>
                    </div>
                </c:if>  
                <c:if test="${role eq 'successed'}">
                    <div class="row segment-row">
                        <div class="col-xs-12">
                            <div class="alert alert-success">Pomyślnie edytowano uprawnienia Użytkownika!</div>
                        </div>
                    </div>
                </c:if>  

                <div class="row segment-row">
                    <div class="col-xs-12">
                        <span class="segment-title">Użytkownicy</span>
                    </div>
                </div>

                <div class="row row-content admin-row">
                    <div class="col-xs-12">

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
                                                <span class="cell-content-text">Użytkownik</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Email</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Organizacja</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Login</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Aktywny</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Role</span>
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
                                                        <a href="${currentPage.link}/users/show/${item.userid}" title="Podgląd" class="btn btn-info button-table">
                                                            <i class="fa fa-eye"></i>
                                                        </a>
                                                        <a href="${currentPage.link}/users/role/${item.userid}" title="Edytuj uprawnienia" class="btn btn-warning button-table">
                                                            <i class="fa fa-id-card-o"></i>
                                                        </a>
                                                        <c:choose>
                                                            <c:when test="${item.enabled eq 1}">
                                                                <a href="${currentPage.link}/users/deactivate/${item.userid}" title="Dezaktywuj" class="btn btn-danger button-table">
                                                                    <i class="fa fa-toggle-off"></i>
                                                                </a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="${currentPage.link}/users/activate/${item.userid}" title="Aktywuj" class="btn btn-success button-table">
                                                                    <i class="fa fa-toggle-on"></i>
                                                                </a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td class="table-cell">${item.title} ${item.firstname} ${item.lastname}</td>
                                                    <td class="table-cell">${item.email}</td>
                                                    <td class="table-cell">${item.organization}</td>
                                                    <td class="table-cell">${item.userName}</td>
                                                    <c:choose>
                                                        <c:when test="${item.enabled eq 0}">
                                                            <td class="table-cell">Nie</td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td class="table-cell">Tak</td>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <c:choose>
                                                        <c:when test="${roles[item.userName] eq '[ADMIN]'}">
                                                            <td class="table-cell">Administrator</td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:choose>
                                                                <c:when test="${roles[item.userName] eq '[REVIEWER]'}">
                                                                    <td class="table-cell">Recenzent</td>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:choose>
                                                                        <c:when test="${roles[item.userName] eq '[AUTHOR]'}">
                                                                            <td class="table-cell">Autor</td>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <td class="table-cell">-</td>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <tr class="table-row table-row-odd">
                                                    <td class="table-cell row-actions">
                                                        <a href="${currentPage.link}/users/show/${item.userid}" title="Podgląd" class="btn btn-info button-table">
                                                            <i class="fa fa-eye"></i>
                                                        </a>
                                                        <a href="${currentPage.link}/users/role/${item.userid}" title="Edytuj uprawnienia" class="btn btn-warning button-table">
                                                            <i class="fa fa-id-card-o"></i>
                                                        </a>
                                                        <c:choose>
                                                            <c:when test="${item.enabled eq 1}">
                                                                <a href="${currentPage.link}/users/deactivate/${item.userid}" title="Dezaktywuj" class="btn btn-danger button-table">
                                                                    <i class="fa fa-toggle-off"></i>
                                                                </a>
                                                            </c:when>
                                                            <c:otherwise>
                                                                <a href="${currentPage.link}/users/activate/${item.userid}" title="Aktywuj" class="btn btn-success button-table">
                                                                    <i class="fa fa-toggle-on"></i>
                                                                </a>
                                                            </c:otherwise>
                                                        </c:choose>
                                                    </td>
                                                    <td class="table-cell">${item.title} ${item.firstname} ${item.lastname}</td>
                                                    <td class="table-cell">${item.email}</td>
                                                    <td class="table-cell">${item.organization}</td>
                                                    <td class="table-cell">${item.userName}</td>
                                                    <c:choose>
                                                        <c:when test="${item.enabled eq 0}">
                                                            <td class="table-cell">Nie</td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <td class="table-cell">Tak</td>
                                                        </c:otherwise>
                                                    </c:choose>
                                                    <c:choose>
                                                        <c:when test="${roles[item.userName] eq '[ADMIN]'}">
                                                            <td class="table-cell">Administrator</td>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <c:choose>
                                                                <c:when test="${roles[item.userName] eq '[REVIEWER]'}">
                                                                    <td class="table-cell">Recenzent</td>
                                                                </c:when>
                                                                <c:otherwise>
                                                                    <c:choose>
                                                                        <c:when test="${roles[item.userName] eq '[AUTHOR]'}">
                                                                            <td class="table-cell">Autor</td>
                                                                        </c:when>
                                                                        <c:otherwise>
                                                                            <td class="table-cell">-</td>
                                                                        </c:otherwise>
                                                                    </c:choose>
                                                                </c:otherwise>
                                                            </c:choose>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </tr>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>

                                </tbody>

                            </table>
                        </div>
                    </div>
                </div>

                <div class="row segment-row">
                    <div class="col-xs-12">
                        <span class="segment-title">Artykuły</span>
                    </div>
                </div>

                <div class="row row-content admin-row">
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
                                    <c:forEach items="${dataArticle}" var="item" varStatus="counter">
                                        <!-- To jest if który sprawdza czy jest parzysty czy nieparzysty wiersz, jedyna różnica to table-row-even lub table-row-odd-->
                                        <c:choose>
                                            <c:when test="${counter.count % 2 == 0}">
                                                <tr class="table-row table-row-even">
                                                    <td class="table-cell row-actions">
                                                        <a href="${currentPage.link}/articles/show/${item.articleId}" title="Podgląd" class="btn btn-info button-table"><i class="fa fa-eye"></i></a>
                                                        <a href="${currentPage.link}/articles/reviewers/${item.articleId}" title="Przydziel recenzentów" class="btn btn-success button-table"><i class="fa fa-user-plus"></i></a>
                                                        <a href="${currentPage.link}/articles/edit/${item.articleId}" title="Edycja" class="btn btn-warning button-table"><i class="fa fa-pencil"></i></a>
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
                                                        <a href="${currentPage.link}/articles/show/${item.articleId}" title="Podgląd" class="btn btn-info button-table"><i class="fa fa-eye"></i></a>
                                                        <a href="${currentPage.link}/articles/reviewers/${item.articleId}" title="Przydziel recenzentów" class="btn btn-success button-table"><i class="fa fa-user-plus"></i></a>
                                                        <a href="${currentPage.link}/articles/edit/${item.articleId}" title="Edycja" class="btn btn-warning button-table"><i class="fa fa-pencil"></i></a>
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