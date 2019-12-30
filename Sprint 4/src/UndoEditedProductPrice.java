import java.io.IOException;

public class UndoEditedProductPrice implements Command {
	private StoreOwner_Edit Undo;

	public UndoEditedProductPrice(StoreOwner_Edit undo) {
		super();
		Undo = undo;
	}

	@Override
	public void execute() throws IOException {
		/*Products product=new Products();
		product.setName("coca");
		product.setPrice("ss");
		product.setBrand(null);
		product.setCategory(null); */Undo.undoEdit();
		
	}
}
