<!DOCTYPE html>
<html>
	<head>
		<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
		<style>
			* {box-sizing: border-box;}
			.center {
				position: relative;
				top: 50px;
				margin: auto;
				width: 50%;
			}
			body {
				font-size: 20px;
				color: white;
				background-color: #202124;
				margin: 0;
				font-family: Arial, Helvetica, sans-serif;
			}
			
			
			/* Create two equal columns that floats next to each other */
			.column {
				float: left;
				width: 33.33%;
				position: relative;
				padding: 10px;
				height: 75px;
				vertical-align: middle;
			}
			
			/* Clear floats after the columns */
			.row:after {
			  content: "";
			  display: table;
			  clear: both;
			}		
			
			
			.autocomplete {
			  /*the container must be positioned relative:*/
			  position: relative;
			  display: inline-block;
			}
			input {
			  border: 1px solid transparent;
			  background-color: #f1f1f1;
			  padding: 10px;
			  font-size: 16px;
			}
			input[type=text] {
			  background-color: #f1f1f1;
			}
			input[type=submit] {
			  background-color: DodgerBlue;
			  color: #fff;
			}
			.autocomplete-items {
			  position: absolute;
			  border: 1px solid #d4d4d4;
			  border-bottom: none;
			  border-top: none;
			  z-index: 99;
			  /*position the autocomplete items to be the same width as the container:*/
			  top: 100%;
			  left: 0;
			  right: 0;
			}
			.autocomplete-items div {
			  padding: 10px;
			  cursor: pointer;
			  background-color: #fff;
			  border-bottom: 1px solid #d4d4d4;
			}
			.autocomplete-items div:hover {
			  /*when hovering an item:*/
			  background-color: #e9e9e9;
			}
			.autocomplete-active {
			  /*when navigating through the items using the arrow keys:*/
			  background-color: DodgerBlue !important;
			  color: #ffffff;
			}
						
			
			
			
			.btn-group button {
				font-size: 20px;
				color: white; /* White text */
				padding: 10px 24px; /* Some padding */
				cursor: pointer; /* Pointer/hand icon */
				width: 100%; /* Set a width if needed */
				display: block; /* Make the buttons appear below each other */
			}
			
			.btn-group button:not(:last-child) {
				border-bottom: none; /* Prevent double borders */
			}
			
			/* Add a background color on hover */
			.btn-group button:hover {
				background-color: black;
				color: black;
			}
			
			
			
			
			
			.topnav {
				overflow: hidden;
				background-color: #e9e9e9;
			}
			
			.topnav a {
				float: left;
				display: block;
				color: black;
				text-align: center;
				padding: 14px 16px;
				text-decoration: none;
				font-size: 20px;
			}
			
			.topnav a:hover {
				background-color: #ddd;
				color: black;
			}
			
			.topnav a.active {
				border-bottom: 3px solid red;
			}
			
			.topnav .search-container {
				float: right;
			}
			
			.topnav input[type=text] {
				padding: 6px;
				margin-top: 8px;
				font-size: 17px;
				border: none;
			}
			
			.topnav .search-container button {
				float: right;
				padding: 6px 10px;
				margin-top: 8px;
				margin-right: 16px;
				background: #ddd;
				font-size: 17px;
				border: none;
				cursor: pointer;
			}
			
			.topnav .search-container button:hover {
				background: #ccc;
			}
			
			@media screen and (max-width: 600px)
			{
				 .topnav .search-container {
					float: none;
				 }
				 .topnav a, .topnav input[type=text], .topnav .search-container button {
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
		</style>
	</head>
</html>
