package dev.ajith.Productderviceoct2026.Client;

import dev.ajith.Productderviceoct2026.DTO.FakestoreProductdto;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpMessageConverterExtractor;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;



@Component
public class Fakestoreclient {
    @Autowired
    private RestTemplate restTemplate ;
    public FakestoreProductdto getproductbyiid(int id)
    {
        String getproduct ="https://fakestoreapi.com/products/1"+id;
        FakestoreProductdto fspdto=requestForObject(getproduct,HttpMethod.GET,null,FakestoreProductdto.class);
        return fspdto;
    }
    public FakestoreProductdto[]  getalllproducts()
    {
        String getproduct ="https://fakestoreapi.com/products";
        FakestoreProductdto[] fspdtos=restTemplate.getForObject(getproduct,FakestoreProductdto[].class);
        return fspdtos;
    }
    public FakestoreProductdto createproduct(FakestoreProductdto fakestoreProductdto) {
        String createproduct ="https://fakestoreapi.com/products";
        FakestoreProductdto response= restTemplate.postForObject(createproduct, fakestoreProductdto, FakestoreProductdto.class);
        return response;
    }
    public FakestoreProductdto replaceproduct(int id, FakestoreProductdto fakestoreProductdto) {
        String replaceproduct ="https://fakestoreapi.com/products/"+id;
        FakestoreProductdto response= putForObject(replaceproduct,fakestoreProductdto,FakestoreProductdto.class);
        return response;
    }
    public <T> @Nullable T putForObject(String url, @Nullable Object request, Class<T> responseType,
                                         @Nullable Object... uriVariables) throws RestClientException {

        RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
        HttpMessageConverterExtractor<T> responseExtractor =
                new HttpMessageConverterExtractor<>(responseType, restTemplate.getMessageConverters());
        return restTemplate.execute(url, HttpMethod.PUT, requestCallback, responseExtractor, uriVariables);
    }
public <T> @Nullable T requestForObject(String url,HttpMethod httpmethod, @Nullable Object request, Class<T> responseType) throws RestClientException {

    RequestCallback requestCallback = restTemplate.httpEntityCallback(request, responseType);
    HttpMessageConverterExtractor<T> responseExtractor =
            new HttpMessageConverterExtractor<>(responseType, restTemplate.getMessageConverters());
    return restTemplate.execute(url,httpmethod, requestCallback, responseExtractor);
 }
    public boolean deleteproduct(int id) {
        String deleteproduct = "https://fakestoreapi.com/products/" + id;
        try{
            restTemplate.delete(deleteproduct);
            return true;
        } catch(RestClientException e){
            e.printStackTrace();
            return false;

        }
    }


}
