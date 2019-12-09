package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.Conversion;
import dao.EquipmentDao;
import dao.MemberDao;
import model.Equipment;
import model.Member;

@WebServlet("/Member")
public class MemberServlet extends BaseServlet{
	
	private MemberDao memberDao = new MemberDao();
	
    protected void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
			request.setAttribute("memberList", memberDao.getList());
	   
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	request.getRequestDispatcher("/member.jsp").forward(request, response);
    }
    
    protected void delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String id = request.getParameter("id");
        
        MemberDao memberDao = new MemberDao();
        try {
        	memberDao.delete(Integer.parseInt(id));
			 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    protected void add(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Member member = new Member();
        Conversion.convert(member, request);
        MemberDao memberDao = new MemberDao();
        try {
        	memberDao.add(member);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    protected void update(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    	Member member = new Member();
        Conversion.convert(member, request);
        MemberDao memberDao = new MemberDao();
        try {
        	memberDao.update(member);
        	
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	this.show(request, response);
    }
    
    protected void addedit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id = request.getParameter("id");
        String type = request.getParameter("type");
        MemberDao memberDao = new MemberDao();
        if(type.equals("edit")) {
        	request.setAttribute("action", "Member?action=update");       	
        	request.setAttribute("heading", "회원 정보 수정");
        	request.setAttribute("btname", "수정");
        	try {
        		Member member=memberDao.get(Integer.parseInt(id));
        		request.setAttribute("member", member);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }else {
        	request.setAttribute("action", "Member?action=add");
        	
        	request.setAttribute("heading", "회원 추가");
            request.setAttribute("btname", "추가");
        }
        request.getRequestDispatcher("/addEditMember.jsp").forward(request, response);
    	
    }

}