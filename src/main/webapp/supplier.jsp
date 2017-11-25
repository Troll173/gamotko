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
                <div class="page-content d-flex ">


                    <div class="col-md-12 page-details">


                        <div class="row">
                            <div class="col-md-5 ">
                                <div class="card">
                                    <div class="card-header">
                                        <h4>
                                            Supplier Details
                                        </h4>
                                    </div>

                                    <div class="col-md-12">
                                        <table class="table table-striped">
                                            <tr>
                                                <td>Supplier Name: </td>
                                                <th>${supplier.supplier_name}</th>
                                            </tr>
                                            <tr>
                                                <td>Supplier Addres:</td>
                                                <th>${supplier.supplier_address}</th>
                                            </tr>
                                            <tr>
                                                <td>Contact #:</td>
                                                <th>${supplier.contact_number}</th>
                                            </tr>
                                            <tr>
                                                <td>Email Address:</td>
                                                <th><a href="mailto:${supplier.email}">${supplier.email}</a></th>
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
                                                Supplied Products
                                            </h4>
                                        </div>

                                        <div class="col-md-12">

                                            <table class="table datatable">
                                                <thead class="thead-inverse">
                                                <tr>
                                                    <th>Product Name</th>
                                                    <th>Last Price</th>
                                                </tr>
                                                </thead>
                                                <tbody>
                                                <t:forEach items="${products}" var="product">
                                                    <tr id="prod-${product.product.id}" class="animated">
                                                        <td>${product.product.generic_name} ${product.product.dosage}
                                                                ${product.product.preparation}
                                                            (${product.product.brand_name})
                                                                ${product.product.packaging}
                                                        </td>
                                                        <td>${product.last_price}</td>
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