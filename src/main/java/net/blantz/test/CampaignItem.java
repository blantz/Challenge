package net.blantz.test;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CampaignItem {
	@Id
	@GeneratedValue
	Long id;
	
	String name;

	public CampaignItem() {
		super();
	}

	public CampaignItem(String name) {
		super();
		this.name = name;
	}
	
	public CampaignItem(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
