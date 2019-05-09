package com.example.hellocat.bean;

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
    private ImageBean image;
    private String image_id;
    private String sub_id;
    private String user_id;

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
}
