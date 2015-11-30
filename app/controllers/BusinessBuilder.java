package controllers;

/**
 * Created by ZenasMeng on 11/18/15.
 */
public class BusinessBuilder
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

    public BusinessBuilder()
    {
    }

    public BusinessBuilder withName(String name)
    {
        this.name = name;
        return this;
    }

    public BusinessBuilder withLocationAddress(String locationAddress)
    {
        this.locationAddress = locationAddress;
        return this;
    }

    public BusinessBuilder withCity(String city)
    {
        this.city = city;
        return this;
    }

    public BusinessBuilder withState(String state)
    {
        this.state = state;
        return this;
    }

    public BusinessBuilder withZipCode(String zipCode)
    {
        this.zipCode = zipCode;
        return this;
    }

    public BusinessBuilder withCountryCode(String countryCode)
    {
        this.countryCode = countryCode;
        return this;
    }

    public BusinessBuilder withUrl(String url)
    {
        this.url = url;
        return this;
    }

    public BusinessBuilder withPhone(String phone)
    {
        this.phone = phone;
        return this;
    }

    public BusinessBuilder withRating(double rating)
    {
        this.rating = rating;
        return this;
    }

    public BusinessBuilder withLatitude(double latitude)
    {
        this.latitude = latitude;
        return this;
    }

    public BusinessBuilder withLongitude(double longitude)
    {
        this.longitude = longitude;
        return this;
    }


    public Business build()
    {
        Business business = new Business();
        business.setName(name);
        business.setLocationAddress(locationAddress);
        business.setCity(city);
        business.setState(state);
        business.setZipCode(zipCode);
        business.setCountryCode(countryCode);
        business.setUrl(url);
        business.setPhone(phone);
        business.setRating(rating);
        business.setLatitude(latitude);
        business.setLongitude(longitude);
        return business;
    }
}
