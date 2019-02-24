/*
function a(){
  console.log('A');
}
*/
var a = function(){
  console.log('A');
}//익명함수
 
 
function slowfunc(callback){
  callback();
}
 
slowfunc(a);