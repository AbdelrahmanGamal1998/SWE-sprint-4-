import java.io.IOException;

public class UndoDeletedProduct implements Command{
	private StoreOwner StoreOwner;

	public UndoDeletedProduct(StoreOwner storeOwner) {
		super();
		StoreOwner = storeOwner;
	}

	@Override
	public void execute() throws IOException {
		StoreOwner.addProduct(null, null, null, null);
		
	}
}