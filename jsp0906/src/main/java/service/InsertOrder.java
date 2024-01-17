package service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.OrderDao;
import dto.Order1;

public class InsertOrder implements CommandProcess {

    @Override
    public String requestPro(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("insertOrder start....");

        // 실제로 입력받은 값을 등록하는 작업
        request.setCharacterEncoding("utf-8");

        try {
           
        	String order_date = request.getParameter("order_date");
        	int custcode = Integer.parseInt(request.getParameter("custom"));
            int sabun = Integer.parseInt(request.getParameter("sawon"));
            String order_desc = request.getParameter("order_desc");
            String order_state = request.getParameter("order_state");

            System.out.println("order1");
            
            Order1 order = new Order1();
            order.setOrder_date(order_date);
            order.setCustcode(custcode);
            order.setOrder_desc(order_desc);
            order.setSabun(sabun);
            order.setOrder_state(order_state);

            System.out.println("order insert");
            OrderDao od = OrderDao.getinstance();
            int result = od.insert(order);

            // 결과 값을 request에 설정
            request.setAttribute("result", result);
            request.setAttribute("order_date", order.getOrder_date());
            request.setAttribute("custcode", order.getCustcode());
            request.setAttribute("order_desc", order.getOrder_desc());
            request.setAttribute("sabun", order.getSabun());
            request.setAttribute("order_state", order.getOrder_state());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // 결과 페이지로 이동
        return "insertOrder.jsp";
    }

}