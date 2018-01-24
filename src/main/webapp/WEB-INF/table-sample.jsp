<%-- 
    Document   : table-sample
    Created on : 2018-01-24, 13:26:12
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
                                        <th class="table-header-cell width-140">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Akcje</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-100">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Profil</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-120">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Producent</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-max">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Nazwa</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-120">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Konfiguracje</span>
                                            </div>
                                        </th>
                                        <th class="table-header-cell width-80">
                                            <div class="cell-content">
                                                <span class="cell-content-text">Rabat</span>
                                            </div>
                                        </th>
                                    </tr>
                                </thead>

                                <!-- TBODY -->
                                <tbody>
                                    <tr class="table-row table-row-odd">
                                        <td class="table-cell row-actions">
                                            <a href="${currentPage.link}/podglad/${item.id}" title="Podgląd" class="btn btn-info button-table"><i class="fa fa-eye"></i></a>
                                            <a href="${currentPage.link}/edytuj/${item.id}" title="Edytuj" class="btn btn-warning button-table"><i class="fa fa-pencil"></i></a>
                                            <a href="${currentPage.link}/usun/${item.id}" title="Usuń" class="btn btn-danger button-table"><i class="fa fa-trash"></i></a>
                                        </td>
                                        <td class="table-cell">${item.windowProfile.windowProfileGroup.name}</td>
                                        <td class="table-cell">${item.windowProfile.windowProfileGroup.manufacturer.name}</td>
                                        <td class="table-cell">${item.windowProfile.name}</td>
                                        <td class="table-cell">${item.windowProfile.pricePerSquareMeter}</td>
                                        <td class="table-cell"></td>
                                    </tr>
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