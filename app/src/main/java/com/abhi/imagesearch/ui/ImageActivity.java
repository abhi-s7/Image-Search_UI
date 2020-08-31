package com.abhi.imagesearch.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.StrictMode;
import android.provider.MediaStore;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.abhi.imagesearch.ui.Adapter.SliderAdapter;
import com.abhi.imagesearch.ui.Constants.BrandData;
import com.abhi.imagesearch.ui.Model.ImageModel;
import com.abhi.imagesearch.ui.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ImageActivity extends AppCompatActivity {

    private ViewPager2 viewPager2;
    private ArrayList<ImageModel> items;
    private SliderAdapter adapter;
    private Button sayBtn;
    private EditText searchInput;
    private TextView brandNameTV;
    private String brandName = "";
    private static final String TAG = "ImageActivity";
    public static final String SAHRE_TITLE = "www.dapscare.com\n\n9996444445\n9996701001";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_images_constraint);

        String query = getIntent().getStringExtra("query");
        String[] arr ;
        if (query != null && !TextUtils.isEmpty(query)) {
            arr = query.split("\\s");
            brandName = arr[0];
        }

        init();
        fillImageList();
        setViewPager();

//        searchInput.setText("eco");
        adapter.getFilter().filter(query);
        brandNameTV.setText("#" + brandName);

        searchInput.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.getFilter().filter(s);
               // search = s;
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
    private void init() {
        viewPager2 = findViewById(R.id.viewPagerImageSlider);
        items = new ArrayList<>();
        searchInput = findViewById(R.id.search_input);
        brandNameTV = findViewById(R.id.searchedBrandName);
    }

    private void fillImageList() {

        List<String[]> list = getArrays(brandName.toLowerCase());
        Log.d(TAG, "brandName: " + brandName.toLowerCase());
        Log.d(TAG, "fillImageList() returned: " + list);
        if(list.get(0) != null && list.get(1) != null){
            for(int i = 0; i< list.get(0).length; i++){
                ImageModel im = new ImageModel(list.get(0)[i],list.get(1)[i]);
                items.add(im);
            }
        }
//        items.add(new ImageModel("Suzuki Accord 800",R.drawable.accord_new));
//        items.add(new ImageModel("Suzuki Alto 800",R.drawable.alto800));
//        items.add(new ImageModel("Eco Sports 1",R.drawable.amaze_new));
//        items.add(new ImageModel("Eco Sports 2",R.drawable.bolero));
    }

    private List<String[]> getArrays(String brand) {
        String[] nameArr ;
        String[] fileNameArr ;
        switch (brand){
            case "suzuki":
                nameArr = BrandData.suzuki;
                fileNameArr = BrandData.suzukiFileNames;
                break;

            case "cheveorlet":
                nameArr = BrandData.cheveorlet;
                fileNameArr = BrandData.cheveorletFileNames;
                break;
            case "ford":
                nameArr = BrandData.ford;
                fileNameArr = BrandData.fordFileNames;
                break;

            case "honda":
                nameArr = BrandData.honda;
                fileNameArr = BrandData.hondaFileNames;
                break;

            case "hyundai":
                nameArr = BrandData.hyundai;
                fileNameArr = BrandData.hyundaiFileNames;
                break;

            case "isuzu":
                nameArr = BrandData.isuzu;
                fileNameArr = BrandData.isuzuFileNames;
                break;

            case "jeep":
                nameArr = BrandData.jeep;
                fileNameArr = BrandData.jeepFileNames;
                break;
            case "mahindra":
                nameArr = BrandData.mahindra;
                fileNameArr = BrandData.mahindraFileNames;
                break;
            case "nissan":
                nameArr = BrandData.nissan;
                fileNameArr = BrandData.nissanFileNames;
                break;

            case "renault":
                nameArr = BrandData.renault;
                fileNameArr = BrandData.renaultFileNames;
                break;
            case "skoda":
                nameArr = BrandData.skoda;
                fileNameArr = BrandData.skodaFileNames;
                break;

            case "volkswagen":
                nameArr = BrandData.volkswagen;
                fileNameArr = BrandData.volkswagenNames;
                break;

            case "tata":
                nameArr = BrandData.tata;
                fileNameArr = BrandData.tataFileNames;
                break;

            case "toyota":
                nameArr = BrandData.toyota;
                fileNameArr = BrandData.toyotaFileNames;
                break;

            default:
                nameArr = null;
                fileNameArr = null;
                break;
        }
        List<String[]> list = new ArrayList<>();
        list.add(nameArr);
        list.add(fileNameArr);
        return list;
    }

    private void setViewPager() {
        viewPager2.setClipToPadding(false);
        viewPager2.setClipChildren(false);
        viewPager2.setOffscreenPageLimit(3);
        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.85f + r * 0.15f);
            }
        });

        viewPager2.setPageTransformer(compositePageTransformer);

        adapter = new SliderAdapter(ImageActivity.this,items,viewPager2);

