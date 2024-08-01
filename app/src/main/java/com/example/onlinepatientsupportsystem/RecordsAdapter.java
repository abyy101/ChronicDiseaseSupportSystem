package com.example.onlinepatientsupportsystem;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecordsAdapter extends RecyclerView.Adapter<RecordsAdapter.RecordViewHolder> {

    private List<Record> recordList;

    public RecordsAdapter(List<Record> recordList) {
        this.recordList = recordList;
    }

    @NonNull
    @Override
    public RecordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_record, parent, false);
        return new RecordViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecordViewHolder holder, int position) {
        Record record = recordList.get(position);
        holder.bind(record);
    }

    @Override
    public int getItemCount() {
        return recordList.size();
    }

    public static class RecordViewHolder extends RecyclerView.ViewHolder {

        private TextView fullNameTextView;
        private TextView genderTextView;
        private TextView dobTextView;
        private TextView heightTextView;
        private TextView conditionTextView;
        private TextView medicineNameTextView;
        private TextView prescriptionTextView;
        private TextView additionalInfoTextView;

        public RecordViewHolder(@NonNull View itemView) {
            super(itemView);
            fullNameTextView = itemView.findViewById(R.id.textViewFullName);
            genderTextView = itemView.findViewById(R.id.textViewGender);
            dobTextView = itemView.findViewById(R.id.textViewDOB);
            heightTextView = itemView.findViewById(R.id.textViewHeight);
            conditionTextView = itemView.findViewById(R.id.textViewCondition);
            medicineNameTextView = itemView.findViewById(R.id.textViewMedicineName);
            prescriptionTextView = itemView.findViewById(R.id.textViewPrescription);
            additionalInfoTextView = itemView.findViewById(R.id.textViewAdditionalInfo);
        }

        public void bind(Record record) {
            fullNameTextView.setText(record.getFullName());
            genderTextView.setText(record.getGender());
            dobTextView.setText(record.getDob());
            heightTextView.setText(record.getHeight());
            conditionTextView.setText(record.getCondition());
            medicineNameTextView.setText(record.getMedicineName());
            prescriptionTextView.setText(record.getPrescription());
            additionalInfoTextView.setText(record.getAdditionalInfo());
        }
    }
}
