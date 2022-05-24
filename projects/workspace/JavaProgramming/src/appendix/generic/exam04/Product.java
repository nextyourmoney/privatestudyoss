package appendix.generic.exam04;

public class Product<K, M> {

	

		private K kind;
		private M model;
		
		public K getKind() {return this.kind;}
		public M getModel() {return this.model;}
		public void setKind(K kind) {this.kind = kind;}
		public void setModel(M model) {this.model = model;}

		@Override
		public boolean equals(Object obj) {
			if(obj instanceof Product) {
				Product p = (Product) obj;
				if(kind.equals(p.kind) && model.equals(p.model));
			}
		
		
	}

}
