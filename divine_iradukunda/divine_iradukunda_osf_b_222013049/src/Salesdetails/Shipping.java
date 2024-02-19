package Salesdetails;

public class Shipping {
private int shipping_id;
private String command_id;
private String shipping_address;
private String shipping_status;
private String shipping_date;


public Shipping(int shipping_id, String command_id, String shipping_address, String shipping_status,
		String shippind_date) {
	super();
	this.shipping_id = shipping_id;
	this.command_id = command_id;
	this.shipping_address = shipping_address;
	this.shipping_status = shipping_status;
	this.shipping_date = shipping_date;
}


public int getShipping_id() {
	return shipping_id;
}


public void setShipping_id(int shipping_id) {
	this.shipping_id = shipping_id;
}


public String getCommand_id() {
	return command_id;
}


public void setCommand_id(String command_id) {
	this.command_id = command_id;
}


public String getShipping_address() {
	return shipping_address;
}


public void setShipping_address(String shipping_address) {
	this.shipping_address = shipping_address;
}


public String getShipping_status() {
	return shipping_status;
}


public void setShipping_status(String shipping_status) {
	this.shipping_status = shipping_status;
}


public String getShipping_date() {
	return shipping_date;
}


public void setShipping_date(String shipping_date) {
	this.shipping_date = shipping_date;
}

}
