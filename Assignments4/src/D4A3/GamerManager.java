package D4A3;

public class GamerManager implements GamerService {
	

	@Override
	public void register(Gamer gamer) {
		if (CheckUtil.isRealPerson(gamer.getFirstName(), gamer.getLastName(),gamer.getNationalIdentityNumber())) {
			System.out.println("Kaydınız yapıldı. Hoşgeldiniz : "+gamer.getFirstName()+" "+gamer.getLastName());
		}else {
			System.out.println("Bilgilerinizi kontrol ediniz.");
		}
		
	}

	@Override
	public void update(Gamer gamer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Gamer gamer) {
		// TODO Auto-generated method stub
		
	}

}
