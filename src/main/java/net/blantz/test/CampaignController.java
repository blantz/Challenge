package net.blantz.test;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequestMapping("/campaign")
public class CampaignController {
	
	@Autowired
	CampaignRepository repo;
	
	/**
	 * Find Campaign by id
	 * @param id the id of the desired campaign
	 * @return returns campaign requested, or null if not found
	 */
	@GetMapping(value = "/findById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Campaign getCampaignById(@PathVariable("id") Long id) {
		Campaign retval = null;
		Optional<Campaign> result =  repo.findById(id);
		if (result.isPresent())
		{
			retval = result.get();
		}
		return retval;
	}

	/**
	 * Add a new Campaign
	 * 
	 * If the id field has any value, it is set to null.
	 * 
	 * This method is not to be used to update an existing campaign (one that already has an id assigned)
	 * 
	 * @param campaign the new campaign to add.
	 * @return the id of the newly created campaign
	 */
	@PostMapping (value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Long addNewCampaign(@NotNull @RequestBody Campaign campaign) {
		campaign.id = null;
		repo.save(campaign);
		return campaign.id;
	}
	
	/**
	 * Update an existing Campaign
	 * 
	 * @param campaign the campaign to update
	 */
	@PutMapping (value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void updateExistingCampaign(@NotNull @RequestBody Campaign campaign) {
		repo.save(campaign);
	}
	
	/**
	 * Delete an existing Campaign by id
	 * 
	 * @param id the id of the campaign to delete
	 */
	@DeleteMapping (value = "/delete/{id}")
	public void deleteExistingCampaignById (@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
