package common.dto;

import lombok.Data;

@Data
public class Location {
	private int locationId;
	private String streetAddress;
	private String postalCode;
	private String city;
	private String stateProvince;
	private String countryId;
}
