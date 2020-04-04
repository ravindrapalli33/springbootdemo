/**
 * 
 */
package com.rav.springbootdemo.dto;

import java.io.Serializable;

import org.springframework.data.annotation.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class CountryInfoDto implements Serializable {

	@Transient
	private static final long serialVersionUID = 7654246068148889773L;

	@JsonProperty("_id")
	private Long id;

	@JsonProperty("iso2")
	private String iso2;

	@JsonProperty("iso3")
	private String iso3;

	@JsonProperty("lat")
	private Long latitude;

	@JsonProperty("long")
	private Long longitude;

	@JsonProperty("flag")
	private String flag;

}
