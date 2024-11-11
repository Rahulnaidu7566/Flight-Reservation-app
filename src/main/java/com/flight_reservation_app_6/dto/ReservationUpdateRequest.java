package com.flight_reservation_app_6.dto;

public class ReservationUpdateRequest {

	private long id;
	private boolean CheckedIn;
	private int NumberOfBags;
	public long getId() {
		return id;
	}
	public boolean isCheckedIn() {
		return CheckedIn;
	}
	public void setCheckedIn(boolean checkedIn) {
		CheckedIn = checkedIn;
	}
	public int getNumberOfBags() {
		return NumberOfBags;
	}
	public void setNumberOfBags(int numberOfBags) {
		NumberOfBags = numberOfBags;
	}
	public void setId(long id) {
		this.id = id;
	}
	
}
