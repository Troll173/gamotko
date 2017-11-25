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
                            Supplier List
                            <button  data-toggle="modal" data-target="#addNewModal" class="btn btn-outline-primary btn-sm float-right" style="margin-right: 10px;"><i class="fa fa-plus-circle"></i> Add Supplier</button>
                        </h4>
                    </div>


                    <div class="col-md-12 page-details">

                        <table class="table datatable">
                            <thead class="thead-inverse">
                            <tr>
                                <th>Supplier Name</th>
                                <th>Supplier Address</th>
                                <th>Contact Number</th>
                                <th>Email</th>
                            </tr>
                            </thead>
                            <tbody>
                            <t:forEach items="${suppliers}" var="supplier">
                                <tr>
                                    <td><a href="/inventory/supplier/${supplier.id}">${supplier.supplier_name}</a></td>
                                    <td>${supplier.supplier_address}</td>
                                    <td>${supplier.contact_number}</td>
                                    <td>${supplier.email}</td>
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


<!-- The Modal -->
<div class="modal fade" id="addNewModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">

            <div class="modal-header">
                <h4 class="modal-title">New Supplier</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <form:form modelAttribute="newSupplier" method="post">
                <div class="modal-body">

                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="supplier_name" >Supplier Name</label>
                                <form:input path="supplier_name" id="supplier_name" name="supplier_name" type="text" class="form-control" placeholder="Enter Supplier Name" required="required"/>
                            </div>
                        </div>
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="contact_number" >Contact Number</label>
                                <form:input path="contact_number" id="contact_number" name="contact_number" type="text" class="form-control mobile" required="required" placeholder="Enter Contact Number"/>
                            </div>
                        </div>
                    </div>


                    <div class="row">
                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="supplier_address" >Supplier Address</label>
                                <form:textarea path="supplier_address" id="supplier_address" name="brand_name" type="text" class="form-control" required="required" placeholder="Enter Supplier Address"/>
                            </div>
                        </div>

                        <div class="col-md-6">
                            <div class="form-group">
                                <label for="email" >Email</label>
                                <form:input path="email" id="email" name="email" type="email" class="form-control" required="required" placeholder="Enter Email Address"/>
                            </div>
                        </div>
                    </div>


                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary"><i class="fa fa-save"></i> Save</button>
                </div>
            </form:form>
        </div>
    </div>
</div>


<%@ include file = "fragments/footer.jsp" %>