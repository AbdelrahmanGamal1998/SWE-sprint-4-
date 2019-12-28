import java.io.IOException;

public class UndoEditedProductPrice implements Command {
	private Edit Undo;

	public UndoEditedProductPrice(Edit undo) {
		super();
		Undo = undo;
	}

	@Override
	public void execute() throws IOException {
		Products s=new Products();
		s.setName("coca");
		s.setPrice("ss");
		s.setBrand(null);
		s.setCategory(null); Undo.undoEdit(s);
		
	}
}
