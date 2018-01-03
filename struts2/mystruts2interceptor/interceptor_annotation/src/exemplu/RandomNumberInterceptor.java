package actions;

import java.util.Map;
import java.util.Random;

import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class RandomNumberInterceptor implements Interceptor {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
	}

	@Override
	public String intercept(ActionInvocation actionInvocation) throws Exception {
		
		//ia sesiunea
		Map session=actionInvocation.getInvocationContext().getSession();
		
		//daca nu este setat numarul in sesiune, seteaza-l
		if (!session.containsKey("guess") || !(session.get("guess") != null)) {
			Random random = new Random();
			int deGhicit = random.nextInt(10)+1;
			session.put("guess",deGhicit);
		}
		
		//invoca celelalte actiuni
		return actionInvocation.invoke();
	}

}
