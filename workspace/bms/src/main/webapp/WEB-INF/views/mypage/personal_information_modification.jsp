<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<!-- CSS only -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

<!-- JS, Popper.js, and jQuery -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
<style>



</style>
<html>
<body>
	<div class="col-md-8 order-md-1">
	
          <h1 class="mb-3">개인 정보 수정</h1>
          
          <form class="needs-validation"> 
                
              <div class="form-inline form-group ">
                <label class="col-sm-3" for="username" style="font-size:1.5em;">입주자 이름 :</label>
                <input type="text" class="form-control" id="username" placeholder="" value="">
              </div>            


            <div class="form-inline form-group ">
              <label class="col-sm-3" for="userId" style="font-size:1.5em;">입주자 아이디 :</label>
              <div class="input-group">
                <input type="text" class="form-control" id="userId">
                <button type="button" class="btn btn-primary" >중복 확인</button>
              </div>
            </div>
            

             <div class="form-inline form-group ">
                <label class="col-sm-3" for="password" style="font-size:1.5em;">비밀번호 :</label>
                <input type="password" class="form-control" id="password" placeholder="" value="">
             </div>  
              
             <div class="form-inline form-group ">
                <label class="col-sm-3" for="password" style="font-size:1.5em;">비밀번호 확인 :</label>
                <input type="password" class="form-control" id="password" placeholder="" value="">
             </div>

            
         	<div class="form-inline form-group ">
                <label class="col-sm-3" for="snn" style="font-size:1.5em;">주민등록번호 :</label>
                <input type="text" class="form-control" id="snn" placeholder="" value="">
             </div>



            <div class="form-inline form-group ">
                <label class="col-sm-3" for="email" style="font-size:1.5em;">Email :</label>
                <input type="text" class="form-control" id="email" placeholder="" value="">
             </div>

           <div class="form-inline form-group ">
                <label class="col-sm-3" for="adress" style="font-size:1.5em;">임차 장소 :</label>
                <input type="text" class="form-control" id="adress" placeholder="" value="">
             </div>
            
             <div class="form-inline form-group ">
                <label class="col-sm-3" for="phone" style="font-size:1.5em;">휴대폰 번호 :</label>
                <input type="text" class="form-control" id="phone" placeholder="" value="">
             </div>
            
            
            <hr>
            
            
            <button type="button" class="btn btn-success">저장</button>  
            <button type="button" class="btn btn-danger">회원 탈퇴</button>  
               
          </form>
        </div>
</body>
</html>
