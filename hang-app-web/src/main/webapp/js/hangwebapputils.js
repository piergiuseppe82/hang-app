function validateRegisterForm(){
//		console.log($("input#fullName.validate.valid").length);
	
		if(!$("input#fullName.validate.valid").length) return false;
		if(!$("input#username.validate.valid").length) return false;
		if(!$("input#password.validate.valid").length) return false;
		if(!$("input#email.validate.valid").length) return false;
		return true;		
}
function getDHMSDifferenceBetween(secondTime){
    var firstTime = (new Date()).getTime();
    var oneSecond = 1000;
    var oneMinute = 60*oneSecond;
    var oneHour = 60*oneMinute;
    var oneDay = 24*oneHour; 
    
    
    var day =  parseInt(Math.abs((firstTime - secondTime)/(oneDay)));
    var hours = parseInt(Math.abs(((firstTime - secondTime) % oneDay)/oneHour));
    var minutes = parseInt(Math.abs((((firstTime - secondTime) % oneDay)%oneHour)/oneMinute));
    var seconds = parseInt(Math.abs(((((firstTime - secondTime) % oneDay)%oneHour)%oneMinute)/oneSecond));
    
    var myObject = new Object();
    myObject.day = day;
    myObject.hours = hours;
    myObject.minutes = minutes;
    myObject.seconds = seconds;
    
    return myObject;
}

function getFormattedDHMS(data){
     var formattedData = "";
     if(data.day >0){
         formattedData = formattedData+data.day+"d ";
     }
    if(data.hours >0){
         formattedData = formattedData+data.hours+"h ";
     }
    if(data.minutes >0){
         formattedData = formattedData+data.minutes+"m ";
     }
    if(data.seconds >0){
         formattedData = formattedData+data.seconds+"s ";
     }
     return formattedData+ "ago";
}