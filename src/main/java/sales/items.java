package sales;

import java.util.List;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.bson.codecs.pojo.annotations.BsonProperty;

public class items {

	@BsonProperty(value = "name")
	private String name;
	@BsonProperty(value = "tags")
	private List<String> tagsList;
	/*@BsonIgnore*/
	@BsonIgnore
	private Double price;
	@BsonProperty(value = "quantity")
	private Integer quantity;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<String> getTagsList() {
		return tagsList;
	}
	public void setTagsList(List<String> tagsList) {
		this.tagsList = tagsList;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
}
