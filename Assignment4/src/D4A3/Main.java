package D4A3;

public class Main {

	public static void main(String[] args) {
		CampaignService campaignService = new CampaignManager();
		GameService gameService = new GameManager();
		GamerService gamerService = new GamerManager();
		GameSellService gameSellService = new GameSellManager();		
		
		Gamer gamer = new Gamer();
		gamer.setId(1);
		gamer.setFirstName("Eren");
		gamer.setLastName("Uygun");
		gamer.setNationalIdentityNumber("11111111111");
		
		Game game = new Game();
		game.setId(1);
		game.setName("Super Mario");
		game.setPrice(10);
		
		Campaign campaign = new  Campaign();
		campaign.setId(1);
		campaign.setName("SummerSet");
		campaign.setDiscount(4);
		
		gamerService.register(gamer);
		gameService.addGame(game);
		campaignService.addCampaign(campaign);
		
		campaignService.updateCampaign(campaign, 6);
		
		gameSellService.sellGame(game, gamer, campaign);
		
		
		
		
		
		
		

	}

}
