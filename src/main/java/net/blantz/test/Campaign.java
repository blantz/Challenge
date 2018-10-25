package net.blantz.test;

import java.util.Collection;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Campaign {
	
	@Id
	@GeneratedValue
	Long id;

	Long campaignItemId;
	@ElementCollection
	Collection<Long> siteItemIds;
	
	public Campaign() {
		super();
	}

	public Campaign(Long campaignItemId, Collection<Long> siteItemIds) {
		super();
		this.campaignItemId = campaignItemId;
		this.siteItemIds = siteItemIds;
	}

	public Campaign(Long id, Long campaignItemId, Collection<Long> siteItemIds) {
		super();
		this.id = id;
		this.campaignItemId = campaignItemId;
		this.siteItemIds = siteItemIds;
	}

	public Long getCampaignItemId() {
		return campaignItemId;
	}

	public void setCampaignItemId(Long campaignItemId) {
		this.campaignItemId = campaignItemId;
	}

	public Collection<Long> getSiteItemIds() {
		return siteItemIds;
	}

	public void setSiteItemIds(Collection<Long> siteItemIds) {
		this.siteItemIds = siteItemIds;
	}
	
	
}
