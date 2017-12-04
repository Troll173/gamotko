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
                        <ul class="nav nav-tabs" role="tablist">
                            <t:forEach items="${queuedList}" var="obj" varStatus="loop">
                                <li class="nav-item">
                                    <a class="nav-link <t:if test="${loop.index==0}">active</t:if>" href="#${obj.get("supplier").id}" role="tab" data-toggle="tab">${obj.get("supplier").supplier_name}</a>
                                </li>
                            </t:forEach>
                        </ul>
                    </div>


                    <div class="col-md-12 page-details">



                        <!-- Tab panes -->
                        <div class="tab-content">
                            <t:forEach items="${queuedList}" var="ob" varStatus="loop">
                            <div role="tabpanel" class="tab-pane fade in <t:if test="${loop.index==0}">active show</t:if>" id="${ob.get("supplier").id}">

                                <div class="row" style="padding-top: 10px;">
                                    <div class="col-md-6">
                                        <div class="card card-inverse">
                                            <div class="card-header">
                                                Supplied Products
                                            </div>
                                            <div class="card-body">
                                                <ul  id="sortable1" class="connectedSortable list-group">
                                                    <t:forEach items="${ob.get('supplier').supplierProducts}" var="prod">
                                                        <li class="list-group-item">${prod.product.generic_name} ${prod.product.dosage}
                                                                ${prod.product.preparation} ${prod.product.packaging} (${prod.product.brand_name})
                                                        </li>
                                                    </t:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="col-md-6">
                                        <div class="card ">
                                            <div class="card-header">
                                                New Purchase Order
                                            </div>
                                            <div class="card-body">
                                                <ul id="sortable2" class="connectedSortable list-group" >
                                                    <t:forEach items="${ob.get('products')}" var="poitem">
                                                        <li class="list-group-item">${poitem.product.generic_name} ${poitem.product.dosage}
                                                                ${poitem.product.preparation} ${poitem.product.packaging} (${poitem.product.brand_name})
                                                                    <input value="${poitem.qty}" type="number" class="form-control float-right" placeholder="Enter Qty">
                                                        </li>
                                                    </t:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            </t:forEach>
                        </div>


                    </div>



                </div>
            </div>
        </div>
    </div>
</section>



<%@ include file = "fragments/footer.jsp" %>

<script>
    $( "#sortable1, #sortable2" ).sortable({
        connectWith: ".connectedSortable",
        receive: function( event, ui ) {
            if(ui.sender[0].id === "sortable1") {
                $(ui.item[0]).append("<input type=\"number\" class=\"form-control float-right\" placeholder=\"Enter Qty\">");
            }else{
                $(ui.item[0]).find(".form-control").remove();
            }
            console.log(ui, event);
        }
    }).disableSelection();
</script>