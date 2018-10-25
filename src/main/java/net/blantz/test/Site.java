package net.blantz.test;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Site {
	@Id
	@GeneratedValue
	Long id;

	Long siteItemID;
	@ElementCollection
	Collection<Long> campaignItemIds;
	
	
	public Site() {
		super();
	}

	public Site(Long siteItemID, Collection<Long> campaignItemIds) {
		super();
		this.siteItemID = siteItemID;
		this.campaignItemIds = campaignItemIds;
	}

	public Site(Long id, Long siteItemID, Collection<Long> campaignItemIds) {
		super();
		this.id = id;
		this.siteItemID = siteItemID;
		this.campaignItemIds = campaignItemIds;
	}


	public Long getSiteItemID() {
		return siteItemID;
	}


	public void setSiteItemID(Long siteItemID) {
		this.siteItemID = siteItemID;
	}


	public Collection<Long> getCampaignItemIds() {
		return campaignItemIds;
	}


	public void setCampaignItemIds(Collection<Long> campaignItemIds) {
		this.campaignItemIds = campaignItemIds;
	}
	
	
}
