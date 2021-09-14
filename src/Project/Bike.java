package Project;

public class Bike {
	
	private String id;
	private String name;
	private boolean needsRepair;
	private final long expireTime;

	public long getExpireTime() {
		return expireTime;
	}

	public Bike(String id, String name, long expireTime) {
		this.id = id;
		this.name = name;
		this.needsRepair = false;
		BikeStore.addBikeToList(this);
		this.expireTime = expireTime;
	}

	public boolean isNeedsRepair() {
		return needsRepair;
	}

	public void setNeedsRepair(boolean needsRepair) {
		this.needsRepair = needsRepair;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bike other = (Bike) obj;
		if (id == null) {
			return other.id == null;
		} else return id.equals(other.id);
	}
	
	@Override
	public String toString() {
		return "Bike[id=" + id + "]";
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
