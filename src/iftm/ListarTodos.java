package iftm;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ListarTodos
 */
@WebServlet("/ListarTodos")
public class ListarTodos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListarTodos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter saida = response.getWriter();
		response.setContentType("text/html");
		saida.print("<a href=index.html>Inicio</a><hr>");
		List<Dados> lista = Banco.listaTodos();
		saida.print("<table border=1><tr><th>Nome</th> <th>Telefone</th> <th>Ações</th> </tr>");
		for (Dados dados : lista) {
			saida.print("<tr><td>" + dados.getNome() + "</td><td>" + dados.getTelefone() + "</td>"
					+ "<td><a href=alterar?id=" + dados.getChavePrimaria() + ">Alterar</a> " + "<a href=excluir?id="
					+ dados.getChavePrimaria() + ">Excluir</a></td></tr>");
		}
		saida.print("</table>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
