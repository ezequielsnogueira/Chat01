package controlPessoa; 
import java.io.IOException;  
 import java.io.PrintWriter;  
 import java.util.ArrayList;  
 import java.util.List;  
 import javax.servlet.ServletException;  
 import javax.servlet.http.HttpServlet;  
 import javax.servlet.http.HttpServletRequest;  
 import javax.servlet.http.HttpServletResponse;  
 import org.json.JSONArray;  
 import org.json.JSONException;  
 import org.json.JSONObject;  
 import modelPessoa.Pessoa;  
 public class PessoaServ extends HttpServlet {       
           private static final long serialVersionUID = 1L;  
           @Override  
           protected void doGet(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {  
                recuperarPessoas(request, response);  
           }  
           @Override  
           protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {  
                recuperarPessoas(request, response);  
           }  
           private void recuperarPessoas(final HttpServletRequest request, final HttpServletResponse response) throws IOException {  
                try {  
                     request.setCharacterEncoding("UTF-8");  
            response.setCharacterEncoding("UTF-8");  
            response.setContentType("application/json");   
            PrintWriter out = response.getWriter();   
                     List<Pessoa> procedimentos = getPessoas();  
                     JSONArray jsonArray = new JSONArray();  
                     for (Pessoa obj : procedimentos) {  
                          JSONObject jsonObject = new JSONObject();  
                          jsonObject.put("nome", obj.getNome());  
                          jsonObject.put("idade", obj.getIdade());  
                          jsonArray.put(jsonObject);  
                     }  
                     out.print(jsonArray);  
                } catch (JSONException e) {  
                     e.printStackTrace();  
                }  
           }  
           private List<Pessoa> getPessoas() {  
                List<Pessoa> pessoas = new ArrayList<Pessoa>();  
                Pessoa pessoaUm = new Pessoa();  
                pessoaUm.setNome("Gustavo Lopes de Oliveira");  
                pessoaUm.setIdade(25);  
                Pessoa pessoaDois = new Pessoa();  
                pessoaDois.setNome("Ralph Miranda");  
                pessoaDois.setIdade(28);  
                pessoas.add(pessoaUm);  
                pessoas.add(pessoaDois);  
                return pessoas;  
           }  
      }