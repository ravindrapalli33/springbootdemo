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
public class NovelCovidAllDetailsDto implements Serializable {

	@Transient
	private static final long serialVersionUID = -5992224100582954220L;

	@JsonProperty("cases")
	private Long cases;

	@JsonProperty("deaths")
	private Long deaths;

	@JsonProperty("recovered")
	private Long recovered;

	@JsonProperty("updated")
	private Long updated;

	@JsonProperty("active")
	private Long active;

	@JsonProperty("affectedCountries")
	private Long affectedCountries;

}
