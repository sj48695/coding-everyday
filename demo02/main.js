var http = require('http');
var fs = require('fs');
var url=require('url');

var app = http.createServer(function(request,response){
    var _url = request.url;/*/?id=HTML*/
    var queryData=url.parse(_url,true).query;
//    var title=queryData.id;
    var pathname=url.parse(_url, true).pathname;
    
    if(pathname==='/'){
     /*response.end(fs.readFileSync(__dirname + _url));*/
      if(queryData.id===undefined){

        fs.readdir('./data', (err, filelist) => {
          console.log(filelist);
          var title ='Welcome';
          var descrition='Hello,Node.js';

          var list ='<ol>';
          var i=0;
          while(i<filelist.length){
            list=list+`<li><a href="/?id=${filelist[i]}">${filelist[i]}</a></li>`;
            i=i+1;
          }
          list=list+'</ol>';

          var template=`
            <!doctype html>
            <html>
            <head>
              <title>WEB1 - ${title}</title>
              <meta charset="utf-8">
            </head>
            <body>
              <h1><a href="/">WEB</a></h1>
              ${list}
              <h2>${title}</h2>
             <p>${descrition}</p>
            </body>
            </html>
            `;
            response.writeHead(200);
            response.end(template);
          });

      }else{
        fs.readdir('./data', (err, filelist) => {
          console.log(filelist);
          var descrition='Hello,Node.js';

          var list ='<ol>';
          var i=0;
          while(i<filelist.length){
            list=list+`<li><a href="/?id=${filelist[i]}">${filelist[i]}</a></li>`;
            i=i+1;
          }
          list=list+'</ol>';
          fs.readFile(`data/${queryData.id}`,'utf-8',function(err,descrition)){

            var title =queryData.id;
            var template=`
              <!doctype html>
              <html>
              <head>
                <title>WEB1 - ${title}</title>
                <meta charset="utf-8">
              </head>
              <body>
                <h1><a href="/">WEB</a></h1>
                ${list}
                <h2>${title}</h2>
               <p>${descrition}</p>
              </body>
              </html>
              `;
              response.writeHead(200);
              response.end(template);
            }
          });
      }

    }else{
      response.writeHead(404);
      response.end('not found');
    }



});
app.listen(3000);