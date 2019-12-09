package controller;

import java.io.IOException;
import java.lang.reflect.Method;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
/**
 * Servlet implementation class BaseServlet
 */
public class BaseServlet extends HttpServlet {

 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.setContentType("text/html;charset=utf-8");
        String action = request.getParameter("action");
        if(action == null || action.isEmpty()){
            throw new RuntimeException("û�д��ݷ�������,�����������õķ���");
        }
         
        Method method = null;
         
        try {
            method = getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException("û���ҵ�����õķ�����" + action + "������÷����Ƿ����!");
        }
         
        try {
            method.invoke(this, request, response);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            throw new RuntimeException(action + "�÷��������쳣!");
        }
    }
}