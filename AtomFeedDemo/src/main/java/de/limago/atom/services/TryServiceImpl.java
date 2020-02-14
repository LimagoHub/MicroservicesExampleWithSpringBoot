package de.limago.atom.services;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import de.limago.atom.services.models.TryModel;

@Service
public class TryServiceImpl implements TryService {
	
	@Override
	public List<TryModel> createModels() {
		return  Arrays.asList(new TryModel(),new TryModel(),new TryModel(),new TryModel(),new TryModel(),new TryModel(),new TryModel());
	}

}
