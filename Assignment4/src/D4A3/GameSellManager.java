package D4A3;

public class GameSellManager implements GameSellService {

	@Override
	public void sellGame(Game game, Gamer gamer, Campaign campaign) {
		System.out.println(game.getName()+" adlı oyun "+(game.getPrice()/campaign.getDiscount())+" Tl'den "+gamer.getFirstName()+" adlı kullanıcıya satıldı." );
		
	}

}
