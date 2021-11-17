package D4A3;

public class CampaignManager implements CampaignService {

	@Override
	public void addCampaign(Campaign campaign) {
		// TODO Auto-generated method stub
		System.out.println(campaign.getName() + " Eklendi. İndirim Oranı : "+campaign.getDiscount());
		
	}

	@Override
	public void updateCampaign(Campaign campaign,double discountRate) {
		System.out.println(campaign.getName() + " Eski İndirim Oranı : "+campaign.getDiscount());
		campaign.setDiscount(discountRate);
		System.out.println(campaign.getName() + " Yeni İndirim Oranı : "+campaign.getDiscount());
		
	}

	@Override
	public void deleteCampagin(Campaign campaign) {
		// TODO Auto-generated method stub
		System.out.println(campaign.getName() + " Silindi.");
		
	}

	

}
