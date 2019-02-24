var http = require('http');
var fs = require('fs');
var url=require('url');
var qs=require('querystring');

function templateHTML(title,list,body){//재사용할 수 있는
  return `<!doctype html>
            <html>
              <head>
                <title>WEB1 - ${title}</title>
                <meta charset="utf-8">
              </head>
              <body>
                <h1><a href="/">WEB</a></h1>
                ${list}
                <a href="/create">create</a>
              ${body}
              </body>
            </html>
            `;
}
function templateList(filelist){
   var list ='<ol>';
   var i=0;
    while(i<filelist.length){
      list=list+`<li><a href="/?id=${filelist[i]}">${filelist[i]}</a></li>`;
      i=i+1;
    }
          list=list+'</ol>';
  return list;
}

var app = http.createServer(function(request,response){//요청, 응답
  var _url = request.url;/*/?id=HTML*/
  var queryData=url.parse(_url,true).query;
  var pathname=url.parse(_url, true).pathname;
  if(pathname==='/'){
    /*response.end(fs.readFileSync(__dirname + _url));*/
    if(queryData.id===undefined){
      fs.readdir('./data', (err, filelist) => {
        var title ='Welcome';
        var descrition='Hello,Node.js';
        var list= templateList(filelist);
        var template=templateHTML(title,list, `<h2>${title}</h2><p>${descrition}</p>`);
        response.writeHead(200);
        response.end(template);
      });
    }else{
      fs.readdir('./data', (err, filelist) => {
        var descrition='Hello,Node.js';
        var list= templateList(filelist);
        fs.readFile(`data/${queryData.id}`,'utf-8',function(err,descrition){
          var title =queryData.id;
          var template=templateHTML(title,list,`<h2>${title}</h2><p>${descrition}</p>`);
          response.writeHead(200);
          response.end(template);
        });
      });
    }
  }else if(pathname==='/create'){
      fs.readdir('./data', (err, filelist) => {
      var title ='WEB - create';
      var list= templateList(filelist);
      var template=templateHTML(title,list, `
        <form action="http://localhost:3000/create_process" method="post">
          <p><input type="text" name="title" placeholder="title"></p>
          <p>
            <textarea name="description" placeholder="description"></textarea>
          </p>
          <p>
            <input type="submit">
          </p>
        </form>`);
      response.writeHead(200);
      response.end(template);
    });
  }else if(pathname==='/create_process'){
    var body='';
    request.on('data',function(data){//서버쪽에서 수신할 때 마다 콜백함수를 실행
      body=body+data;
      console.log(data);
    });
    request.on('end',function(){
      var post=qs.parse(body);//객체화
      var title=post.title;
      var description=post.description;
      fs.writeFile(`data/${title}`,description,'utf8',function(err){
        response.writeHead(302,{Location:`/?id=${title}`});//리다이렉션
        //response.writeHead(200);//성공
        response.end('success');
      });
    });
  }else{
    response.writeHead(404);
    response.end('not found');
  }
});
app.listen(3000); 
