function validateRegisterForm(){
//		console.log($("input#fullName.validate.valid").length);
	
		if(!$("input#fullName.validate.valid").length) return false;
		if(!$("input#username.validate.valid").length) return false;
		if(!$("input#password.validate.valid").length) return false;
		if(!$("input#email.validate.valid").length) return false;
		return true;		
}
