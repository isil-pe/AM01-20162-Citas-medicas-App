package com.isil.activities.storage;

import com.isil.activities.R;
import com.isil.activities.model.DoctorEntity;
import com.isil.activities.model.LocationEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Pablo on 11/27/2016.
 */

public class LocationRepository {

    private List<LocationEntity> lsLocationEntities;

    public LocationRepository(){lsLocationEntities= new ArrayList<LocationEntity>();}

    public void mock() {


        LocationEntity locationEntity= new LocationEntity(1,"Local San Borja","Sede Hospitalaria","Av. Guardia Civil 385 – San Borja","619-6161","Unidad de Cuidados Intensivos (U.C.I)");
        locationEntity.setPhoto(R.drawable.sb1);
        LocationEntity locationEntity2= new LocationEntity(1,"Local Santa Anita","MediCentro","Carretera Central 111 Edificio Médico 5to Piso, Santa Anita","619-6162","Centro de Terapia Física y Rehabilitación");
        locationEntity2.setPhoto(R.drawable.sa);
        LocationEntity locationEntity3= new LocationEntity(1,"Local Lima","Sede Hospitalaria","Av. Garcilaso de la Vega 1420 - Lima","619-6160","Unidad de Cuidados Intensivos (U.C.I) Centro Quirúrgico Centro Endoscópico");
        locationEntity3.setPhoto(R.drawable.lima);
        LocationEntity locationEntity4= new LocationEntity(1,"Local El Polo","MediCentro","Av. Encalada 960, Surco","619-6163","Programa Cuídate para pacientes con enfermedades crónicas Medicina Preventiva (Ginecología y Pediatría) Servicio de Imágenes");
        locationEntity4.setPhoto(R.drawable.polo);
        LocationEntity locationEntity5= new LocationEntity(1,"Local San Isidro","Sede Hospitalaria","Av. Paseo de la República 3058, San Isidro","619-6164","Programa Sonrisa Total Odontología Programas para pacientes con enfermedades crónicas Laboratorio");
        locationEntity5.setPhoto(R.drawable.si);

        lsLocationEntities.add(locationEntity);
        lsLocationEntities.add(locationEntity2);
        lsLocationEntities.add(locationEntity3);
        lsLocationEntities.add(locationEntity4);
        lsLocationEntities.add(locationEntity5);

    }

    public void addRestaurant(LocationEntity loc)
    {
        lsLocationEntities.add(loc);
    }




    public List<LocationEntity> allLocations()
    {
        return this.lsLocationEntities;
    }

    public int countPlaces()
    {
        return this.lsLocationEntities.size();
    }
    public LocationEntity lastLocations()
    {
        if(this.lsLocationEntities.size()>0)
        {
            return this.lsLocationEntities.get(this.lsLocationEntities.size()-1);
        }
        return null;
    }
}
