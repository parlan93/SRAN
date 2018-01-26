<%-- 
    Document   : admin-article-reviewers
    Created on : 2018-01-25, 22:34:08
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

                        <c:if test="${success eq '1'}">
                            <div class="alert alert-success">Pomyślnie przydzielono recenzentów!  <a href="/admin" class="alert-link">Wróć do panelu Administratora</a></div>
                        </c:if>
                        <c:if test="${success eq '2'}">
                            <div class="alert alert-success">Pomyślnie przydzielono trzeciego recenzenta!  <a href="/admin" class="alert-link">Wróć do panelu Administratora</a></div>
                        </c:if>

                        <c:if test="${error eq '1'}">
                            <div class="alert alert-danger">Zadeklarowano już wszystkich możliwych recenzentów!  <a href="/admin" class="alert-link">Wróć do panelu Administratora</a></div>
                        </c:if>
                        <c:if test="${error eq '2'}">
                            <div class="alert alert-danger">Zadeklarowano już wszystkich możliwych recenzentów!  <a href="/admin" class="alert-link">Wróć do panelu Administratora</a></div>
                        </c:if>
                        <c:if test="${error eq '3'}">
                            <div class="alert alert-danger">Recenzenci muszą być unikatowi!  <a href="/admin" class="alert-link">Wróć do panelu Administratora</a></div>
                        </c:if>

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${currentPage.link}/save" method="post">

                                    <c:choose>
                                        <c:when test="${reviewersAmount eq 0}">
                                            <div class="form-group">
                                                <label>Recenzent 1</label>
                                                <select class="form-control" name="reviewer-1" required="">
                                                    <option value="" selected=""></option>
                                                    <c:forEach items="${reviewers}" var="reviewer" varStatus="counter">
                                                        <option value="${reviewer.userid}" id="reviewer-1-${counter.index + 1}">
                                                            ${reviewer.title} ${reviewer.firstname} ${reviewer.lastname}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>

                                            <div class="form-group">
                                                <label>Recenzent 2</label>
                                                <select class="form-control" name="reviewer-2" required="">
                                                    <option value="" selected=""></option>
                                                    <c:forEach items="${reviewers}" var="reviewer" varStatus="counter">
                                                        <option value="${reviewer.userid}" id="reviewer-2-${counter.index + 1}">
                                                            ${reviewer.title} ${reviewer.firstname} ${reviewer.lastname}
                                                        </option>
                                                    </c:forEach>
                                                </select>
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <div class="form-group">
                                                <label>Recenzent 1</label>
                                                <select class="form-control" name="reviewer-1" required="" disabled="">
                                                    <option value="${first.userid}" selected="">
                                                        ${first.title} ${first.firstname} ${first.lastname}
                                                    </option>
                                                </select> 
                                                <input type="hidden" name="reviewer-1" value="${first.userid}">
                                            </div>

                                            <div class="form-group">
                                                <label>Recenzent 2</label>
                                                <select class="form-control" name="reviewer-2" required="" disabled="">
                                                    <option value="${second.userid}" selected="">
                                                        ${second.title} ${second.firstname} ${second.lastname}
                                                    </option>
                                                </select> 
                                                <input type="hidden" name="reviewer-2" value="${second.userid}">
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                    <c:choose>
                                        <c:when test="${reviewersAmount eq 3}">
                                            <div class="form-group">
                                                <label>Recenzent 3</label>
                                                <select class="form-control" name="reviewer-3" required="" disabled="">
                                                    <option value="${third.userid}" selected="">
                                                        ${third.title} ${third.firstname} ${third.lastname}
                                                    </option>
                                                </select>
                                                <input type="hidden" name="reviewer-3" value="${third.userid}">
                                            </div>
                                        </c:when>
                                        <c:otherwise>
                                            <c:choose>
                                                <c:when test="${article.reviewStatus.plName eq 'Niejednoznaczny'}">
                                                    <div class="form-group">
                                                        <label>Recenzent 3</label>
                                                        <select class="form-control" name="reviewer-3" required="">
                                                            <option value="" selected=""></option>
                                                            <c:forEach items="${reviewers}" var="reviewer" varStatus="counter">
                                                                <option value="${reviewer.userid}" id="reviewer-3-${counter.index + 1}">
                                                                    ${reviewer.title} ${reviewer.firstname} ${reviewer.lastname}
                                                                </option>
                                                            </c:forEach>
                                                        </select>
                                                    </div>
                                                </c:when>
                                                <c:otherwise>
                                                </c:otherwise>
                                            </c:choose>
                                        </c:otherwise>
                                    </c:choose>

                                    <input type="hidden" name="article-id" value="${articleId}" />
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <div class="form-group">
                                        <button type="submit" value="submit" class="btn btn-success">Zapisz</button>
                                    </div>
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