package com.isil.activities.view.adapters;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filterable;

import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.isil.activities.R;
import com.isil.activities.model.DoctorEntity;

import java.util.List;
import java.util.ArrayList;

import static com.isil.activities.R.id.iviDisponible;
import static com.isil.activities.R.id.medRow;

/**
 * Created by Pablo on 11/4/2016.
 */

public class DoctorAdapter extends BaseAdapter implements Filterable {

    private Context context;
    private List<DoctorEntity> lsDoctorEntities;
    private List<DoctorEntity> originalData;
    private Filter docFilter;


    public DoctorAdapter(Context context, List<DoctorEntity> originalData) {
        this.context = context;
        this.originalData = originalData;
        this.lsDoctorEntities = originalData;

    }

    @Override
    public int getCount() {
        return lsDoctorEntities.size();
    }

    @Override
    public Object getItem(int i) {
        return lsDoctorEntities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

       View v = convertView;

        if(v == null)
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            v = inflater.inflate(R.layout.row_doctor, null);
            ViewHolder holder = new ViewHolder();
            holder.tviName = (TextView)v.findViewById(R.id.tviName);
            holder.iviDoc = (ImageView) v.findViewById(R.id.iviDoc);
            holder.tviCategory = (TextView)v.findViewById(R.id.tviCategory);
            holder.tviLocation = (TextView)v.findViewById(R.id.tviLocation);
            holder.tviSchedule= (TextView)v.findViewById(R.id.tviSchedule);
            //holder.iviDisponible = (ImageView) v.findViewById(iviDisponible);
            v.setTag(holder);


        }
        DoctorEntity entry = lsDoctorEntities.get(position);

        if((entry != null))

        {

            ViewHolder holder = (ViewHolder)v.getTag();

            //if (entry.getCategory().equals("Cardiologia")){
                holder.tviName.setText(entry.getName());
                holder.iviDoc.setImageResource(entry.getIcon());
                holder.tviCategory.setText(entry.getCategory());
                holder.tviLocation.setText(entry.getLocation());
                holder.tviSchedule.setText(""+(entry.getSchedule()));
                //holder.iviDisponible.setVisibility(View.GONE);
               /* boolean disponible = entry.isAvailable();
                if (disponible) {
                    holder.iviDisponible.setVisibility(View.VISIBLE);
                } else {
                    holder.iviDisponible.setVisibility(View.GONE);
                }*/
            //}






          return v;
        }

        return v;
    }

    public void resetData() {
        lsDoctorEntities = originalData;
    }

   @Override
    public Filter getFilter() {
        if (docFilter == null)
            docFilter = new DocFilter();
        return docFilter;
    }
    private class DocFilter extends Filter {

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            FilterResults results = new FilterResults();
            // We implement here the filter logic
            if (constraint == null || constraint.length() == 0) {
                // No filter implemented we return all the list
                results.values = originalData;
                results.count = originalData.size();
            }
            else {
                // We perform filtering operation
                List<DoctorEntity> nDocList = new ArrayList<DoctorEntity>();

                for (DoctorEntity doctorEntity : lsDoctorEntities) {
                    if (doctorEntity.getName().toUpperCase().startsWith(constraint.toString().toUpperCase()))

                        nDocList.add(doctorEntity);
                }

                results.values = nDocList;
                results.count = nDocList.size();

            }
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint,
                                      FilterResults results) {
            // Now we have to inform the adapter about the new list filtered
            if (results.count == 0)
                notifyDataSetInvalidated();
            else {
                lsDoctorEntities = (List<DoctorEntity>) results.values;
                notifyDataSetChanged();
            }

        }

    }

    static class ViewHolder
    {
        ImageView iviDoc;
        TextView tviName;
        ImageView iviDisponible;
        TextView tviCategory;
        TextView tviLocation;
        TextView tviSchedule;
    }
}
