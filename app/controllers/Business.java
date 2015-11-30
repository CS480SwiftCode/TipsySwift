package controllers;
public class Business
{
    private String name;

    private String locationAddress;
    private String city;
    private String state;
    private String zipCode;
    private String countryCode;

    private String url;
    private String phone;
    private double rating;

    private double latitude;
    private double longitude;

    private String happyHour;

    public Business()
    {

    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Name: " + name + "\n");
        sb.append("Address: " + locationAddress + "\n");
        sb.append("City: " + city + "\n");
        sb.append("State: " + state + "\n");
        sb.append("Zip: " + zipCode + "\n");
        sb.append("Country Code: " + countryCode + "\n");
        sb.append("URL: " + url + "\n");
        sb.append("Phone: " + phone + "\n");
        sb.append("Rating: " + rating + "\n");
        sb.append("Latitude: " + latitude + "\n");
        sb.append("Longitude: " + longitude + "\n");
        sb.append("Happy Hours: " + happyHour + "\n");

        return sb.toString();
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getLocationAddress()
    {
        return locationAddress;
    }

    public void setLocationAddress(String locationAddress)
    {
        this.locationAddress = locationAddress;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getZipCode()
    {
        return zipCode;
    }

    public void setZipCode(String zipCode)
    {
        this.zipCode = zipCode;
    }

    public String getCountryCode()
    {
        return countryCode;
    }

    public void setCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setPhone(String phone)
    {
        this.phone = phone;
    }

    public double getRating()
    {
        return rating;
    }

    public void setRating(double rating)
    {
        this.rating = rating;
    }

    public double getLatitude()
    {
        return latitude;
    }

    public void setLatitude(double latitude)
    {
        this.latitude = latitude;
    }

    public double getLongitude()
    {
        return longitude;
    }

    public void setLongitude(double longitude)
    {
        this.longitude = longitude;
    }

    public String getHappyHour()
    {
        return happyHour;
    }

    public void setHappyHour(String happyHour)
    {
        this.happyHour = happyHour;
    }
}
