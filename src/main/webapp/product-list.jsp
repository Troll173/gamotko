<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="t" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file = "fragments/header.jsp" %>

<section class="page">
    <div class="container-fluid">
        <div class="row">
            <div class="statistics col-lg-12 col-12">
                <div class="page-content d-flex bg-white has-shadow card">
                    <div class="card-header">
                        <h4>
                            Product List
                            <button  data-toggle="modal" data-target="#addNewModal" class="btn btn-outline-primary btn-sm float-right"><i class="fa fa-plus"></i> Add New</button>
                        </h4>
                    </div>


                        <div class="col-md-12 page-details">

                            <table class="table datatable">
                                <thead class="thead-inverse">
                                    <tr>
                                        <th>Generic Name</th>
                                        <th>Brand Name</th>
                                        <th>Dosage</th>
                                        <th>Preparation</th>
                                        <th>Packaging</th>
                                        <th>In Stock</th>
                                        <th>Action</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <t:forEach items="${products}" var="product">
                                    <tr>
                                        <td>${product.generic_name}</td>
                                        <td>${product.brand_name}</td>
                                        <td>${product.dosage}</td>
                                        <td>${product.preparation}</td>
                                        <td>${product.packaging}</td>

                                        <t:set var="total" value="0" />
                                        <t:forEach var="stock" items="${product.stocks}">
                                            <t:set var="total" value="${total + stock.qty}" />
                                        </t:forEach>
                                            <td><a href="/inventory/products/stocks/${product.id}">${total}</a></td>


                                        <td>
                                            <button class="btn btn-primary btn-sm"><i class="fa fa-edit"></i> Edit</button>
                                        </td>
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
                <h4 class="modal-title">New Product</h4>
                <button type="button" class="close" data-dismiss="modal">&times;</button>
            </div>

            <form:form modelAttribute="product" method="post">
            <div class="modal-body">

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="generic_name" >Generic Name</label>
                            <form:input path="generic_name" id="generic_name" name="generic_name" type="text" class="form-control" placeholder="Enter Generic Name" required="required"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="brand_name" >Brand Name</label>
                            <form:input path="brand_name" id="brand_name" name="brand_name" type="text" class="form-control" required="required" placeholder="Enter Brand Name"/>
                        </div>
                    </div>
                </div>


                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="dosage" >Dosage</label>
                            <form:input path="dosage" id="dosage" name="dosage" type="text" class="form-control" required="required" placeholder="Enter Dosage"/>
                        </div>
                    </div>
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="preparation" >Preparation</label>
                            <form:input path="preparation" id="preparation" name="preparation" type="text" class="form-control" required="required" placeholder="Enter Preparation"/>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-md-6">
                        <div class="form-group">
                            <label for="packaging" >Packaging</label>
                            <form:input path="packaging"  type="text" name="packaging" class="form-control" id="packaging"/>
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
<script>
    $(document).ready(function () {

        var substringMatcher = function(strs) {
            return function findMatches(q, cb) {
                var matches, substringRegex;

                // an array that will be populated with substring matches
                matches = [];

                // regex used to determine if a string contains the substring `q`
                substrRegex = new RegExp(q, 'i');

                // iterate through the pool of strings and for any string that
                // contains the substring `q`, add it to the `matches` array
                $.each(strs, function(i, str) {
                    if (substrRegex.test(str)) {
                        matches.push(str);
                    }
                });

                cb(matches);
            };
        };

        var states = [];

        $('#packaging').typeahead({
                hint: true,
                highlight: true,
                minLength: 1
            },
            {
                name: 'states',
                source: substringMatcher(states)
            });
    })
</script>