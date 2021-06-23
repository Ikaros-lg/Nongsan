<%-- 
    Document   : index
    Created on : May 5, 2020, 10:57:00 PM
    Author     : LENOVO
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<c:url value = "/view/client/assets" var="url"/>

  <!-- Start header section -->
  <jsp:include page = "./header/mainHeader.jsp" flush = "true" />
  <!-- / header section -->
<!--  content -->
 <!-- catg header banner section -->
  <section id="aa-catg-head-banner">
  <img src="${pageContext.request.contextPath}/view/client/assets/images/archive-banner.png" alt="banner blog">
    <div class="aa-catg-head-banner-area">
     <div class="container">
      <div class="aa-catg-head-banner-content">
        <h2>Đăng nhập</h2>
        <ol class="breadcrumb">
          <li><a href="${pageContext.request.contextPath}/">Trang chủ</a></li>                   
          <li style="color:#fff">Đăng nhập</li>
        </ol>
      </div>
     </div>
   </div>
  </section>
  <!-- / catg header banner section -->

 <!-- Cart view section -->
 <section id="aa-myaccount">
   <div class="container">
     <div class="row">
       <div class="col-md-12">
        <div class="aa-myaccount-area">         
            <div class="row">
              <div class="col-md-8 col-md-push-2">
                <div class="aa-myaccount-login">
                <h4>Đăng nhập</h4>
                 <form class="aa-login-form" name="" onsubmit="validate();" action="${pageContext.request.contextPath}/view/client/login" method="post">
                  <label for="">Username<span>*</span></label>
                   <input  type="text" placeholder="Username" name="username">
                   <label for="">Mật khẩu<span>*</span></label>
                    <input  type="password" placeholder="Password" name="password">
                    <p class="rememberme" style="display: block"><input type="checkbox" id="rememberme"> Ghi nhớ </p> 
     
                    <p style="color:red; display:block">
		                ${errorMsg}
		            </p>
		             <button type="submit" class="aa-browse-btn">Đăng nhập</button>
		                
                  </form>
                </div>
                       
              </div>
            </div>          
         </div>
       </div>
     </div>
   </div>
 </section>
                       
        <form id="loginGoogle" name="loginGoogle" onsubmit="" action="${pageContext.request.contextPath}/view/client/logingoogle" method="post">
<!--                  <label for="">Username<span>*</span></label>-->
                  <input style="display: none;" id="loginName" type="text" placeholder="Username" name="ggname">  
                  
                  <input style="display: none;" id="loginEmail" type="text" placeholder="Username" name="ggemail">  
                   
                  <button style="margin-left: 300px;" id="buttonGoogle" type="submit" class="aa-browse-btn"></button>
		                
                  </form>
 <!-- / Cart view section -->
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <title>Insert title here</title>

        <script src="https://apis.google.com/js/platform.js" async defer></script>
        <meta name="google-signin-client_id" content="116688576330-uhr9rqlc91f4qma3ligglv32obafdt8n.apps.googleusercontent.com">
    </head>
    <body>
        <br><br><br><br>
        <div style=" width: 140px; margin-left: 300px;" 
             class="g-signin2" data-onsuccess="onSignIn" id="myP" >Đăng nhập </div>
        <img id="myImg"><br>
        
        <div id="status">
        </div>

        <script type="text/javascript">
            document.getElementById("loginGoogle").style.display="none";
            function onSignIn(googleUser) {
                var profile = googleUser.getBasicProfile();
                var name = profile.getName();
                var email=profile.getEmail();
                document.getElementById("loginGoogle").style.display="block";
                document.getElementById("logoutGoogle").style.display="block";
                document.getElementById("loginName").value = name;
                document.getElementById("loginEmail").value = email;
                document.getElementById("buttonGoogle").innerHTML = "Tiếp tục với tư cách với tư cách "+name;
//                document.getElementById("myP").style.visibility = "hidden";
            }
        </script>

        <button id="logoutGoogle" style="display: none; margin-left: 300px;" onclick="myFunction()">Đăng xuất tài khoản google</button>

        <script>
            function myFunction() {
                gapi.auth2.getAuthInstance().disconnect();
                location.reload();
                document.getElementById("loginGoogle").style.display="none";
            }
        </script>



    </body>
</html> 
<!--  end content-->
   <script type="text/javascript">
		var date = new Date();
		
		var day = date.getDate();
		var month = date.getMonth() + 1;
		var year = date.getFullYear();
		
		if (month < 10) month = "0" + month;
		if (day < 10) day = "0" + day;
		
		var today = year + "-" + month + "-" + day;
		
		
		document.getElementById('the-date').value = today;
                
</script>
<!--  footer-->
 <jsp:include page = "./footer/footer.jsp" flush = "true" />
<!-- end footer-->
  
  
