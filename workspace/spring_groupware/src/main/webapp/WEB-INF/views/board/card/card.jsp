<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script type="text/javascript" src="vendor/jquery/jquery.js"></script>
<title></title>

<style>
	.card{
		display : inline-block;
		margin-right : 20px;
		margin-bottom : 20px;
		width : 280px;
		height : 400px;
		perspective : 560px;
	}
	
	.card-inner {
		position : relative;
		width : 100%;
		height : 100%;
		text-align : center;
		transition : transform 0.8s;
		transform-style:preserve-3d;
	}
	
	.card.flipped .card-inner{
		transform : rotateY(180deg);
	}
	
	.card-front, .card-back{
		position: absolute;
		width : 100%;
		height : 100%;
		border : 1px solid black;
		backface-visibility : hidden;
	}
	
	.card-front {
		background : pink;
	}
	
	.card-back{
		background : gray;
		transform : rotateY(180deg);
	}
</style>


</head>

<body>
	<div class="card ">
		<div class="card-inner">
			<div class="card-front">
				앞
			</div>
			<div class="card-back">
				뒤
			</div>
		</div>
	</div>
		<div class="card ">
		<div class="card-inner">
			<div class="card-front">
				앞
			</div>
			<div class="card-back">
				뒤
			</div>
		</div>
	</div>
		<div class="card ">
		<div class="card-inner">
			<div class="card-front">
				앞
			</div>
			<div class="card-back">
				뒤
			</div>
		</div>
	</div>

<script>
	
	/* $('.card').on('mouseenter', function(){
		this.classList.toggle('flipped');
	}) */
	
	$('.card').on('mouseenter', function(){
		this.classList.add('flipped');
	})
	
	$('.card').on('mouseleave', function(){
		this.classList.remove('flipped');
	})
	
</script>

</body>
</html>