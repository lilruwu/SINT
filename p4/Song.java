package p4;

import java.util.ArrayList;
import java.util.Arrays;

public class Song {
    String id;
    String tittle;
    String composer;
    String duration;
    ArrayList <String> genre = new ArrayList <String>();
    String lang;
    String aid;



    public Song(String id, String tittle,ArrayList<String> genre, String duration, String composer,String lang){
            this.id=id;
            this.tittle=tittle;
            this.composer=composer;
            this.duration=duration;
            this.genre=genre;
            this.lang=lang;
         


    } 

    public Song() {
        
    }
    public String getId(){
        return id;
    }
    public String getTittle(){
        return tittle;
    }
    public String getComposer(){
        return composer;
    }
    public String getDuration(){
        return duration;
    }
    public ArrayList <String> getGenre(){
        return genre;
    }
    public String getGenreXML(){
        String list = Arrays.toString(genre.toArray()).replace("[", "").replace("]", "");
        return list;
    }
    public String getLang(){
        return lang;
    }
    
    public String getAlbumID() {
    	return aid;
    }
   
    public void setId(String id) {
        this.id = id;
    }
    public void setTittle(String tittle) {
        this.tittle = tittle;
    }
    public void setComposer(String composer) {
        this.composer = composer;
    }
    public void setDuration(String duration) {
        this.duration = duration;
    }
    public void setGenre(String genre) {
        this.genre.add(genre);
    }
    public void setLang(String lang) {
        this.lang = lang;
    }
    
    public void setAlbumID(String aid) {
    this.aid=aid;
    }

 public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", title='" + tittle + '\'' +
                ", composer='" + composer + '\'' +
                ", duration='" + duration + '\'' +
                ", genre='" + genre + '\'' +
                ", lang='" + lang + '\'' +
                ", albumid='" + aid + '\'' +"}";
              
}

}
