package com.example.hellocat;

import com.com.sky.downloader.greendao.BreedImageDao;
import com.com.sky.downloader.greendao.DaoSession;
import com.example.hellocat.bean.Breed;
import com.example.hellocat.bean.BreedImage;
import com.example.hellocat.bean.Categories;
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

    public static void addBreedImage(BreedImage breedImage){
        DaoSession daoSession = BaseApplication.getDaoSession();
        BreedImageDao imageDao=daoSession.getBreedImageDao();

        List<BreedImage> breedImageList = imageDao.queryBuilder()
                .where(BreedImageDao.Properties.Id.eq(breedImage.id))

                .build().list();

        if(breedImageList.size()>0){
            return;
        }


        daoSession.getBreedImageDao().insert(breedImage);


    }

    public static BreedImage getBreedImage(String Id){
        DaoSession daoSession = BaseApplication.getDaoSession();
        BreedImageDao imageDao=daoSession.getBreedImageDao();
        List<BreedImage> breedImageList = imageDao.loadAll();

         for(int i=0;i<breedImageList.size();i++){
             String mId=breedImageList.get(i).breeds.get(0).id;
             if(mId.equals(Id)){
                 return breedImageList.get(i);
             }
         }

        return null;

    }

    public static void addCategories(List<Categories> categoriesList){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<Categories> breeds = daoSession.loadAll(Categories.class);

        if(breeds.size()>0){
            return;
        }


        for(int i=0;i<categoriesList.size();i++){
            Categories categories=categoriesList.get(i);
            daoSession.getCategoriesDao().insert(categories);

        }
    }
    public static List<Categories> getCategories(){
        DaoSession daoSession = BaseApplication.getDaoSession();
        List<Categories> categories = daoSession.getCategoriesDao().loadAll();
        return categories;

    }


}
