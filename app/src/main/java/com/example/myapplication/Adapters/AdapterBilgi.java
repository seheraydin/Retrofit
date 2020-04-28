package com.example.myapplication.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.myapplication.Models.Bilgiler;
import com.example.myapplication.R;

import java.util.List;

//15: extend BaseAdaapter yap ve implemente et
public class AdapterBilgi extends BaseAdapter {

    //16: almamız gereken bilgileri tanımlayalım
    List<Bilgiler> list;
    Context context;

    //17: tanımladığımız bilgileri dışarıdan alacağız bu yüzden constructor oluştur
    //sağ tık- generate -constructore

    public AdapterBilgi(List<Bilgiler> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @Override
    //18: listSize
    public int getCount() {
        return list.size();
    }

    @Override
    //19: listin positionu
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    //20: convertView tanımla , textViewları tanımla set et ve döndür
    public View getView(int position, View convertView, ViewGroup parent) {
        //20 : tanımla
        convertView = LayoutInflater.from(context).inflate(R.layout.layout,parent,false);
        TextView userID=convertView.findViewById(R.id.idUserID);
        TextView id=convertView.findViewById(R.id.idID);
        TextView title=convertView.findViewById(R.id.idTitle);
        TextView body=convertView.findViewById(R.id.idBody);

        //20 :set et
        userID.setText(""+ list.get(position).getUserId());
        id.setText(""+list.get(position).getId());
        title.setText(""+list.get(position).getTitle());
        body.setText(""+list.get(position).getBody());

        return convertView;
    }
}
