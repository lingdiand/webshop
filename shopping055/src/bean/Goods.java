package bean;

public class Goods {
	private String name;
	private int price;
	private String text;
	private String photo;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int i) {
		this.id = i;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

}
