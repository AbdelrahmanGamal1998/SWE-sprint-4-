import java.io.IOException;

public class UndoEditedProductPrice implements Command {
	private StoreOwner StoreOwner;

	public UndoEditedProductPrice(StoreOwner storeOwner) {
		super();
		StoreOwner = storeOwner;
	}

	@Override
	public void execute() throws IOException {
		Products s=new Products();
		s.setName("coca");
		s.setPrice("ss");
		s.setBrand(null);
		s.setCategory(null); StoreOwner.undoEdit(s);
		
	}
}
