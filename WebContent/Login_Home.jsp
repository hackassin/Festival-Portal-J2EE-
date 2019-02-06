<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<html lang="en">

<head>
<title>Event Portal</title>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

<link rel='stylesheet prefetch'
	href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

<link rel="stylesheet" href="css/style.css">

<script type="text/javascript" src="js/index.js"></script>

<script type="text/javascript" src="js/SignupValidation.js"></script>

</head>

<body background="Resources\carnival_custom_res_2.jpeg">

	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>
	<br>

	<div class="login-box">
		<div class="lb-header">
			<a href="#" class="active" id="login-box-link">Login</a> <a href="#"
				id="signup-box-link">Sign Up</a>
		</div>
		<!--<div class="social-login">
      <a href="#">
        <i class="fa fa-facebook fa-lg"></i>
        Login in with facebook
      </a>
      <a href="#">
        <i class="fa fa-google-plus fa-lg"></i>
        log in with Google
      </a>
    </div> -->



		<form class="username-login" action="ValidateLogin.htm" method="post">
			<table class="center">
				<tr>
					<td>
						<div class="u-form-group">
							<input type="text" placeholder="Username" name="Username"
								required>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="u-form-group">
							<input type="password" placeholder="Password" name="Password"
								required>
						</div>
					</td>
				</tr>
				<tr>
					<td><input type="submit" class="button" value="Login">
					</td>
				</tr>
				<tr>
					<td>
						<div class="u-form-group">
							<a href="#" class="forgot-password">Forgot password?</a>
						</div>
					</td>
				</tr>
			</table>
		</form>

		<form name="SignupForm" class="username-signup"
			action="RegisterUser.htm" onsubmit="return SignupValidation()"
			method="post">
			<table>

				<tr>
					<td><div class="u-form-group">
							<input type="text" placeholder="Username" name="Username"
								required>
						</div></td>
				</tr>
				<tr>
					<td>
						<div class="u-form-group">
							<input type="password" placeholder="Password" name="Password"
								required>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="u-form-group">
							<input type="password" placeholder="Confirm Password"
								name="ConfirmPassword" required>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="u-form-group">
							<input type="text" placeholder="Firstname" name="Firstname"
								required>
						</div>
					</td>
				</tr>
				<tr>
					<td><div class="u-form-group">
							<input type="text" placeholder="Lastname" name="Lastname"
								required>
						</div></td>
				</tr>
				<tr>
					<td><div class="u-form-group">
							<input type="email" placeholder="Email" name="Email" required>
						</div></td>
				</tr>
				<tr>
					<td>
						<div class="u-form-group">
							<input type="text" placeholder="Phonenumber" name="Phonenumber"
								required>
						</div>
					</td>
				</tr>
				<tr>
					<td>
						<div class="u-form-group">
							<input type="text" placeholder="Address" name="Address" required>
						</div>
					</td>
				</tr>
				<tr>
					<td><input type="submit" class="button" value="Sign Up">
					</td>
				</tr>
			</table>

		</form>
		<h5 style="color: white" align="center">${User_Reg_Success}</h5>
		<h5 style="color: #ff4000" align="center">${login_error}</h5>
		<h5 style="color: #FF4500" align="center">${User_Reg_Error}</h5>
	</div>
	<script
		src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

	<script src="js/index.js"></script>
	<script src="js/SignupValidation.js"></script>

</body>

</html>
