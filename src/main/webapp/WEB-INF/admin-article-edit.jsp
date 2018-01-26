<%-- 
    Document   : admin-article-edit
    Created on : 2018-01-26, 12:26:02
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
                            <div class="alert alert-success">Pomyślnie edytowano statusy artykułu!  <a href="/admin" class="alert-link">Wróć do panelu Administratora</a></div>
                        </c:if>

                        <div class="row">
                            <div class="col-xs-12">
                                <form action="${currentPage.link}/save" method="post">

                                    <!--review status-->
                                    <div class="form-group">
                                        <label>Status recenzji</label>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.reviewStatus.plName eq 'Do recenzji'}">
                                                        <input type="radio" name="review-status" id="TO_REVIEW" value="TO_REVIEW" checked="" />Do recenzji
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="review-status" id="TO_REVIEW" value="TO_REVIEW" />Do recenzji
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.reviewStatus.plName eq 'Do ponownej recenzji'}">
                                                        <input type="radio" name="review-status" id="TO_REVIEW_ONCE_MORE" value="TO_REVIEW_ONCE_MORE" checked="" />Do ponownej recenzji
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="review-status" id="TO_REVIEW_ONCE_MORE" value="TO_REVIEW_ONCE_MORE" />Do ponownej recenzji
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.reviewStatus.plName eq 'Pozytywna'}">
                                                        <input type="radio" name="review-status" id="POSITIVE" value="POSITIVE" checked="" />Pozytywna
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="review-status" id="POSITIVE" value="POSITIVE" />Pozytywna
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.reviewStatus.plName eq 'Negatywna'}">
                                                        <input type="radio" name="review-status" id="NEGATIVE" value="NEGATIVE" checked="" />Negatywna
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="review-status" id="NEGATIVE" value="NEGATIVE" />Negatywna
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.reviewStatus.plName eq 'Niejednoznaczny'}">
                                                        <input type="radio" name="review-status" id="AMBIGUOUS" value="AMBIGUOUS" checked="" />Niejednoznaczna
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="review-status" id="AMBIGUOUS" value="AMBIGUOUS" />Niejednoznaczna
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                    </div><!--end review status-->
                                        
                                    <!--article status-->
                                    <div class="form-group">
                                        <label>Status recenzji</label>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.articleStatus.plName eq 'Nowy'}">
                                                        <input type="radio" name="article-status" id="NEW" value="NEW" checked="" />Nowy
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="article-status" id="NEW" value="NEW" />Nowy
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.articleStatus.plName eq 'Czeka na recenzję'}">
                                                        <input type="radio" name="article-status" id="WAITING_FOR_REVIEW" value="WAITING_FOR_REVIEW" checked="" />Czeka na recenzję
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="article-status" id="WAITING_FOR_REVIEW" value="WAITING_FOR_REVIEW" />Czeka na recenzję
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.articleStatus.plName eq 'Czeka na ponowną recenzję'}">
                                                        <input type="radio" name="article-status" id="WAITING_FOR_REVIEW_ONCE_MORE" value="WAITING_FOR_REVIEW_ONCE_MORE" checked="" />Czeka na ponowną recenzję
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="article-status" id="WAITING_FOR_REVIEW_ONCE_MORE" value="WAITING_FOR_REVIEW_ONCE_MORE" />Czeka na ponowną recenzję
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.articleStatus.plName eq 'Oceniony przyjęty'}">
                                                        <input type="radio" name="article-status" id="REVIEWED_ACCEPTED" value="REVIEWED_ACCEPTED" checked="" />Oceniony, przyjęty
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="article-status" id="REVIEWED_ACCEPTED" value="REVIEWED_ACCEPTED" />Oceniony, przyjęty
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.articleStatus.plName eq 'Oceniony do poprawy'}">
                                                        <input type="radio" name="article-status" id="REVIEWED_TO_CORRECT" value="REVIEWED_TO_CORRECT" checked="" />Oceniony, do poprawy
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="article-status" id="REVIEWED_TO_CORRECT" value="REVIEWED_TO_CORRECT" />Oceniony, do poprawy
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                        <div class="radio">
                                            <label>
                                                <c:choose>
                                                    <c:when test="${article.articleStatus.plName eq 'Oceniony odrzucony'}">
                                                        <input type="radio" name="article-status" id="REVIEWED_DECLINED" value="REVIEWED_DECLINED" checked="" />Oceniony, odrzucony
                                                    </c:when>
                                                    <c:otherwise>
                                                        <input type="radio" name="article-status" id="REVIEWED_DECLINED" value="REVIEWED_DECLINED" />Oceniony, odrzucony
                                                    </c:otherwise>
                                                </c:choose>
                                            </label>
                                        </div>
                                    </div><!--end article status-->
                                    
                                    <input type="hidden" name="article-id" value="${article.articleId}" />
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