<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">  
 <html>  
 <head>  
 <meta http-equiv="Content-type" content="text/html;charset=UTF-8"></meta>  
 
 
<script src="http://code.jquery.com/jquery-latest.js">
        </script>
  <script type="text/javascript">  
 //<![CDATA[  
 $(document).ready(function(){    
   var teste;  
   $.ajax({  
     data: "",  
     dataType: 'json',  
     url: './PessoaServlet',  
     type: 'POST',  
     success: function(data){  
          var corpo = "<div><h2>Lista de Pessoas</h2><ul>";  
          for (var i = 0, length = data.length; i < length; i++) {  
                     var pessoa = data[i];  
                     corpo += "<li>"+  
                                    "<span>Nome: "+pessoa.nome+"</span><span style='margin-left:10px;'>Idade: "+ pessoa.idade+"</span>"                           
                               "</li>";                                     
       }    
       corpo += "</ul></div>";  
       var divCorpo = document.getElementById("divCorpoHtml");  
       divCorpo.innerHTML=corpo;  
     },  
     error: function() {  
       alert("Ocorreu um erro na requisição ajax");  
     }  
   });  
 });  
 //]]>       
 </script>  
 </head>  
 <body style="padding: 10px;">       
      <div id="divCorpoHtml">       
      </div>  
 </body>  
 </html>  