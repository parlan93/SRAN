<%-- 
    Document   : author-article-revision
    Created on : 2018-01-25, 13:03:50
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
                                <form action="${currentPage.link}/save" method="post" enctype="multipart/form-data" accept-charset="utf-8">

                                    <div class="form-group">
                                        <label>Plik z nazwiskami autorów</label>
                                        <input type="file" name="fileWithNames" id="fileWithNames" required="">
                                    </div>
                                    
                                    <div class="form-group">
                                        <label>Plik bez nazwisk autorów</label>
                                        <input type="file" name="fileWithoutNames" id="fileWithoutNames" required="">
                                    </div>

                                    <input type="hidden" name="article-id" value="${articleId}" />
                                    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                                    <button type="submit" value="submit" class="btn btn-success">Zapisz</button>
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