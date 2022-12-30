package p3;

import java.util.ArrayList;
import java.util.Arrays;

public class Song {
    String id;
    String tittle;
    String composer;
    String duration;
    ArrayList <String> genre = new ArrayList <String>();
    String lang;



    public Song(String id, String tittle,ArrayList<String> genre, String duration, String composer,String lang){
            this.id=id;
            this.tittle=tittle;
            this.composer=composer;
            this.duration=duration;
            this.genre=genre;
            this.lang=lang;
         


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
   


}