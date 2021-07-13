package weddinghall.model;

public class Halls {
	public int id;
	public String roomtype;

	public String facilities;
	public int cost;
	public String filename;
	public String path;

	public Halls(int id, String roomtype, String facilities, int cost, String filename, String path) {
		super();
		this.id = id;
		this.roomtype = roomtype;

		this.facilities = facilities;
		this.cost = cost;
		this.filename = filename;
		this.path = path;
	}

	public Halls(String roomtype, String facilities, int cost, String filename, String path) {
		super();
		this.roomtype = roomtype;

		this.facilities = facilities;
		this.cost = cost;
		this.filename = filename;
		this.path = path;
	}

	public Halls(int id, String roomtype, String facilities, int cost) {
		super();
		this.id = id;
		this.roomtype = roomtype;

		this.facilities = facilities;
		this.cost = cost;
	}

	public Halls(int id, String roomtype, String facilities, int cost, String filename) {
		super();
		this.id = id;
		this.roomtype = roomtype;

		this.facilities = facilities;
		this.cost = cost;
		this.filename = filename;
	}

	public Halls(String roomtype, String facilities, int cost, String filename) {
		super();
		this.roomtype = roomtype;

		this.facilities = facilities;
		this.cost = cost;
		this.filename = filename;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRoomtype() {
		return roomtype;
	}

	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}


	public String getFacilities() {
		return facilities;
	}

	public void setFacilities(String facilities) {
		this.facilities = facilities;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
