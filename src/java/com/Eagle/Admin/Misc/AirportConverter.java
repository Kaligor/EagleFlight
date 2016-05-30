package com.Eagle.Admin.Misc;

import com.Eagle.Model.Airport;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Airport.class, value="AirportConverter")
public class AirportConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        Airport airport = new Airport();
        airport.setId(Long.parseLong(value));
        return airport;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        return String.valueOf(((Airport) value).getId());
    }

}
