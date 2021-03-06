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
                <div class="page-content d-flex">


                    <div class="col-md-12 page-details">

                        <div class="row">
                            <div class="col-md-5 ">
                                <div class="card">
                                    <div class="card-header">
                                        <h4>
                                            PO Details
                                        </h4>
                                    </div>

                                    <div class="col-md-12">
                                    <table class="table table-striped">
                                        <tr>
                                            <td>Po Number:</td>
                                            <th>${po.po_number}</th>
                                        </tr>
                                        <tr>
                                            <td>Date Created:</td>
                                            <th><fmt:formatDate value="${po.date_created}" pattern="MMM dd, YYYY" /></th>
                                        </tr>
                                        <tr>
                                            <td>Supplier:</td>
                                            <th><a href="/inventory/supplier/${po.supplier.id}">${po.supplier.supplier_name}</a></th>
                                        </tr>
                                    </table>
                                    </div>

                                </div>
                            </div>

                            <div class="col-md-7">
                                <div class="card">

                                    <div class="card">
                                        <div class="card-header">
                                            <h4>
                                                PO Content
                                            </h4>
                                        </div>

                                        <div class="col-md-12">

                                            <table class="table datatable">
                                                <thead class="thead-inverse">
                                                <tr>
                                                    <th>Product Name</th>
                                                    <th>Qty</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <t:forEach items="${po.poItems}" var="poItem">
                                                    <tr id="prod-${poItem.product.id}" class="animated">
                                                        <td>${poItem.product.generic_name} ${poItem.product.dosage}
                                                                ${poItem.product.preparation}
                                                            (${poItem.product.brand_name})
                                                            ${poItem.product.packaging}
                                                        </td>
                                                        <td>${poItem.qty}</td>
                                                    </tr>
                                                </t:forEach>
                                                </tbody>
                                            </table>


                                        </div>

                                    </div>


                                </div>
                            </div>

                        </div>


                    </div>

                </div>
            </div>
        </div>
    </div>
</section>



<%@ include file = "fragments/footer.jsp" %>

<script>
    var hash = window.location.hash;
    console.log(hash);
    $(hash+"").addClass("tada");
</script>