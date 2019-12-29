import java.io.IOException;

public class UndoEditedProductPrice implements Command {
	private Edit Undo;

	public UndoEditedProductPrice(Edit undo) {
		super();
		Undo = undo;
	}

	@Override
	public void execute() throws IOException {
		Products product=new Products();
		product.setName("coca");
		product.setPrice("ss");
		product.setBrand(null);
		product.setCategory(null); Undo.undoEdit(product);
		
	}
}
