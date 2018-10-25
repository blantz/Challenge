package net.blantz.test;

import java.util.Optional;

import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/site")
public class SiteController {
	@Autowired
	SiteRepository repo;
	
	/**
	 * Find Site by id
	 * @param id the id of the desired Site
	 * @return returns Site requested, or null if not found
	 */
	@GetMapping(value = "/findById/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
	public Site getSiteById(@PathVariable("id") Long id) {
		Site retval = null;
		Optional<Site> result =  repo.findById(id);
		if (result.isPresent())
		{
			retval = result.get();
		}
		return retval;
	}

	/**
	 * Add a new Site
	 * 
	 * If the id field has any value, it is set to null.
	 * 
	 * This method is not to be used to update an existing Site (one that already has an id assigned)
	 * 
	 * @param Site the new Site to add.
	 * @return the id of the newly created Site
	 */
	@PostMapping (value = "/add", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public Long addNewSite(@NotNull @RequestBody Site site) {
		site.id = null;
		repo.save(site);
		return site.id;
	}
	
	/**
	 * Update an existing Site
	 * 
	 * @param Site the Site to update
	 */
	@PutMapping (value = "/update", consumes = {MediaType.APPLICATION_JSON_VALUE})
	public void updateExistingSite(@NotNull @RequestBody Site site) {
		repo.save(site);
	}
	
	/**
	 * Delete an existing Site by id
	 * 
	 * @param id the id of the Site to delete
	 */
	@DeleteMapping (value = "/delete/{id}")
	public void deleteExistingSiteById (@PathVariable("id") Long id) {
		repo.deleteById(id);
	}
}