//        adapter.setOnItemClickListener(new SliderAdapter.OnItemClickListener() {
//            @Override
//            public void onSaveClick(int position) {
//                ImageModel m = items.get(position);
//                Toast.makeText(ImageActivity.this,"Save: " +  m.getTitle(), Toast.LENGTH_SHORT).show();
//                saveFun();
//            }
//
//            @Override
//            public void onShareClick(int position) {
//
//                ImageModel m = items.get(position);
//                Toast.makeText(ImageActivity.this,"Share: " +  m.getTitle(), Toast.LENGTH_SHORT).show();
//                shareCodeFinal();
//
//            }
//        });
        adapter.setOnItemClickListener(new SliderAdapter.OnItemClickListener() {
            @Override
            public void onSaveIVClick(int position, ImageView imageView) {
                ImageModel m = items.get(position);
                //Toast.makeText(ImageActivity.this,"Save: " +  m.getTitle(), Toast.LENGTH_SHORT).show();
                saveFun(m.getTitle(),imageView);
            }

            @Override
            public void onShareIVClick(int position, ImageView imageView) {
                ImageModel m = items.get(position);
                shareImage(m.getTitle(),imageView);
            }
        });
        viewPager2.setAdapter(adapter);

    }

    private void saveFun(String imgTitle, ImageView imageView) {
        if (checkPermission()){
            //imagesavetomyphonegallerytest();
            try {
                //saveImageFinal();
                andridSaveImage(imgTitle, imageView);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{

            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.READ_EXTERNAL_STORAGE},111);
            }
        }
    }

    /*************************************Saving image***************************************/
    private void andridSaveImage(String imgTitle, ImageView imageView) throws IOException{

        BitmapDrawable draw = (BitmapDrawable) imageView.getDrawable();
        Bitmap bitmap = draw.getBitmap();

//        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
//        String time = String.valueOf(timestamp.getTime());

        OutputStream fos;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            ContentResolver resolver = getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put(MediaStore.Images.Media.DISPLAY_NAME, imgTitle +".jpg");
            contentValues.put(MediaStore.Images.Media.MIME_TYPE,"image/jgp");
            contentValues.put(MediaStore.Images.Media.RELATIVE_PATH, Environment.DIRECTORY_PICTURES);
            String ImageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();


            Uri url;
            Uri ImageUri = resolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues);
            fos = resolver.openOutputStream(Objects.requireNonNull(ImageUri));
            Toast.makeText(this, "Saved Successfully " + ImageDir, Toast.LENGTH_LONG).show();
            Intent galleryIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            //File f = new File(dir.toString());
//            Uri picUri = Uri.fromFile(Image);
            galleryIntent.setData(ImageUri);

        }else{
            String ImageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).toString();
            File Image = new File(ImageDir,imgTitle + ".jpg" );
            fos = new FileOutputStream(Image);
            Toast.makeText(this, "Saved Successfully in " + Image.toString(), Toast.LENGTH_LONG).show();
            Intent galleryIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
            //File f = new File(dir.toString());
            Uri picUri = Uri.fromFile(Image);
            galleryIntent.setData(picUri);
            this.sendBroadcast(galleryIntent);

        }

        bitmap.compress(Bitmap.CompressFormat.JPEG,100,fos);

        Objects.requireNonNull(fos).close();

    }

    /*************************************Share image***************************************/

    public void shareImage(String imgTitle, ImageView imageView){
        Drawable drawableShare = imageView.getDrawable();
        Bitmap bitmapShare = ((BitmapDrawable)drawableShare).getBitmap();

        try {
            // This changes the API Policy and  we don't get error ClipData.Item.getUri
            StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
            StrictMode.setVmPolicy(builder.build());

            File file = new File(ImageActivity.this.getExternalCacheDir(), imgTitle + ".jpg");
            FileOutputStream fOut = new FileOutputStream(file);

            bitmapShare.compress(Bitmap.CompressFormat.JPEG,80,fOut);
            fOut.flush();
            fOut.flush();
            file.setReadable(true,false);
            //sharing intent
            Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(android.content.Intent.EXTRA_SUBJECT, "DAPS");
            intent.putExtra(android.content.Intent.EXTRA_TEXT,SAHRE_TITLE);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.setType("image/jpg");
            startActivity(Intent.createChooser(intent,"Share Image Via"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(this, "File not found :(", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    //check for permissions
    private boolean checkPermission(){

        int write = ContextCompat.checkSelfPermission(ImageActivity.this,Manifest.permission.WRITE_EXTERNAL_STORAGE);
        int read = ContextCompat.checkSelfPermission(ImageActivity.this,Manifest.permission.READ_EXTERNAL_STORAGE);

        return write== PackageManager.PERMISSION_GRANTED && read == PackageManager.PERMISSION_GRANTED;
    }

    //grant permission


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        for (int grantResult: grantResults){
            if (grantResult == PackageManager.PERMISSION_GRANTED){
                Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
            }
        }
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater inflater = getMenuInflater();
//        inflater.inflate(R.menu.search_menu, menu);
//        MenuItem searchItem = menu.findItem(R.id.action_search);
//        SearchView searchView = (SearchView) searchItem.getActionView();
//        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                return false;
//            }
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                adapter.getFilter().filter(newText);
//                return false;
//            }
//        });
//        return true;
//    }

}
