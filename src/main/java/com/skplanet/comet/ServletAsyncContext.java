package com.skplanet.comet;

import java.io.IOException;

import javax.servlet.AsyncContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ServletAsyncContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        final AsyncContext asyncContext = req.startAsync(req, res);
        asyncContext.getResponse().getWriter().println("Start");
        asyncContext.start(new StockPriceRunner(asyncContext));
    }

    private class StockPriceRunner implements Runnable {
        AsyncContext asyncContext;
        
        public StockPriceRunner(AsyncContext asyncContext) {
            this.asyncContext = asyncContext;
        }

        @Override
        public void run() {
            String ticker = "GOOG";
            Double price = 100.0;
            
            try {
                asyncContext.getResponse().getWriter().printf("ticker: %s, price: %.2f", ticker, price);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                asyncContext.complete();
            }
        }
    }
}
