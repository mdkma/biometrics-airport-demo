function login (){
	//document.getElementById("status1").innerHTML = "Submitting...";
    var dataArray = $("#submitForm").serializeArray(),
        len = dataArray.length,
        dataObj = {};

    for (i=0; i<len; i++) {
        dataObj[dataArray[i].name] = dataArray[i].value;
    }
    var identifier = dataObj['email'];
    //console.log(dataObj['email']);
    if(identifier === 'hi@derek.ma'){
        window.location.href = "asStudent.html";
    } else{
        window.location.href = "asTutor.html";
    }
}

function submitQuestion (){
    
}