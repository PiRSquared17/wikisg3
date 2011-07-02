package pos.domain;

public class CreditCard {

	private String holder;

	private String number;

	private int month;

	private int year;

	public String getHolder() {
		return this.holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public int getMonth() {
		return this.month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public int getYear() {
		return this.year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}
