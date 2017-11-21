<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags" %>
<!-- Page Footer-->
<footer class="main-footer">
    <div class="container-fluid">
        <div class="row">
            <div class="col-sm-6">
                <p>GAMOT KO PHARMACEUTICALS, INC. &copy; 2018-2020</p>
            </div>
            <div class="col-sm-6 text-right">
                <p>Design by <a href="hermes-technologies.com" class="external">Hermes Technologies</a></p>
            </div>
        </div>
    </div>
</footer>
</div>
</div>
</div>

<%@ include file = "foot.jsp" %>

<script>

    var url = "${requestScope['javax.servlet.forward.request_uri']}";
    var title = "";

    $('li > a[href^="'+url+'"]').first().parent().addClass("active");
    if(url === "/"){
        title = "DASHBOARD";
    }else{
        console.log(url);
        switch (true){
            case url.indexOf("inventory") > 0:
                openInventory();
            break;
        }
        title = url.substring(1, url.length).toUpperCase();
    }
    $(".container-fluid > h2").html(title);

    function openInventory() {
        $("#invAnchor").prop("aria-expanded",true).css("background-color","#EEF5F9");
        $("#invOptions").addClass("show");
    }

</script>