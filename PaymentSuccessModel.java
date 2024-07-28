
public class PaymentSuccessModel {
	private String bankHost;
	private String totalPrice;
	private String transactionId;
	
	public void setBankHost(String host) {
		this.bankHost = host;
	}
	public void setTotalPrice(String total) {
		this.totalPrice = total;
	}
	public void settransactionId(String id) {
		this.transactionId = id;
	}
	
	
	public String getBankHost() {
		return bankHost;
	}
	public String setTotalPrice() {
		return totalPrice;
	}
	public String setTransactionId() {
		return transactionId;
	}
}
