package ru.tulupov.alex.medalmanah;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder> {

    protected Context context;
    protected List<Events> eventsList;

    public EventAdapter(Context context, List<Events> eventsList) {
        this.context = context;
        this.eventsList = eventsList;
    }

    @Override
    public EventViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_event, parent, false);
        return new EventViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EventViewHolder holder, int position) {
        Events events = eventsList.get(position);

        holder.title.setText(events.getTitle());
        holder.text.setText(events.getAnons());
        holder.start.setText(events.getStart());
        holder.end.setText(events.getEnd());
    }

    @Override
    public int getItemCount() {
        return eventsList.size();
    }

    public static class EventViewHolder extends RecyclerView.ViewHolder {

        TextView text;
        TextView title;
        TextView start;
        TextView end;

        public EventViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.itemEventText);
            title = (TextView) itemView.findViewById(R.id.itemEventTitle);
            start = (TextView) itemView.findViewById(R.id.itemEventStart);
            end = (TextView) itemView.findViewById(R.id.itemEventEnd);

        }
    }
}
