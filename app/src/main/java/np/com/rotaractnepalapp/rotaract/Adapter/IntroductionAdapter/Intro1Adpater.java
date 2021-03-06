package np.com.rotaractnepalapp.rotaract.Adapter.IntroductionAdapter;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.codesgood.views.JustifiedTextView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;
import np.com.rotaractnepalapp.rotaract.Class.ClassIntroduction.Intro1Class;
import np.com.rotaractnepalapp.rotaract.R;

public class Intro1Adpater extends RecyclerView.Adapter<Intro1Adpater.ClubViewHolder> {

    ArrayList<Intro1Class> data = new ArrayList<>();

    public Intro1Adpater(ArrayList<Intro1Class> data) {
        this.data = data;
    }

    @NonNull
    @Override
    public ClubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.itemadapter, viewGroup, false);
        return new ClubViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ClubViewHolder clubViewHolder, int i) {
        clubViewHolder.title.setText(data.get(i).getTitle());
        clubViewHolder.images.setImageResource(data.get(i).getImage());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ClubViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        CircleImageView images;
        public ClubViewHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.nameTextView);
            images = (CircleImageView) itemView.findViewById(R.id.imageView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        final Intro1Class clickedDataItem = data.get(position);
                        final Dialog Information;
                        Information = new Dialog(v.getContext());

                        Information.setContentView(R.layout.intro_item_adapter_layout);

                        ImageView Image = (ImageView) Information.findViewById(R.id.dialogImage);
                        Image.setImageResource(clickedDataItem.getDimage());

                        TextView Title = (TextView) Information.findViewById(R.id.dialogTitle);
                        Title.setText(clickedDataItem.getTitle());

                        JustifiedTextView Introduction = (JustifiedTextView) Information.findViewById(R.id.dialogInformation);
                        Introduction.setText(clickedDataItem.getInformation());

                        TextView close = (TextView) Information.findViewById(R.id.closeDialog);
                        close.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                Information.dismiss();
                            }
                        });

                        Information.setCanceledOnTouchOutside(false);
                        Information.setCancelable(false);
                        Information.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                        Information.show();
                    }
                }
            });
        }
    }
}
