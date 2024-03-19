package sales;

import java.util.Date;
import java.util.List;

import org.bson.codecs.pojo.annotations.BsonProperty;
import org.bson.types.ObjectId;


public class sales {
	
	private ObjectId id;
	@BsonProperty(value = "saleDate")
	private Date saleDate;
	@BsonProperty(value = "items")
	private List<items> itemsList;
	@BsonProperty(value = "storeLocation")
	private String storeLocation;
	@BsonProperty(value = "customer")
	private customer customer;
	@BsonProperty(value = "couponUsed")
	private Boolean couponUsed;
	@BsonProperty(value = "purchaseMethod")
	private String purchaseMethod;
	public ObjectId getId() {
		return id;
	}
	public void setId(ObjectId id) {
		this.id = id;
	}
	public Date getSaleDate() {
		return saleDate;
	}
	public void setSaleDate(Date saleDate) {
		this.saleDate = saleDate;
	}
	public List<items> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<items> itemsList) {
		this.itemsList = itemsList;
	}
	public String getStoreLocation() {
		return storeLocation;
	}
	public void setStoreLocation(String storeLocation) {
		this.storeLocation = storeLocation;
	}
	public customer getCustomer() {
		return customer;
	}
	public void setCustomer(customer customer) {
		this.customer = customer;
	}
	public Boolean getCouponUsed() {
		return couponUsed;
	}
	public void setCouponUsed(Boolean couponUsed) {
		this.couponUsed = couponUsed;
	}
	public String getPurchaseMethod() {
		return purchaseMethod;
	}
	public void setPurchaseMethod(String purchaseMethod) {
		this.purchaseMethod = purchaseMethod;
	}
	
	
	

}
