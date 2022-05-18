package spittr.data;


import java.time.LocalDate;

public class Spittle {
    private final Long id;
    private final String message;
    private final LocalDate time;
    private Double latitude;
    private Double longitude;

    public Spittle(String message, LocalDate time){
        this(message, time, null, null);
    }


    public Spittle(String message, LocalDate time, Double latutude, Double longitude) {
        this.id = null;
        this.message = message;
        this.time = time;
        this.latitude = latutude;
        this.longitude = longitude;
    }

    public Spittle(Long id, String message, LocalDate time, Double latutude, Double longitude) {
        this.id = id;
        this.message = message;
        this.time = time;
        this.latitude = latutude;
        this.longitude = longitude;
    }

    public Long getId() {
        return id;
    }

    public String getMessage() {
        return message;
    }

    public LocalDate getTime() {
        return time;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Spittle;
    }
}
