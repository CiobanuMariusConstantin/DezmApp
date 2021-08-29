package dezmembrari.audi;

public class AddPart {
		
		String partName;
		
		int OEMcode;
		
		int price;
		
		String origin;
		
		String condition;
		
		public  void partName() {
		
		}
		
		public int OEMcodee() {
			return OEMcode;
			
		}
		
		public AddPart (String partName, int OEMcode, int price, String origin, String condition) {
			this.partName = partName;
			this.OEMcode = OEMcode;
			this.price = price;
			this.origin = origin;
			this.condition = condition;
		}

		
		public String getPartName() {
			return partName;
		}

		
		public void setPartName(String partName) {
			this.partName = partName;
		}

		
		public int getOEMcode() {
			return OEMcode;
		}

		
		public void setOEMcode(int oEMcode) {
			OEMcode = oEMcode;
		}

		public int getPrice() {
			return price;
		}

		
		public void setPrice(int price) {
			this.price = price;
		}

		
		public String getOrigin() {
			return origin;
		}

		
		public void setOrigin(String origin) {
			this.origin = origin;
		}

		
		public String getCondition() {
			return condition;
		}

		
		public void setCondition(String condition) {
			this.condition = condition;
		}
		
		
	}
