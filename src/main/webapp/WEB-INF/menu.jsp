<!DOCTYPE html>
<html>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			* { box-sizing: border-box; }
			body {
				font-size: 20px;
				color: white;
				margin-top:50px;
				margin-left:0;
				background-color: #202124;
				font-family: Arial, Helvetica, sans-serif;
			}
			
			table, td, th {
				border:none;
			}
			table{
				border-collapse: collapse;
				width:100%
			}
			th{
				float: left;
				width: 100%;
				position: relative;
				height: 95px;
				vertical-align: middle;
			}
			
			textarea {
				width: 100%;
				height: 300px;
				padding: 12px 20px;
				box-sizing: border-box;
				maxlength:10;
				border: 2px solid #ccc;
				border-radius: 4px;
				background-color: #f8f8f8;
				font-size: 16px;
				resize: none;
			}
			
			
			#overlay {
			  position: fixed;
			  display: none;
			  width: 100%;
			  height: 100%;
			  top: 0;
			  left: 0;
			  right: 0;
			  bottom: 0;
			  background-color: rgba(0,0,0,0.5);
			  z-index: 2;
			  cursor: pointer;
			}
			#text{
			  position: absolute;
			  top: 50%;
			  left: 50%;
			  font-size: 22px;
			  color: white;
			  transform: translate(-50%,-50%);
			  -ms-transform: translate(-50%,-50%);
			}
			
			/* Sert a redimensionner l'image afin qu'elle tienne dans l'emplacement donné */
			.fit {
				max-width: 99%;
			  	max-height: 99%;
			}
			
			.btn-group button {
				background-color: transparent;
				border-radius: 12px;
				font-size: 22px;
				border:none;
				border-bottom: 1px solid white;
				color: black; /* Couleur du texte */
				cursor: pointer; /* Pointer/hand icon */
				width: 100%; /* Set a width if needed */
				height: 100%;
				text-align:left;
				display: block; /* Make the buttons appear below each other */
			}
			
			.btn-group a {
				text-decoration: none;
				position: relative;
				vertical-align: middle;
				width:100%;
			}
			
			.btn-group button:not(:last-child) {
				border-bottom: none; /* Prevent double borders */
			}
			
			/* Add a background color on hover */
			.btn-group button:hover {
				background-color: #4f4f4f;
				color: white;
			}

			/* Barre de navigation haute */			
			.topnav {
				z-index: 10;
				overflow: hidden;
				background-color: #e9e9e9;
				position:fixed;
				width:100%;
				top:0;
				height:54px;
			}
			
			/* Lien dans la barre de navigation */
			.topnav a {
				float: left;
				display: block;
				color: black;
				text-align: center;
				padding: 14px 16px;
				text-decoration: none;
				font-size: 20px;
			}
			
			.topnav a:hover, .topnav button[type=submit]:hover {
				background-color: #ddd;
				color: black;
			}
			
			.topnav a.active {
				border-bottom: 3px solid red;
			}
			
			.topnav input[type=text]{
				float:right;
				padding: 6px;
				margin-top: 8px;
				margin-right:0;
				font-size: 20px;
				border: none;
			}
			
			.topnav button[type=submit] {
				float:right;
				padding: 6px;
				margin-top: 8px;
				margin-right:16px;
				font-size: 20px;
				border: none;
			}
			
			@media screen and (max-width: 600px) {
			  .topnav a, .topnav input[type=text] {
			    float: none;
			    display: block;
			    text-align: left;
			    width: 100%;
			    margin: 0;
			    padding: 14px;
			  }
			  
			  .topnav input[type=text] {
			    border: 1px solid #ccc;  
			  }
			}
			
			.center {
				margin-top: 104px;
				margin-bottom: 50px;
				margin-right:auto;
				margin-left:auto;
				width: 50%;
				background-color: #e9e9e9;
				padding: 1em;
				border-style: groove;	
				color: black;		
			}
		</style>
		
		<script>
			function on() {
			  document.getElementById("overlay").style.display = "block";
			}
			
			function off() {
			  document.getElementById("overlay").style.display = "none";
			}
			function redirect()
			{
				sleep(10000);
				var url = "artistes";
			    document.write("Redirecting to the url in 1  seconds..."); 
			    setTimeout(function(){window.location = url;}, 1000);  
			}
			function sleep(ms) {
				return new Promise(resolve => setTimeout(resolve, ms));
			}
		</script>
	</head>
</html>
