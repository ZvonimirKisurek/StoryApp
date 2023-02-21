package com.zoneproduction.library.GlavniScreenovi;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zoneproduction.library.Knjige.AdventureCategory;
import com.zoneproduction.library.Knjige.ArtCategory;
import com.zoneproduction.library.Knjige.BiographyCategory;
import com.zoneproduction.library.Knjige.ChildrenCategory;
import com.zoneproduction.library.Knjige.ComediesCategory;
import com.zoneproduction.library.Knjige.FantasyCategory;
import com.zoneproduction.library.Knjige.FinancialCategory;
import com.zoneproduction.library.Knjige.HistoryCategory;
import com.zoneproduction.library.Knjige.HorrorCategory;
import com.zoneproduction.library.Knjige.MotivationalCategory;
import com.zoneproduction.library.Knjige.MysteryCategory;
import com.zoneproduction.library.Knjige.PoetryCategory;
import com.zoneproduction.library.Knjige.ReligionCategory;
import com.zoneproduction.library.Knjige.RomanceCategory;
import com.zoneproduction.library.Knjige.SciFiCategory;
import com.zoneproduction.library.R;


public class Fragment_Library extends Fragment {

    public static Fragment_Library newInstance() {

        return new Fragment_Library();
    }

    ImageView imageFantasy, imageAdventure, imageMystery, imageRomance, imageHorror, imageReligion , imageBios, imagePoetry;
    ImageView imageSciFi, imageChildren, imageArt, imageMotivational,  imageFinancial, imageHistory, imageComedies;

    HomeScreenReader hsr = new HomeScreenReader();
    String type = hsr.getType();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment__library, container, false);
        imageAdventure = view.findViewById(R.id.imageAction);
        imageArt = view.findViewById(R.id.imageArtHow);
        imageFantasy = view.findViewById(R.id.imageFantasy);
        imageMystery = view.findViewById(R.id.imageMystery);
        imageRomance = view.findViewById(R.id.imageRomance);
        imageHorror = view.findViewById(R.id.imageHorror);
        imageReligion = view.findViewById(R.id.imageReligion);
        imageBios = view.findViewById(R.id.imageBiographies);
        imagePoetry = view.findViewById(R.id.imagePoetry);
        imageSciFi = view.findViewById(R.id.imageSciFi);
        imageChildren = view.findViewById(R.id.imageChildren);
        imageMotivational = view.findViewById(R.id.imageMotivational);
        imageFinancial = view.findViewById(R.id.imageFinancial);
        imageHistory = view.findViewById(R.id.imageHistory);
        imageComedies = view.findViewById(R.id.imageComedies);

        imageAdventure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), AdventureCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageArt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ArtCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageFantasy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), FantasyCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageMystery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), MysteryCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageHorror.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), HorrorCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageRomance.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), RomanceCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageReligion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ReligionCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageBios.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), BiographyCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imagePoetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), PoetryCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageSciFi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), SciFiCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageChildren.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ChildrenCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageMotivational.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), MotivationalCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageFinancial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), FinancialCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });
        imageHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), HistoryCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        imageComedies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getActivity(), ComediesCategory.class);
                startActivity(i);
                getActivity().finish();

            }
        });

        return view;

    }
}

//    private MyImagesViewModel myImagesViewModel;
//    private RecyclerView rv;
//
//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//
//        View view = inflater.inflate(R.layout.fragment__library, container, false);
//        rv = view.findViewById(R.id.rv);
//
//        rv.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
//
//        MyImagesAdapter adapter = new MyImagesAdapter();
//        rv.setAdapter(adapter);
//
//        myImagesViewModel = new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication()).create(MyImagesViewModel.class);
//        myImagesViewModel.getAllImages().observe(getActivity(), new Observer<List<MyImages>>() {
//            @Override
//            public void onChanged(List<MyImages> myImages) {
//
//                adapter.setImagesList(myImages);
//
//            }
//        });
//
//        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT | ItemTouchHelper.LEFT) {
//            @Override
//            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
//                return false;
//            }
//
//            @Override
//            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
//
//                myImagesViewModel.delete(adapter.getPosition(viewHolder.getAdapterPosition()));
//
//            }
//
//        }).attachToRecyclerView(rv);
//
////        adapter.setListener(new MyImagesAdapter.onImageClickListener() {
////            @Override
////            public void onImageClick(MyImages myImages) {
////
////                Intent intent = new Intent(MainActivity.this, UpdateImageActivity.class);
////                intent.putExtra("id", myImages.getImage_id());
////                intent.putExtra("title", myImages.getImage_title());
////                intent.putExtra("description", myImages.getImage_description());
////                intent.putExtra("image", myImages.getImage());
////                startActivityForResult(intent, 4);
////            }
////        });
//
//        return view;
//    }
//
//    @Override
//    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//
//        if (requestCode == 3 && resultCode == RESULT_OK && data != null) {
//            String title = data.getStringExtra("title");
//            String description = data.getStringExtra("description");
//            byte[] image = data.getByteArrayExtra("image");
//
//            MyImages myImages = new MyImages(title, description, image);
//            myImagesViewModel.insert(myImages);
//        }
//
//        if (requestCode == 4 && resultCode == RESULT_OK && data != null) {
//            String title = data.getStringExtra("updateTitle");
//            byte[] image = data.getByteArrayExtra("image");
//            String description = data.getStringExtra("updateDescription");
//
//            int id = data.getIntExtra("id", -1);
//
//            MyImages myImages = new MyImages(title, description, image);
//            myImages.setImage_id(id);
//            myImagesViewModel.update(myImages);
//        }
//    }
