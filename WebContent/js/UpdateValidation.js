/**
 * 
 */

function UpdateValidation()
{	
	//var x = document.forms["UpdateForm"]["email"].value;
	//var y = x.indexOf("@");
	
	if (document.forms["UpdateForm"]["password"].value != document.forms["UpdateForm"]["confirm_password"].value)
	{
		alert("Passwords do not match");
		document.forms["UpdateForm"]["password"].focus();
		return false;
	} 
	
	/*if (y < 0)
	{
		alert("Invalid email address");
		document.forms["UpdateForm"]["email"].focus();
		return false;
	}*/ 
	
	return true;
	
}
/*function UpdateValidation()
{	
	if (document.forms["UpdateForm"]["username"].value == null || document.forms["UpdateForm"]["username"].value == "")
	{
		alert("Please enter username");
		document.forms["UpdateForm"]["username"].focus();
		return false;
	}

	if (document.forms["UpdateForm"]["password"].value == null || document.forms["UpdateForm"]["password"].value == "")
	{
		alert("Do not leave the password fields blank");
		document.forms["UpdateForm"]["password"].focus();
		return false;
	}
	
	if (document.forms["UpdateForm"]["confirm_password"].value == null || document.forms["UpdateForm"]["confirm_password"].value == "")
	{
		alert("Do not leave the password fields blank");
		document.forms["UpdateForm"]["confirm_password"].focus();
		return false;
	}
	
	if (document.forms["UpdateForm"]["firstname"].value == null || document.forms["UpdateForm"]["firstname"].value == "")
	{
		alert("Do not leave firstname blank");
		document.forms["UpdateForm"]["firstname"].focus();
		return false;
	}
	
	if (document.forms["UpdateForm"]["lastname"].value == null || document.forms["UpdateForm"]["lastname"].value == "")
	{
		alert("Do not leave lastname blank");
		document.forms["UpdateForm"]["lastname"].focus();
		return false;
	}
	
	if (document.forms["UpdateForm"]["email"].value == null || document.forms["UpdateForm"]["email"].value == "")
	{
		alert("Do not leave email blank");
		document.forms["UpdateForm"]["email"].focus();
		return false;
	}
	
	if (document.forms["UpdateForm"]["phonenumber"].value == null || document.forms["UpdateForm"]["phonenumber"].value == "")
	{
		alert("Please enter phonenumber");
		document.forms["UpdateForm"]["phonenumber"].focus();
		return false;
	}
	
	if (document.forms["UpdateForm"]["address"].value == null || document.forms["UpdateForm"]["address"].value == "")
	{
		alert("Please enter address");
		document.forms["UpdateForm"]["address"].focus();
		return false;
	}
		return true;
}*/