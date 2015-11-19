package com.skplanet.comet;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.continuation.Continuation;
import org.eclipse.jetty.continuation.ContinuationListener;
import org.eclipse.jetty.continuation.ContinuationSupport;

public class ContinuationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		String flag=(String)request.getAttribute("CONT_FLAG");
		if(flag==null) {
			Continuation continuation
			= ContinuationSupport.getContinuation(request);
			continuation.addContinuationListener(new MyListener());
			continuation.setTimeout(5000);
			continuation.suspend();
			request.setAttribute("CONT_FLAG", "RUNNING");
			// asynchronous call
			// continuation.resum() or continuation.complete()
		} else {
		}
		return;
	}
	
	public class MyListener implements ContinuationListener {

		@Override
		public void onComplete(Continuation arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void onTimeout(Continuation arg0) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
