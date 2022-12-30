package p2;


public class Album {
    String id;
    String name;
    String country;
    String singer;
    String isbn; 
    String company;
    String review;
    String year;

    public Album(String id, String name,String country, String singer, String isbn, String company, String review,String year){
            this.id=id;
            this.name=name;
            this.country=country;
            this.singer=singer;
            this.isbn=isbn;
            this.company=company;
            this.review=review;
            this.year=year;

    }

    public String getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getCountry(){
        return country;
    }
    public String getPerformer(){
        return singer;
    }
    public String getIsbn(){
        return isbn;
    }
    public String getCompany(){
        return company;
    }
    public String getReview(){
        return review;
    }
    public String getYear(){
        return year;
    }
}
