package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import object.Character;

/**
 * Servlet implementation class Kadai21
 */
@WebServlet("/Kadai21")
public class Kadai21 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Kadai21() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//doGet(request, response);
		Character[] ch = new Character[100];
		for(int i = 0; ch.length > i; i++) {
			ch[i] = new Character();
		}
		String name =request.getParameter("name");
		int hp =Integer.parseInt(request.getParameter("hp"));
		int mp =Integer.parseInt(request.getParameter("mp"));
		ch[0].setName(ch,"minato",0);
		ch[1].setName(ch,"asaka",1);
		ch[0].setNo(ch,1,0);
		ch[0].setHp(ch,10,0);
		ch[0].setMp(ch,8,0);
		ch[1].setNo(ch,2,1);
		ch[1].setHp(ch,5,1);
		ch[1].setMp(ch,15,1);
		if(name != null || hp != 0 || mp != 0) {
			for(int i = 0; ch.length > i ; i++) {
				if(ch[0].getName(ch, i) == null) {
					ch[0].setNo(ch, i+1, i);
					ch[0].setName(ch, name, i);
					ch[0].setHp(ch, hp, i);
					ch[0].setMp(ch, mp, i);
					break;
				}
			}
		}
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<head>");
		out.println("<meta charset=\"UTF-8\">");
		out.println("<title>宿題2</title>");
		out.println("</head>");
		out.println("<body>");
		out.println("<table border=\"1\" style=\"width:400\">");
		out.println("<table align=\"right\">");
		out.println("<tr bgcolor=\"blue\">");
		//新規登録ボタンでページ移動
		out.println("<th><a href=kadai2.jsp class=btn>新規登録</th>");
		out.println("</tr>");
		out.println("</table>");
		out.println("<b>一覧</b>");
		out.println("<table border=\\\"1\\\" style=\\\"width:400\\\">");
		out.println("<tr bgcolor=\"blue\">");
		out.println("<th>No</th><th>名前</th><th>HP</th><th>MP</th>");
		out.println("</tr>");
		
		//登録されている内容をNo1から表示
		for(int i = 0; ch[0].getName(ch,i) != null; i++) {
			System.out.println(i);
			out.println("<tr>");
			out.println("<th>" + ch[0].getNo(ch,i) + "</th><th>" + ch[0].getName(ch,i) + "</th><th>"
					+ ch[0].getHp(ch, i) + "</th><th>" + ch[0].getMp(ch,i) + "</th>");
			out.println("</tr>");
		}
		out.println("</table>");
		out.println("</body>");
		out.println("</html>");
		out.println("");
	}

}
