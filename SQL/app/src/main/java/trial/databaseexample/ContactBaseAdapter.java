package trial.databaseexample;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Vyas on 4/18/2016.
 */
public class ContactBaseAdapter extends BaseAdapter {
    Context context;
    List<Contact> contactList;
    Contact mContact;
    LayoutInflater layoutInflater;
    public ContactBaseAdapter(Context context, List<Contact> contactList) {
        this.context = context;
        this.contactList = contactList;
        layoutInflater=LayoutInflater.from(this.context);
    }

    @Override
    public int getCount() {
        return contactList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        layoutInflater=(LayoutInflater)context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.view_all_base_layout,parent,false);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }else{
            viewHolder=(ViewHolder)convertView.getTag();
        }
        mContact = new Contact();
        viewHolder.mID.setText(contactList.get(position).getId());
        viewHolder.mName.setText(contactList.get(position).getName());
        viewHolder.mAge.setText(contactList.get(position).getMobile());
        return convertView;
    }
    private class ViewHolder{
        TextView mID,mName,mAge;
       public ViewHolder(View view){
           mID =(TextView)view.findViewById(R.id.id_base_view);
           mName=(TextView)view.findViewById(R.id.name_base_view);
           mAge=(TextView)view.findViewById(R.id.age_base_view);
       }
    }
}
