package id.gits.soalnews;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import butterknife.Bind;
import butterknife.ButterKnife;

public class DetailActivity extends AppCompatActivity {
@Bind(R.id.toolbar)
Toolbar toolbar;

    @Bind(R.id.tvTitle)
    TextView txtTitle;

    @Bind(R.id.tvRead)
    TextView txtRead;

    @Bind(R.id.tvDesc)
    TextView txtDesc;

    @Bind(R.id.dGambar)
    ImageView imageView;

    @Bind(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbarLayout;

    String title,desc,read,imgUrl;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle getdata = getIntent().getExtras();
        title=getdata.getString("title");
        read= getdata.getString("read");
        desc=getdata.getString("desc");
        imgUrl=getdata.getString("imgUrl");
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent)); // transperent color = #00000000
        collapsingToolbarLayout.setCollapsedTitleTextColor(getResources().getColor(android.R.color.white));



        txtTitle.setText(title);
        txtRead.setText("Dibaca Oleh: "+read);
        txtDesc.setText(desc);
        Picasso.with(getApplicationContext()).load(imgUrl).placeholder(R.drawable.placeholder).into(imageView);



    }
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            onBackPressed();
        }

        return super.onOptionsItemSelected(item);
    }
}
