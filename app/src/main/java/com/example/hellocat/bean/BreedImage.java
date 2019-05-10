package com.example.hellocat.bean;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.converter.PropertyConverter;

import java.util.List;
import org.greenrobot.greendao.annotation.Generated;
@Entity
public class BreedImage {
    public String url;
    public String id;

    /**
     * breeds : [{"weight":{"imperial":"6 - 12","metric":"3 - 7"},"id":"beng","name":"Bengal","cfa_url":"http://cfa.org/Breeds/BreedsAB/Bengal.aspx","vetstreet_url":"http://www.vetstreet.com/cats/bengal","vcahospitals_url":"https://vcahospitals.com/know-your-pet/cat-breeds/bengal","temperament":"Alert, Agile, Energetic, Demanding, Intelligent","origin":"United States","country_codes":"US","country_code":"US","description":"Bengals are a lot of fun to live with, but they're definitely not the cat for everyone, or for first-time cat owners. Extremely intelligent, curious and active, they demand a lot of interaction and woe betide the owner who doesn't provide it.","life_span":"12 - 15","indoor":0,"lap":0,"adaptability":5,"affection_level":5,"child_friendly":4,"cat_friendly":4,"dog_friendly":5,"energy_level":5,"grooming":1,"health_issues":3,"intelligence":5,"shedding_level":3,"social_needs":5,"stranger_friendly":3,"vocalisation":5,"bidability":3,"experimental":0,"hairless":0,"natural":0,"rare":0,"rex":0,"suppressed_tail":0,"short_legs":0,"wikipedia_url":"https://en.wikipedia.org/wiki/Bengal_(cat)","hypoallergenic":1}]
     * width : 1795
     * height : 2397
     */
    @Convert(converter = BreedImage.BreedImageConvert.class, columnType = String.class)
    public List<BreedsBean> breeds;

    @Generated(hash = 2094909494)
    public BreedImage(String url, String id, List<BreedsBean> breeds) {
        this.url = url;
        this.id = id;
        this.breeds = breeds;
    }

    @Generated(hash = 1080796236)
    public BreedImage() {
    }

    public String getUrl() {
        return this.url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<BreedsBean> getBreeds() {
        return this.breeds;
    }

    public void setBreeds(List<BreedsBean> breeds) {
        this.breeds = breeds;
    }

    public class BreedsBean{
        public String name;
        public String description;
        public String life_span;
        public String origin;
        public String temperament;
        public String id;


    }

    public static class BreedImageConvert implements PropertyConverter<List<BreedImage.BreedsBean>, String> {

        private static Gson mGson = new Gson();

        @Override
        public List<BreedImage.BreedsBean> convertToEntityProperty(String databaseValue) {
            List<BreedImage.BreedsBean>breedsBeanList  = mGson.fromJson(databaseValue, new TypeToken<List<BreedImage.BreedsBean>>(){}.getType());

            return breedsBeanList;
        }

        @Override
        public String convertToDatabaseValue(List<BreedImage.BreedsBean>  entityProperty) {
            return mGson.toJson(entityProperty);
        }
    }
}
