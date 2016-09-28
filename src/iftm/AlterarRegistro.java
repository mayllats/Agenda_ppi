package iftm;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class AlterarRegistro
 */
@WebServlet("/alterar")
public class AlterarRegistro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AlterarRegistro() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int chave = Integer.parseInt(request.getParameter("id"));
		Dados contato = Banco.carregaRegistro(chave);
		PrintWriter saida = response.getWriter();
		response.setContentType("text/html");
		saida.println("<form action=alterar method=post>");
		saida.println("Nome: <input name=nome value="+ contato.getNome() + ">"); saida.println("Telefone: <input name=telefone value=" + contato.getTelefone() + ">");
		saida.println("<input type=hidden name=chave value=" + chave + ">");
		saida.print("<input type=submit></form>");
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
	throws ServletException, IOException {
	String nome = req.getParameter("nome");
	String telefone = req.getParameter("telefone");
	int chave = Integer.parseInt(req.getParameter("chave"));
	Dados novo = new Dados(chave, nome, telefone);
	Banco.alteraDados(novo);
	resp.sendRedirect("ListarTodos");
	}
	}

	
	