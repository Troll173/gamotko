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
                            Create Purchase Order
                        </h4>
                    </div>


                    <div class="col-md-12 page-details">


                        <ul class="nav nav-tabs" role="tablist">
                            <t:forEach items="${queuedList}" var="obj">
                                <li class="nav-item">
                                    <a class="nav-link" href="#${obj.get("supplier").id}" role="tab" data-toggle="tab">${obj.get("supplier").supplier_name}</a>
                                </li>
                            </t:forEach>
                        </ul>

                        <!-- Tab panes -->
                        <div class="tab-content">
                            <t:forEach items="${queuedList}" var="ob">
                                <div role="tabpanel" class="tab-pane fade in active" id="${ob.get("supplier").id}">

                                <h1>${ob.get("supplier").supplier_name}</h1>
                                <ul>
                                <t:forEach items="${ob.get('products')}" var="prod">
                                    <li>${prod.generic_name}</li>
                                </t:forEach>
                                </ul>
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