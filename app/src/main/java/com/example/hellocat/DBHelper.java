package com.example.hellocat;

import com.com.sky.downloader.greendao.DaoSession;
import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.FavouriteCats;

import java.util.List;

public class DBHelper {
    public static void addBreed(List<Breed> breedList){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<Breed> breeds = daoSession.loadAll(Breed.class);

        if(breeds.size()>0){
            return;
        }


        for(int i=0;i<breedList.size();i++){
            Breed breed=breedList.get(i);
            daoSession.getBreedDao().insert(breed);

        }

    }

    public  static List<Breed> getBreeds(){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<Breed> breeds = daoSession.getBreedDao().loadAll();
        return breeds;
    }

    public static void addFavourite(List<FavouriteCats>favouriteCatsList){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<FavouriteCats> cats = daoSession.loadAll(FavouriteCats.class);

        if(cats.size()>0){
            return;
        }


        for(int i=0;i<favouriteCatsList.size();i++){
            FavouriteCats favouriteCats=favouriteCatsList.get(i);
            daoSession.getFavouriteCatsDao().insert(favouriteCats);

        }

    }

    public static List<FavouriteCats>getFavourite(){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<FavouriteCats> favCat = daoSession.getFavouriteCatsDao().loadAll();
        return favCat;

    }
}
