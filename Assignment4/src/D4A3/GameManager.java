package D4A3;

public class GameManager implements GameService {

	@Override
	public void addGame(Game game) {
		// TODO Auto-generated method stub
		System.out.println(game.getName()+" Adlı oyun "+game.getPrice()+"Tl'den satışa sunuldu. İndirim oranı satışda eklenecektir.");
		
	}

	@Override
	public void update(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Game game) {
		// TODO Auto-generated method stub
		System.out.println("Oyun silindi. "+game.getName());
		
	}

	

}
