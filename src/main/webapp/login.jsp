<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="a" uri="http://java.sun.com/jsp/jstl/core"%>

<%@ include file = "fragments/head.jsp" %>

<div class="page login-page">
    <div class="container d-flex align-items-center">
        <div class="form-holder has-shadow">
            <div class="row">
                <!-- Logo & Information Panel-->
                <div class="col-lg-6">
                    <div class="info d-flex align-items-center">
                        <div class="content">
                            <div class="logo">
                                <h1>Gamot Ko</h1>
                            </div>
                            <p>PHARMACEUTICALS, INC</p>
                        </div>
                    </div>
                </div>
                <!-- Form Panel    -->
                <div class="col-lg-6 bg-white">
                    <div class="form d-flex align-items-center">
                        <h1>${userRes}</h1>
                        <div class="content">
                            <form:form modelAttribute="user" id="login-form">
                                <div class="form-group">
                                    <form:input path="username"  id="login-username" type="text" required="" class="input-material"/>
                                    <label for="login-username" class="label-material">User Name</label>
                                </div>
                                <div class="form-group">
                                    <form:input path="password" id="login-password" type="password"  required="" class="input-material"/>
                                    <label for="login-password" class="label-material">Password</label>
                                </div><button type="submit" class="btn btn-primary">Login</button>

                            </form:form>
                            <a href="#" class="forgot-pass">Forgot Password?</a>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="copyrights text-center">
        <p>GAMOT KO PHARMACEUTICALS, INC. &copy; 2018-2020</p>
    </div>
</div>





<%@ include file = "fragments/foot.jsp" %>

<a:choose>
    <a:when test="${noty == 'Welcome'}">
        <script>
            $(document).ready(function () {
                toastr.success('Login Successful', 'Success')
            })

        </script>
    </a:when>
    <a:when test="${noty == 'Invalid'}">
        <script>
            $(document).ready(function () {
                toastr.error('Login Failed', 'Invalid Credentials')
            })

        </script>
    </a:when>
    <a:otherwise>

    </a:otherwise>
</a:choose>

