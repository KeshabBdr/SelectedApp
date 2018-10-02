package np.com.rotaractnepalapp.rotaract.Class.ClassIntroduction;

public class Intro4Class {

    private int image;
    private String title;
    private String information;

    public Intro4Class() {
    }

    public Intro4Class(int image, String title, String information) {
        this.image = image;
        this.title = title;
        this.information = information;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getInformation() {
        return information;
    }

    public void setInformation(String information) {
        this.information = information;
    }
}
