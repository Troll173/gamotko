<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ include file = "fragments/header.jsp" %>

<section class="page">
    <div class="container-fluid">
        <div class="row">
            <div class="statistics col-lg-12 col-12">
                <div class="page-content d-flex bg-white has-shadow card">
                    <div class="card-header">
                        <h4>
                           Purchase Order List
                            <button  data-toggle="modal" data-target="#addNewModal" class="btn btn-outline-primary btn-sm float-right" style="margin-right: 10px;"><i class="fa fa-plus-circle"></i> Create PO</button>
                        </h4>
                    </div>


                    <div class="col-md-12 page-details">

                        <table class="table datatable">
                            <thead class="thead-inverse">
                            <tr>
                                <th>PO Number</th>
                                <th>Supplier</th>
                                <th>Date Created</th>
                            </tr>
                            </thead>
                            <tbody>
                            <t:forEach items="${pos}" var="po">
                                <tr>
                                    <td><a href="/inventory/po/${po.id}">${po.po_number}</a></td>
                                    <td><a href="/inventory/supplier/${po.supplier.id}">${po.supplier.supplier_name}</a></td>
                                    <td><fmt:formatDate value="${po.date_created}" pattern="MMM dd, YYYY" /></td>
                                </tr>
                            </t:forEach>
                            </tbody>
                        </table>

                    </div>



                </div>
            </div>
        </div>
    </div>
</section>



<%@ include file = "fragments/footer.jsp" %>