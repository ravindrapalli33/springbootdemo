/**
 * 
 */
package com.rav.springbootdemo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 * @author ravin_58p52h3
 *
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode	
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = Include.NON_NULL)
public class CountryDto implements Serializable {

	@Transient
	private static final long serialVersionUID = 6518113369542156554L;

	@JsonProperty("country")
	private String country;

	@JsonProperty("countryInfo")
	private CountryInfoDto countryInfo;

	@JsonProperty("cases")
	private Long cases;

	@JsonProperty("todayCases")
	private Long todayCases;

	@JsonProperty("deaths")
	private Long deaths;

	@JsonProperty("todayDeaths")
	private Long todayDeaths;

	@JsonProperty("recovered")
	private Long recovered;

	@JsonProperty("active")
	private Long active;

	@JsonProperty("critical")
	private Long critical;

	@JsonProperty("casesPerOneMillion")
	private Long casesPerOneMillion;

	@JsonProperty("deathsPerOneMillion")
	private Long deathsPerOneMillion;

	@JsonProperty("updated")
	private Long updated;

}
