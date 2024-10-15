package Product;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import space.jdbc.memo.JdbcMemoDao;
import space.jdbc.memo.Memo;
import space.jdbc.memo.MemoDao;

//@WebServlet({"/input", "/save",})
@WebServlet("/Product/*")
public class ProductServlet extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		process(req, resp);
	}

	private void process(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//http://localhost:8080/app01/memo/list
		String uri = req.getRequestURI();
		
		int lastIndex = uri.lastIndexOf("/");
		String action = uri.substring(lastIndex + 1);
//		System.out.println(action);
		
		if(action.equals("input")) {
			//페이지 보여주는 코드
			RequestDispatcher rd = req.getRequestDispatcher("/index.html");
			rd.forward(req, resp);
			
			
		}else if(action.equals("save")) {
			//memo 저장 코드
			Product product = new Product();
			ProductDao pdao = new JdbcProductDao();
			
			product.setId(1);
			product.setName("가나다라");
			product.setPrice("10000");
			product.setContent("안녕하세요");
			
			pdao.insert(product);
			
		}else if(action.equals("list")) {
			//dao 리스트 가져오기
			//request 속성으로 가져오기
			ProductDao pdao = new JdbcProductDao();
			
			List<Product> products = pdao.findAll();
			req.setAttribute("products", products);
			
		}else if(action.equals("delete")) {
			ProductDao pdao = new JdbcProductDao();
			
			pdao.deleteById(1);
			
		}else if(action.equals("detail")) {
			Product product = new Product();
			ProductDao pdao = new JdbcProductDao();
			
			List<Product> products = pdao.findAll();
			req.setAttribute("products", products);
		}else if(action.equals("findbyid")) {
			Product product = new Product();
			ProductDao pdao = new JdbcProductDao();
			
			Product product1 = pdao.findById(1);
			req.setAttribute("product", product1);
		}
		
		String dispatcherUrl = null;
		
		if(action.equals("input")) {
			dispatcherUrl = "/index.html";
			
		}else if(action.equals("save")) {
			dispatcherUrl = "/save.html";
		}else if(action.equals("list")) {
			dispatcherUrl = "/list.jsp";
		}else if(action.equals("detail")) {
			dispatcherUrl = "/detail.jsp";
		}else if(action.equals("delete")) {
			dispatcherUrl = "/delete.html";
		}else if(action.equals("findbyid")) {
			dispatcherUrl = "/findbyid.jsp";
		}
		RequestDispatcher rd = req.getRequestDispatcher(dispatcherUrl);
		rd.forward(req, resp);
		
	}
	
}
