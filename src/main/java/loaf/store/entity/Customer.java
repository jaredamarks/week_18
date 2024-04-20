package loaf.store.entity;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;
	private Long storeId;
	private String customerInfo;
	
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "customer_item", 
	joinColumns = @JoinColumn(name = "customer_id"), 
	inverseJoinColumns = @JoinColumn(name = "item_id"))
	private Set<Item> items = new HashSet<>();
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "loaf_store_id")
	private LoafStore loafStore;
}
