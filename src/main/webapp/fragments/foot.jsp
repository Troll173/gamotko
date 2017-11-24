<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- Javascript files-->
<%--Todo add datatable responsive--%>
<script src="${pageContext.servletContext.contextPath}/node_modules/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/jquery-ui.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/typeahead.bundle.js"></script>
<script src="${pageContext.servletContext.contextPath}/node_modules/datatables.net/js/jquery.dataTables.js"></script>
<script src="${pageContext.servletContext.contextPath}/node_modules/datatables.net-bs4/js/dataTables.bootstrap4.js"></script>
<script src="${pageContext.servletContext.contextPath}/node_modules/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/node_modules/datatables.net-responsive-bs4/js/responsive.bootstrap4.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/vendor/popper.js/umd/popper.min.js"> </script>
<script src="${pageContext.servletContext.contextPath}/vendor/bootstrap/js/bootstrap.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/vendor/jquery.cookie/jquery.cookie.js"> </script>
<script src="${pageContext.servletContext.contextPath}/vendor/jquery-validation/jquery.validate.min.js"></script>
<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.5.0/Chart.min.js"></script>--%>
<%--<script src="${pageContext.servletContext.contextPath}/js/charts-home.js"></script>--%>
<script src="${pageContext.servletContext.contextPath}/node_modules/toastr/build/toastr.min.js"></script>
<script src="${pageContext.servletContext.contextPath}/js/front.js"></script>


<script>

    $('.datatable').DataTable({
        responsive: true
    });
</script>

</body>
</html>