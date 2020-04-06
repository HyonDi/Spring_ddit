<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<title></title>

  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- Font Awesome Icons -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/fontawesome-free/css/all.min.css">
  
  <!-- Ionicons -->
  <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
  
  <!-- Theme style -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/dist/css/adminlte.min.css">
  
  <!-- Google Font: Source Sans Pro -->
  <link href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700" rel="stylesheet">
  
  <!-- SweetAlert2 -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/sweetalert2-theme-bootstrap-4/bootstrap-4.min.css">
  
  <!-- Toastr -->
  <link rel="stylesheet" href="<%=request.getContextPath()%>/resources/bootstrap/plugins/toastr/toastr.min.css">
  


</head>


<%--  <body>
	<form action='login' method="post">
		아이디 : <input type="text" name="id" value="${param.id}"/><br/>
		패스워드 : <input type="password" name="pwd"/><br/>
		<input type='submit' value='로그인'/>
	</form>

</body>	 --%>


<body class="login-page" style="min-height: 512.391px;">

<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>JSP_Board</b></a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
      <p class="login-box-msg">로그인</p>

      <form action="login" method="post">
        <div class="input-group mb-3">
          <input type="text" name="id" value="${param.id}" class="form-control" placeholder="ID">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-user"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
          <input type="password" name="pwd" class="form-control" placeholder="Password">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
          <div class="col-8">
           <%--  <div class="icheck-primary">
              <input type="checkbox" id="remember">
              <label for="remember">
                Remember Me
              </label>
            </div> --%>
          </div>
          <!-- /.col -->
          <div class="col-4">
            <button type="submit" class="btn btn-primary btn-block swalDefaultError">로그인</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

      <%-- <div class="social-auth-links text-center mb-3">
        <p>- OR -</p>
        <a href="#" class="btn btn-block btn-primary">
          <i class="fab fa-facebook mr-2"></i> Sign in using Facebook
        </a>
        <a href="#" class="btn btn-block btn-danger">
          <i class="fab fa-google-plus mr-2"></i> Sign in using Google+
        </a>
      </div> --%>
      <!-- /.social-auth-links -->

      <%-- <p class="mb-1">
        <a href="forgot-password.html">I forgot my password</a>
      </p>
      <p class="mb-0">
        <a href="register.html" class="text-center">Register a new membership</a>
      </p> --%>
      
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
<!-- /.login-box -->





</body>


<!-- jQuery -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/jquery/jquery.min.js"></script>
<!-- Bootstrap 4 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/bootstrap/js/bootstrap.bundle.min.js"></script>
<!-- SweetAlert2 -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/sweetalert2/sweetalert2.min.js"></script>
<!-- Toastr -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/plugins/toastr/toastr.min.js"></script>
<!-- AdminLTE App -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/adminlte.min.js"></script>
<!-- AdminLTE for demo purposes -->
<script src="<%=request.getContextPath()%>/resources/bootstrap/dist/js/demo.js"></script>




<script>


 $(function() {
	 
 const Toast = Swal.mixin({
     toast: true,
     position: 'top-end',
     showConfirmButton: false,
     timer: 3000
   });
 

 
/*  $('.swalDefaultError').click(function() {
	 
	 if("${param.id}" !=""){
		 return;
	 }
	 
	 Toast.fire({
       type: 'question',
       title: '아이디를 입력해주세요.'
	 })
	 
   }); */
 
 
 
 
 if("${param.id}" !=""){
	/* alert("아이디 혹은 패스워드가 일치하지 않습니다."); */
	Toast.fire({
      type: 'error',
      title: '아이디 혹은 패스워드가 일치하지 않습니다.'
    })
    
}else if("${msg}"!=""){
	
	Toast.fire({
       type: 'question',
       title: '${msg}'
	 })
	
}
 
 })



</script>
</html>