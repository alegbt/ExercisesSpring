package co.develhope.interceptorsmiddleware2.interceptors;


import co.develhope.interceptorsmiddleware2.entities.Month;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Component
public class MonthInterceptor implements HandlerInterceptor {

   static List<Month> months = new ArrayList<>(Arrays.asList(
            new Month(1, "gennaio", "january", "januar"),
            new Month(2, "febbraio", "february", "februar"),
            new Month(3, "marzo", "march", "marsch"),
            new Month(4, "aprile", "april", "april"),
            new Month(5, "maggio", "may", "dürfen"),
            new Month(6, "giugno", "june", "juni")
    ));


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception{
        String myMonthNumber = request.getHeader("monthNumber");
        if(myMonthNumber == null || myMonthNumber == ""){
             response.setStatus(400);
             return false;
        }else {
            Integer monthNumber = Integer.parseInt(myMonthNumber);
            Optional<Month> month = months.stream().filter(singleMonth -> {
                return singleMonth.getMonthNumber() == monthNumber;
            }).findFirst();

            if (month.isPresent()) {
                request.setAttribute("month", month.get());
            } else {
                request.setAttribute("month", new Month("nope", "nope", "nope"));
            }
            response.setStatus(200);
            return true;

        }

    }




}
