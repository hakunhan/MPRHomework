package com.example.my_mobile_sql.adapters;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.my_mobile_sql.EditNoteActivity;
import com.example.my_mobile_sql.R;
import com.example.my_mobile_sql.database.NoteManager;
import com.example.my_mobile_sql.models.Note;

import java.util.List;


public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.NoteHolder> {
    private List<Note> notes;
    private Context context;
    private static final int EDIT = 2;

    public NoteAdapter(List<Note> notes) {
        this.notes = notes;
    }

    @NonNull
    @Override
    public NoteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View itemView = inflater.inflate(R.layout.item_note, parent, false);

        return new NoteHolder(itemView, context);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteHolder holder, final int position) {
        Note note = this.notes.get(position);

        holder.bind(note);
    }

    @Override
    public int getItemCount() {
        return this.notes.size();
    }

    public class NoteHolder extends RecyclerView.ViewHolder {
        private TextView tvText;
        private Context context;

        public NoteHolder(@NonNull View itemView, final Context context) {
            super(itemView);

            tvText = itemView.findViewById(R.id.tvText);
            this.context = context;
        }

        public void bind(final Note note) {
            tvText.setText(note.getText());

            tvText.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent data = new Intent(context, EditNoteActivity.class);

                    data.putExtra("id", note.getId());
                    data.putExtra("text", note.getText());
                    ((Activity) context).startActivityForResult(data, EDIT);
                }
            });

            tvText.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    new AlertDialog.Builder(context)
                            .setTitle("Delete")
                            .setMessage("Do you want to delete this note?")
                            .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    notes.remove(note);
                                    NoteManager.getInstance(context).delete(note.getId());

                                    notifyDataSetChanged();
                                }
                            }).setNegativeButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    }).show();


                    return true;
                }
            });
        }
    }
}
