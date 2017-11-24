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
                            Stocks of ${productName}
                            <button  data-toggle="modal" data-target="#addNewModal" class="btn btn-outline-primary btn-sm float-right"><i class="fa fa-plus"></i> Stock In</button>
                            <button  data-toggle="modal" data-target="#addNewModal" class="btn btn-outline-warning btn-sm float-right" style="margin-right: 10px;"><i class="fa fa-plus-circle"></i> Add To PO</button>
                        </h4>
                    </div>


                    <div class="col-md-12 page-details">

                        <table class="table datatable">
                            <thead class="thead-inverse">
                            <tr>
                                <th>Lot Number</th>
                                <th>Batch Number</th>
                                <th>Quantity</th>
                                <th>Purchase Order</th>
                                <th>Expiration Date</th>
                            </tr>
                            </thead>
                            <tbody>
                            <t:forEach items="${stocks}" var="stock">
                                <tr>
                                    <td>${stock.lot_number}</td>
                                    <td>${stock.batch_number}</td>
                                    <td>${stock.qty}</td>
                                    <td><a href="/inventory/po/${stock.po.id}">${stock.po.po_number}</a></td>
                                    <td><fmt:formatDate value="${stock.expiration_date}" pattern="MMM dd, YYYY" /></td>
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