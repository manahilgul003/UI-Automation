if(true){
    console.log("hello");
}
if(false){
    console.log("hello");
}
if(1===1){
    console.log("hello");
}
if(1==1){
    console.log("hello");
}
if(1==1){
    console.log("hello");
}
if(1===1){
    console.log("hello");
}
var doit=true;
if(doit){
    console.log("done");
}
var doit=false;
if(doit){
    console.log("done");
}
5%3 
6%3 
var toggles = document.querySelectorAll('.toggle');
for(togglepos=0;togglepos<toggles.length;togglepos++){
	if(togglepos%2==0){
		toggles[togglepos].click();
	}
}
// select every second item in the list
var toggles = document.querySelectorAll('.toggle');
for(togglepos=0;togglepos<toggles.length;togglepos++){
	if(togglepos%2==1){
		toggles[togglepos].click();
	}
}
var toggles = document.querySelectorAll(".toggle");
for(togglepos=0; togglepos<toggles.length; togglepos+=2){
    toggles[togglepos].click();
}
var toggles = document.querySelectorAll(".toggle");
for(togglepos=1; togglepos<toggles.length; togglepos+=2){
        toggles[togglepos].click();
}
var toggles = document.querySelectorAll(".toggle");
for(togglepos=1; togglepos<toggles.length; togglepos= togglepos+2){
        toggles[togglepos].click();
}
var toggles = document.querySelectorAll(".toggle");
var toggleit = false;
for(togglepos=0; togglepos<toggles.length; togglepos++){
    if(toggleit){
        toggles[togglepos].click();
    }
    toggleit=!toggleit;
}
if(true){
    console.log("true it is");
} else {
    console.log("false indeed");
}
