package p4;


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

    public Album() {
        
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

    public void setId(String id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public void setPerformer(String singer) {
        this.singer = singer;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public void setCompany(String company) {
        this.company = company;
    }
    public void setReview(String review) {
        this.review = review.trim();
    }
    public void setYear(String year) {
        this.year = year;
    }
    
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", singer='" + singer + '\'' +
                ", isbn='" + isbn + '\'' +
                ", company='" + company + '\'' +
                ", review='" + review + '\'' +
                ", year='" + year + '\'' +"}";
              
}
}
