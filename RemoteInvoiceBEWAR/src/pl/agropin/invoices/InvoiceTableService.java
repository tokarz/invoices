package pl.agropin.invoices;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class InvoiceTableService {
    private String message = new String("Hello, ");
	
	public void Hello() {
    }

    @WebMethod
    public String sayHello(String name) {
        return message + name + ".";
    }
}
