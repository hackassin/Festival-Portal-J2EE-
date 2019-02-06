function SignupValidation()
{	
	//var x = document.forms["UpdateForm"]["email"].value;
	//var y = x.indexOf("@");
	
	if (document.forms["SignupForm"]["Password"].value != document.forms["SignupForm"]["ConfirmPassword"].value)
	{
		alert("Passwords do not match");
		document.forms["SignupForm"]["Password"].focus();
		return false;
	} 
	return true;
}	