var testFolder = './data';//data라고만 해도 된다. ./는 현재파일
var fs = require('fs');

fs.readdir(testFolder, (err, filelist) => {
	console.log(filelist);
});