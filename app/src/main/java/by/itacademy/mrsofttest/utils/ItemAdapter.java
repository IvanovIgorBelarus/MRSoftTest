package by.itacademy.mrsofttest.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import by.itacademy.mrsofttest.R;
import by.itacademy.mrsofttest.model.Contact;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder> {
    private List<Contact> contactList = new ArrayList<>();
    private final LayoutInflater inflater;

    public ItemAdapter(Context context) {
        this.inflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.item_recycler, parent, false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        holder.onBind(contactList.get(position));
    }

    @Override
    public int getItemCount() {
        return contactList.size();
    }

    public void update(List<Contact> contactList) {
        this.contactList = contactList;
        notifyDataSetChanged();
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder {
        private TextView name;
        private TextView placeOfWork;
        private TextView phone;
        private String fullName;

        ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            placeOfWork = itemView.findViewById(R.id.placeOfWork);
            phone = itemView.findViewById(R.id.phone);
        }

        @SuppressLint("SetTextI18n")
        public void onBind(Contact contact) {
            fullName = String.format("%s %s %s", contact.firstName, contact.secondName, contact.surName);
            name.setText(fullName);
            placeOfWork.setText(contact.placeOfWork);
            phone.setText(Integer.valueOf(contact.phone).toString());
        }
    }
}
