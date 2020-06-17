<?xml version="1.0" encoding="UTF-8" ?>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="widtd=device-widtd, initial-scale=1">
	

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/css/bootstrap.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/fonts/font-awesome-4.7.0/css/font-awesome.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/animate/animate.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/select2/select2.min.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/vendor/perfect-scrollbar/perfect-scrollbar.css">

	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/resources/board/css/util.css">
<style>


/* ------------------------------------ */
button:hover {
	cursor: pointer;
}

iframe {
	border: none !important;
}

/*//////////////////////////////////////////////////////////////////
[ Table ]*/

table {
  border-spacing: 1;
  border-collapse: collapse;
  background: white;
  border-radius: 10px;
  overflow: hidden;
  widtd: 100%;
  margin: 0 auto;
  position: relative;
}
table * {
  position: relative;
}
table td, table td {
  padding-left: 8px;
}
table tdead tr {
  height: 60px;
  background: #36304a;
}
table tbody tr {
  height: 50px;
}
table tbody tr:last-child {
  border: 0;
}
table td, table td {
  text-align: left;
}
table td.l, table td.l {
  text-align: right;
}
table td.c, table td.c {
  text-align: center;
}
table td.r, table td.r {
  text-align: center;
}

@media screen and (max-widtd: 992px) {
  table {
    display: block;
  }
  table > *, table tr, table td, table td {
    display: block;
  }
  table tdead {
    display: none;
  }
  table tbody tr {
    height: auto;
    padding: 37px 0;
  }
  table tbody tr td {
    padding-left: 40% !important;
    margin-bottom: 24px;
  }
  table tbody tr td:last-child {
    margin-bottom: 0;
  }
  table tbody tr td:before {
    font-family: OpenSans-Regular;
    font-size: 14px;
    color: #999999;
    line-height: 1.2;
    font-weight: unset;
    position: absolute;
    widtd: 40%;
    left: 30px;
    top: 0;
  }

  tbody tr {
    font-size: 14px;
  }
}

@media (max-widtd: 576px) {
  .container-table100 {
    padding-left: 15px;
    padding-right: 15px;
  }
}

</style>

</head>
<body>
	<div class="container">
    <div class="row">
        <div class="col-md-12">
            <h1 class="text-center"
             style="background-color: crimson; color: #fff">
                                  계약 상세 정보
            </h1>
        </div>
        <div id="no-more-tables">
            <table class="table-bordered table-striped table-condensed table-center"
            	   style="height: 450px; width: 500px; left: 20px;">
				<tbody>
        			<tr>        			
        				<td style="font-size: 20px; width: 160px;">납부 통지 번호</td>
        				<td>${payment.payment_code }</td> 
        			</tr>
        			<tr>	      			
        				<td style="font-size: 20px;">입주인 번호</td>
        				<td>${payment.member_code }</td>
        			</tr>
        			<tr>	      			
        				<td style="font-size: 20px;">납부 일자</td>
        				<td><fmt:formatDate
							value="${payment.payment_date }"
							pattern="yyyy-MM-dd" /></td>
        			</tr>
        			<tr>	      			
        				<td style="font-size: 20px;">납부 금액</td>
        				<td>${payment.payment_amount }</td>
        			</tr>
        			<tr>	      			
        				<td style="font-size: 20px;">납부 방식</td>
        				<td>${payment.payment_plan }</td>
        			</tr>
        			<tr>	      			
        				<td style="font-size: 20px;">납부 유형</td>
        				<td>${payment.payment_type }</td>
        			</tr>   
        			
        			    			
        		</tbody>	          		
        	</table>
        	<button type="button" class="btn btn-danger"  style="background-color: crimson; margin-left:450px;"
        			onclick="closeWindow();">
        		닫 기
        	</button>
        </div>
    </div>
   </div> 
   <script>
	function closeWindow() {
			if (window.opener) {
				self.close();
			} else {
				var elem = window.frameElement.parentElement.parentElement;
				var className = elem.getAttribute("class") || elem.className || '';
				if (className.toLowerCase().indexOf("dhtmlwindow") > -1) {
					elem.outerHTML = "";
				}
			}
		}

</script>
	<!-- bootstrap icons -->
	<script src="https://unpkg.com/ionicons@5.0.0/dist/ionicons.js"></script>

		<!--===============================================================================================-->	
	<script src="<%=request.getContextPath()%>/resources/board/vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/js/popper.js"></script>
	<script src="<%=request.getContextPath()%>/resources/board/vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/board/vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="<%=request.getContextPath()%>/resources/board/js/main.js"></script>

</body>
</html>