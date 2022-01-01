package com.appsdeveloperblog.photoapp.api.users.business.concretes;

import java.util.ArrayList;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.appsdeveloperblog.photoapp.api.users.business.abstracts.UserService;
import com.appsdeveloperblog.photoapp.api.users.business.dtos.UserDto;
import com.appsdeveloperblog.photoapp.api.users.dataAccess.UserRepository;
import com.appsdeveloperblog.photoapp.api.users.entities.UserEntity;

@Service
public class UserManager implements UserService {

	private UserRepository userRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	public UserManager(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	// Bcrypte şifrelerin farklı olma nedeni salt password olayından ötürü

	@Override
	public UserDto add(UserDto userDto) {
		// Büyük Db'lerde int ve long'un sınırları aşılabileceğinden oto arttırma yerine
		// random uuid atıyoruz.String field olması gerekli.
		userDto.setUserId(UUID.randomUUID().toString());
		userDto.setEncryptedPassword(this.bCryptPasswordEncoder.encode(userDto.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity user = modelMapper.map(userDto, UserEntity.class);
		// user.setEncryptedPassword("abcde"); Önceden yoktu diye eklediğimiz geçici
		// çözüm
		this.userRepository.save(user);
		UserDto returnValue = modelMapper.map(user, UserDto.class);
		return returnValue;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserEntity userEntity = this.userRepository.findByEmail(username);
		if (userEntity == null) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı.");
		}

		return new User(userEntity.getEmail(), userEntity.getEncryptedPassword(), true, true, true, true,
				new ArrayList<>());

	}

	@Override
	public UserDto getUserDetailsByEmail(String email) {
		UserEntity userEntity = this.userRepository.findByEmail(email);
		if (userEntity == null) {
			throw new UsernameNotFoundException("Kullanıcı bulunamadı.");
		}
		
		
		
		
		return new ModelMapper().map(userEntity, UserDto.class);
	}

}

//Son kullanıcıya user nesnesi döndürmeyiniz.

//Authorization Filter'lar yazdığımız bütün 
//CrossCuttingConcern -> uygulamayı dikine kesen ilgi alanlarının kısaltması