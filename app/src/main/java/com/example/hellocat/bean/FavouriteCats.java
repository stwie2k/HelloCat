package com.example.hellocat.bean;

import com.google.gson.Gson;

import org.greenrobot.greendao.annotation.Convert;
import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.converter.PropertyConverter;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class FavouriteCats {
    public String created_at;

    /**
     * id : 11182
     * image : {"id":"9ccXTANkb","url":"https://cdn2.thecatapi.com/images/9ccXTANkb.jpg"}
     * image_id : 9ccXTANkb
     * sub_id : your-user-1234
     * user_id : uoynht
     */

    private int id;

    @Convert(converter = FavoriteCatConvert.class, columnType = String.class)

    private ImageBean image;
    private String image_id;
    private String sub_id;
    private String user_id;

    @Generated(hash = 359716108)
    public FavouriteCats(String created_at, int id, ImageBean image, String image_id,
            String sub_id, String user_id) {
        this.created_at = created_at;
        this.id = id;
        this.image = image;
        this.image_id = image_id;
        this.sub_id = sub_id;
        this.user_id = user_id;
    }

    @Generated(hash = 1175916924)
    public FavouriteCats() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ImageBean getImage() {
        return image;
    }

    public void setImage(ImageBean image) {
        this.image = image;
    }

    public String getImage_id() {
        return image_id;
    }

    public void setImage_id(String image_id) {
        this.image_id = image_id;
    }

    public String getSub_id() {
        return sub_id;
    }

    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public static class ImageBean {
        /**
         * id : 9ccXTANkb
         * url : https://cdn2.thecatapi.com/images/9ccXTANkb.jpg
         */

        private String id;
        private String url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    public static class FavoriteCatConvert implements PropertyConverter<ImageBean, String> {

        private static Gson mGson = new Gson();

        @Override
        public ImageBean convertToEntityProperty(String databaseValue) {
            ImageBean catFavoriteImage = mGson.fromJson(databaseValue, ImageBean.class);

            return catFavoriteImage;
        }

        @Override
        public String convertToDatabaseValue(ImageBean entityProperty) {
            return mGson.toJson(entityProperty);
        }
    }
}
