package HibernateProj.RestaurantMgt;

import org.hibernate.annotations.DynamicUpdate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
@DynamicUpdate
public class RestaurantsMgt {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
//	@Column
//	private int Id;
//	
	@Column
	private int restaurantId;

	
	@Column(length=50)
	private String restaurantName;
	
	@Column
	private int avgCost;
	
	@Column(length=5)
	private int rating;
	
	@Column(length=50)
	private String ownerName;
	
	
	@Override
	public String toString() {
		return "RestaurantsMgt [restaurantId=" + restaurantId + ", restaurantName=" + restaurantName + ", avgCost="
				+ avgCost + ", rating=" + rating + ", ownerName=" + ownerName + "]";
	}
	
	
	
//	public int getId() {
//		return Id;
//	}
//
//	public void setId(int id) {
//		Id = id;
//	}

	public int getRestaurantId() {
		return restaurantId;
	}
	
	public void setRestaurantId(int restaurantId) {
		this.restaurantId = restaurantId;
	}
	
	public String getRestaurantName() {
		return restaurantName;
	}
	
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	
	public int getAvgCost() {
		return avgCost;
	}
	
	public void setAvgCost(int avgCost) {
		this.avgCost = avgCost;
	}
	
	public int getRating() {
		return rating;
	}
	
	public void setRating(int rating) {
		this.rating = rating;
	}
	
	public String getOwnerName() {
		return ownerName;
	}
	
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

}
