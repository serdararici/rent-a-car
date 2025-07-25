package kodlama.io.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import kodlama.io.rentACar.business.abstracts.BrandService;
import kodlama.io.rentACar.business.requests.CreateBrandRequest;
import kodlama.io.rentACar.business.requests.UpdateBrandRequest;
import kodlama.io.rentACar.business.responses.GetAllBrandsResponse;
import kodlama.io.rentACar.business.responses.GetByIdBrandResponse;
import kodlama.io.rentACar.business.rules.BrandBusinessRules;
import kodlama.io.rentACar.core.utilities.mappers.ModelMapperService;
import kodlama.io.rentACar.dataAccess.abstracts.BrandRepository;
import kodlama.io.rentACar.entities.concretes.Brand;
import lombok.AllArgsConstructor;

@Service  // this class is a Business object
@AllArgsConstructor
public class BrandManager implements BrandService{
	private BrandRepository brandRepository;
	private ModelMapperService modelMapperService;
	private BrandBusinessRules brandBusinessRules;

	// the constructor is made by lombok 
	/*
	public BrandManager(BrandRepository brandRepository) {
		super();
		this.brandRepository = brandRepository;
	} */  



	@Override
	public List<GetAllBrandsResponse> getAll() {
		
		
		List<Brand> brands = brandRepository.findAll();
		
		// without mapping
		/*
		List<GetAllBrandsResponse> brandsResponse = new ArrayList<GetAllBrandsResponse>();
		
		for (Brand brand : brands) {
			GetAllBrandsResponse responseItem = new GetAllBrandsResponse();
			responseItem.setId(brand.getId());
			responseItem.setName(brand.getName());
			
			brandsResponse.add(responseItem);
		}
		*/
		
		//  stream() lets you iterate over a collection like forEach, making data processing easier and more readable.
		// first map that ı used here from streamapi, second one is from modelmapper
		List<GetAllBrandsResponse> brandsResponse = brands.stream()
				.map(brand -> this.modelMapperService.forResponse()
						.map(brand, GetAllBrandsResponse.class)).collect(Collectors.toList());
		
		// business rules
		
		return brandsResponse;
	}



	@Override
	public void add(CreateBrandRequest createBrandRequest) {
		
		/*Brand brand = new Brand();
		brand.setName(createBrandRequest.getName());
		*/
		
		this.brandBusinessRules.checkIfBrandNameExists(createBrandRequest.getName());
		
		// used model mapper
		Brand brand = this.modelMapperService.forRequest().map(createBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
		
	}



	@Override
	public GetByIdBrandResponse getById(int id) {
		Brand brand = this.brandRepository.findById(id).orElseThrow();
		
		GetByIdBrandResponse response = this.modelMapperService.forResponse()
				.map(brand, GetByIdBrandResponse.class);
		
		return response;
	}



	@Override
	public void update(UpdateBrandRequest updateBrandRequest) {
		
		Brand brand = this.modelMapperService.forRequest().map(updateBrandRequest, Brand.class);
		
		this.brandRepository.save(brand);
	}



	@Override
	public void delete(int id) {
		
		this.brandRepository.deleteById(id);
		
	}
	
}
