/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Eagle.Admin.Misc;

import com.Eagle.Model.Plane;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author User
 */
@FacesConverter(forClass = Plane.class, value = "PlaneConverter")
public class PlaneConverter implements Converter
{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value)
    {
        Plane plane = new Plane();
        plane.setId(Long.parseLong(value));
        return plane;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value)
    {
        return String.valueOf(((Plane) value).getId());
    }
}
